package com.kot.dish.api.backoffice.v1.recipe;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.dish.api.backoffice.v1.ingredient.IngredientV1Response;

public class RecipeV1Response {

	private Long id;
	private String name;
	private String description;
	private List<IngredientV1Response> ingredients = new ArrayList<>();
	private Instant createdDate;
	private Instant lastModifiedDate;

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

	public List<IngredientV1Response> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientV1Response> ingredients) {
		this.ingredients = ingredients;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		RecipeV1Response that = (RecipeV1Response) o;

		return new EqualsBuilder().append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(ingredients, that.ingredients)
				.append(createdDate, that.createdDate)
				.append(lastModifiedDate, that.lastModifiedDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
				.append(name)
				.append(description)
				.append(ingredients)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "RecipeV1Response{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", ingredients=" + ingredients +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
