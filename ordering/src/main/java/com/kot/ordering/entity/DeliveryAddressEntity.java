package com.kot.ordering.entity;

import java.util.UUID;
import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "delivery_address")
public class DeliveryAddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "additional_info")
    private String additionalInfo;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DeliveryAddressEntity entity)) return false;

        return new EqualsBuilder().append(getId(), entity.getId())
                .append(getCountry(), entity.getCountry())
                .append(getCity(), entity.getCity())
                .append(getStreet(), entity.getStreet())
                .append(getHouseNumber(), entity.getHouseNumber())
                .append(getAdditionalInfo(), entity.getAdditionalInfo())
                .append(getOrder(), entity.getOrder())
                .append(getCreatedDate(), getLastModifiedDate())
                .append(getLastModifiedDate(), getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getCountry())
                .append(getCity())
                .append(getStreet())
                .append(getHouseNumber())
                .append(getAdditionalInfo())
                .append(getOrder())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DeliveryAddressEntity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", order=" + order +
                ", createdDate=" + getCreatedDate() + '\'' +
                ", lastModifiedDate=" + getLastModifiedDate() + '\'' +
                '}';
    }
}
