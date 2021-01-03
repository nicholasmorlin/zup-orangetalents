package com.orangezup.openingaccount.services.exceptions;

public class DuplicateKeyViolationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateKeyViolationException(String msg) {
		super(msg);
	}
	
	public DuplicateKeyViolationException(String msg, Throwable cause) {
		super (msg, cause);
	}
}