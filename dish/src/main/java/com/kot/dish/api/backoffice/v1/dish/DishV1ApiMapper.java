package com.kot.dish.api.backoffice.v1.dish;

import com.kot.dish.bll.model.Dish;

public interface DishV1ApiMapper {

	DishV1Response modelToDto(Dish model);

	Dish dtoToModel(DishV1Request dto);
}
