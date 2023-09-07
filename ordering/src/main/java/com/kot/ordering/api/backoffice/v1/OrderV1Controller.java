package com.kot.ordering.api.backoffice.v1;

import java.util.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kot.ordering.api.ApiInfo;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.order.OrderService;
import com.kot.ordering.service.statistic.OrderStatisticService;

@RestController
@RequestMapping(OrderV1Controller.API_URL)
@Tag(name = "Ordering API")
public class OrderV1Controller {

    public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.ORDER_ENDPOINT;

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
        Sort sort = PagingV1Utils.getSort(sortDirection, sortField, DEFAULT_SORT);
        Pageable pageable = PagingV1Utils.buildPageable(pageIndex, pageSize, sort);

        Page<Order> fetchedPage = orderService.findAll(pageable);
        PageV1Response pageV1Response = new PageV1Response<>(
                fetchedPage.stream().map(model -> orderV1ApiMapper.domainToDto(model, PagingV1Utils.parseExpandField(expand))).toList(),
                fetchedPage.getTotalElements(),
                pageable.getPageNumber(),
                pageable.getPageSize());
        return pageV1Response;
    }

    @Operation(summary = "Get an order by its id")
    @GetMapping("/{id}")
    public ResponseEntity<OrderV1Response> getById(
            @Parameter(description = "Id of order to be searched")
            @PathVariable UUID id) {
        Order model = orderService.findById(id);
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

}
