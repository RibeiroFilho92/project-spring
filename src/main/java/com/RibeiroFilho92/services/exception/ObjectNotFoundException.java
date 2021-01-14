package com.RibeiroFilho92.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
