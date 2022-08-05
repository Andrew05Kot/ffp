package com.kot.dish.api.backoffice.v1.category;

import org.springframework.stereotype.Component;
import com.kot.dish.bll.model.Category;

@Component
public class CategoryV1ApiMapperImpl implements CategoryV1ApiMapper {

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
