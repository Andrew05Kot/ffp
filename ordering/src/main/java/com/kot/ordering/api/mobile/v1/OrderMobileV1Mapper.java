package com.kot.ordering.api.mobile.v1;

import org.springframework.stereotype.Component;

import com.kot.ordering.domain.OrderEntity;

@Component
public class OrderMobileV1Mapper {

	public OrderEntity dtoToDomain(OrderMobileV1Request dto) {
		OrderEntity model = new OrderEntity();
		model.setTotalPrice(dto.getTotalPrice());
		model.setCardName(dto.getCardName());
		model.setCardNumber(dto.getCardNumber());
		model.setExpiration(dto.getExpiration());
		model.setCvv(dto.getCvv());
		model.setPaymentMethod(dto.getPaymentMethod());
		return model;
	}
}
