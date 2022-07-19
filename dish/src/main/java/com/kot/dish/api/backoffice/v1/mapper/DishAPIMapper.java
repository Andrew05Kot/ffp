package com.kot.dish.api.backoffice.v1.mapper;

import com.kot.dish.api.backoffice.v1.dto.DishResponse;
import com.kot.dish.api.backoffice.v1.dto.DishRequest;
import com.kot.dish.bll.model.Dish;

public interface DishAPIMapper {

	DishResponse modelToDto(Dish model);

	Dish dtoToModel(DishRequest dto);
}
