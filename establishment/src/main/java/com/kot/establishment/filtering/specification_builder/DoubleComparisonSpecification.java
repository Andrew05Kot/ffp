package com.kot.establishment.filtering.specification_builder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.Specification;

import com.kot.establishment.filtering.criteria_parser.FilteringCriteria;
import com.kot.establishment.filtering.criteria_parser.FilteringOperation;

public class DoubleComparisonSpecification<Entity> implements Specification<Entity> {

	private final FilteringCriteria searchCriteria;

	public DoubleComparisonSpecification(FilteringCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}


	@Override
	public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Double searchValue = Double.valueOf(searchCriteria.value().toString());
		if (FilteringOperation.GREATER_OR_EQUAL == searchCriteria.operation()) {
			return cb.ge(root.get(searchCriteria.key()), searchValue);
		} else if (FilteringOperation.LESS_OR_EQUAL == searchCriteria.operation()) {
			return cb.le(root.get(searchCriteria.key()), searchValue);
		}
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof DoubleComparisonSpecification<?> that)) return false;

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
		return "DoubleComparisonSpecification{" +
				"searchCriteria=" + searchCriteria +
				'}';
	}
}
