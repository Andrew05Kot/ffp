package com.kot.image.exception;

public class MaxFileSizeException extends Exception {

	public MaxFileSizeException(Integer maxSize) {
		super("The file size must be less than the " + maxSize);
	}
}
