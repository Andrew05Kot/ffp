package com.kot.bll.order;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.kot.dal.domain.PaymentMethod;

public class Order {

	private Long id;

	private ZonedDateTime createdDate;

	private ZonedDateTime lastModifiedDate;

	private BigDecimal totalPrice;

	private String cardName;

	private String cardNumber;

	private String expiration;

	private String cvv;

	private PaymentMethod paymentMethod;

	private List<Long> selectedDishes;

	private List<String> selectedCategories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		return new EqualsBuilder()
				.append(id, order.id)
				.append(createdDate, order.createdDate)
				.append(lastModifiedDate, order.lastModifiedDate)
				.append(totalPrice, order.totalPrice)
				.append(cardName, order.cardName)
				.append(cardNumber, order.cardNumber)
				.append(expiration, order.expiration)
				.append(cvv, order.cvv)
				.append(paymentMethod, order.paymentMethod)
				.append(selectedCategories, order.selectedCategories)
				.append(selectedDishes, order.selectedDishes)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(createdDate)
				.append(lastModifiedDate)
				.append(totalPrice)
				.append(cardName)
				.append(cardNumber)
				.append(expiration)
				.append(cvv)
				.append(paymentMethod)
				.append(selectedDishes)
				.append(selectedCategories)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				", totalPrice=" + totalPrice +
				", cardName='" + cardName + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				", expiration='" + expiration + '\'' +
				", cvv='" + cvv + '\'' +
				", paymentMethod=" + paymentMethod +
				", selectedDishes=" + selectedDishes +
				", selectedCategories=" + selectedCategories +
				'}';
	}
}
