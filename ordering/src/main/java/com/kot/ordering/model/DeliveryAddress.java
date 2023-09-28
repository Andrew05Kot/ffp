package com.kot.ordering.model;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.entity.DeliveryAddressEntity;

public class DeliveryAddress {

    private UUID id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String additionalInfo;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    public DeliveryAddress() {
    }

    public DeliveryAddress(DeliveryAddressEntity entity) {
        setId(entity.getId());
        setCountry(entity.getCountry());
        setCity(entity.getCity());
        setStreet(entity.getStreet());
        setHouseNumber(entity.getHouseNumber());
        setAdditionalInfo(entity.getAdditionalInfo());
        setCreatedDate(entity.getCreatedDate());
        setLastModifiedDate(entity.getLastModifiedDate());
    }

    public DeliveryAddressEntity getEntity() {
        DeliveryAddressEntity entity = new DeliveryAddressEntity();
        entity.setId(this.id);
        entity.setCountry(this.country);
        entity.setCity(this.city);
        entity.setStreet(this.street);
        entity.setHouseNumber(this.houseNumber);
        entity.setAdditionalInfo(this.additionalInfo);
        entity.setCreatedDate(this.createdDate);
        entity.setLastModifiedDate(this.lastModifiedDate);
        return entity;
    }

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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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

        if (!(o instanceof DeliveryAddress that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getCountry(), that.getCountry())
                .append(getCity(), that.getCity())
                .append(getStreet(), that.getStreet())
                .append(getHouseNumber(), that.getHouseNumber())
                .append(getAdditionalInfo(), that.getAdditionalInfo())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getCountry())
                .append(getCity())
                .append(getStreet())
                .append(getHouseNumber())
                .append(getAdditionalInfo())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
