package com.kot.dish.builder;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.domain.RecipeEntity;

public class TestDishBuilder {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private CategoryEntity category;
    private RecipeEntity recipe;

    private final TestCategoryBuilder testCategoryBuilder = new TestCategoryBuilder();
    private final TestRecipeBuilder testRecipeBuilder = new TestRecipeBuilder();

    public TestDishBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = randomValue;
        this.name = "name- " + randomValue;
        this.description = "description-" + randomValue;
        this.price = getRand(100);
        this.imageUrl = "https://image" + randomValue + ".com";
        this.category = testCategoryBuilder.build();
        this.recipe = testRecipeBuilder.build();
    }

    public DishEntity build() {
        DishEntity entity = new DishEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setPrice(this.price);
        entity.setImageUrl(this.imageUrl);
        entity.setCategory(this.category);
        entity.setRecipe(this.recipe);
        this.initDefaultData();
        return entity;
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    private BigDecimal getRand(int maxValue) {
        BigDecimal max = new BigDecimal(maxValue + ".0");
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        return randFromDouble.divide(max, BigDecimal.ROUND_DOWN);
    }

}
