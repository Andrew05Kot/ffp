package com.kot.dish.api.backoffice.v1.dish;

import com.kot.dish.api.ApiInfo;
import com.kot.dish.bll.model.Dish;
import com.kot.dish.bll.service.DishService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(DishV1Controller.API_URL)
@Tag(name = "Dish Backoffice API V1")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8765"})
public class DishV1Controller {

    static final int DEFAULT_PAGE_SIZE = 15;
    public static final int DEFAULT_PAGE_INDEX = 0;
    public static final String DEFAULT_SORT_DIRECTION = "ASC";
    public static final String DEFAULT_SORT_FIELD = "id";
    public static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by(DEFAULT_SORT_DIRECTION).withProperty(DEFAULT_SORT_FIELD));

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePage<DishV1Response> getAll(
            @RequestParam(name = "pageIndex") Optional<Integer> pageIndex,
            @RequestParam(name = "pageSize") Optional<Integer> pageSize,
            @RequestParam(name = "sortDirection") Optional<String> sortDirection,
            @RequestParam(name = "sortField") Optional<String> sortField,
            @RequestParam(value = "search", required = false) Optional<String> filter) {
        Sort sort = getSort(sortDirection, sortField);
        Pageable pageable = getResult(pageIndex, pageSize, sort);

        Page<Dish> fetchedPage = filter.isPresent() ? dishService.findAll(filter.get(), pageable) : dishService.findAll(pageable);

        return new ResponsePage<>(fetchedPage.stream().map(dishAPIMapper::modelToDto).toList(),
                fetchedPage.getTotalElements(),
                pageable.getPageNumber(),
                pageable.getPageSize());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/unpaged")
    public List<DishV1Response> getAll() {
        Page<Dish> fetchedPage = dishService.findAll();
        return fetchedPage.stream().map(dishAPIMapper::modelToDto).toList();
    }

    private static Pageable getResult(Optional<Integer> pageIndex, Optional<Integer> pageSize, Sort sort) {
        int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
        int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
        return PageRequest.of(index, size, sort);
    }

    private Sort getSort(Optional<String> sortDirection, Optional<String> sortField) {
        if (sortField.isPresent() && sortDirection.isPresent()) {
            return switch (sortDirection.get().toUpperCase()) {
                case "ASC" -> Sort.by(Sort.Order.asc(sortField.get()));
                case "DESC" -> Sort.by(Sort.Order.desc(sortField.get()));
                default -> DEFAULT_SORT;
            };
        }
        return DEFAULT_SORT;
    }
}
