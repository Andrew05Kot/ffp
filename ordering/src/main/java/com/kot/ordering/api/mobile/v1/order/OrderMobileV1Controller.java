package com.kot.ordering.api.mobile.v1.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kot.ordering.api.ApiInfo;
import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.order.OrderService;

@RestController
@RequestMapping(OrderMobileV1Controller.API_URL)
@Tag(name = "Ordering Mobile API")
public class OrderMobileV1Controller {

    public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.MOBILE_API_VERSION_V1 + ApiInfo.ORDER_ENDPOINT;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMobileV1Mapper orderMobileV1Mapper;

    @Operation(summary = "Create a new order", tags = {"order"})
    @PostMapping()
    public ResponseEntity<OrderMobileV1Response> create(
            @Parameter(description = "Order to create. Cannot null or empty.",
                    required = true, schema = @Schema(implementation = OrderMobileV1Request.class))
            @RequestBody OrderMobileV1Request request) {
        Order model = orderMobileV1Mapper.dtoToDomain(request);
        OrderEntity created = orderService.create(model);
        return new ResponseEntity<>(
                orderMobileV1Mapper.domainToDto(created),
                HttpStatus.CREATED);
    }

}
