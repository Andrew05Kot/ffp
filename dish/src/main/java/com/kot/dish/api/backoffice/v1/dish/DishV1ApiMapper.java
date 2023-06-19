package com.kot.dish.api.backoffice.v1.dish;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.dish.api.backoffice.v1.category.CategoryV1ApiMapper;
import com.kot.dish.api.backoffice.v1.infrastructure.ApiV1Mapper;
import com.kot.dish.api.backoffice.v1.recipe.RecipeV1ApiMapper;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.service.CategoryService;

@Component
public class DishV1ApiMapper implements ApiV1Mapper<DishEntity, DishV1Response, DishV1Request> {

	@Autowired
	private CategoryV1ApiMapper categoryMapper;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RecipeV1ApiMapper recipeMapper;

	@Override
	public DishV1Response domainToDto(DishEntity entity, List<String> expandFields) {
		DishV1Response response = new DishV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDescription(entity.getDescription());
		response.setPrice(entity.getPrice());
		response.setImageUrl(entity.getImageUrl());
		response.setCategory(categoryMapper.domainToDto(entity.getCategory()));
		response.setCreatedDate(entity.getCreatedDate());
		response.setLastModifiedDate(entity.getLastModifiedDate());
		if (entity.getRecipe() != null) {
			response.setRecipe(recipeMapper.domainToDto(entity.getRecipe(), null));
		}
		return response;
	}

	@Override
	public DishV1Response domainToDto(DishEntity entity) {
		return domainToDto(entity, null);
	}

	@Override
	public DishEntity dtoToDomain(DishV1Request dto) {
		DishEntity model = new DishEntity();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPrice(dto.getPrice());
		model.setCategory(categoryService.findById(dto.getCategoryId()));
		return model;
	}
}
