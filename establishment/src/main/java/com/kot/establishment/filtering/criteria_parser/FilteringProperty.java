package com.kot.establishment.filtering.criteria_parser;

import java.util.List;

import com.kot.establishment.filtering.specification_builder.SpecificationBuilder;

public record FilteringProperty(String propertyName, Class<?> expectedType, List<FilteringOperation> operators,
								SpecificationBuilder specificationBuilder) {
}