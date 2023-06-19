package com.kot.client;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FraudDishV1Response {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private FraudCategoryV1Response category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public FraudCategoryV1Response getCategory() {
		return category;
	}

	public void setCategory(FraudCategoryV1Response category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		FraudDishV1Response that = (FraudDishV1Response) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(price, that.price)
				.append(category, that.category)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.append(price)
				.append(category)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishResponseModel{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", category=" + category +
				'}';
	}
}
