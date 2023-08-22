package com.kot.user.api.backoffice.v1.user;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class MockPage<E> implements Page {

	private int totalElements;
	private List<E> content;

	public MockPage(int totalElements, List<E> content) {
		this.totalElements = totalElements;
		this.content = content;
	}

	@Override
	public long getTotalElements() {
		return this.content.size();
	}

	@Override
	public List getContent() {
		return this.content;
	}

	@Override
	public int getTotalPages() {
		return 0;
	}

	@Override
	public Page map(Function converter) {
		return null;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int getNumberOfElements() {
		return 0;
	}

	@Override
	public boolean hasContent() {
		return false;
	}

	@Override
	public Sort getSort() {
		return null;
	}

	@Override
	public boolean isFirst() {
		return false;
	}

	@Override
	public boolean isLast() {
		return false;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}

	@Override
	public Pageable nextPageable() {
		return null;
	}

	@Override
	public Pageable previousPageable() {
		return null;
	}

	@Override
	public Iterator iterator() {
		return null;
	}
}
