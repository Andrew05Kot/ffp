package com.kot.ordering.api.mobile.v1.dishes_list;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DishToOrderMobileV1Request {

    private Integer quantity;
    private String dishName;
    private String dishCategoryName;
    private Long dishId;
    private Long categoryId;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DishToOrderMobileV1Request that)) return false;

        return new EqualsBuilder()
                .append(getDishId(), that.getDishId())
                .append(getQuantity(), that.getQuantity())
                .append(getDishName(), that.getDishName())
                .append(getDishCategoryName(), that.getDishCategoryName())
                .append(getCategoryId(), that.getCategoryId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getDishId())
                .append(getQuantity())
                .append(getDishName())
                .append(getDishCategoryName())
                .append(getCategoryId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "DishToOrderMobileV1Request{" +
                "dishId=" + dishId +
                ", quantity=" + quantity +
                ", dishName='" + dishName + '\'' +
                ", dishCategoryName='" + dishCategoryName + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}


