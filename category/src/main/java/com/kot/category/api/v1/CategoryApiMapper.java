package com.kot.category.api.v1;

import com.kot.category.bll.model.Category;

public interface CategoryApiMapper {

	CategoryResponse modelToDto(Category model);

	Category dtoToModel(CategoryRequest dto);
}
