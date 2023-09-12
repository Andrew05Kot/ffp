package com.kot.ordering.api.mobile.v1.delevery_address;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@OpenAPIDefinition(info = @Info(title = "Delivery ADDRESS Mobile V1 API", version = "1.0", description = "API for user's delivery address of requested orders"))
public class DeliveryAddressMobileV1Request {

    @Schema(description = "The country of the delivery address")
    private String country;

    @Schema(description = "The city of the delivery address")
    private String city;

    @Schema(description = "The street of the delivery address")
    private String street;

    @Schema(description = "The house number of the delivery address")
    private String houseNumber;

    @Schema(description = "Additional information about the delivery address")
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

        if (!(o instanceof DeliveryAddressMobileV1Request that)) return false;

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
        return "DeliveryAddressMobileV1Request{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
