package com.kot.dish.api.mobile.v1.dish;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.dish.api.mobile.v1.category.CategoryMobileV1Response;

public class DishMobileV1Response {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;
	private Long rating;

	private CategoryMobileV1Response category;

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

	public CategoryMobileV1Response getCategory() {
		return category;
	}

	public void setCategory(CategoryMobileV1Response category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DishMobileV1Response that = (DishMobileV1Response) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(category, that.category)
				.append(price, that.price)
				.append(rating, that.rating)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.append(category)
				.append(price)
				.append(rating)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishMobileV1Response{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				", price=" + price +
				", rating=" + rating +
				'}';
	}
}
