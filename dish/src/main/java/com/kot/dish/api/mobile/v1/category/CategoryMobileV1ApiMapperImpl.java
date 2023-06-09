package com.kot.dish.api.mobile.v1.category;

import org.springframework.stereotype.Component;

import com.kot.dish.domain.CategoryEntity;

@Component
public class CategoryMobileV1ApiMapperImpl implements CategoryMobileV1ApiMapper {

	@Override
	public CategoryMobileV1Response domainToDto(CategoryEntity entity) {
		CategoryMobileV1Response response = new CategoryMobileV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDescription(entity.getDescription());
		response.setIconName(entity.getIconName());
		return response;
	}
}
