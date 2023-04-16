package com.kot.dish.api.backoffice.v1.dish;

import com.kot.dish.api.backoffice.v1.category.CategoryV1ApiMapper;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.bll.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishV1ApiMapperImpl implements DishV1ApiMapper {

	@Autowired
	private CategoryV1ApiMapper categoryMapper;

	@Autowired
	private CategoryService categoryService;

	@Override
	public DishV1Response modelToDto(Dish model) {
		DishV1Response response = new DishV1Response();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setDescription(model.getDescription());
		response.setPrice(model.getPrice());
		response.setImageUrl(model.getImageUrl());
		response.setCategory(categoryMapper.modelToDto(model.getCategory()));
		response.setCreatedDate(model.getCreatedDate());
		response.setLastModifiedDate(model.getLastModifiedDate());
		return response;
	}

	@Override
	public Dish dtoToModel(DishV1Request dto) {
		Dish model = new Dish();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPrice(dto.getPrice());
		model.setCategory(categoryService.findById(dto.getCategoryId()));
		return model;
	}
}
