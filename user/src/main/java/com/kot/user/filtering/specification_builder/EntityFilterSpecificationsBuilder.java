package com.kot.user.filtering.specification_builder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.kot.user.filtering.criteria_parser.FilteringCriteria;
import com.kot.user.filtering.criteria_parser.FilteringProperty;

public abstract class EntityFilterSpecificationsBuilder<Entity> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityFilterSpecificationsBuilder.class);

	protected abstract List<FilteringProperty> getAllowedFilterableProperties();

	public Specification<Entity> buildSpecification(List<FilteringCriteria> searchCriterias) {
		return searchCriterias.stream()
				.map(this::buildSpecification)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.reduce(Specification::and)
				.orElse(null);
	}

	private Optional<Specification<Entity>> buildSpecification(FilteringCriteria searchCriteria) {
		return findFilterablePropertyByCriteria(searchCriteria)
				.map(filterableProperty -> filterableProperty.specificationBuilder().buildSpecification(searchCriteria));
	}

	private Optional<FilteringProperty> findFilterablePropertyByCriteria(FilteringCriteria searchCriteria) {
		return getAllowedFilterableProperties().stream()
				.filter(property -> property.propertyName().equals(searchCriteria.key()))
				.peek(property -> LOGGER.warn("Filtering on property '{}' has been skipped because it's absent in filterableProperties", searchCriteria.key()))
				.findFirst();
	}

	public Specification<Entity> buildSpecification(FilteringCriteria... searchCriteria) {
		return buildSpecification(Arrays.asList(searchCriteria));
	}
}