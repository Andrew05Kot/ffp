package com.kot.dish.api.v1.dto;

import com.kot.dish.model.DishEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DishResponse {

	private Long id;

	private String name;

	private Long categoryId;

	public DishResponse(DishEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.categoryId = entity.getCategoryId();
	}
}
