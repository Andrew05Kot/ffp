package com.kot.user.filtering.specification_builder;

import org.springframework.data.jpa.domain.Specification;

import com.kot.user.filtering.criteria_parser.FilteringCriteria;

public interface SpecificationBuilder<Entity> {

	Specification<Entity> buildSpecification(FilteringCriteria searchCriteria);

}