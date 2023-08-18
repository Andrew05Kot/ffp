package com.kot.user.filtering.criteria_parser;

import java.util.List;

import com.kot.user.filtering.specification_builder.SpecificationBuilder;

public record FilteringProperty(String propertyName, Class<?> expectedType, List<FilteringOperation> operators,
								SpecificationBuilder specificationBuilder) {
}