package com.kot.dish.filtering.models.dish;

import java.util.List;

import com.kot.dish.domain.DishEntity;
import com.kot.dish.filtering.specification_builder.EntityFilterSpecificationsBuilder;
import com.kot.dish.filtering.criteria_parser.FilteringProperty;
import com.kot.dish.filtering.specification_builder.StringComparisonSpecificationBuilder;

public class DishSpecificationsBuilder extends EntityFilterSpecificationsBuilder<DishEntity> {

	@Override
	public List<FilteringProperty> getAllowedFilterableProperties() {
		return List.of(
				new FilteringProperty("text",
						String.class,
						DishTextSpecificationBuilder.SUPPORTED_OPERATORS,
						new DishTextSpecificationBuilder()),
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