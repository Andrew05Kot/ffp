package com.kot.searching;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BasicPredicateBuilder<T> {

    private final List<SearchCriteria> criteria;
    private final Class<T> tClass;
    private final String collectionName;

    public BasicPredicateBuilder(Class<T> tClass, String collectionName) {
        this.criteria = new ArrayList<>();
        this.tClass = tClass;
        this.collectionName = collectionName;
    }

    public void from(String search) throws IllegalArgumentException {
        if (search != null) {
            Pattern pattern = Pattern.compile("([\\w.]+?)([:<>])([\\w.\\- ]+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                SearchCriteria c = new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3));
                if (!c.isValid()) {
                    throw new IllegalArgumentException("Invalid query: " + c.toString());
                }
                this.criteria.add(c);
            }
            if (this.criteria.size() == 0) {
                throw new IllegalArgumentException("Invalid query: " + search);
            }
        }
    }

    public void with(String key, String operation, String value) {
        this.criteria.add(new SearchCriteria(key, operation, value));
    }

    public BooleanExpression build() {
        if (this.criteria.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = criteria.stream().map(param -> {
            BasicPredicate<T> predicate = new BasicPredicate<>(param);
            return predicate.getPredicate(this.tClass, this.collectionName);
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression expression = predicates.remove(0);

        for (BooleanExpression item : predicates) {
            expression = expression.and(item);
        }

        return expression;

    }
}