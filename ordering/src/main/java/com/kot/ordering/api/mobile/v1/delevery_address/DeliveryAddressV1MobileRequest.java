package com.kot.ordering.api.mobile.v1.delevery_address;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DeliveryAddressV1MobileRequest {

    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String additionalInfo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DeliveryAddressV1MobileRequest that)) return false;

        return new EqualsBuilder()
                .append(getCountry(), that.getCountry())
                .append(getCity(), that.getCity())
                .append(getStreet(), that.getStreet())
                .append(getHouseNumber(), that.getHouseNumber())
                .append(getAdditionalInfo(), that.getAdditionalInfo())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCountry())
                .append(getCity())
                .append(getStreet())
                .append(getHouseNumber())
                .append(getAdditionalInfo())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DeliveryAddressV1MobileRequest{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
