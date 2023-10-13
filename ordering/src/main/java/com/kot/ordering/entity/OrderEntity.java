package com.kot.ordering.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ordering")
public class OrderEntity extends BaseEntity {

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
                ", createdDate=" + getCreatedDate() +
                ", lastModifiedDate=" + getLastModifiedDate() +
                '}';
    }
}
