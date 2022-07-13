//package com.kot.category.bll.mapper;
//
//import com.kot.category.bll.model.Category;
//import com.kot.category.dal.model.CategoryEntity;
//
//public class CategoryMapperImpl implements CategoryMapper {
//
//	@Override
//	public Category entityToModel(CategoryEntity entity) {
//		Category model = new Category();
//		model.setId(entity.getId());
//		model.setName(entity.getName());
//		return model;
//	}
//
//	@Override
//	public CategoryEntity modelToEntity(Category model) {
//		CategoryEntity entity = new CategoryEntity();
//		entity.setId(model.getId());
//		entity.setName(model.getName());
//		return entity;
//	}
//}
