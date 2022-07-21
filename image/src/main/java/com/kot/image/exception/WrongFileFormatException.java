package com.kot.image.exception;

import java.util.List;

public class WrongFileFormatException extends Exception {

	public WrongFileFormatException(List<String> supportedFormats) {
		super("We don't support this file format. Supported formats are " + supportedFormats);
	}

	public WrongFileFormatException(String message) {
		super(message);
	}
}
