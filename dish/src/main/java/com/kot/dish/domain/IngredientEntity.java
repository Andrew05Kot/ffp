package com.kot.dish.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "ingredient")
public class IngredientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

	@Column(name = "description", length = 5000)
	private String description;

	@Column(name = "calories")
	private Double calories;

	@Column(name = "sugar_per_100_gram")
	private Double sugarPer100Gram;

	@Column(name = "protein_per_100_gram")
	private Double proteinPer100Gram;

	@Column(name = "fats_per_100_gram")
	private Double fatsPer100Gram;

	@Column(name = "carbohydrates_per_100_gram")
	private Double carbohydratesPer100Gram;

	@Column(name = "carbon_dioxide_per_100_gram")
	private Double carbonDioxidePer100Gram;

	@ManyToMany(mappedBy = "ingredients", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<RecipeEntity> recipes = new ArrayList<>();

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate = Instant.now();

	public void addRecipe(RecipeEntity recipe) {
		this.recipes.add(recipe);
	}

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

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public Double getSugarPer100Gram() {
		return sugarPer100Gram;
	}

	public void setSugarPer100Gram(Double sugarPer100Gram) {
		this.sugarPer100Gram = sugarPer100Gram;
	}

	public Double getProteinPer100Gram() {
		return proteinPer100Gram;
	}

	public void setProteinPer100Gram(Double proteinPer100Gram) {
		this.proteinPer100Gram = proteinPer100Gram;
	}

	public Double getFatsPer100Gram() {
		return fatsPer100Gram;
	}

	public void setFatsPer100Gram(Double fatsPer100Gram) {
		this.fatsPer100Gram = fatsPer100Gram;
	}

	public Double getCarbohydratesPer100Gram() {
		return carbohydratesPer100Gram;
	}

	public void setCarbohydratesPer100Gram(Double carbohydratesPer100Gram) {
		this.carbohydratesPer100Gram = carbohydratesPer100Gram;
	}

	public Double getCarbonDioxidePer100Gram() {
		return carbonDioxidePer100Gram;
	}

	public void setCarbonDioxidePer100Gram(Double carbonDioxidePer100Gram) {
		this.carbonDioxidePer100Gram = carbonDioxidePer100Gram;
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

	public List<RecipeEntity> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeEntity> recipes) {
		this.recipes = recipes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		IngredientEntity that = (IngredientEntity) o;

		return new EqualsBuilder().append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(calories, that.calories)
				.append(sugarPer100Gram, that.sugarPer100Gram)
				.append(proteinPer100Gram, that.proteinPer100Gram)
				.append(fatsPer100Gram, that.fatsPer100Gram)
				.append(carbohydratesPer100Gram, that.carbohydratesPer100Gram)
				.append(carbonDioxidePer100Gram, that.carbonDioxidePer100Gram)
				.append(createdDate, that.createdDate)
				.append(lastModifiedDate, that.lastModifiedDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id)
				.append(name)
				.append(description)
				.append(calories)
				.append(sugarPer100Gram)
				.append(proteinPer100Gram)
				.append(fatsPer100Gram)
				.append(carbohydratesPer100Gram)
				.append(carbonDioxidePer100Gram)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "IngredientEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", calories=" + calories +
				", sugarPer100Gram=" + sugarPer100Gram +
				", proteinPer100Gram=" + proteinPer100Gram +
				", fatsPer100Gram=" + fatsPer100Gram +
				", carbohydratesPer100Gram=" + carbohydratesPer100Gram +
				", carbonDioxidePer100Gram=" + carbonDioxidePer100Gram +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
