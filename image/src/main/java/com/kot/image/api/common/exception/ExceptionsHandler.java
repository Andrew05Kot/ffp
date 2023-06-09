package com.kot.image.api.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kot.image.exception.MaxFileSizeException;
import com.kot.image.exception.WrongFileFormatException;

@ControllerAdvice
public class ExceptionsHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

	@ExceptionHandler(WrongFileFormatException.class)
	public ResponseEntity<ExceptionsMessageWrapper> handleWrongFileFormatException(WrongFileFormatException ex) {

		ExceptionsMessageWrapper message = new ExceptionsMessageWrapper(ex.getMessage());

		LOGGER.error(message.getReason(), ex);
		return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(MaxFileSizeException.class)
	public ResponseEntity<Object> handleMaxFileSizeException(MaxFileSizeException ex) {

		ExceptionsMessageWrapper message = new ExceptionsMessageWrapper(ex.getMessage());

		LOGGER.error(message.getReason(), ex);
		return new ResponseEntity<>(message, HttpStatus.PAYLOAD_TOO_LARGE);
	}

}
