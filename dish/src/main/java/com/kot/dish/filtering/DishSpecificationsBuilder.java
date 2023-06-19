package com.kot.dish.filtering;

import java.util.List;

import com.kot.dish.domain.DishEntity;

public class DishSpecificationsBuilder extends EntityFilterSpecificationsBuilder<DishEntity> {

	@Override
	public List<FilteringProperty> getFilterableProperties() {
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