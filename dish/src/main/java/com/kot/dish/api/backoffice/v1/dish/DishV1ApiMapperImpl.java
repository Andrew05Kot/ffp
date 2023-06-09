package com.kot.dish.api.backoffice.v1.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kot.dish.api.backoffice.v1.category.CategoryV1ApiMapper;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.service.CategoryService;

@Component
public class DishV1ApiMapperImpl implements DishV1ApiMapper {

    @Autowired
    private CategoryV1ApiMapper categoryMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public DishV1Response domainToDto(DishEntity entity) {
        DishV1Response response = new DishV1Response();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setPrice(entity.getPrice());
        response.setImageUrl(entity.getImageUrl());
        response.setCategory(categoryMapper.domainToDto(entity.getCategory()));
        response.setCreatedDate(entity.getCreatedDate());
        response.setLastModifiedDate(entity.getLastModifiedDate());
        return response;
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
