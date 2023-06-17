package com.kot.dish.api.backoffice.v1.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.dish.api.backoffice.v1.ingredient.IngredientV1ApiMapperImpl;
import com.kot.dish.api.backoffice.v1.ingredient.IngredientV1Response;
import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.domain.RecipeEntity;

@Component
public class RecipeV1ApiMapperImpl implements RecipeV1ApiMapper {

	@Autowired
	private IngredientV1ApiMapperImpl ingredientMapper;

	@Override
	public RecipeV1Response domainToDto(RecipeEntity entity, List<String> expandFields) {
		RecipeV1Response response = new RecipeV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDescription(entity.getDescription());
		response.setCreatedDate(entity.getCreatedDate());
		response.setLastModifiedDate(entity.getLastModifiedDate());
		if (entity.getIngredients() != null && entity.getIngredients().size() > 0) {
			System.out.println("Yes!");
			response.setIngredients(
					entity.getIngredients().stream().map(ingredientEntity -> ingredientMapper.domainToDto(ingredientEntity, null)).toList()
			);
		}
		return response;
	}

	@Override
	public RecipeEntity dtoToDomain(RecipeV1Response dto) {
		RecipeEntity entity = new RecipeEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getName());
		return entity;
	}

}
