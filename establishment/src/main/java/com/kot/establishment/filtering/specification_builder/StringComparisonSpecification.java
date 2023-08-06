package com.kot.establishment.filtering.specification_builder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.Specification;

import com.kot.establishment.filtering.criteria_parser.FilteringCriteria;
import com.kot.establishment.filtering.criteria_parser.FilteringOperation;


public class StringComparisonSpecification<Entity> implements Specification<Entity> {

	private final FilteringCriteria searchCriteria;

	public StringComparisonSpecification(FilteringCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String searchValueLowerCase = StringUtils.lowerCase((String) searchCriteria.value());
		if (FilteringOperation.EQUAL == searchCriteria.operation()) {
			return cb.equal(cb.lower(root.get(searchCriteria.key())), searchValueLowerCase);
		} else if (FilteringOperation.NOT_EQUAL == searchCriteria.operation()) {
			return cb.notEqual(cb.lower(root.get(searchCriteria.key())), searchValueLowerCase);
		} else if (FilteringOperation.CONTAIN == searchCriteria.operation()) {
			return cb.like(cb.lower(root.get(searchCriteria.key())), "%" + searchValueLowerCase + "%");
		} else {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof StringComparisonSpecification<?> that)) return false;

		return new EqualsBuilder()
				.append(searchCriteria, that.searchCriteria)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(searchCriteria)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "StringComparisonSpecification{" +
				"searchCriteria=" + searchCriteria +
				'}';
	}
}