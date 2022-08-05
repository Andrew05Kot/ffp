package com.kot.api.backoffice.v1;

import java.io.Serializable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class UnPagedPage implements Pageable, Serializable {

	private static final long serialVersionUID = 1232825578694716871L;

	@Override
	public boolean isPaged() {
		return false;
	}

	public Pageable previousOrFirst() {
		return this;
	}

	public Pageable next() {
		return this;
	}

	public boolean hasPrevious() {
		return false;
	}

	public int getPageSize() {
		throw new UnsupportedOperationException();
	}

	public int getPageNumber() {
		throw new UnsupportedOperationException();
	}

	public long getOffset() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Sort getSort() {
		return null;
	}

	public Pageable first() {
		return this;
	}

	@Override
	public Pageable withPage(int pageNumber) {
		throw new UnsupportedOperationException();
	}
}
