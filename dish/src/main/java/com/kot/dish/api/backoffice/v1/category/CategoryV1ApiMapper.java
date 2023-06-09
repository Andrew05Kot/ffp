package com.kot.dish.api.backoffice.v1.category;

import com.kot.dish.domain.CategoryEntity;

public interface CategoryV1ApiMapper {

	CategoryV1Response domainToDto(CategoryEntity model);

	CategoryEntity dtoToDomain(CategoryV1Request dto);
}
