package com.kot.ordering.api.backoffice.v1;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.api.backoffice.v1.delevery_address.DeliveryAddressV1Response;
import com.kot.ordering.api.backoffice.v1.dishes_list.DishToOrderV1Response;
import com.kot.ordering.api.backoffice.v1.user_details.UserDetailV1Response;
import com.kot.ordering.client.FraudDishV1Response;
import com.kot.ordering.entity.OrderStatus;
import com.kot.ordering.entity.PaymentMethod;

public class OrderV1Response {

    private UUID id;
    private BigDecimal totalPrice;

    private PaymentMethod paymentMethod;

    private List<FraudDishV1Response> selectedDishes;

    private List<String> selectedCategories;

    private UserDetailV1Response userDetail;

    private DeliveryAddressV1Response deliveryAddress;

    private OrderStatus orderStatus;

    private List<DishToOrderV1Response> dishesToOrder;

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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<FraudDishV1Response> getSelectedDishes() {
        return selectedDishes;
    }

    public void setSelectedDishes(List<FraudDishV1Response> selectedDishes) {
        this.selectedDishes = selectedDishes;
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public UserDetailV1Response getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailV1Response userDetail) {
        this.userDetail = userDetail;
    }

    public DeliveryAddressV1Response getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressV1Response deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<DishToOrderV1Response> getDishesToOrder() {
        return dishesToOrder;
    }

    public void setDishesToOrder(List<DishToOrderV1Response> dishesToOrder) {
        this.dishesToOrder = dishesToOrder;
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

        if (!(o instanceof OrderV1Response that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getTotalPrice(), that.getTotalPrice())
                .append(getPaymentMethod(), that.getPaymentMethod())
                .append(getSelectedDishes(), that.getSelectedDishes())
                .append(getSelectedCategories(), that.getSelectedCategories())
                .append(getUserDetail(), that.getUserDetail())
                .append(getDeliveryAddress(), that.getDeliveryAddress())
                .append(getOrderStatus(), that.getOrderStatus())
                .append(getDishesToOrder(), that.getDishesToOrder())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getTotalPrice())
                .append(getPaymentMethod())
                .append(getSelectedDishes())
                .append(getSelectedCategories())
                .append(getUserDetail())
                .append(getDeliveryAddress())
                .append(getOrderStatus())
                .append(getDishesToOrder())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderV1Response{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", paymentMethod=" + paymentMethod +
                ", selectedDishes=" + selectedDishes +
                ", selectedCategories=" + selectedCategories +
                ", userDetail=" + userDetail +
                ", deliveryAddress=" + deliveryAddress +
                ", orderStatus=" + orderStatus +
                ", dishesToOrder=" + dishesToOrder +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
