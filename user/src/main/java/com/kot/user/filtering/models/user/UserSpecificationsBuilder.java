package com.kot.user.filtering.models.user;

import java.util.List;

import com.kot.user.entity.UserEntity;
import com.kot.user.filtering.criteria_parser.FilteringProperty;
import com.kot.user.filtering.specification_builder.EntityFilterSpecificationsBuilder;
import com.kot.user.filtering.specification_builder.StringComparisonSpecificationBuilder;


public class UserSpecificationsBuilder extends EntityFilterSpecificationsBuilder<UserEntity> {

	@Override
	public List<FilteringProperty> getAllowedFilterableProperties() {
		return List.of(
				new FilteringProperty("firstName",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<UserEntity>()),
				new FilteringProperty("lastName",
						String.class,
						StringComparisonSpecificationBuilder.SUPPORTED_OPERATORS,
						new StringComparisonSpecificationBuilder<UserEntity>())
		);
	}
}