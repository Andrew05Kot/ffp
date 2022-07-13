package com.kot.dish.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "dish")
public class DishEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "category_id")
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

		DishEntity that = (DishEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(categoryId, that.categoryId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
				.append(name)
				.append(categoryId)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", categoryId=" + categoryId +
				'}';
	}
}
