package com.kot.dish.api.mobile.v1.category;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CategoryMobileV1Request {

	private Long id;

	private String name;

	private String description;

	private String iconName;

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

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		CategoryMobileV1Request that = (CategoryMobileV1Request) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(iconName, that.iconName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(name)
				.append(description)
				.append(iconName)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "CategoryMobileApiV1Request{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", iconName='" + iconName + '\'' +
				'}';
	}
}
