package com.kot.dish.bll.filtering;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<Entity> {

    Specification<Entity> buildSpecification(FilteringCriteria searchCriteria);

}