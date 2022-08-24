package com.kot.bll.statistic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.kot.bll.order.Order;
import com.kot.bll.order.OrderService;
import com.kot.dal.QOrderEntity;
import com.kot.intercomm.client.DishV1Client;
import com.kot.intercomm.client.FraudDishV1Response;

@Service
public class OrderStatisticService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatisticService.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private DishV1Client dishV1Client;

	public Map<String, BigDecimal> getStatistic() {
		List<Order> orders = orderService.findAll(Sort.by(Sort.Direction.ASC, "creationDate")).toList();
		LOGGER.info("Founded {} orders for statistics.", orders.size());
		return orders.stream().collect(Collectors.toMap(
				order -> order.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
				order -> calculateTotal(order.getDishIds()
						.stream()
						.map(dishId -> dishV1Client.getDishById(dishId))
						.collect(Collectors.toList())),
				(a, b) -> a
		));
	}

	public Map<String, BigDecimal> getStatistic(String startDate, String endDate) {
		ZonedDateTime startDateTime = ZonedDateTime.parse(startDate);
		ZonedDateTime endDateTime = ZonedDateTime.parse(endDate);
		Sort sort = Sort.by(Sort.Direction.ASC, "creationDate");

		List<Order> orders = orderService.findAll(sort, QOrderEntity.orderEntity.createdDate.after(startDateTime).and(QOrderEntity.orderEntity.createdDate.before(endDateTime)));

		return orders.stream().collect(Collectors.toMap(
				order -> order.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
				order -> calculateTotal(order.getDishIds()
						.stream()
						.map(dishId -> dishV1Client.getDishById(dishId))
						.collect(Collectors.toList())),
				(a, b) -> a
		));
	}

	private BigDecimal calculateTotal(List<FraudDishV1Response> dishes) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		MathContext mc = new MathContext(3);
		for (FraudDishV1Response dish : dishes) {
			totalPrice = totalPrice.add(dish.getPrice(), mc);
		}
		return totalPrice;
	}

}
