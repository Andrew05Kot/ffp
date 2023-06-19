package com.kot.dish.api.mobile.v1.category;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kot.dish.api.ApiInfo;
import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.service.CategoryService;

@RestController
@RequestMapping(CategoryMobileV1Controller.API_URL)
@Tag(name = "Category Mobile API")
public class CategoryMobileV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.MOBILE_API_VERSION_V1 + ApiInfo.CATEGORY_ENDPOINT;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryMobileV1ApiMapper categoryApiMapper;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return new ResponseEntity<>("Works!", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryMobileV1Response> getById(@PathVariable Long id) {
		CategoryEntity model = categoryService.findById(id);
		return new ResponseEntity<>(categoryApiMapper.domainToDto(model), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryMobileV1Response>> getAll() {
		List<CategoryEntity> dishEntities = categoryService.findAll().getContent();
		List<CategoryMobileV1Response> dishResponses = dishEntities
				.stream()
				.map(model -> categoryApiMapper.domainToDto(model))
				.toList();
		return new ResponseEntity<>(dishResponses, HttpStatus.OK);
	}
}
