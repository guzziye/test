package com.css.eshop.exception;

import org.apache.log4j.Logger;

import com.css.eshop.message.SystemErrorMessage;

/**
 * Extended exception for system related exceptions
 * 
 * @author AIS
 */
public class WebwerviceException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger
			.getLogger(WebwerviceException.class);

	public WebwerviceException() {
		super();
	}

	public WebwerviceException(String message) {
		super(message);
	}

	public WebwerviceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}