package com.kot.category.api;

import com.kot.category.bll.model.Category;

public interface CategoryApiMapper {

	CategoryResponse modelToDto(Category model);

	Category dtoToModel(CategoryRequest dto);
}
