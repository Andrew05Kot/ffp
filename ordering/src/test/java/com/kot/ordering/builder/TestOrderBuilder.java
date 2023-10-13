package com.kot.ordering.builder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.entity.PaymentMethod;
import com.kot.ordering.model.DeliveryAddress;
import com.kot.ordering.model.DishToOrder;
import com.kot.ordering.model.Order;
import com.kot.ordering.model.UserDetail;

public class TestOrderBuilder {

    private UUID id;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private List<DishToOrder> dishesToOrder;
    private DeliveryAddress deliveryAddress;
    private UserDetail userDetail;
    private ZonedDateTime createdDate = ZonedDateTime.now();
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    private static final TestUserDetailBuilder testUserDetailBuilder = new TestUserDetailBuilder();
    private static final TestDeliveryAddressBuilder testDeliveryAddressBuilder = new TestDeliveryAddressBuilder();
    private static final TestDishToOrderBuilder testDishToOrderBuilder = new TestDishToOrderBuilder();

    public TestOrderBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = UUID.randomUUID();
        this.totalPrice = BigDecimal.valueOf(randomValue);
        this.paymentMethod = PaymentMethod.CREDIT_CARD;
        this.orderStatus = OrderStatus.RECEIVED;
        this.deliveryAddress = testDeliveryAddressBuilder.build();
        this.userDetail = testUserDetailBuilder.build();
        this.dishesToOrder = List.of(
                new DishToOrder(testDishToOrderBuilder.build()),
                new DishToOrder(testDishToOrderBuilder.build())
        );
    }

    public Order build() {
        Order order = new Order();
        order.setId(this.id);
        order.setTotalPrice(this.totalPrice);
        order.setPaymentMethod(this.paymentMethod);
        order.setOrderStatus(this.orderStatus);
        order.setDeliveryAddress(this.deliveryAddress);
        order.setUserDetail(this.userDetail);
        order.setDishesToOrder(this.dishesToOrder);
        order.setCreatedDate(this.createdDate);
        order.setLastModifiedDate(this.lastModifiedDate);
        initDefaultData();
        return order;
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestOrderBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public TestOrderBuilder setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public TestOrderBuilder setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public TestOrderBuilder setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public TestOrderBuilder setDishesToOrder(List<DishToOrder> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
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
