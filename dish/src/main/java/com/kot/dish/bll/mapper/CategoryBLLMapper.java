package com.kot.dish.bll.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.kot.dish.bll.model.Category;
import com.kot.dish.dal.entity.CategoryEntity;

@Mapper
public interface CategoryBLLMapper {

	CategoryBLLMapper INSTANCE = Mappers.getMapper(CategoryBLLMapper.class);

	Category entityToModel(CategoryEntity entity);

	CategoryEntity modelToEntity(Category model);
}
