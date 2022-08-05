package com.kot.dish.api.backoffice.v1.category;

import com.kot.dish.bll.model.Category;

public interface CategoryV1ApiMapper {

	CategoryV1Response modelToDto(Category model);

	Category dtoToModel(CategoryV1Request dto);
}
