package com.kot.dish.bll.filtering;

import com.kot.dish.dal.entity.DishEntity;

import java.util.List;

public class DishSpecificationsBuilder extends EntityFilterSpecificationsBuilder<DishEntity> {

    @Override
    public List<FilteringProperty> getFilterableProperties() {
        return List.of(
                new FilteringProperty("name",
                        String.class,
                        StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
                        new StringComparisonSpecificationBuilder<DishEntity>()),
                new FilteringProperty("description",
                        String.class,
                        StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
                        new StringComparisonSpecificationBuilder<DishEntity>()),
                new FilteringProperty("category",
                        String.class,
                        StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
                        new StringComparisonSpecificationBuilder<DishEntity>())
        );
    }
}