package com.kot.dish.bll.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Dish {

	private Long id;

	private String name;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Dish dish = (Dish) o;

		return new EqualsBuilder()
				.append(id, dish.id)
				.append(name, dish.name)
				.append(categoryId, dish.categoryId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(categoryId)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "Dish{" +
				"id=" + id +
				", name='" + name + '\'' +
				", categoryId=" + categoryId +
				'}';
	}
}
