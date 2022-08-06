package com.kot.api.backoffice.v1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kot.api.ApiInfo;
import com.kot.api.UnPagedPage;
import com.kot.bll.order.Order;
import com.kot.bll.order.OrderService;
import com.kot.bll.statistic.OrderStatisticService;

@RestController
@RequestMapping(OrderV1Controller.API_URL)
@Tag(name = "Ordering API")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.ORDER_ENDPOINT;

	public static final Integer DEFAULT_PAGE_SIZE = 10;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderV1ApiMapper orderV1ApiMapper;

	@Autowired
	private OrderStatisticService orderStatisticService;

	@GetMapping("/")
	public ResponseEntity<List<OrderV1Response>> getAll() {
		List<Order> models = orderService.findAll().getContent();
		List<OrderV1Response> responses = models
				.stream()
				.map(model -> orderV1ApiMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(responses, HttpStatus.OK);
	}

	@GetMapping("/page")
	public ResponseEntity<PageV1Response<OrderV1Response>> getAllPage(
			@RequestParam(value = "index", required = false) Optional<Integer> index,
			@RequestParam(value = "size", required = false) Optional<Integer> size
	) {
		int pageSize = size.orElse(DEFAULT_PAGE_SIZE);

		boolean isPageable = index.isPresent() && pageSize > 0;

		Pageable pageable = isPageable ?
				PageRequest.of(index.get(), pageSize)
				: new UnPagedPage();

		Page<Order> entitiesPaged = orderService.findAll(pageable);
		List<OrderV1Response> responses = entitiesPaged
				.stream()
				.map(model -> orderV1ApiMapper.modelToDto(model))
				.collect(Collectors.toList());
		PageV1Response<OrderV1Response> apiResponseTypePageResponse =
				new PageV1Response<>(responses, entitiesPaged.getTotalElements(), entitiesPaged.getNumber(), entitiesPaged.getSize());
		return ResponseEntity.ok(apiResponseTypePageResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderV1Response> getById(@PathVariable Long id) {
		Order model = orderService.findById(id);
		return new ResponseEntity<>(orderV1ApiMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/statistic")
	public ResponseEntity<?> getStatistic(
			@RequestParam(value = "startDate", required = false) Optional<String> startDate,
			@RequestParam(value = "endDate", required = false) Optional<String> endDate
	) {
		if (startDate.isPresent() && endDate.isPresent()) {
			return ResponseEntity.ok(orderStatisticService.getStatistic(startDate.get(), endDate.get()));
		}
		return ResponseEntity.ok(orderStatisticService.getStatistic());
	}

}
