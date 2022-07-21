package com.kot.dish.api.mobile.v1.mapper;

import com.kot.dish.api.mobile.v1.dto.DishMobileV1Request;
import com.kot.dish.api.mobile.v1.dto.DishMobileV1Response;
import com.kot.dish.bll.model.Dish;

public interface DishMobileV1APIMapper {

	DishMobileV1Response modelToDto(Dish model);

	Dish dtoToModel(DishMobileV1Request dto);
}
