package com.kot.dish.api.mobile.v1.category;

import com.kot.dish.domain.CategoryEntity;

public interface CategoryMobileV1ApiMapper {

	CategoryMobileV1Response domainToDto(CategoryEntity entity);

}
