package com.kot.dish.filtering.models.ingredient;

import java.util.List;

import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.filtering.specification_builder.EntityFilterSpecificationsBuilder;
import com.kot.dish.filtering.criteria_parser.FilteringProperty;
import com.kot.dish.filtering.specification_builder.StringComparisonSpecificationBuilder;

public class IngredientSpecificationsBuilder extends EntityFilterSpecificationsBuilder<IngredientEntity> {

	@Override
	public List<FilteringProperty> getAllowedFilterableProperties() {
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