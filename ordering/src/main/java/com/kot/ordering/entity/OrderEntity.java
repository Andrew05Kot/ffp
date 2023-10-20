package com.kot.ordering.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "ordering")
public class OrderEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 16, name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "total_price", nullable = false)
    @NotNull
    private BigDecimal totalPrice;

    @Column(name = "order_status", nullable = false)
    @NotNull
    private OrderStatus orderStatus;

    @Column(name = "payment_method", nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DishToOrderEntity> dishesToOrder;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private DeliveryAddressEntity deliveryAddress;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserDetailEntity userDetail;

    @CreatedDate
    @Column(name = "created_date", updatable = false, nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

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

    public List<DishToOrderEntity> getDishesToOrder() {
        return dishesToOrder;
    }

    public void setDishesToOrder(List<DishToOrderEntity> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
    }

    public DeliveryAddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public UserDetailEntity getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
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

        if (!(o instanceof OrderEntity that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getTotalPrice(), that.getTotalPrice())
                .append(getOrderStatus(), that.getOrderStatus())
                .append(getPaymentMethod(), that.getPaymentMethod())
                .append(getDishesToOrder(), that.getDishesToOrder())
                .append(getDeliveryAddress(), that.getDeliveryAddress())
                .append(getUserDetail(), that.getUserDetail())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getTotalPrice())
                .append(getOrderStatus())
                .append(getPaymentMethod())
                .append(getDishesToOrder())
                .append(getDeliveryAddress())
                .append(getUserDetail())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
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
