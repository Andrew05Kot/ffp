package com.kot;

import lombok.Data;

@Data
public class AddressEntity {

    private String country;
    private String city;
    private String postCode;

    public AddressEntity(String country, String city, String postCode) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
    }
}
