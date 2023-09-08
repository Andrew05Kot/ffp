package com.kot.ordering.test_data;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.entity.PaymentMethod;
import com.kot.ordering.model.Order;
import com.kot.ordering.model.UserDetail;
import com.kot.ordering.service.order.OrderService;

@Component
//@Profile("test-data")
public class OrderingTestDataGenerator {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishV1Client dishClient;

    private final SecureRandom random = new SecureRandom();

    private List<FraudDishV1Response> allDishes;

    @PostConstruct
    public void buildAndSaveOrders() {
        this.allDishes = dishClient.getDishes();

        int ordersCount = random.nextInt(900) + 750;
        for (int i = 0; i < ordersCount; i++) {
            Order order = new Order();
            order.setCardName("Master Card");
            order.setCardNumber(ordersCount + "" + ordersCount + "" + random.nextInt(4000) + 1000);
            order.setExpiration("12.05.2022");
            order.setCvv((random.nextInt(900) + 100) + "");
            order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            order.setSelectedDishes(getRandomDishes());

            UserDetail userDetail = new UserDetail();
            userDetail.setFirstName("hello");
            userDetail.setLastName("world");
            userDetail.setEmail("user@gmail.com");

            order.setUserDetail(userDetail);

            orderService.create(order);

//            OrderEntity order = new OrderEntity();
//            order.setCreatedDate(ZonedDateTime.now().minusDays(random.nextInt(364) + 1));
//            order.setCardName("Master Card");
//            order.setCardNumber(ordersCount + "" + ordersCount + "" + random.nextInt(4000) + 1000);
//            order.setExpiration("12.05.2022");
//            order.setCvv((random.nextInt(900) + 100) + "");
//            order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
//            order.setSelectedDishes(getRandomDishes());
//            orderService.create(order);
//
//            UserDetailEntity userDetail = new UserDetailEntity();
//            userDetail.setEmail("some-user.email");
        }
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
