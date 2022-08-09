package com.kot.api.mobile.v1;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.kot.dal.PaymentMethod;

public class OrderMobileV1Request {

	@Schema(description = "Total price of Order with dishes and discounts",
			example = "26.90", required = false)
	private BigDecimal totalPrice;

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

	@Schema(description = "A list of unique dish identifiers",
			example = "[1, 2]")
	private List<Long> dishIds;

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

	public List<Long> getDishIds() {
		return dishIds;
	}

	public void setDishIds(List<Long> dishIds) {
		this.dishIds = dishIds;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		OrderMobileV1Request that = (OrderMobileV1Request) o;

		return new EqualsBuilder()
				.append(totalPrice, that.totalPrice)
				.append(cardName, that.cardName)
				.append(cardNumber, that.cardNumber)
				.append(expiration, that.expiration)
				.append(cvv, that.cvv)
				.append(paymentMethod, that.paymentMethod)
				.append(dishIds, that.dishIds)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(totalPrice)
				.append(cardName)
				.append(cardNumber)
				.append(expiration)
				.append(cvv)
				.append(paymentMethod)
				.append(dishIds)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "OrderV1Response{" +
				"totalPrice=" + totalPrice +
				", cardName='" + cardName + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				", expiration='" + expiration + '\'' +
				", cvv='" + cvv + '\'' +
				", paymentMethod=" + paymentMethod +
				", dishIds=" + dishIds +
				'}';
	}
}
