package com.kot.user.api.backoffice.v1.user;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserV1Response {

	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	private String country;
	private String city;
	private String street;
	private String houseNumber;
	private String imageUrl;
	private Instant createdDate;
	private Instant lastModifiedDate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		UserV1Response response = (UserV1Response) o;

		return new EqualsBuilder().append(id, response.id)
				.append(firstName, response.firstName)
				.append(lastName, response.lastName)
				.append(email, response.email)
				.append(birthday, response.birthday)
				.append(country, response.country)
				.append(city, response.city)
				.append(street, response.street)
				.append(houseNumber, response.houseNumber)
				.append(imageUrl, response.imageUrl)
				.append(createdDate, response.createdDate)
				.append(lastModifiedDate, response.lastModifiedDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
				.append(firstName)
				.append(lastName)
				.append(email)
				.append(birthday)
				.append(country)
				.append(city)
				.append(street)
				.append(houseNumber)
				.append(imageUrl)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "UserV1Response{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", birthday=" + birthday +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", houseNumber='" + houseNumber + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
