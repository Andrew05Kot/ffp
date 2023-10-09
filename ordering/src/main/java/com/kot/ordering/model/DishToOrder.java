package com.kot.ordering.model;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.kot.ordering.entity.DishToOrderEntity;

public class DishToOrder {

    private UUID id;
    private Integer quantity;
    private String dishName;
    private String dishCategoryName;
    private Long dishId;
    private Long categoryId;
    private Order order;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

    public DishToOrder() {
    }

    public DishToOrder(DishToOrderEntity entity) {
        setId(entity.getId());
        setQuantity(entity.getQuantity());
        setDishName(entity.getDishName());
        setDishCategoryName(entity.getDishCategoryName());
        setDishId(entity.getDishId());
        setCategoryId(entity.getCategoryId());
        setCreatedDate(entity.getCreatedDate());
        setLastModifiedDate(entity.getLastModifiedDate());
    }

    public DishToOrderEntity getEntity() {
        DishToOrderEntity entity = new DishToOrderEntity();
        entity.setId(this.id);
        entity.setQuantity(this.quantity);
        entity.setDishName(this.dishName);
        entity.setDishCategoryName(this.dishCategoryName);
        entity.setDishId(this.dishId);
        entity.setCategoryId(this.categoryId);
        if (this.order != null) {
            entity.setOrder(this.order.getEntity());
        }
        entity.setLastModifiedDate(this.lastModifiedDate);
        entity.setCreatedDate(this.createdDate);
        return entity;
    }

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DishToOrder that)) return false;

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
        return "DishToOrder{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", dishName='" + dishName + '\'' +
                ", dishCategoryName='" + dishCategoryName + '\'' +
                ", dishId=" + dishId +
                ", categoryId=" + categoryId +
                ", order=" + order +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
