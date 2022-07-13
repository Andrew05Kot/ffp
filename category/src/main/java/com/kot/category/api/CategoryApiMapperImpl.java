package com.kot.category.api;

import com.kot.category.bll.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryApiMapperImpl implements CategoryApiMapper {

	@Override
	public CategoryResponse modelToDto(Category model) {
		CategoryResponse response = new CategoryResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

	@Override
	public Category dtoToModel(CategoryRequest dto) {
		Category model = new Category();
		model.setId(dto.getId());
		model.setName(dto.getName());
		return model;
	}
}
