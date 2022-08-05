package com.kot.api.backoffice.v1;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.bll.Order;
import com.kot.intercomm.client.DishClient;

@Component
public class OrderV1ApiMapper {

	@Autowired
	private DishClient dishClient;

	public OrderV1Response modelToDto(Order model) {
		OrderV1Response response = new OrderV1Response();
		response.setId(model.getId());
		response.setCreationDate(model.getCreationDate());
		response.setTotalPrice(model.getTotalPrice());
		response.setCardName(model.getCardName());
		response.setCardNumber(model.getCardNumber());
		response.setExpiration(model.getExpiration());
		response.setPaymentMethod(model.getPaymentMethod());
		response.setDishes(model.getDishIds().stream().map(dishId -> dishClient.getDishById(dishId)).collect(Collectors.toList()));
		return response;
	}
}
