package com.kot.category.api.backoffice.v1;

import com.kot.category.bll.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryApiV1MapperImpl implements CategoryApiV1Mapper {

	@Override
	public CategoryV1Response modelToDto(Category model) {
		CategoryV1Response response = new CategoryV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

	@Override
	public Category dtoToModel(CategoryV1Request dto) {
		Category model = new Category();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}
}
