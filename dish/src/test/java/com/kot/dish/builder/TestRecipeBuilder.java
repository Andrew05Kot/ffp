package com.kot.dish.builder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.domain.RecipeEntity;

public class TestRecipeBuilder {

    private Long id;
    private String name;
    private String description;
    private List<IngredientEntity> ingredients;

    private final TestIngredientBuilder testIngredientBuilder = new TestIngredientBuilder();

    public TestRecipeBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = randomValue;
        this.name = "name- " + randomValue;
        this.description = "description-" + randomValue;
        this.ingredients = Arrays.asList(testIngredientBuilder.build(), testIngredientBuilder.build());
    }

    public RecipeEntity build() {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(this.id);
        recipeEntity.setName(this.name);
        recipeEntity.setDescription(this.description);
        recipeEntity.setIngredients(this.ingredients);
        initDefaultData();
        return recipeEntity;
    }

    public RecipeEntity buildNew() {
        return this.setId(null).build();
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestRecipeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TestRecipeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TestRecipeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TestRecipeBuilder setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
