package com.kot.test_data;

import java.util.concurrent.ThreadLocalRandom;
import com.kot.entity.EstablishmentEntity;

public class EstablishmentBuilder {

	private Long id;

	private String country;

	private String city;

	private String street;

	private String houseNumber;

	public EstablishmentBuilder() {
		this.initDefaultData();
	}

	private void initDefaultData() {
		int randomValue = ThreadLocalRandom.current().nextInt(1, 999999);
		this.id = (long) randomValue;
		this.country = randomValue + "-country";
		this.city = randomValue + "-city";
		this.street = randomValue + "-street";
		this.houseNumber = "" + ThreadLocalRandom.current().nextInt(1, 100);
	}

	public EstablishmentEntity build() {
		EstablishmentEntity entity = new EstablishmentEntity();
		entity.setId(this.id);
		entity.setCountry(this.country);
		entity.setCity(this.city);
		entity.setStreet(this.street);
		entity.setHouseNumber(this.houseNumber);
		initDefaultData();
		return entity;
	}

	public EstablishmentEntity buildNewEntity() {
		return setId(null).build();
	}

	public EstablishmentBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public EstablishmentBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public EstablishmentBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public EstablishmentBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public EstablishmentBuilder setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}
}
