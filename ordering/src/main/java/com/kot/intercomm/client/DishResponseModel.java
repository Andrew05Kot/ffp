package com.kot.intercomm.client;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DishResponseModel {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private CategoryResponseModel category;

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

	public CategoryResponseModel getCategory() {
		return category;
	}

	public void setCategory(CategoryResponseModel category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DishResponseModel that = (DishResponseModel) o;

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
