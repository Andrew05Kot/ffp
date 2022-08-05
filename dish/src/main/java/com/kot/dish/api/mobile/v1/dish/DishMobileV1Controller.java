package com.kot.dish.api.mobile.v1.dish;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kot.dish.api.ApiInfo;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.bll.service.DishService;

@RestController
@RequestMapping(DishMobileV1Controller.API_URL)
@Tag(name = "Dish Mobile API")
public class DishMobileV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.MOBILE_API_VERSION_V1 + ApiInfo.DISH_ENDPOINT;

	@Autowired
	private DishService dishService;

	@Autowired
	private DishMobileV1ApiMapper dishAPIMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DishMobileV1Response> getById(@PathVariable Long id) {
		Dish model = dishService.findById(id);
		return new ResponseEntity<>(dishAPIMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<DishMobileV1Response>> getAll() {
		List<Dish> dishEntities = dishService.findAll().getContent();
		List<DishMobileV1Response> dishResponses = dishEntities
				.stream()
				.map(model -> dishAPIMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}

}