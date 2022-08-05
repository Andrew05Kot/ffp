package com.kot.api.mobile.v1;

import org.springframework.stereotype.Component;
import com.kot.bll.Order;

@Component
public class OrderMobileV1Mapper {

	public Order dtoToModel(OrderMobileV1Request dto) {
		Order model = new Order();
		model.setTotalPrice(dto.getTotalPrice());
		model.setCardName(dto.getCardName());
		model.setCardNumber(dto.getCardNumber());
		model.setExpiration(dto.getExpiration());
		model.setCvv(dto.getCvv());
		model.setPaymentMethod(dto.getPaymentMethod());
		return model;
	}
}
