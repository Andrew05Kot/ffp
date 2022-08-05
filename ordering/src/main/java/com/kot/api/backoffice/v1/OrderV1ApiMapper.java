package com.kot.api.backoffice.v1;

import org.springframework.stereotype.Component;
import com.kot.bll.Order;

@Component
public class OrderV1ApiMapper {

	public OrderV1Response modelToDto(Order model) {
		OrderV1Response response = new OrderV1Response();
		response.setId(model.getId());
		response.setCreationDate(model.getCreationDate());
		response.setTotalPrice(model.getTotalPrice());
		response.setCardName(model.getCardName());
		response.setCardNumber(model.getCardNumber());
		response.setExpiration(model.getExpiration());
		response.setPaymentMethod(model.getPaymentMethod());
		return response;
	}
}
