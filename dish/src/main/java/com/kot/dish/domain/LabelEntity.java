package com.kot.dish.domain;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "label")
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 5000)
    private String description;

    @ManyToMany(mappedBy = "labels")
    private Set<DishEntity> dishes;

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

    public Set<DishEntity> getDishes() {
        return dishes;
    }

    public void setDishes(Set<DishEntity> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LabelEntity that)) return false;

        return new EqualsBuilder().append(getId(), that.getId())
                .append(getName(), that.getName())
                .append(getDescription(), that.getDescription())
                .append(getDishes(), that.getDishes())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getName())
                .append(getDescription())
                .append(getDishes())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "LabelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
