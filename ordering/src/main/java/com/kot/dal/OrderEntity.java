package com.kot.dal;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "ordering")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private ZonedDateTime creationDate;

	@Column(name = "total_price", nullable = false)
	@NotNull
	private BigDecimal totalPrice;

	@Column(name = "card_name", nullable = false)
	@NotBlank
	private String cardName;

	@Column(name = "card_number", nullable = false)
	@NotBlank
	private String cardNumber;

	@Column(name = "expiration", nullable = false)
	@NotBlank
	private String expiration;

	@Column(name = "cvv", nullable = false)
	@NotBlank
	private String cvv;

	@Column(name = "payment_method", nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	@Column(name = "dish_ids")
	@ElementCollection(targetClass = Long.class)
	private List<Long> dishIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
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

		OrderEntity that = (OrderEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(creationDate, that.creationDate)
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
				.append(id)
				.append(creationDate)
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
		return "OrderEntity{" +
				"id=" + id +
				", creationDate=" + creationDate +
				", totalPrice=" + totalPrice +
				", cardName='" + cardName + '\'' +
				", cardNumber='" + cardNumber + '\'' +
				", expiration='" + expiration + '\'' +
				", cvv='" + cvv + '\'' +
				", paymentMethod=" + paymentMethod +
				", dishIds=" + dishIds +
				'}';
	}
}
