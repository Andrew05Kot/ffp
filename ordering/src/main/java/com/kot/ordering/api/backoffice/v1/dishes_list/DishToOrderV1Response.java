package com.kot.ordering.api.backoffice.v1.dishes_list;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DishToOrderV1Response {

    private UUID id;
    private Integer quantity;
    private String dishName;
    private Long dishId;
    private String dishCategoryName;
    private Long categoryId;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

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

        if (!(o instanceof DishToOrderV1Response that)) return false;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getQuantity(), that.getQuantity())
                .append(getDishName(), that.getDishName())
                .append(getDishCategoryName(), that.getDishCategoryName())
                .append(getDishId(), that.getDishId())
                .append(getCategoryId(), that.getCategoryId())
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
                .append(getCreatedDate())
                .append(getLastModifiedDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DishToOrderMobileV1Response{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", dishName='" + dishName + '\'' +
                ", dishCategoryName='" + dishCategoryName + '\'' +
                ", dishId=" + dishId +
                ", categoryId=" + categoryId +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}


