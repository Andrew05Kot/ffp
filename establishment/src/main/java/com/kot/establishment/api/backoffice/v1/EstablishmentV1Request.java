package com.kot.establishment.api.backoffice.v1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.establishment.entity.EstablishmentEntity;

public class EstablishmentV1Request {

	private String country;

	private String city;

	private String street;

	private String houseNumber;

	public EstablishmentEntity toEntityForCreate(Long id) {
		EstablishmentEntity entity = new EstablishmentEntity();
		entity.setId(id);
		entity.setCountry(this.country);
		entity.setCity(this.city);
		entity.setStreet(this.street);
		entity.setHouseNumber(this.houseNumber);
		return toEntityForUpdate(entity);
	}

	public EstablishmentEntity toEntityForUpdate(EstablishmentEntity entity) {
		return entity;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		EstablishmentV1Request that = (EstablishmentV1Request) o;

		return new EqualsBuilder()
				.append(country, that.country)
				.append(city, that.city)
				.append(street, that.street)
				.append(houseNumber, that.houseNumber)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(country)
				.append(city)
				.append(street)
				.append(houseNumber)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "EstablishmentV1Response{" +
				"country='" + country + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", houseNumber='" + houseNumber + '\'' +
				'}';
	}
}
