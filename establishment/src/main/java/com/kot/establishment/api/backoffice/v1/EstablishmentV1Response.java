package com.kot.establishment.api.backoffice.v1;

import java.time.Instant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.establishment.entity.EstablishmentEntity;

public class EstablishmentV1Response {

	private Long id;

	private String country;

	private String city;

	private String street;

	private String houseNumber;

	private Double latitude;

	private Double longitude;

	private Instant createdDate;

	private Instant lastModifiedDate;

	public EstablishmentV1Response(EstablishmentEntity entity) {
		this.id = entity.getId();
		this.country = entity.getCountry();
		this.city = entity.getCity();
		this.street = entity.getStreet();
		this.houseNumber = entity.getHouseNumber();
		this.latitude = entity.getLatitude();
		this.longitude = entity.getLongitude();
		this.createdDate = entity.getCreatedDate();
		this.lastModifiedDate = entity.getLastModifiedDate();
	}

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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		EstablishmentV1Response that = (EstablishmentV1Response) o;

		return new EqualsBuilder().append(id, that.id)
				.append(country, that.country)
				.append(city, that.city)
				.append(street, that.street)
				.append(houseNumber, that.houseNumber)
				.append(longitude, that.longitude)
				.append(latitude, that.latitude)
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
				.append(longitude)
				.append(latitude)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "EstablishmentV1Response{" +
				"id=" + id +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", houseNumber='" + houseNumber + '\'' +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
