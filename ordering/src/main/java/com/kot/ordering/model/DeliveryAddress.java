package com.kot.ordering.model;

import java.time.ZonedDateTime;
import java.util.UUID;

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

    public DeliveryAddress() {}

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
        entity.setCountry(this.country);
        entity.setCity(this.city);
        entity.setStreet(this.street);
        entity.setHouseNumber(this.houseNumber);
        entity.setAdditionalInfo(this.additionalInfo);
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
}
