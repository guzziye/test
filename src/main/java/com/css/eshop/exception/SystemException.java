package com.css.eshop.exception;

import org.apache.log4j.Logger;

import com.css.eshop.message.SystemErrorMessage;

/**
 * Extended exception for system related exceptions
 * 
 * @author AIS
 */
public class SystemException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SystemException.class);
	private SystemErrorMessage seEnum;
	private Object[] parameters;
	private boolean hasParam;

	public SystemException(SystemErrorMessage seEnum) {
		super();
		this.setSeEnum(seEnum);
		this.hasParam = false;
	}

	public SystemException(SystemErrorMessage seEnum, Throwable e) {
		super(e);
		this.setSeEnum(seEnum);
	}

	public SystemException(SystemErrorMessage seEnum, Object... objs) {
		super();
		this.setSeEnum(seEnum);
		if (objs != null) {
			hasParam = true;
			this.parameters = objs;
		} else
			hasParam = false;
	}

	/**
	 * Return system error message from SystemErrorMessage variable seEnum
	 * 
	 * @return String that represents system error message
	 */
	public String getNewSystemMessage() {
		if (this.hasParam) {
			log.info("Error message to user:" + seEnum.getSystemMessage(this.getParameters()));
			return seEnum.getSystemMessage(this.getParameters());
		} else {
			log.info("Error message to user:" + seEnum.getSystemMessage());
			return seEnum.getSystemMessage();
		}
	}

	/**
	 * Return class name and system message from SystemErrorMessage variable seEnum
	 * 
	 * @return String that represents class name and system message
	 */
	@Override
	public String toString() {
		final String s = getClass().getName();
		final String message = seEnum.getSystemMessage(getParameters());
		return s + ": " + message;
	}

	private Object[] getParameters() {
		return parameters;
	}

	public void setSeEnum(SystemErrorMessage seEnum) {
		this.seEnum = seEnum;
	}

	
	public SystemErrorMessage getSeEnum() {
		return seEnum;
	}
}