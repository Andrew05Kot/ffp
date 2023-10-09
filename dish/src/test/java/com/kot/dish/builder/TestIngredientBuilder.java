package com.kot.dish.builder;

import java.util.concurrent.ThreadLocalRandom;

import com.kot.dish.domain.IngredientEntity;

public class TestIngredientBuilder {

    private Long id;
    private String name;
    private String description;
    private Double calories;
    private Double sugarPer100Gram;
    private Double proteinPer100Gram;
    private Double fatsPer100Gram;
    private Double carbohydratesPer100Gram;
    private Double carbonDioxidePer100Gram;

    public TestIngredientBuilder() {
        initDefaultData();
    }

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = randomValue;
        this.name = "name- " + randomValue;
        this.description = "description-" + randomValue;
        this.calories = randomValue.doubleValue() + 0.5d;
        this.sugarPer100Gram = randomValue.doubleValue() + 5.5;
        this.proteinPer100Gram = randomValue.doubleValue() - 5.5;
        this.fatsPer100Gram = randomValue.doubleValue() + 20.5;
        this.carbohydratesPer100Gram = randomValue.doubleValue() - 10.5;
        this.carbonDioxidePer100Gram = randomValue.doubleValue() + 10.5;
    }

    public IngredientEntity build() {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(this.id);
        ingredientEntity.setName(this.name);
        ingredientEntity.setDescription(this.description);
        ingredientEntity.setCalories(this.calories);
        ingredientEntity.setSugarPer100Gram(this.sugarPer100Gram);
        ingredientEntity.setProteinPer100Gram(this.proteinPer100Gram);
        ingredientEntity.setFatsPer100Gram(this.fatsPer100Gram);
        ingredientEntity.setCarbohydratesPer100Gram(this.carbohydratesPer100Gram);
        ingredientEntity.setCarbonDioxidePer100Gram(this.carbonDioxidePer100Gram);
        initDefaultData();
        return ingredientEntity;
    }

    public IngredientEntity buildNew() {
        return this.setId(null).build();
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestIngredientBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TestIngredientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TestIngredientBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TestIngredientBuilder setCalories(Double calories) {
        this.calories = calories;
        return this;
    }

    public TestIngredientBuilder setSugarPer100Gram(Double sugarPer100Gram) {
        this.sugarPer100Gram = sugarPer100Gram;
        return this;
    }

    public TestIngredientBuilder setProteinPer100Gram(Double proteinPer100Gram) {
        this.proteinPer100Gram = proteinPer100Gram;
        return this;
    }

    public TestIngredientBuilder setFatsPer100Gram(Double fatsPer100Gram) {
        this.fatsPer100Gram = fatsPer100Gram;
        return this;
    }

    public TestIngredientBuilder setCarbohydratesPer100Gram(Double carbohydratesPer100Gram) {
        this.carbohydratesPer100Gram = carbohydratesPer100Gram;
        return this;
    }

    public TestIngredientBuilder setCarbonDioxidePer100Gram(Double carbonDioxidePer100Gram) {
        this.carbonDioxidePer100Gram = carbonDioxidePer100Gram;
        return this;
    }
}
