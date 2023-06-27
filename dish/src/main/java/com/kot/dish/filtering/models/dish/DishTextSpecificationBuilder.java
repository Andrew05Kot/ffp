package com.kot.dish.filtering.models.dish;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.kot.dish.domain.DishEntity;
import com.kot.dish.filtering.criteria_parser.FilteringCriteria;
import com.kot.dish.filtering.criteria_parser.FilteringOperation;
import com.kot.dish.filtering.specification_builder.SpecificationBuilder;

public class DishTextSpecificationBuilder implements SpecificationBuilder<DishEntity> {

	public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
			FilteringOperation.EQUAL, FilteringOperation.CONTAIN);

	@Override
	public Specification<DishEntity> buildSpecification(FilteringCriteria filteringCriteria) {
		return new DishTextSpecification(filteringCriteria);
	}
}