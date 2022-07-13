package com.kot.dish.bll.mapper;

import com.kot.dish.bll.model.Dish;
import com.kot.dish.dal.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DishBLLMapper {

	DishBLLMapper INSTANCE = Mappers.getMapper(DishBLLMapper.class);

	Dish entityToModel(DishEntity entity);

	DishEntity modelToEntity(Dish model);
}
