package com.kot.dish.filtering;

import java.util.List;

public record FilteringProperty(String propertyName, Class<?> expectedType, List<FilteringOperation> operators,
								SpecificationBuilder specificationBuilder) {
}