package com.kot.ordering.api.backoffice.v1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.api.backoffice.v1.delevery_address.DeliveryAddressV1Response;
import com.kot.ordering.api.backoffice.v1.dishes_list.DishToOrderV1Response;
import com.kot.ordering.api.backoffice.v1.user_details.UserDetailV1Response;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Response;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.entity.PaymentMethod;

public class OrderV1Response {

    @Schema(description = "UUID of order entity", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;

    @Schema(description = "Calculated total price of the order", accessMode = Schema.AccessMode.READ_ONLY)
    private BigDecimal totalPrice;

    @Schema(description = "User details of the order", accessMode = Schema.AccessMode.READ_ONLY)
    private UserDetailV1Response userDetail;

    @Schema(description = "Delivery address of the order", accessMode = Schema.AccessMode.READ_ONLY)
    private DeliveryAddressV1Response deliveryAddress;

    @ArraySchema(schema = @Schema(description = "List of ordered dishes ", accessMode = Schema.AccessMode.READ_ONLY))
    private List<DishToOrderV1Response> dishesToOrder;

    @Schema(description = "Current status of the order", accessMode = Schema.AccessMode.READ_ONLY)
    private OrderStatus orderStatus;

    @Schema(description = "Payment method used for the order", accessMode = Schema.AccessMode.READ_ONLY)
    private PaymentMethod paymentMethod;

    @Schema(description = "Date and time when the order was created", accessMode = Schema.AccessMode.READ_ONLY)
    private ZonedDateTime createdDate;

    @Schema(description = "Date and time when the order was last modified", accessMode = Schema.AccessMode.READ_ONLY)
    private ZonedDateTime lastModifiedDate;

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

    public DeliveryAddressV1Response getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressV1Response deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<DishToOrderV1Response> getDishesToOrder() {
        return dishesToOrder;
    }

    public void setDishesToOrder(List<DishToOrderV1Response> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
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

    public UserDetailV1Response getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailV1Response userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof OrderV1Response that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getTotalPrice(), that.getTotalPrice())
                .append(getDeliveryAddress(), that.getDeliveryAddress())
                .append(getDishesToOrder(), that.getDishesToOrder())
                .append(getOrderStatus(), that.getOrderStatus())
                .append(getPaymentMethod(), that.getPaymentMethod())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .append(getUserDetail(), that.getUserDetail())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getTotalPrice())
                .append(getDeliveryAddress())
                .append(getDishesToOrder())
                .append(getOrderStatus())
                .append(getPaymentMethod())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .append(getUserDetail())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderV1Response{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", getUserDetail=" + userDetail +
                ", deliveryAddress=" + deliveryAddress +
                ", dishesToOrder=" + dishesToOrder +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
