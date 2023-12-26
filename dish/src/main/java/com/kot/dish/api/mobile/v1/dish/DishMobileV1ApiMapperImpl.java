package com.kot.dish.api.mobile.v1.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.dish.api.mobile.v1.category.CategoryMobileV1ApiMapper;
import com.kot.dish.domain.DishEntity;

@Component
public class DishMobileV1ApiMapperImpl implements DishMobileV1ApiMapper {

	@Autowired
	private CategoryMobileV1ApiMapper categoryMapper;

	@Override
	public DishMobileV1Response domainToDto(DishEntity entity) {
		DishMobileV1Response response = new DishMobileV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDescription(entity.getDescription());
		response.setRating(entity.getRating());
		response.setPrice(entity.getPrice());
		response.setCategory(categoryMapper.domainToDto(entity.getCategory()));
		return response;
	}
}
