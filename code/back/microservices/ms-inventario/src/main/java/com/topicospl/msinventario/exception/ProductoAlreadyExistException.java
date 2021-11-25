package com.topicospl.msinventario.exception;

public class ProductoAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductoAlreadyExistException(String msg) {
		super(msg);
	}

}
