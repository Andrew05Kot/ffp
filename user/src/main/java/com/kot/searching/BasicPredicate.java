package com.kot.searching;

import com.querydsl.core.types.dsl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class BasicPredicate<T> {

    private SearchCriteria criteria;

    BasicPredicate(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    BooleanExpression getPredicate(Class<T> tClass, String collectionName) {
        PathBuilder<T> entityPath = new PathBuilder<>(tClass, collectionName);

        // Date criteria
        if (this.isDate(criteria.getValue())) {
            DatePath<LocalDate> datePath = entityPath.getDate(criteria.getKey(), LocalDate.class);
            switch (criteria.getOperation()) {
                case ":":
                    return datePath.eq(LocalDate.parse(criteria.getValue()));
                case ">":
                    return datePath.gt(LocalDate.parse(criteria.getValue()));
                case "<":
                    return datePath.lt(LocalDate.parse(criteria.getValue()));
            }
        }

        if (this.isNumber(criteria.getValue())) {
            NumberPath<BigDecimal> numPath = entityPath.getNumber(criteria.getKey(), BigDecimal.class);
            switch (criteria.getOperation()) {
                case ":":
                    return numPath.eq(new BigDecimal(criteria.getValue()));
                case ">":
                    return numPath.gt(new BigDecimal(criteria.getValue()));
                case "<":
                    return numPath.lt(new BigDecimal(criteria.getValue()));
            }
        }

        StringPath stringPath = entityPath.getString(criteria.getKey());
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            return stringPath.containsIgnoreCase(criteria.getValue());
        }

        return null;
    }

    private boolean isDate(String value) {
        try {
            LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String value) {
        try {
            new BigDecimal(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}