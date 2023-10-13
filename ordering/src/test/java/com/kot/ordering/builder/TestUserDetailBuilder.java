package com.kot.ordering.builder;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.ordering.model.UserDetail;

public class TestUserDetailBuilder {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String imageUrl;
    private ZonedDateTime createdDate = ZonedDateTime.now();
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    public TestUserDetailBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = UUID.randomUUID();
        this.firstName = "first " + randomValue;
        this.lastName = "last " + randomValue;
        this.email = "email " + randomValue;
        this.phoneNumber = "phoneNumber " + randomValue;
        this.imageUrl = "imageUrl " + randomValue;
    }

    public UserDetail build() {
        UserDetail entity = new UserDetail();
        entity.setId(this.id);
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setImageUrl(this.imageUrl);
        entity.setCreatedDate(this.createdDate);
        entity.setLastModifiedDate(this.lastModifiedDate);
        this.initDefaultData();
        return entity;
    }

    public UserDetail buildNew() {
        return this.setId(null).build();
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    private int getRand(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }


    public TestUserDetailBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public TestUserDetailBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TestUserDetailBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TestUserDetailBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public TestUserDetailBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public TestUserDetailBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
