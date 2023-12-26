package com.kot.ordering.service.statistic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.model.Order;
import com.kot.ordering.service.order.OrderService;

@Service
public class OrderStatisticService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatisticService.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishV1Client dishV1Client;

    public SortedMap<String, BigDecimal> getStatisticsByParallelStreams() {
        List<Order> orders = orderService.findAll().getContent();
        return getStatisticsMap(orders);
    }

    public SortedMap<String, BigDecimal> getStatisticsByParallelStreams(String startDate, String endDate) {
        ZonedDateTime startDateTime = ZonedDateTime.parse(startDate);
        ZonedDateTime endDateTime = ZonedDateTime.parse(endDate);
        String search = "createdDate>=" + startDateTime + "&startDateTime<=" + endDateTime;
        List<Order> orders = orderService.findAll(search);
        return getStatisticsMap(orders);
    }

    private TreeMap<String, BigDecimal> getStatisticsMap(List<Order> orders) {
        List<FraudDishV1Response> dishes = dishV1Client.getDishes();
        LOGGER.info("Founded {} orders for statistics.", orders.size());

        MathContext mc = new MathContext(3);

        return orders.stream().collect(Collectors.toMap(
                order -> order.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
                order -> calculateTotal(order.getDishesToOrder()
                        .parallelStream()
                        .map(dishToOrder -> getDishResponseById(dishes, dishToOrder.getDishId()))
                        .toList()),
                (a, b) -> a.add(b, mc),
                TreeMap::new
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

    private FraudDishV1Response getDishResponseById(List<FraudDishV1Response> dishes, Long id) {
        return dishes.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

}
