package com.kot.api.mobile.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.kot.bll.order.OrderService;

public class OrderMobileV1Controller {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderMobileV1Mapper orderMobileV1Mapper;

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody OrderMobileV1Request request) {
		orderService.save(orderMobileV1Mapper.dtoToModel(request));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
