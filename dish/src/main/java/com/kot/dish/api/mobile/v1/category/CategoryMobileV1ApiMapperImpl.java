package com.kot.dish.api.mobile.v1.category;

import org.springframework.stereotype.Component;
import com.kot.dish.bll.model.Category;

@Component
public class CategoryMobileV1ApiMapperImpl implements CategoryMobileV1ApiMapper {

	@Override
	public CategoryMobileV1Response modelToDto(Category model) {
		CategoryMobileV1Response response = new CategoryMobileV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setDescription(model.getDescription());
		response.setIconName(model.getIconName());
		return response;
	}

	@Override
	public Category dtoToModel(CategoryMobileV1Request dto) {
		Category model = new Category();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setIconName(dto.getIconName());
		return model;
	}
}
