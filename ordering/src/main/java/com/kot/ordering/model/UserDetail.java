package com.kot.ordering.model;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.entity.UserDetailEntity;

public class UserDetail {

    private UUID id;
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String imageUrl;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    public UserDetail() {}

    public UserDetail(UserDetailEntity entity) {
        setId(entity.getId());
        setFirstName(entity.getFirstName());
        setUserId(entity.getUserId());
        setLastName(entity.getLastName());
        setEmail(entity.getEmail());
        setPhoneNumber(entity.getPhoneNumber());
        setImageUrl(entity.getImageUrl());
        setCreatedDate(entity.getCreatedDate());
        setLastModifiedDate(entity.getLastModifiedDate());
    }

    public UserDetailEntity getEntity() {
        UserDetailEntity entity = new UserDetailEntity();
        entity.setId(this.id);
        entity.setUserId(this.userId);
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setImageUrl(this.imageUrl);
        return entity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

        if (!(o instanceof UserDetail that)) return false;

        return new EqualsBuilder().append(getId(), that.getId())
                .append(getUserId(), that.getUserId())
                .append(getFirstName(), that.getFirstName())
                .append(getLastName(), that.getLastName())
                .append(getEmail(), that.getEmail())
                .append(getPhoneNumber(), that.getPhoneNumber())
                .append(getImageUrl(), that.getImageUrl())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getUserId())
                .append(getFirstName())
                .append(getLastName())
                .append(getEmail())
                .append(getPhoneNumber())
                .append(getImageUrl())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }
}
