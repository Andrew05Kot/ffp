package com.kot.dish.api.backoffice.v1.dish;

import com.kot.dish.bll.model.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishV1ApiMapperImpl implements DishV1ApiMapper {

	@Override
	public DishV1Response modelToDto(Dish model) {
		DishV1Response response = new DishV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setCategoryId(model.getCategoryId());
		return response;
	}

	@Override
	public Dish dtoToModel(DishV1Request dto) {
		Dish model = new Dish();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setCategoryId(dto.getCategoryId());
		return model;
	}
}
