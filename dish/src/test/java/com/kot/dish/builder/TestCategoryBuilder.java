package com.kot.dish.builder;

import java.util.concurrent.ThreadLocalRandom;

import com.kot.dish.domain.CategoryEntity;

public class TestCategoryBuilder {

    private Long id;
    private String name;
    private String description;
    private String iconName;

    private void initDefaultData() {
        Long randomValue = getRand(1L, 9999999L);
        this.id = randomValue;
        this.name = "name- " + randomValue;
        this.description = "description-" + randomValue;
        this.iconName = "icon-" + randomValue;
    }

    public CategoryEntity build() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(this.id);
        categoryEntity.setName(this.name);
        categoryEntity.setDescription(this.description);
        categoryEntity.setIconName(this.iconName);
        return categoryEntity;
    }

    public CategoryEntity buildNew() {
        return this.setId(null).build();
    }

    private Long getRand(Long from, Long to) {
        return ThreadLocalRandom.current().nextLong(from, to);
    }

    public TestCategoryBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TestCategoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TestCategoryBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TestCategoryBuilder setIconName(String iconName) {
        this.iconName = iconName;
        return this;
    }
}
