package com.kot.establishment.api.backoffice.v1;

import com.kot.establishment.api.ApiInfo;
import com.kot.establishment.entity.EstablishmentEntity;
import com.kot.establishment.service.EstablishmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@RequestMapping(EstablishmentV1Controller.API_URL)
@Tag(name = "Establishment Backoffice API V1")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8765"})
public class EstablishmentV1Controller {

    public static final int DEFAULT_PAGE_SIZE = 15;
    public static final int DEFAULT_PAGE_INDEX = 0;
    public static final String DEFAULT_SORT_DIRECTION = "ASC";
    public static final String DEFAULT_SORT_FIELD = "id";
    public static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by(DEFAULT_SORT_DIRECTION).withProperty(DEFAULT_SORT_FIELD));

    @Autowired
    private EstablishmentService establishmentService;

    public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.API_VERSION_V1 + ApiInfo.ESTABLISHMENT_ENDPOINT;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EstablishmentV1Response create(@Validated(Default.class) @RequestBody EstablishmentV1Request request) {
        EstablishmentEntity establishmentEntity = establishmentService.create(request.toEntityForCreate(null));
        return new EstablishmentV1Response(establishmentService.create(establishmentEntity));
    }

    @PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EstablishmentV1Response update(@PathVariable(value = "id") Long id,
                                          @Validated(Default.class) @RequestBody EstablishmentV1Request request) {
        EstablishmentEntity establishmentEntity = establishmentService.update(request.toEntityForCreate(id));
        return new EstablishmentV1Response(establishmentService.create(establishmentEntity));
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public EstablishmentV1Response getById(@PathVariable(value = "id") Long id) {
        return new EstablishmentV1Response(establishmentService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstablishmentPageV1Response getAll(
            @RequestParam(name = "pageIndex") Optional<Integer> pageIndex,
            @RequestParam(name = "pageSize") Optional<Integer> pageSize,
            @RequestParam(name = "sortDirection") Optional<String> sortDirection,
            @RequestParam(name = "sortField") Optional<String> sortField) {
        Sort sort = getSort(sortDirection, sortField);
        Pageable pageable = getResult(pageIndex, pageSize, sort);

        Page<EstablishmentEntity> fetchedPage = establishmentService.findAll(pageable);
        return new EstablishmentPageV1Response(fetchedPage.stream().map(EstablishmentV1Response::new).toList(),
                fetchedPage.getTotalElements(),
                pageable.getPageNumber(),
                pageable.getPageSize());
    }

    private static Pageable getResult(Optional<Integer> pageIndex, Optional<Integer> pageSize, Sort sort) {
        int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
        int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
        return pageIndex.isPresent() && size > 0 ?
                PageRequest.of(index, size, sort)
                : Pageable.unpaged();
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

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public void deleteById(@PathVariable(value = "id") Long id) {
        establishmentService.delete(id);
    }

}
