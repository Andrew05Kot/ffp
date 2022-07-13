package com.kot.dish.api.v1.dto;

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
}
