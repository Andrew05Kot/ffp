package com.kot.category.bll.mapper;

import com.kot.category.bll.model.Category;
import com.kot.category.dal.model.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryBLLMapper {

	CategoryBLLMapper INSTANCE = Mappers.getMapper(CategoryBLLMapper.class);

	Category entityToModel(CategoryEntity entity);

	CategoryEntity modelToEntity(Category model);
}
