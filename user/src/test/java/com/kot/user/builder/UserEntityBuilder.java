package com.kot.user.builder;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.user.entity.UserEntity;

public class UserEntityBuilder {

	private UUID id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String country;
	private String city;
	private String street;
	private String houseNumber;

	public UserEntityBuilder() {
		initDefaultData();
	}

	private void initDefaultData() {
		Long randomValue = getRand(1L, 9999999L);
		this.id = UUID.randomUUID();
		this.firstName = "first " + randomValue;
		this.lastName = "last " + randomValue;
		this.birthday = new Date(getRand(1900, 2023), getRand(1, 12), getRand(1, 28));
		this.country = randomValue % 2 == 0 ? "UKRAINE" : "USA";
		this.city = "city" + randomValue;
		this.street = "street" + randomValue;
		this.houseNumber = randomValue + "A";
	}

	public UserEntity build() {
		UserEntity entity = new UserEntity();
		entity.setId(this.id);
		entity.setFirstName(this.firstName);
		entity.setLastName(this.lastName);
		entity.setBirthday(this.birthday);
		entity.setCountry(this.country);
		entity.setCity(this.city);
		entity.setStreet(this.street);
		entity.setHouseNumber(this.houseNumber);
		this.initDefaultData();
		return entity;
	}

	public UserEntity buildNew() {
		return this.setId(null).build();
	}

	private Long getRand(Long from, Long to) {
		return ThreadLocalRandom.current().nextLong(from, to);
	}

	private int getRand(int from, int to) {
		return ThreadLocalRandom.current().nextInt(from, to);
	}

	public UserEntityBuilder setId(UUID id) {
		this.id = id;
		return this;
	}

	public UserEntityBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserEntityBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserEntityBuilder setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	public UserEntityBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public UserEntityBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public UserEntityBuilder setStreet(String street) {
		this.street = street;
		return this;
	}

	public UserEntityBuilder setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}
}
