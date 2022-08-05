package com.kot.dish.api.mobile.v1.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.dish.api.mobile.v1.category.CategoryMobileV1ApiMapper;
import com.kot.dish.bll.model.Dish;

@Component
public class DishMobileV1ApiMapperImpl implements DishMobileV1ApiMapper {

	@Autowired
	private CategoryMobileV1ApiMapper categoryMapper;

	@Override
	public DishMobileV1Response modelToDto(Dish model) {
		DishMobileV1Response response = new DishMobileV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setCategory(categoryMapper.modelToDto(model.getCategory()));
		return response;
	}
}
