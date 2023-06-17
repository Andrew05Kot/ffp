package com.kot.dish.api.backoffice.v1.ingredient;

import java.time.Instant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IngredientV1Response {

	private Long id;
	private String name;
	private String description;
	private Double calories;
	private Double sugarPer100Gram;
	private Double proteinPer100Gram;
	private Double fatsPer100Gram;
	private Double carbohydratesPer100Gram;
	private Double carbonDioxidePer100Gram;
	private Instant createdDate = Instant.now();
	private Instant lastModifiedDate = Instant.now();

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		IngredientV1Response that = (IngredientV1Response) o;

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
		return "IngredientResponse{" +
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
