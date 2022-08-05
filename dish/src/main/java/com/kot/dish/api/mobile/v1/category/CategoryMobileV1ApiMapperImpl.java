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
}
