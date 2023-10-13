package com.kot.ordering.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.entity.PaymentMethod;

public class Order {

    private UUID id;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private List<DishToOrder> dishesToOrder;
    private DeliveryAddress deliveryAddress;
    private UserDetail userDetail;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    public Order() {
    }

    public Order(OrderEntity entity) {
        setId(entity.getId());
        setTotalPrice(entity.getTotalPrice());
        setOrderStatus(entity.getOrderStatus());
        setPaymentMethod(entity.getPaymentMethod());
        if (entity.getDishesToOrder() != null) {
            setDishesToOrder(entity.getDishesToOrder().stream().map(DishToOrder::new).toList());
        }
        if (entity.getDeliveryAddress() != null) {
            setDeliveryAddress(new DeliveryAddress(entity.getDeliveryAddress()));
        }
        if (entity.getUserDetail() != null) {
            setUserDetail(new UserDetail(entity.getUserDetail()));
        }
        setCreatedDate(entity.getCreatedDate());
        setLastModifiedDate(entity.getLastModifiedDate());
    }

    public OrderEntity getEntity() {
        OrderEntity entity = new OrderEntity();
        entity.setId(this.id);
        entity.setTotalPrice(this.totalPrice);
        entity.setOrderStatus(this.orderStatus);
        entity.setPaymentMethod(this.paymentMethod);
        if (this.dishesToOrder != null) {
            entity.setDishesToOrder(this.dishesToOrder.stream().map(DishToOrder::getEntity).toList());
        }
        if (this.userDetail != null) {
            entity.setUserDetail(this.userDetail.getEntity());
        }
        if (this.deliveryAddress != null) {
            entity.setDeliveryAddress(this.deliveryAddress.getEntity());
        }
        entity.setCreatedDate(this.createdDate);
        entity.setLastModifiedDate(this.lastModifiedDate);
        return entity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<DishToOrder> getDishesToOrder() {
        return dishesToOrder;
    }

    public void setDishesToOrder(List<DishToOrder> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Order order)) return false;

        return new EqualsBuilder()
                .append(id, order.id)
                .append(totalPrice, order.totalPrice)
                .append(orderStatus, order.orderStatus)
                .append(paymentMethod, order.paymentMethod)
                .append(dishesToOrder, order.dishesToOrder)
                .append(deliveryAddress, order.deliveryAddress)
                .append(userDetail, order.userDetail)
                .append(createdDate, order.createdDate)
                .append(lastModifiedDate, order.lastModifiedDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(totalPrice)
                .append(orderStatus)
                .append(paymentMethod)
                .append(dishesToOrder)
                .append(deliveryAddress)
                .append(userDetail)
                .append(createdDate)
                .append(lastModifiedDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                ", dishesToOrder=" + dishesToOrder +
                ", deliveryAddress=" + deliveryAddress +
                ", userDetail=" + userDetail +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
