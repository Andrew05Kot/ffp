package com.kot.dish.api.mobile.v1.mapper;

import com.kot.dish.api.mobile.v1.dto.DishMobileV1Request;
import com.kot.dish.api.mobile.v1.dto.DishMobileV1Response;
import com.kot.dish.bll.model.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishMobileV1APIMapperImpl implements DishMobileV1APIMapper {

	@Override
	public DishMobileV1Response modelToDto(Dish model) {
		DishMobileV1Response response = new DishMobileV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setCategoryId(model.getCategoryId());
		return response;
	}

	@Override
	public Dish dtoToModel(DishMobileV1Request dto) {
		Dish model = new Dish();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setCategoryId(dto.getCategoryId());
		return model;
	}
}
