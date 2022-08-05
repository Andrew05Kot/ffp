package com.kot.intercomm.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DISH")
public interface DishClient {

	@GetMapping(value = "/api/v1/dishes/", consumes = "application/json")
	List<DishResponseModel> getDishes();

	@GetMapping(value = "/api/v1/dishes/{id}", consumes = "application/json")
	DishResponseModel getDishById(@PathVariable(name = "id") Long id);
}
