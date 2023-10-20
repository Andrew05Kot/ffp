package com.kot.ordering.test_data;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.ordering.client.DishV1Client;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.dao.OrderDao;
import com.kot.ordering.entity.*;

@Component
//@Profile("test-data")
public class OrderingTestDataGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderingTestDataGenerator.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DishV1Client dishClient;

    private final SecureRandom random = new SecureRandom();

    private List<FraudDishV1Response> allDishes;

    @PostConstruct
    public void buildAndSaveOrders() {
        LOGGER.info("Started data generating...");
        this.allDishes = dishClient.getDishes();

        int ordersCount = random.nextInt(9000) + 7500;
        for (int i = 0; i < ordersCount; i++) {

            OrderEntity order = new OrderEntity();
            order.setTotalPrice(new BigDecimal(Math.random() * 100));
            order.setOrderStatus(OrderStatus.RECEIVED);
            order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            order.setCreatedDate(getRandomDate());
            List<Long> dishIds = getRandomDishes();
            List<DishToOrderEntity> dishesToOrder = new ArrayList<>();
            for (Long dishId : dishIds) {
                FraudDishV1Response fraudDishV1Response = allDishes.stream().filter(d -> d.getId().equals(dishId)).findFirst().get();
                DishToOrderEntity dishToOrder = new DishToOrderEntity();
                dishToOrder.setQuantity(random.nextInt(5) + 1);
                dishToOrder.setDishName(fraudDishV1Response.getName());
                dishToOrder.setDishCategoryName(fraudDishV1Response.getCategory().getName());
                dishToOrder.setDishId(dishId);
                dishToOrder.setCategoryId(fraudDishV1Response.getCategory().getId());
                dishToOrder.setOrder(order);
                dishesToOrder.add(dishToOrder);
            }

            DeliveryAddressEntity deliveryAddress = new DeliveryAddressEntity();
            deliveryAddress.setCountry("Country Name");
            deliveryAddress.setCity("City Name");
            deliveryAddress.setStreet("Street Name");
            deliveryAddress.setHouseNumber("123");
            deliveryAddress.setAdditionalInfo("Additional Info");
            deliveryAddress.setOrder(order);

            UserDetailEntity userDetail = new UserDetailEntity();
            userDetail.setFirstName("First Name");
            userDetail.setLastName("Last Name");
            userDetail.setEmail("email@example.com");
            userDetail.setPhoneNumber("1234567890");
            userDetail.setImageUrl("https://example.com/image.jpg");
            userDetail.setOrder(order);

            order.setDishesToOrder(dishesToOrder);
            order.setDeliveryAddress(deliveryAddress);
            order.setUserDetail(userDetail);

            orderDao.create(order);

//            Order order = new Order();
//            order.setPaymentMethod(PaymentMethod.CREDIT_CARD);
//
//            UserDetail userDetail = new UserDetail();
//            userDetail.setFirstName("hello");
//            userDetail.setLastName("world");
//            userDetail.setEmail("user@gmail.com");
//
//            order.setUserDetail(userDetail);
//
//            orderDao.create(order);

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
        LOGGER.info("Generated {} of random orders", ordersCount);
    }

    private ZonedDateTime getRandomDate() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        int year = currentDateTime.getYear();
        int randomMonth = random.nextInt(12) + 1;
        int maxDay = YearMonth.of(year, randomMonth).lengthOfMonth();
        int randomDay = random.nextInt(maxDay) + 1;
        return ZonedDateTime.of(LocalDate.of(year, randomMonth, randomDay), currentDateTime.toLocalTime(), ZoneId.systemDefault());
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
