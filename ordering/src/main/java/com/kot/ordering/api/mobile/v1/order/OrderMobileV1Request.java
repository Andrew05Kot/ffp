package com.kot.ordering.api.mobile.v1.order;

import java.util.List;
import javax.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.api.mobile.v1.delevery_address.DeliveryAddressV1MobileRequest;
import com.kot.ordering.api.mobile.v1.user_details.UserDetailV1MobileRequest;
import com.kot.ordering.entity.PaymentMethod;

public class OrderMobileV1Request {

    @Schema(description = "The name of credit card.",
            example = "Master Card", required = true)
    @Size(max = 50)
    private String cardName;

    @Schema(description = "The number of credit card.",
            example = "8693 3569 3366 6469", required = true)
    @Size(max = 19)
    private String cardNumber;

    @Schema(description = "The expiration time of credit card.",
            example = "21/29", required = true)
    @Size(max = 5)
    private String expiration;

    @Schema(description = "The cvv code of credit card.",
            example = "21/29", required = true)
    @Size(max = 3)
    private String cvv;

    @Schema(description = "The payment method of order. (Enum)")
    private PaymentMethod paymentMethod;

    @Schema(description = "The identification string of User.")
    private String userId;

    @Schema(description = "A list of unique dish identifiers",
            example = "[1, 2]")
    private List<Long> dishIds;

    private UserDetailV1MobileRequest userDetail;

    private DeliveryAddressV1MobileRequest deliveryAddress;

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

    public List<Long> getDishIds() {
        return dishIds;
    }

    public void setDishIds(List<Long> dishIds) {
        this.dishIds = dishIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDetailV1MobileRequest getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailV1MobileRequest userDetail) {
        this.userDetail = userDetail;
    }

    public DeliveryAddressV1MobileRequest getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddressV1MobileRequest deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderMobileV1Request that = (OrderMobileV1Request) o;

        return new EqualsBuilder()
                .append(cardName, that.cardName)
                .append(cardNumber, that.cardNumber)
                .append(expiration, that.expiration)
                .append(cvv, that.cvv)
                .append(paymentMethod, that.paymentMethod)
                .append(userId, that.userId)
                .append(dishIds, that.dishIds)
                .append(userDetail, that.userDetail)
                .append(deliveryAddress, that.deliveryAddress)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(cardName)
                .append(cardNumber)
                .append(expiration)
                .append(cvv)
                .append(paymentMethod)
                .append(userId)
                .append(dishIds)
                .append(userDetail)
                .append(deliveryAddress)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderV1Response{" +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiration='" + expiration + '\'' +
                ", cvv='" + cvv + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", userId=" + userId + '\'' +
                ", dishIds=" + dishIds +
                ", userDetails=" + userDetail +
                ", deliveryAddress=" + deliveryAddress +
                '}';
    }
}
