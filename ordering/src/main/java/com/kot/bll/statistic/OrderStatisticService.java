package com.kot.bll.statistic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
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

	@Autowired
	private OrderService orderService;

	@Autowired
	private DishV1Client dishV1Client;

	public Map<String, BigDecimal> getStatistic() {
		List<Order> orders = orderService.findAll(Sort.by(Sort.Direction.ASC, "creationDate")).toList();
		SortedMap<String, BigDecimal> statisticsMap = new TreeMap<>();
		System.out.println("orders count >> " + orders.size());
		MathContext mc = new MathContext(3);
		for (Order order : orders) {
			List<FraudDishV1Response> dishesOfOrder = order.getDishIds()
					.stream()
					.map(dishId -> dishV1Client.getDishById(dishId))
					.collect(Collectors.toList());
			BigDecimal total = calculateTotal(dishesOfOrder);
			String date = order.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM"));
			statisticsMap.merge(date, total, (a, b) -> a.add(b, mc));
		}
		return statisticsMap;
	}

	public Map<String, BigDecimal> getStatistic(String startDate, String endDate) {
		ZonedDateTime startDateTime = ZonedDateTime.parse(startDate);
		ZonedDateTime endDateTime = ZonedDateTime.parse(endDate);
		SortedMap<String, BigDecimal> statisticsMap = new TreeMap<>();
		Sort sort = Sort.by(Sort.Direction.ASC, "creationDate");

		List<Order> orders = orderService.findAll(sort, QOrderEntity.orderEntity.createdDate.after(startDateTime).and(QOrderEntity.orderEntity.createdDate.before(endDateTime)));
		System.out.println("orders count >> " + orders.size());
		MathContext mc = new MathContext(3);
		for (Order order : orders) {
			List<FraudDishV1Response> dishesOfOrder = order.getDishIds()
					.stream()
					.map(dishId -> dishV1Client.getDishById(dishId))
					.collect(Collectors.toList());
			BigDecimal total = calculateTotal(dishesOfOrder);
			String date = order.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM"));
			statisticsMap.merge(date, total, (a, b) -> a.add(b, mc));
		}
		return statisticsMap;
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
