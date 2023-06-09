package com.kot.dish.api.backoffice.v1.dish;

import com.kot.dish.domain.DishEntity;

public interface DishV1ApiMapper {

	DishV1Response domainToDto(DishEntity entity);

	DishEntity dtoToDomain(DishV1Request dto);
}
