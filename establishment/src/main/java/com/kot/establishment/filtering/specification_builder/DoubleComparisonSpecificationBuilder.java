package com.kot.establishment.filtering.specification_builder;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.kot.establishment.filtering.criteria_parser.FilteringCriteria;
import com.kot.establishment.filtering.criteria_parser.FilteringOperation;

public class DoubleComparisonSpecificationBuilder<Entity> implements SpecificationBuilder<Entity> {

	public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
			FilteringOperation.GREATER_OR_EQUAL, FilteringOperation.LESS_OR_EQUAL
	);

	@Override
	public Specification<Entity> buildSpecification(FilteringCriteria searchCriteria) {
		return new DoubleComparisonSpecification<>(searchCriteria);
	}

}