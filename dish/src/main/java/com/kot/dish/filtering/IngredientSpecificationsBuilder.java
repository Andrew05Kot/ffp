package com.kot.dish.filtering;

import java.util.List;

import com.kot.dish.domain.IngredientEntity;

public class IngredientSpecificationsBuilder extends EntityFilterSpecificationsBuilder<IngredientEntity> {

	@Override
	public List<FilteringProperty> getFilterableProperties() {
		return List.of(
				new FilteringProperty("name",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<IngredientEntity>()),
				new FilteringProperty("description",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<IngredientEntity>())
		);
	}
}