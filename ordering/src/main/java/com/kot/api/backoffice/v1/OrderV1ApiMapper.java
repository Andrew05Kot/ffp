package com.kot.api.backoffice.v1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.bll.order.Order;
import com.kot.intercomm.client.DishV1Client;
import com.kot.intercomm.client.DishV1ResponseModel;

@Component
public class OrderV1ApiMapper {

	@Autowired
	private DishV1Client dishClient;

	public OrderV1Response modelToDto(Order model) {
		OrderV1Response response = new OrderV1Response();
		response.setId(model.getId());
		response.setCreationDate(model.getCreationDate());
		response.setCardName(model.getCardName());
		response.setCardNumber(model.getCardNumber());
		response.setExpiration(model.getExpiration());
		response.setPaymentMethod(model.getPaymentMethod());
		response.setDishes(model.getDishIds().stream().map(dishId -> dishClient.getDishById(dishId)).collect(Collectors.toList()));
		response.setTotalPrice(calculateTotal(response.getDishes()));
		return response;
	}

	private BigDecimal calculateTotal(List<DishV1ResponseModel> dishes) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		MathContext mc = new MathContext(3);
		for (DishV1ResponseModel dish : dishes) {
			totalPrice = totalPrice.add(dish.getPrice(), mc);
		}
		return totalPrice;
	}
}
