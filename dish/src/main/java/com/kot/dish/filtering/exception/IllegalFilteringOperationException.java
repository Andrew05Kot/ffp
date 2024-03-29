package com.kot.dish.filtering.exception;

import java.io.Serial;
import java.io.Serializable;

public class IllegalFilteringOperationException extends RuntimeException implements Serializable {

	@Serial
	private static final long serialVersionUID = -461054010965555628L;

	public IllegalFilteringOperationException(String message) {
		super(message);
	}
}