package com.kot.dish.filtering.criteria_parser;

import com.kot.dish.filtering.exception.IllegalFilteringOperationException;

public enum FilteringOperation {

	EQUAL("="),

	NOT_EQUAL("!="),

	CONTAIN(":"),

	GREATER_THEN(">"),

	GREATER_OR_EQUAL(">="),

	LESS_THEN("<"),

	LESS_OR_EQUAL("<="),

	IN("_="),

	NOT_IN("!_="),

	IS_NULL("IS NULL"),

	IS_NOT_NULL("IS NOT NULL");

	private final String code;

	FilteringOperation(String code) {
		this.code = code;
	}

	public static FilteringOperation fromString(String text) {
		for (FilteringOperation b : FilteringOperation.values()) {
			if (b.code.equalsIgnoreCase(text)) {
				return b;
			}
		}
		throw new IllegalFilteringOperationException("Unknown filtering operation '" + text + "'");
	}

}
