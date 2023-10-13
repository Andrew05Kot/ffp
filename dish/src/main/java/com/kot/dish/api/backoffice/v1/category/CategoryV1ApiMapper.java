package com.kot.dish.api.backoffice.v1.category;

import java.util.List;
import org.springframework.stereotype.Component;

import com.kot.dish.api.backoffice.v1.infrastructure.ApiV1Mapper;
import com.kot.dish.domain.CategoryEntity;

@Component
public class CategoryV1ApiMapper implements ApiV1Mapper<CategoryEntity, CategoryV1Response, CategoryV1Request> {

	@Override
	public CategoryV1Response domainToDto(CategoryEntity entity, List<String> expandFields) {
		CategoryV1Response response = new CategoryV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		return response;
	}

	@Override
	public CategoryV1Response domainToDto(CategoryEntity entity) {
		return domainToDto(entity, null);
	}

	@Override
	public CategoryEntity dtoToDomain(CategoryV1Request dto) {
		CategoryEntity model = new CategoryEntity();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}

	@Override
	public void copyProperties(CategoryV1Request categoryV1Request, CategoryEntity categoryEntity) {

	}
}
