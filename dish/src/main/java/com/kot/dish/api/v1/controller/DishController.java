package com.kot.dish.api.v1.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.kot.dish.api.v1.dto.DishRequest;
import com.kot.dish.api.v1.dto.DishResponse;
import com.kot.dish.model.DishEntity;
import com.kot.dish.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dishes")
public class DishController {

	@Autowired
	private DishService dishService;

	@PostMapping("/")
	public ResponseEntity<DishResponse> create(@RequestBody DishRequest request) {
		DishEntity entity = request.createEntity();
		entity = dishService.save(entity);
		return new ResponseEntity<>(new DishResponse(entity), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DishResponse> getById(@PathVariable Long id) {
		return new ResponseEntity<>(new DishResponse(dishService.findById(id)), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<DishResponse>> getAll() {
		List<DishEntity> dishEntities = dishService.findAll().getContent();
		List<DishResponse> dishResponses = dishEntities.stream().map(DishResponse::new).collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}

}
