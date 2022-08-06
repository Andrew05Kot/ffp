package com.kot.dish.api.backoffice.v1.dish;

import java.util.List;
import java.util.stream.Collectors;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kot.dish.api.ApiInfo;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.bll.service.DishService;

@RestController
@RequestMapping(DishV1Controller.API_URL)
@Tag(name = "Dish API")
@CrossOrigin(origins = "http://localhost:4200")
public class DishV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.DISH_ENDPOINT;

	@Autowired
	private DishService dishService;

	@Autowired
	private DishV1ApiMapper dishAPIMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}


	@PostMapping("/")
	public ResponseEntity<DishV1Response> create(@RequestBody DishV1Request request) {
		Dish model = dishService.save(dishAPIMapper.dtoToModel(request));
		return new ResponseEntity<>(dishAPIMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DishV1Response> getById(@PathVariable Long id) {
		Dish model = dishService.findById(id);
		return new ResponseEntity<>(dishAPIMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<DishV1Response>> getAll() {
		List<Dish> dishEntities = dishService.findAll().getContent();
		List<DishV1Response> dishResponses = dishEntities
				.stream()
				.map(model -> dishAPIMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}

}
