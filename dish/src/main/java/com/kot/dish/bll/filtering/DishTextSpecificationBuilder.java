package com.kot.dish.bll.filtering;

import com.kot.dish.dal.entity.DishEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class DishTextSpecificationBuilder implements SpecificationBuilder<DishEntity> {

    public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
            FilteringOperation.EQUAL, FilteringOperation.CONTAIN);

    @Override
    public Specification<DishEntity> buildSpecification(FilteringCriteria filteringCriteria) {
        return new DishTextSpecification(filteringCriteria);
    }
}