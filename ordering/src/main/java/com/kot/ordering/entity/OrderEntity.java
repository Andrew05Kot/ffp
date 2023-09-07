package com.kot.ordering.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @Column(name = "selected_dishes_ids")
    @ElementCollection(targetClass = Long.class)
    private List<Long> selectedDishes;

    @Column(name = "selected_categories")
    @ElementCollection(targetClass = String.class)
    private List<String> selectedCategories;

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

        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(getCreatedDate(), getLastModifiedDate())
                .append(getLastModifiedDate(), getLastModifiedDate())
                .append(totalPrice, that.totalPrice)
                .append(cardName, that.cardName)
                .append(cardNumber, that.cardNumber)
                .append(expiration, that.expiration)
                .append(cvv, that.cvv)
                .append(paymentMethod, that.paymentMethod)
                .append(selectedCategories, that.selectedCategories)
                .append(selectedDishes, that.selectedDishes)
                .append(deliveryAddress, that.deliveryAddress)
                .append(userDetail, that.userDetail)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .append(totalPrice)
                .append(cardName)
                .append(cardNumber)
                .append(expiration)
                .append(cvv)
                .append(paymentMethod)
                .append(selectedDishes)
                .append(selectedCategories)
                .append(deliveryAddress)
                .append(userDetail)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiration='" + expiration + '\'' +
                ", cvv='" + cvv + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", selectedDishes=" + selectedDishes +
                ", selectedCategories=" + selectedCategories +
//                ", deliveryAddress=" + deliveryAddress +
//                ", userDetail=" + userDetail +
                ", createdDate=" + getCreatedDate() +
                ", lastModifiedDate=" + getLastModifiedDate() +
                '}';
    }
}
