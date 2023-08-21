package com.kot.user.filtering.models.user;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

import com.kot.user.filtering.criteria_parser.FilteringCriteria;
import com.kot.user.filtering.criteria_parser.FilteringOperation;
import com.kot.user.filtering.specification_builder.SpecificationBuilder;

public class UserFullNameSpecificationBuilder<Entity> implements SpecificationBuilder<Entity> {

	public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
			FilteringOperation.EQUAL, FilteringOperation.CONTAIN);

	@Override
	public Specification<Entity> buildSpecification(FilteringCriteria filteringCriteria) {
		return new UserFullNameSpecification<>(filteringCriteria);
	}
}