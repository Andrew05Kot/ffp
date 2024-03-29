package com.kot.dish.api.backoffice.v1.category;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kot.dish.api.ApiInfo;
import com.kot.dish.api.backoffice.v1.infrastructure.ApiV1Mapper;
import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.service.CategoryService;

@RestController
@RequestMapping(CategoryV1Controller.API_URL)
@Tag(name = "Category API")
public class CategoryV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.CATEGORY_ENDPOINT;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ApiV1Mapper<CategoryEntity, CategoryV1Response, CategoryV1Request> categoryApiMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<CategoryV1Response> create(@RequestBody CategoryV1Request request) {
		CategoryEntity model = categoryService.save(categoryApiMapper.dtoToDomain(request));
		return new ResponseEntity<>(categoryApiMapper.domainToDto(model), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryV1Response> getById(@PathVariable Long id) {
		CategoryEntity model = categoryService.findById(id);
		return new ResponseEntity<>(categoryApiMapper.domainToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryV1Response>> getAll() {
		List<CategoryEntity> models = categoryService.findAll().getContent();
		List<CategoryV1Response> dishResponses = models
				.stream()
				.map(model -> categoryApiMapper.domainToDto(model))
				.toList();
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}
}
