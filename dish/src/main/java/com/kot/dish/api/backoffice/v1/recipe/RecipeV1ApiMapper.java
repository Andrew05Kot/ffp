package com.kot.dish.api.backoffice.v1.recipe;

import java.util.List;

import com.kot.dish.api.backoffice.v1.ingredient.IngredientV1Response;
import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.domain.RecipeEntity;

public interface RecipeV1ApiMapper {

	RecipeV1Response domainToDto(RecipeEntity entity, List<String> expandFields);

	RecipeEntity dtoToDomain(RecipeV1Response dto);

}
