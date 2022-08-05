package com.kot.dish.api.mobile.v1.category;

import com.kot.dish.bll.model.Category;

public interface CategoryMobileV1ApiMapper {

	CategoryMobileV1Response modelToDto(Category model);

}
