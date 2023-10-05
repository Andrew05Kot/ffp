package com.kot.dish.filtering.models.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.kot.dish.domain.DishEntity;
import com.kot.dish.filtering.criteria_parser.FilteringCriteria;
import com.kot.dish.filtering.criteria_parser.FilteringCriteriaParser;
import com.kot.dish.filtering.specification_builder.EntityFilterSpecificationsBuilder;
import com.kot.dish.filtering.criteria_parser.FilteringProperty;
import com.kot.dish.filtering.specification_builder.StringComparisonSpecificationBuilder;

@Component
public class DishSpecificationsBuilder extends EntityFilterSpecificationsBuilder<DishEntity> {

	@Autowired
	private FilteringCriteriaParser searchCriteriaParser;

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

	public Specification<DishEntity> buildSpecification(String filter) {
		Specification<DishEntity> filteringSpecification = null;
		if (filter != null) {
			List<FilteringCriteria> searchCriteria = searchCriteriaParser.parseSearchCriteria(filter, getAllowedFilterableProperties());
			filteringSpecification = buildSpecification(searchCriteria);
		}
		return filteringSpecification;
	}
}
