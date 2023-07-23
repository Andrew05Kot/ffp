package com.kot.ordering.test_data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.domain.OrderEntity;
import com.kot.ordering.domain.PaymentMethod;
import com.kot.ordering.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator {

	@Autowired
	private OrderService orderService;

	@Autowired
	private DishV1Client dishClient;

	private final SecureRandom random = new SecureRandom();

	private List<FraudDishV1Response> allDishes;

	@PostConstruct
	public void buildAndSaveOrders() {
		this.allDishes = dishClient.getDishes();

		int ordersCount = random.nextInt(9500) + 7500;
		for (int i = 0; i < ordersCount; i++) {
			OrderEntity order = new OrderEntity();
			order.setCreatedDate(ZonedDateTime.now().minusDays(random.nextInt(364) + 1));
			order.setCardName("Master Card");
			order.setCardNumber(ordersCount + "" + ordersCount + "" + random.nextInt(4000) + 1000);
			order.setExpiration("12.05.2022");
			order.setCvv((random.nextInt(900) + 100) + "");
			order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
			order.setSelectedDishes(getRandomDishes());
			List<FraudDishV1Response> orderDishes = order.getSelectedDishes().stream().map(dishId -> allDishes.stream()
					.filter(dishV1ResponseModel -> dishV1ResponseModel.getId().equals(dishId))
					.findAny()
					.orElse(null)).toList();
			order.setTotalPrice(calculateTotal(orderDishes));
			orderService.save(order);
		}
	}

	private BigDecimal calculateTotal(List<FraudDishV1Response> dishes) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		MathContext mc = new MathContext(3);
		for (FraudDishV1Response dish : dishes) {
			totalPrice = totalPrice.add(dish.getPrice(), mc);
		}
		return totalPrice;
	}

	private List<Long> getRandomDishes() {
		int count = (int) (Math.random() * allDishes.size()) + 1;
		Collections.shuffle(allDishes);
		List<FraudDishV1Response> selectedDishes = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			selectedDishes.add(allDishes.get(i));
		}
		return selectedDishes.stream().map(FraudDishV1Response::getId).toList();
	}
}
