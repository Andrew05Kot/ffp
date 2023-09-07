package com.kot.ordering.api.backoffice.v1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingV1Utils {

    public static final int DEFAULT_PAGE_SIZE = 15;
    public static final int DEFAULT_PAGE_INDEX = 0;

    public static Sort getSort(Optional<String> sortDirection, Optional<String> sortField, Sort defaultSort) {
        if (sortField.isPresent() && sortDirection.isPresent()) {
            return switch (sortDirection.get().toUpperCase()) {
                case "ASC" -> Sort.by(Sort.Order.asc(sortField.get()));
                case "DESC" -> Sort.by(Sort.Order.desc(sortField.get()));
                default -> defaultSort;
            };
        }
        return defaultSort;
    }

    public static Pageable buildPageable(Optional<Integer> pageIndex, Optional<Integer> pageSize, Sort sort) {
        int size = pageSize.orElse(DEFAULT_PAGE_SIZE);
        int index = pageIndex.orElse(DEFAULT_PAGE_INDEX);
        return pageIndex.isPresent() && size > 0 ?
                PageRequest.of(index, size, sort)
                : Pageable.unpaged();
    }

    public static List<String> parseExpandField(Optional<String> expandFields) {
        return expandFields.map(s -> Arrays.asList(s.split(","))).orElse(Collections.emptyList());
    }

}
