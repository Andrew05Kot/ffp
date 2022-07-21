package com.kot.category.api.mobile.v1;

import com.kot.category.bll.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMobileApiV1MapperImpl implements CategoryMobileApiV1Mapper {

	@Override
	public CategoryMobileApiV1Response modelToDto(Category model) {
		CategoryMobileApiV1Response response = new CategoryMobileApiV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

	@Override
	public Category dtoToModel(CategoryMobileApiV1Request dto) {
		Category model = new Category();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}
}
