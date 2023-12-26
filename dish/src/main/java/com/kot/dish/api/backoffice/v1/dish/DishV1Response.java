package com.kot.dish.api.backoffice.v1.dish;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.dish.api.backoffice.v1.category.CategoryV1Response;
import com.kot.dish.api.backoffice.v1.recipe.RecipeV1Response;

public class DishV1Response {

	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private String imageUrl;

	private CategoryV1Response category;

	private Instant createdDate;

	private Instant lastModifiedDate;

	private RecipeV1Response recipe;

	private List<String> labels;
	private Long rating;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public RecipeV1Response getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeV1Response recipe) {
		this.recipe = recipe;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
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

		DishV1Response that = (DishV1Response) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(category, that.category)
				.append(price, that.price)
				.append(imageUrl, that.imageUrl)
				.append(createdDate, that.createdDate)
				.append(lastModifiedDate, that.lastModifiedDate)
				.append(recipe, that.recipe)
				.append(labels, that.labels)
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
				.append(imageUrl)
				.append(createdDate)
				.append(lastModifiedDate)
				.append(recipe)
				.append(rating)
				.append(labels)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishV1Response{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				", price=" + price +
				", imageUrl=" + imageUrl +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				", recipe=" + recipe +
				", rating=" + rating +
				", labels=" + labels +
				'}';
	}
}
