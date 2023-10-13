package com.kot.establishment.filtering.models.establishment;

import java.util.List;


import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.filtering.criteria_parser.FilteringOperation;
import com.kot.establishment.filtering.criteria_parser.FilteringProperty;
import com.kot.establishment.filtering.specification_builder.DoubleComparisonSpecificationBuilder;
import com.kot.establishment.filtering.specification_builder.EntityFilterSpecificationsBuilder;
import com.kot.establishment.filtering.specification_builder.StringComparisonSpecificationBuilder;

public class EstablishmentSpecificationsBuilder extends EntityFilterSpecificationsBuilder<EstablishmentEntity> {

	@Override
	public List<FilteringProperty> getAllowedFilterableProperties() {
		return List.of(
				new FilteringProperty("country",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<EstablishmentEntity>()),
				new FilteringProperty("country",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<EstablishmentEntity>()),
				new FilteringProperty("city",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<EstablishmentEntity>()),
				new FilteringProperty("houseNumber",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<EstablishmentEntity>()),
				new FilteringProperty("latitude",
						Double.class,
						DoubleComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new DoubleComparisonSpecificationBuilder<EstablishmentEntity>()),
				new FilteringProperty("longitude",
						Double.class,
						DoubleComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new DoubleComparisonSpecificationBuilder<EstablishmentEntity>())
		);
	}
}