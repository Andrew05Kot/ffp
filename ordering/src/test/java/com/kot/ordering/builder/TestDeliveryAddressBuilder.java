package com.kot.ordering.builder;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.ordering.model.DeliveryAddress;

public class TestDeliveryAddressBuilder {

    private UUID id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String additionalInfo;

    public TestDeliveryAddressBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = UUID.randomUUID();
        this.country = "Country-" + randomValue;
        this.city = "city-" + randomValue;
        this.street = "street-" + randomValue;
        this.houseNumber = "houseNumber-" + randomValue;
        this.additionalInfo = "additionalInfo-" + randomValue;
    }

    public DeliveryAddress build() {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setId(this.id);
        deliveryAddress.setCountry(this.country);
        deliveryAddress.setCity(this.city);
        deliveryAddress.setStreet(this.street);
        deliveryAddress.setHouseNumber(this.houseNumber);
        deliveryAddress.setAdditionalInfo(this.additionalInfo);
        this.initDefaultData();
        return deliveryAddress;
    }

    public DeliveryAddress buildNew() {
        return this.setId(null).build();
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestDeliveryAddressBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public TestDeliveryAddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public TestDeliveryAddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public TestDeliveryAddressBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public TestDeliveryAddressBuilder setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public TestDeliveryAddressBuilder setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }
}
