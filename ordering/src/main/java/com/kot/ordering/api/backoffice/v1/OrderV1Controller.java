package com.kot.ordering.api.backoffice.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.kot.ordering.api.ApiInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kot.ordering.domain.OrderEntity;
import com.kot.ordering.service.order.OrderService;
import com.kot.ordering.service.statistic.OrderStatisticService;

@RestController
@RequestMapping(OrderV1Controller.API_URL)
@Tag(name = "Ordering API")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8765"})
public class OrderV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.ORDER_ENDPOINT;

	public static final int DEFAULT_PAGE_SIZE = 15;
	public static final int DEFAULT_PAGE_INDEX = 0;
	public static final String DEFAULT_SORT_DIRECTION = "ASC";
	public static final String DEFAULT_SORT_FIELD = "id";
	public static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by(DEFAULT_SORT_DIRECTION).withProperty(DEFAULT_SORT_FIELD));

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderV1ApiMapper orderV1ApiMapper;

	@Autowired
	private OrderStatisticService orderStatisticService;

	@Operation(summary = "Get page of existing orders")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public PageV1Response<OrderV1Response> getAll(
			@RequestParam(name = "pageIndex") Optional<Integer> pageIndex,
			@RequestParam(name = "pageSize") Optional<Integer> pageSize,
			@RequestParam(name = "sortDirection") Optional<String> sortDirection,
			@RequestParam(name = "sortField") Optional<String> sortField,
			@RequestParam(value = "expand_fields", required = false) Optional<String> expand) {
		Sort sort = getSort(sortDirection, sortField);
		Pageable pageable = getResult(pageIndex, pageSize, sort);

		Page<OrderEntity> fetchedPage = orderService.findAll(pageable);
		return new PageV1Response<>(
				fetchedPage.stream().map(model -> orderV1ApiMapper.domainToDto(model, parseExpandField(expand))).toList(),
				fetchedPage.getTotalElements(),
				pageable.getPageNumber(),
				pageable.getPageSize());
	}

	private static Pageable getResult(Optional<Integer> pageIndex, Optional<Integer> pageSize, Sort sort) {
		int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
		int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
		return pageIndex.isPresent() && size > 0 ?
				PageRequest.of(index, size, sort)
				: Pageable.unpaged();
	}

	private Sort getSort(Optional<String> sortDirection, Optional<String> sortField) {
		if (sortField.isPresent() && sortDirection.isPresent()) {
			return switch (sortDirection.get().toUpperCase()) {
				case "ASC" -> Sort.by(Sort.Order.asc(sortField.get()));
				case "DESC" -> Sort.by(Sort.Order.desc(sortField.get()));
				default -> DEFAULT_SORT;
			};
		}
		return DEFAULT_SORT;
	}

	@Operation(summary = "Get an order by its id")
	@GetMapping("/{id}")
	public ResponseEntity<OrderV1Response> getById(
			@Parameter(description = "Id of order to be searched")
			@PathVariable Long id) {
		OrderEntity model = orderService.findById(id);
		return new ResponseEntity<>(orderV1ApiMapper.domainToDto(model, new ArrayList<>()), HttpStatus.OK);
	}

	@Operation(summary = "Get a Map of sales statistics in advance for each month.\n" +
			"To get all the statistics of all existing orders, there is no need to pass startDate and endDate parameters")
	@GetMapping("/statistics")
	public ResponseEntity<?> getStatistics(
			@Parameter(description = "Date from", example = "2022-05-01T00:00:00.000Z")
			@RequestParam(value = "startDate", required = false) Optional<String> startDate,
			@Parameter(description = "Date to", example = "2022-08-01T00:00:00.000Z")
			@RequestParam(value = "endDate", required = false) Optional<String> endDate
	) {
		if (startDate.isPresent() && endDate.isPresent()) {
			return ResponseEntity.ok(orderStatisticService.getStatisticsByParallelStreams(startDate.get(), endDate.get()));
		}
		return ResponseEntity.ok(orderStatisticService.getStatisticsByParallelStreams());
	}

	public List<String> parseExpandField(Optional<String> expandFields) {
		return expandFields.map(s -> Arrays.asList(s.split(","))).orElse(Collections.emptyList());
	}

}
