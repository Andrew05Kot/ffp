package com.kot.user.filtering.models.user;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.kot.user.filtering.criteria_parser.FilteringCriteria;


public class UserFullNameSpecification<Entity> implements Specification<Entity> {

	@Serial
	private static final long serialVersionUID = 7197174407983761606L;
	private final FilteringCriteria filteringCriteria;

	public UserFullNameSpecification(FilteringCriteria filteringCriteria) {
		this.filteringCriteria = filteringCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
		Object filterValue = filteringCriteria.value();
		if (filterValue != null) {
			String searchValueLowerCase = StringUtils.lowerCase((String) filterValue);
			List<Predicate> predicates = new ArrayList<>();
			switch (filteringCriteria.operation()) {
				case EQUAL -> {
					predicates.add(criteriaBuilder.equal(root.get("firstName"), filterValue));
					predicates.add(criteriaBuilder.equal(root.get("lastName"), filterValue));
				}
				case CONTAIN -> {
					predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + searchValueLowerCase + "%"));
					predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + searchValueLowerCase + "%"));
				}
				default -> {
				}
			}
			return criteriaBuilder.or(predicates.toArray(Predicate[]::new));
		}
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		UserFullNameSpecification that = (UserFullNameSpecification) o;

		return new EqualsBuilder()
				.append(filteringCriteria, that.filteringCriteria)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(filteringCriteria)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "TextSpecification{" +
				"filteringCriteria=" + filteringCriteria +
				'}';
	}
}