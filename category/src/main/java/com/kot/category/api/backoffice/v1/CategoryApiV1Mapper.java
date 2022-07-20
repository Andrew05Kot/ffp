package com.kot.category.api.backoffice.v1;

import com.kot.category.bll.model.Category;

public interface CategoryApiV1Mapper {

	CategoryV1Response modelToDto(Category model);

	Category dtoToModel(CategoryV1Request dto);
}
