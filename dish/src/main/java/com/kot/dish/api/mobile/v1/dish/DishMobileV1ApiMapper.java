package com.kot.dish.api.mobile.v1.dish;

import com.kot.dish.bll.model.Dish;

public interface DishMobileV1ApiMapper {

	DishMobileV1Response modelToDto(Dish model);

	Dish dtoToModel(DishMobileV1Request dto);
}
