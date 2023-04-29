package com.kot.intercomm.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DISH")
public interface DishV1Client {

	@GetMapping(value = "/api/v1/dishes/unpaged", consumes = "application/json")
	List<FraudDishV1Response> getDishes();

	@GetMapping(value = "/api/v1/dishes/{id}", consumes = "application/json")
	FraudDishV1Response getDishById(@PathVariable(name = "id") Long id);
}
