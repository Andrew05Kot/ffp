package com.kot.ordering.entity;

import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dish_to_order")
public class DishToOrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 16, name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "quantity", nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "dish_name", nullable = false)
    @NotNull
    private String dishName;

    @Column(name = "dish_category_name", nullable = false)
    private String dishCategoryName;

    @Column(name = "dish_id", nullable = false)
    private Long dishId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishCategoryName() {
        return dishCategoryName;
    }

    public void setDishCategoryName(String dishCategoryName) {
        this.dishCategoryName = dishCategoryName;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DishToOrderEntity that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getQuantity(), that.getQuantity())
                .append(getDishName(), that.getDishName())
                .append(getDishCategoryName(), that.getDishCategoryName())
                .append(getDishId(), that.getDishId())
                .append(getCategoryId(), that.getCategoryId())
                .append(getOrder(), that.getOrder())
                .append(getCreatedDate(), that.getCreatedDate())
                .append(getLastModifiedDate(), that.getLastModifiedDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getQuantity())
                .append(getDishName())
                .append(getDishCategoryName())
                .append(getDishId())
                .append(getCategoryId())
                .append(getOrder())
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DishToOrderEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", dishName='" + dishName + '\'' +
                ", dishCategoryName='" + dishCategoryName + '\'' +
                ", dishId=" + dishId +
                ", categoryId=" + categoryId +
                ", order=" + order + '\'' +
                ", createdDate=" + getCreatedDate() +
                ", lastModifiedDate=" + getLastModifiedDate() +
                '}';
    }
}
