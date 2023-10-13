package com.kot.ordering.api.mobile.v1.order;

import java.util.List;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressMobileV1Request;
import com.kot.ordering.api.mobile.v1.dishes_list.DishToOrderMobileV1Request;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailMobileV1Request;
import com.kot.ordering.entity.PaymentMethod;

@OpenAPIDefinition(info = @Info(title = "Order Mobile V1 API", version = "1.0", description = "API for requesting orders"))
public class OrderMobileV1Request {

    @Schema(description = "Payment method used for the order", accessMode = AccessMode.READ_WRITE)
    private PaymentMethod paymentMethod;

    @Schema(description = "User details of the order", accessMode = AccessMode.READ_WRITE)
    private UserDetailMobileV1Request userDetail;

    @Schema(description = "Delivery address of the order", accessMode = AccessMode.READ_WRITE)
    private DeliveryAddressMobileV1Request deliveryAddress;

    @ArraySchema(schema = @Schema(description = "List of dishes to order", accessMode = AccessMode.READ_WRITE))
    private List<DishToOrderMobileV1Request> dishes;

    public UserDetailMobileV1Request getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailMobileV1Request userDetail) {
        this.userDetail = userDetail;
    }

    public DeliveryAddressMobileV1Request getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressMobileV1Request deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<DishToOrderMobileV1Request> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishToOrderMobileV1Request> dishes) {
        this.dishes = dishes;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof OrderMobileV1Request that)) return false;

        return new EqualsBuilder()
                .append(getUserDetail(), that.getUserDetail())
                .append(getDeliveryAddress(), that.getDeliveryAddress())
                .append(getDishes(), that.getDishes())
                .append(getPaymentMethod(), that.getPaymentMethod())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getUserDetail())
                .append(getDeliveryAddress())
                .append(getDishes())
                .append(getPaymentMethod())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderMobileV1Request{" +
                "paymentMethod=" + paymentMethod +
                ", userDetail=" + userDetail +
                ", deliveryAddress=" + deliveryAddress +
                ", dishes=" + dishes +
                '}';
    }
}
