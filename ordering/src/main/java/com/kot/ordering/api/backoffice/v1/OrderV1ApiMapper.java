package com.kot.ordering.api.backoffice.v1;

import java.util.List;
import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.user_detail.UserDetailService;

@Component
public class OrderV1ApiMapper {

	@Autowired
	private DishV1Client dishClient;

	@Autowired
	private UserDetailService userDetailService;

	public OrderV1Response domainToDto(Order order, List<String> expandFields) {
		OrderV1Response response = new OrderV1Response();
		response.setId(order.getId());
		response.setCreatedDate(order.getCreatedDate());
		response.setLastModifiedDate(order.getLastModifiedDate());
		response.setCardName(order.getCardName());
		response.setCardNumber(order.getCardNumber());
		response.setExpiration(order.getExpiration());
		response.setPaymentMethod(order.getPaymentMethod());
		response.setTotalPrice(order.getTotalPrice());
		response.setUserDetail(userDetailService.findByOrderId(order.getId()));
		expandResponse(response, order, expandFields);
		return response;
	}

	public void expandResponse(OrderV1Response response, Order order, List<String> entitiesToExpand) {
		if (entitiesToExpand == null) {
			return;
		}
		if (entitiesToExpand.contains("dishes")) {
			List<FraudDishV1Response> fraudDishV1ResponseList = order.getSelectedDishes().stream().map(dishId -> dishClient.getDishById(dishId)).toList();
			response.setSelectedDishes(fraudDishV1ResponseList);
			response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
		}
		if (entitiesToExpand.contains("userDetails")) {
			response.setUserDetail(userDetailService.findByOrderId(order.getId()));
//			response.setSelectedDishes(fraudDishV1ResponseList);
//			response.setSelectedCategories(fraudDishV1ResponseList.stream().map(dish -> dish.getCategory().getName()).toList());
		}
	}
}
