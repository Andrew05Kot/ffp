package com.kot.dish.api.backoffice.v1.dish;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.kot.dish.api.backoffice.v1.category.CategoryV1Response;

public class DishV1Response {

	private Long id;

	private String name;

	private String description;

	private CategoryV1Response category;

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

	public CategoryV1Response getCategory() {
		return category;
	}

	public void setCategory(CategoryV1Response category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DishV1Response that = (DishV1Response) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(category, that.category)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.append(category)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishV1Response{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				'}';
	}
}
