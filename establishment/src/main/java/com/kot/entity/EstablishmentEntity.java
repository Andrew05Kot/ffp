package com.kot.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "establishment")
public class EstablishmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate = Instant.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EstablishmentEntity that = (EstablishmentEntity) o;

        return new EqualsBuilder().append(id, that.id)
            .append(country, that.country)
            .append(city, that.city)
            .append(street, that.street)
            .append(houseNumber, that.houseNumber)
            .append(createdDate, that.createdDate)
            .append(lastModifiedDate, that.lastModifiedDate)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id)
            .append(country)
            .append(city)
            .append(street)
            .append(houseNumber)
            .append(createdDate)
            .append(lastModifiedDate)
            .toHashCode();
    }

    @Override
    public String toString() {
        return "Establishment{" +
            "id=" + id +
            ", country='" + country + '\'' +
            ", city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", houseNumber='" + houseNumber + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", lastModifiedDate='" + lastModifiedDate + '\'' +
            '}';
    }
}
