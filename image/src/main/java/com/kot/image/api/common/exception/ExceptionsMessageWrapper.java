package com.kot.image.api.common.exception;

public class ExceptionsMessageWrapper {

	private String reason;

	public ExceptionsMessageWrapper() {
	}

	public ExceptionsMessageWrapper(String messages) {
		this.reason = messages;
	}

	public String getReason() {
		return reason;
	}

}
