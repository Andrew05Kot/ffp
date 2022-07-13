package com.kot.category.api.v1;

import java.util.List;
import java.util.stream.Collectors;
import com.kot.category.bll.model.Category;
import com.kot.category.bll.service.CategoryService;
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
@RequestMapping("api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryApiMapper categoryApiMapper;

	@PostMapping("/")
	public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
		Category model = categoryService.save(categoryApiMapper.dtoToModel(request));
		return new ResponseEntity<>(categoryApiMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
		Category model = categoryService.findById(id);
		return new ResponseEntity<>(categoryApiMapper.modelToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryResponse>> getAll() {
		List<Category> dishEntities = categoryService.findAll().getContent();
		List<CategoryResponse> dishResponses = dishEntities
				.stream()
				.map(model -> categoryApiMapper.modelToDto(model))
				.collect(Collectors.toList());
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}
}
