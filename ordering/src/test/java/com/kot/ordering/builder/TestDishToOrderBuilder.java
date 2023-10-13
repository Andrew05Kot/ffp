package com.kot.ordering.builder;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.ordering.entity.DishToOrderEntity;

public class TestDishToOrderBuilder {

    private UUID id;
    private Integer quantity;
    private String dishName;
    private Long dishId;
    private String dishCategoryName;
    private Long categoryId;

    public TestDishToOrderBuilder() {
        this.initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = UUID.randomUUID();
        this.quantity = Integer.valueOf(getRand(1L, 10L).toString());
        this.dishName = "dishName-" + randomValue;
        this.dishId = randomValue + getRand(1L, 99L);
        this.dishCategoryName = "dishCategoryName-" + randomValue;
        this.categoryId = randomValue + getRand(1L, 99L);
    }

    public DishToOrderEntity build() {
        DishToOrderEntity dishToOrder = new DishToOrderEntity();
        dishToOrder.setId(this.id);
        dishToOrder.setQuantity(this.quantity);
        dishToOrder.setDishName(this.dishName);
        dishToOrder.setDishId(this.dishId);
        dishToOrder.setDishCategoryName(this.dishCategoryName);
        dishToOrder.setCategoryId(this.categoryId);
        this.initDefaultData();
        return dishToOrder;
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestDishToOrderBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public TestDishToOrderBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public TestDishToOrderBuilder setDishName(String dishName) {
        this.dishName = dishName;
        return this;
    }

    public TestDishToOrderBuilder setDishId(Long dishId) {
        this.dishId = dishId;
        return this;
    }

    public TestDishToOrderBuilder setDishCategoryName(String dishCategoryName) {
        this.dishCategoryName = dishCategoryName;
        return this;
    }

    public TestDishToOrderBuilder setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
