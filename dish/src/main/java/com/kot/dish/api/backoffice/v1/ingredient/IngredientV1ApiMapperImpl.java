package com.kot.dish.api.backoffice.v1.ingredient;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kot.dish.api.backoffice.v1.infrastructure.ApiV1Mapper;
import com.kot.dish.domain.IngredientEntity;

@Component
public class IngredientV1ApiMapperImpl implements ApiV1Mapper<IngredientEntity, IngredientV1Response, IngredientV1Response> {

	@Override
	public IngredientV1Response domainToDto(IngredientEntity entity, List<String> expandFields) {
		IngredientV1Response response = new IngredientV1Response();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setDescription(entity.getDescription());
		response.setCalories(entity.getCalories());
		response.setSugarPer100Gram(entity.getSugarPer100Gram());
		response.setFatsPer100Gram(entity.getFatsPer100Gram());
		response.setSugarPer100Gram(entity.getSugarPer100Gram());
		response.setProteinPer100Gram(entity.getProteinPer100Gram());
		response.setCarbonDioxidePer100Gram(entity.getCarbonDioxidePer100Gram());
		response.setCarbohydratesPer100Gram(entity.getCarbohydratesPer100Gram());
		response.setCreatedDate(entity.getCreatedDate());
		response.setLastModifiedDate(entity.getLastModifiedDate());
		return response;
	}

	@Override
	public IngredientV1Response domainToDto(IngredientEntity entity) {
		return domainToDto(entity, null);
	}

	@Override
	public IngredientEntity dtoToDomain(IngredientV1Response dto) {
		IngredientEntity entity = new IngredientEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getName());
		entity.setCalories(dto.getCalories());
		entity.setSugarPer100Gram(dto.getSugarPer100Gram());
		entity.setFatsPer100Gram(dto.getFatsPer100Gram());
		return entity;
	}

}
