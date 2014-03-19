package com.css.eshop.exception;

import org.apache.log4j.Logger;

/**
 * Extended exception for system related exceptions
 * 
 * @author AIS
 */
public class PreciousMetalException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger
			.getLogger(PreciousMetalException.class);

	public PreciousMetalException() {
		super();
	}

	public PreciousMetalException(String message) {
		super(message);
	}

	public PreciousMetalException(String message, Throwable throwable) {
		super(message, throwable);
	}

}