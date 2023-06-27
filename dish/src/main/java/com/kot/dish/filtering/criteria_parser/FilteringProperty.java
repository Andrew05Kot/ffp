package com.kot.dish.filtering.criteria_parser;

import java.util.List;

import com.kot.dish.filtering.specification_builder.SpecificationBuilder;

public record FilteringProperty(String propertyName, Class<?> expectedType, List<FilteringOperation> operators,
								SpecificationBuilder specificationBuilder) {
}