package com.kot.dish.api.backoffice.v1.mapper;

import com.kot.dish.api.backoffice.v1.dto.DishResponse;
import com.kot.dish.api.backoffice.v1.dto.DishRequest;
import com.kot.dish.bll.model.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishAPIMapperImpl implements DishAPIMapper {

	@Override
	public DishResponse modelToDto(Dish model) {
		DishResponse response = new DishResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setCategoryId(model.getCategoryId());
		return response;
	}

	@Override
	public Dish dtoToModel(DishRequest dto) {
		Dish model = new Dish();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setCategoryId(dto.getCategoryId());
		return model;
	}
}
