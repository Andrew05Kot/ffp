package com.kot.ordering.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.kot.ordering.entity.OrderEntity;
import com.kot.ordering.entity.PaymentMethod;

public class Order {

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
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    public Order() {}

    public Order(OrderEntity entity) {
        setId(entity.getId());
        setTotalPrice(entity.getTotalPrice());
        setCardName(entity.getCardName());
        setCardNumber(entity.getCardNumber());
        setExpiration(entity.getExpiration());
        setCvv(entity.getCvv());
        setPaymentMethod(entity.getPaymentMethod());
        setSelectedDishes(entity.getSelectedDishes());
        setSelectedCategories(entity.getSelectedCategories());
//        setDeliveryAddress(new DeliveryAddress(entity.getDeliveryAddress()));
//        setUserDetail(new UserDetail(entity.getUserDetail()));
        setCreatedDate(entity.getCreatedDate());
        setLastModifiedDate(entity.getLastModifiedDate());
    }

    public OrderEntity getEntity() {
        OrderEntity entity = new OrderEntity();
        entity.setId(this.id);
        entity.setTotalPrice(this.totalPrice);
        entity.setCardName(this.cardName);
        entity.setCardNumber(this.cardNumber);
        entity.setExpiration(this.expiration);
        entity.setCvv(this.getCvv());
        entity.setPaymentMethod(this.paymentMethod);
        entity.setSelectedDishes(this.selectedDishes);
        entity.setSelectedCategories(this.selectedCategories);
        entity.setCreatedDate(this.createdDate);
        entity.setLastModifiedDate(this.lastModifiedDate);
        if (this.userDetail != null) {
            entity.setUserDetail(this.userDetail.getEntity());
        }
        if (this.deliveryAddress != null) {
            entity.setDeliveryAddress(this.deliveryAddress.getEntity());
        }
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Long> getSelectedDishes() {
        return selectedDishes;
    }

    public void setSelectedDishes(List<Long> selectedDishes) {
        this.selectedDishes = selectedDishes;
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
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
}
