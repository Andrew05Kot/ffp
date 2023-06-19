package com.kot.dish.filtering;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<Entity> {

	Specification<Entity> buildSpecification(FilteringCriteria searchCriteria);

}