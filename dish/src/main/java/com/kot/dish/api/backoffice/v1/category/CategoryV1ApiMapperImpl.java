package com.kot.dish.api.backoffice.v1.category;

import org.springframework.stereotype.Component;

import com.kot.dish.domain.CategoryEntity;

@Component
public class CategoryV1ApiMapperImpl implements CategoryV1ApiMapper {

	@Override
	public CategoryV1Response domainToDto(CategoryEntity entity) {
		CategoryV1Response response = new CategoryV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		return response;
	}

	@Override
	public CategoryEntity dtoToDomain(CategoryV1Request dto) {
		CategoryEntity model = new CategoryEntity();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}
}
