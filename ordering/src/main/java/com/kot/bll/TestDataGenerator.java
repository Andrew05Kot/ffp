package com.kot.bll;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.ZonedDateTime;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.dal.OrderEntity;
import com.kot.dal.OrderRepository;
import com.kot.dal.PaymentMethod;

@Component
public class TestDataGenerator {

	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void buildAndSaveOrders() {
		SecureRandom random = new SecureRandom();
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
			orderRepository.save(order);
		}
	}
}
