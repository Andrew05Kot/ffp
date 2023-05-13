package com.kot.dish.bll.filtering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class EntityFilterSpecificationsBuilder<Entity> {

    private final static Logger LOGGER = LoggerFactory.getLogger(EntityFilterSpecificationsBuilder.class);

    abstract List<FilteringProperty> getFilterableProperties();

    public Specification<Entity> buildSpecification(List<FilteringCriteria> searchCriterias) {

        Specification<Entity> specification = null;
        for (FilteringCriteria searchCriteria : searchCriterias) {
            Optional<FilteringProperty> filterableProperty = getFilterableProperties().stream().filter(
                    property -> property.propertyName().equals(searchCriteria.key())
            ).findFirst();

            if (filterableProperty.isPresent()) {
                FilteringProperty filterablePropertyObject = filterableProperty.get();
                if (specification == null) {
                    specification = Specification.where(filterablePropertyObject.specificationBuilder().buildSpecification(searchCriteria));
                } else {
                    specification = specification.and(filterablePropertyObject.specificationBuilder().buildSpecification(searchCriteria));
                }

            } else {
                LOGGER.warn("Filtering on property '{}' has been skipped because it's absent in filterableProperties", searchCriteria.key());
            }
        }
        return specification;
    }

    public Specification<Entity> buildSpecification(FilteringCriteria... searchCriteria) {
        return buildSpecification(Arrays.asList(searchCriteria));
    }
}
