package com.kot.ordering.builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.ordering.entity.PaymentMethod;
import com.kot.ordering.model.DeliveryAddress;
import com.kot.ordering.model.Order;
import com.kot.ordering.model.UserDetail;

public class TestOrderBuilder {

    private UUID id;
    private BigDecimal totalPrice;
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
    private PaymentMethod paymentMethod;
    private List<Long> selectedDishes;
    private List<String> selectedCategories;
    private DeliveryAddress deliveryAddress;
    private UserDetail userDetail;

    private static final TestUserDetailBuilder testUserDetailBuilder = new TestUserDetailBuilder();
    private static final TestDeliveryAddressBuilder testDeliveryAddressBuilder = new TestDeliveryAddressBuilder();

    public TestOrderBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = UUID.randomUUID();
        this.totalPrice = BigDecimal.valueOf(randomValue);
        this.cardName = "cardName-" + randomValue.toString();
        this.cardNumber = "cardNumber-" + randomValue.toString();
        this.expiration = "expiration-" + randomValue.toString();
        this.cvv = "cvv-" + randomValue.toString();
        this.paymentMethod = PaymentMethod.CREDIT_CARD;
        this.selectedDishes = List.of(1L, 2L, 3L);
        this.selectedCategories = List.of("category1", "category1", "category3");
        this.deliveryAddress = testDeliveryAddressBuilder.build();
        this.userDetail = testUserDetailBuilder.build();
    }

    public Order build() {
        Order order = new Order();
        order.setId(this.id);
        order.setTotalPrice(this.totalPrice);
        order.setCardName(this.cardName);
        order.setCardNumber(this.cardNumber);
        order.setExpiration(this.expiration);
        order.setCvv(this.cvv);
        order.setPaymentMethod(this.paymentMethod);
        order.setSelectedDishes(this.selectedDishes);
        order.setSelectedCategories(this.selectedCategories);
        order.setDeliveryAddress(this.deliveryAddress);
        order.setUserDetail(this.userDetail);
        return order;
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    private int getRand(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public TestOrderBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public TestOrderBuilder setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public TestOrderBuilder setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public TestOrderBuilder setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public TestOrderBuilder setExpiration(String expiration) {
        this.expiration = expiration;
        return this;
    }

    public TestOrderBuilder setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public TestOrderBuilder setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public TestOrderBuilder setSelectedDishes(List<Long> selectedDishes) {
        this.selectedDishes = selectedDishes;
        return this;
    }

    public TestOrderBuilder setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
        return this;
    }

    public TestOrderBuilder setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public TestOrderBuilder setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
        return this;
    }
}
