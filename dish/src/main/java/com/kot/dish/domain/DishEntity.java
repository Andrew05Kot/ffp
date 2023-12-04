package com.kot.dish.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "dish")
public class DishEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

	@Column(name = "description", length = 5000)
	private String description;

	@Column(name = "price", nullable = false)
	@NotNull
	private BigDecimal price;

	@Column(name = "image_url", length = 5000)
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	@OneToOne(mappedBy = "dish", cascade = CascadeType.ALL)
	private RecipeEntity recipe;

	@ManyToMany
	@JoinTable(
			name = "dish_labels",
			joinColumns = @JoinColumn(name = "dish_id"),
			inverseJoinColumns = @JoinColumn(name = "label_id")
	)
	private Set<LabelEntity> labels;

	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private Instant createdDate = Instant.now();

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Instant lastModifiedDate = Instant.now();

	public DishEntity() {
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

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
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

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
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

	public Set<LabelEntity> getLabels() {
		return labels;
	}

	public void setLabels(Set<LabelEntity> labels) {
		this.labels = labels;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DishEntity that = (DishEntity) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(name, that.name)
				.append(description, that.description)
				.append(category, that.category)
				.append(price, that.price)
				.append(imageUrl, that.imageUrl)
				.append(recipe, that.recipe)
				.append(labels, that.labels)
				.append(createdDate, that.createdDate)
				.append(lastModifiedDate, that.lastModifiedDate)
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
				.append(recipe)
				.append(labels)
				.append(createdDate)
				.append(lastModifiedDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "DishEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				", price=" + price +
				", imageUrl=" + imageUrl +
				", recipe=" + recipe +
				", labels=" + labels +
				", createdDate=" + createdDate +
				", lastModifiedDate=" + lastModifiedDate +
				'}';
	}
}
