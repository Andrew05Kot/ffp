package com.kot.dish.api.mobile.v1.dish;

import com.kot.dish.domain.DishEntity;

public interface DishMobileV1ApiMapper {

	DishMobileV1Response domainToDto(DishEntity entity);

}
