package com.kot.dish.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "recipe")
public class RecipeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "dish_id")
	private DishEntity dish;

	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", length = 5000)
	private String description;

	@ManyToMany
	@JoinTable(name = "recipe_ingredient",
			joinColumns = @JoinColumn(name = "recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<IngredientEntity> ingredients = new ArrayList<>();

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate = Instant.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DishEntity getDish() {
		return dish;
	}

	public void setDish(DishEntity dish) {
		this.dish = dish;
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

	public List<IngredientEntity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientEntity> ingredients) {
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

		RecipeEntity that = (RecipeEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
//				.append(dish, that.dish)
				.append(name, that.name)
				.append(description, that.description)
				.append(ingredients, that.ingredients)
				.append(createdDate, that.createdDate)
				.append(lastModifiedDate, that.lastModifiedDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
//				.append(dish)
				.append(name)
				.append(description)
				.append(ingredients)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "RecipeEntity{" +
				"id=" + id +
//				", dish=" + dish +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", ingredients=" + ingredients +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
