package com.kot.ordering.api.mobile.v1.order;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Response;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Request;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Response;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Response;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.entity.PaymentMethod;

@OpenAPIDefinition(info = @Info(title = "Order Mobile V1 API", version = "1.0", description = "API of requested orders"))
public class OrderMobileV1Response {

    @Schema(description = "UUID of order entity", accessMode = AccessMode.READ_ONLY)
    private UUID id;

    @Schema(description = "User details of the order", accessMode = AccessMode.READ_ONLY)
    private UserDetailMobileV1Response userDetail;

    @Schema(description = "Delivery address of the order", accessMode = AccessMode.READ_ONLY)
    private DeliveryAddressMobileV1Response deliveryAddress;

    @ArraySchema(schema = @Schema(description = "List of ordered dishes ", accessMode = AccessMode.READ_ONLY))
    private List<DishToOrderMobileV1Response> dishesToOrder;

    @Schema(description = "Calculated total price of the order", accessMode = AccessMode.READ_ONLY)
    private BigDecimal totalPrice;

    @Schema(description = "Current status of the order", accessMode = AccessMode.READ_ONLY)
    private OrderStatus orderStatus;

    @Schema(description = "Payment method used for the order", accessMode = AccessMode.READ_ONLY)
    private PaymentMethod paymentMethod;

    @Schema(description = "Date and time when the order was created", accessMode = AccessMode.READ_ONLY)
    private ZonedDateTime createdDate;

    @Schema(description = "Date and time when the order was last modified", accessMode = AccessMode.READ_ONLY)
    private ZonedDateTime lastModifiedDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserDetailMobileV1Response getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailMobileV1Response userDetail) {
        this.userDetail = userDetail;
    }

    public DeliveryAddressMobileV1Response getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressMobileV1Response deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<DishToOrderMobileV1Response> getDishesToOrder() {
        return dishesToOrder;
    }

    public void setDishesToOrder(List<DishToOrderMobileV1Response> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
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

        if (!(o instanceof OrderMobileV1Response response)) return false;

        return new EqualsBuilder()
                .append(getId(), response.getId())
                .append(getUserDetail(), response.getUserDetail())
                .append(getDeliveryAddress(), response.getDeliveryAddress())
                .append(getDishesToOrder(), response.getDishesToOrder())
                .append(getTotalPrice(), response.getTotalPrice())
                .append(getOrderStatus(), response.getOrderStatus())
                .append(getPaymentMethod(), response.getPaymentMethod())
                .append(getCreatedDate(), response.getCreatedDate())
                .append(getLastModifiedDate(), response.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getUserDetail())
                .append(getDeliveryAddress())
                .append(getDishesToOrder())
                .append(getTotalPrice())
                .append(getOrderStatus())
                .append(getPaymentMethod())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderMobileV1Response{" +
                "id=" + id +
                ", userDetail=" + userDetail +
                ", deliveryAddress=" + deliveryAddress +
                ", dishesToOrder=" + dishesToOrder +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
