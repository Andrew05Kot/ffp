package com.kot.user.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "ffp_user")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "uuid-hibernate-generator")
	@GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthday")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "house_number")
	private String houseNumber;

	public UUID getId() {
		return id;
	}

	public UserEntity setId(UUID id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserEntity setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public UserEntity setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public UserEntity setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public UserEntity setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCity() {
		return city;
	}

	public UserEntity setCity(String city) {
		this.city = city;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public UserEntity setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public UserEntity setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}

	@Override
	public String toString() {
		return "UserEntity{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthday=" + birthday +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", houseNumber='" + houseNumber + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		UserEntity that = (UserEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(firstName, that.firstName)
				.append(lastName, that.lastName)
				.append(birthday, that.birthday)
				.append(country, that.country)
				.append(city, that.city)
				.append(street, that.street)
				.append(houseNumber, that.houseNumber)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(firstName)
				.append(lastName)
				.append(birthday)
				.append(country)
				.append(city)
				.append(street)
				.append(houseNumber)
				.toHashCode();
	}
}
