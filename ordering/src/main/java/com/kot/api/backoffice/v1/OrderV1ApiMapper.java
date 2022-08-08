package com.kot.api.backoffice.v1;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.bll.order.Order;
import com.kot.intercomm.client.DishV1Client;

@Component
public class OrderV1ApiMapper {

	@Autowired
	private DishV1Client dishClient;

	public OrderV1Response modelToDto(Order model, List<String> expandFields) {
		OrderV1Response response = new OrderV1Response();
		response.setId(model.getId());
		response.setCreationDate(model.getCreationDate());
		response.setCardName(model.getCardName());
		response.setCardNumber(model.getCardNumber());
		response.setExpiration(model.getExpiration());
		response.setPaymentMethod(model.getPaymentMethod());
		response.setTotalPrice(model.getTotalPrice());
		expandResponse(response, model, expandFields);
		return response;
	}

	public void expandResponse(OrderV1Response response, Order model, List<String> entitiesToExpand) {
		if (entitiesToExpand == null) {
			return;
		}
		if (entitiesToExpand.contains("dishes")) {
			response.setDishes(model.getDishIds().stream().map(dishId -> dishClient.getDishById(dishId)).collect(Collectors.toList()));
		}
	}
}
