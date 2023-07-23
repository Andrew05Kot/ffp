package com.kot.ordering.api.backoffice.v1;

import java.util.List;
import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.domain.OrderEntity;

@Component
public class OrderV1ApiMapper {

	@Autowired
	private DishV1Client dishClient;

	public OrderV1Response domainToDto(OrderEntity entity, List<String> expandFields) {
		OrderV1Response response = new OrderV1Response();
		response.setId(entity.getId());
		response.setCreatedDate(entity.getCreatedDate());
		response.setLastModifiedDate(entity.getLastModifiedDate());
		response.setCardName(entity.getCardName());
		response.setCardNumber(entity.getCardNumber());
		response.setExpiration(entity.getExpiration());
		response.setPaymentMethod(entity.getPaymentMethod());
		response.setTotalPrice(entity.getTotalPrice());
		expandResponse(response, entity, expandFields);
		return response;
	}

	public void expandResponse(OrderV1Response response, OrderEntity entity, List<String> entitiesToExpand) {
		if (entitiesToExpand == null) {
			return;
		}
		if (entitiesToExpand.contains("dishes")) {
			List<FraudDishV1Response> fraudDishV1ResponseList = entity.getSelectedDishes().stream().map(dishId -> dishClient.getDishById(dishId)).toList();
			response.setSelectedDishes(fraudDishV1ResponseList);
			response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
		}
	}
}
