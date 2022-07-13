package com.kot.dish.api.v1.dto;

import com.kot.dish.dal.entity.DishEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequest {

	private Long id;

	private String name;

	private Long categoryId;

	public DishEntity createEntity() {
		DishEntity entity = new DishEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setCategoryId(categoryId);
		return entity;
	}
}
