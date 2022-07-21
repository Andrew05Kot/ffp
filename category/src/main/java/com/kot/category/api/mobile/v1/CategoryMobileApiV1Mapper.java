package com.kot.category.api.mobile.v1;

import com.kot.category.bll.model.Category;

public interface CategoryMobileApiV1Mapper {

	CategoryMobileApiV1Response modelToDto(Category model);

	Category dtoToModel(CategoryMobileApiV1Request dto);
}
