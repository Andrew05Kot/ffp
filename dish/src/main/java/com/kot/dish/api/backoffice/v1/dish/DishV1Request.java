package com.kot.dish.api.backoffice.v1.dish;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DishV1Request {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private Long categoryId;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DishV1Request that = (DishV1Request) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(categoryId, that.categoryId)
				.append(description, that.description)
				.append(price, that.price)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(categoryId)
				.append(description)
				.append(price)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishV1Request{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", categoryId=" + categoryId +
				", price=" + price +
				'}';
	}
}
