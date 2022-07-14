package com.kot.dish.api.v1.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.kot.dish.api.v1.dto.DishRequest;
import com.kot.dish.api.v1.dto.DishResponse;
import com.kot.dish.api.v1.mapper.DishAPIMapper;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.bll.service.DishService;
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

	@Autowired
	private DishAPIMapper dishAPIMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<DishResponse> create(@RequestBody DishRequest request) {
		Dish model = dishService.save(dishAPIMapper.dtoToModel(request));
		return new ResponseEntity<>(dishAPIMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DishResponse> getById(@PathVariable Long id) {
		Dish model = dishService.findById(id);
		return new ResponseEntity<>(dishAPIMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<DishResponse>> getAll() {
		List<Dish> dishEntities = dishService.findAll().getContent();
		List<DishResponse> dishResponses = dishEntities
				.stream()
				.map(model -> dishAPIMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}

}
