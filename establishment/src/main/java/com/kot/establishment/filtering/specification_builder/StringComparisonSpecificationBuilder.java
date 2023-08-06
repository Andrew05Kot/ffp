package com.kot.establishment.filtering.specification_builder;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.kot.establishment.filtering.criteria_parser.FilteringCriteria;
import com.kot.establishment.filtering.criteria_parser.FilteringOperation;


public class StringComparisonSpecificationBuilder<Entity> implements SpecificationBuilder<Entity> {

	public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
			FilteringOperation.EQUAL, FilteringOperation.NOT_EQUAL, FilteringOperation.CONTAIN
	);

	@Override
	public Specification<Entity> buildSpecification(FilteringCriteria searchCriteria) {
		return new StringComparisonSpecification<Entity>(searchCriteria);
	}

}