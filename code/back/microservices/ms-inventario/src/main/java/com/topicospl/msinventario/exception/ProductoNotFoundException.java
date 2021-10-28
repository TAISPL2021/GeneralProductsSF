package com.topicospl.msinventario.exception;

public class ProductoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNotFoundException(String msg) {
		super(msg);
	}

}
