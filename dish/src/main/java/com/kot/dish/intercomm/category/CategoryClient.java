package com.kot.dish.intercomm.category;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CATEGORY")
public interface CategoryClient {

	@GetMapping(value = "/api/v1/categories/", consumes = "application/json")
	List<CategoryResponseModel> getCategories();
}
