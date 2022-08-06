package com.kot.bll.test_data;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.dal.OrderEntity;
import com.kot.dal.OrderRepository;
import com.kot.dal.PaymentMethod;
import com.kot.intercomm.client.DishV1Client;
import com.kot.intercomm.client.DishV1ResponseModel;

@Component
public class TestDataGenerator {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private DishV1Client dishClient;

	private final SecureRandom random = new SecureRandom();

	@PostConstruct
	public void buildAndSaveOrders() {
		List<DishV1ResponseModel> dishes = dishClient.getDishes();

		int ordersCount = random.nextInt(3500) + 7500;
		for (int i = 0; i < ordersCount; i++) {
			OrderEntity order = new OrderEntity();
			order.setCreationDate(ZonedDateTime.now().minusDays(random.nextInt(364) + 1));
			order.setTotalPrice(BigDecimal.valueOf(ordersCount / 2));
			order.setCardName("Master Card");
			order.setCardNumber(ordersCount + "" + ordersCount + "" + random.nextInt(4000) + 1000);
			order.setExpiration("12.05.2022");
			order.setCvv((random.nextInt(900) + 100) + "");
			order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
			order.setDishIds(getRandomDishIds(dishes.size()));
			orderRepository.save(order);
		}
	}

	private List<Long> getRandomDishIds(int size) {
		if (size == 0) ++size;
		List<Long> dishesIds = new ArrayList<>();
		int countOfDishesInOrder = random.nextInt(4) + 1;
		for (int i = 0; i < countOfDishesInOrder; i++) {
			long id = random.nextInt(size);
			if (id != 0) dishesIds.add(id);
		}
		return dishesIds;
	}
}
