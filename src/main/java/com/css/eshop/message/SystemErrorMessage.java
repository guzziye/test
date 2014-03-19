package com.css.eshop.message;

import java.util.Locale;
import com.css.crm.utility.ResourceUtil;

/**
 * Messages for exception error message
 * @author Administrator
 *
 */
public enum SystemErrorMessage {

	SYSTEM_UNEXPECTED_ERROR("GUI1000"),
	SEARCH_CUSTOMER_FAILURE("GUI1001"),
	SOLR_OPERARION_FAILURE("GUI1002"),
	CONTACT_TELEPHONE_DUPLICATE("GUI1003"),
	CONTACT_EMAIL_DUPLICATE("GUI1004"),
	CONTACT_ADDRESS_DUPLICATE("GUI1005"),
	INFO_NOT_FULL("GUI1006"),
	INPUT_FIELD_REQUIRED("GUI1007"),
	INPUT_DATE_INVALID("GUI1008"),
	INPUT_NUBER_INVALID("GUI1009"),
	ATTRIBUTE_DUPLICATE("GUI1010"),
	DISCOUNT_DUPLICATE("GUI1011"),
	DISCOUNT_DEFAULT_DUPLICATE("GUI1012"),
	CUSTOMER_NAME_REQUIRED("GUI1013"),
	CONTACT_TELEPHONE_REQUIRED("GUI1014"),
	CONTACT_EMAIL_REQUIRED("GUI1015"),
	CONTACT_ADDRESS_REQUIRED("GUI1016"),
	INPUT_FORMAT_INVALID("GUI1017"),
	TELEPHONE_LENGTH_INVALID("GUI1018"),
	
	LDAP_AUTHENTICATE_FAILURE("SYS1001"),
	SEND_EMAIL_FAILURE("SYS1002"),
	NO_ACCESS_RIGHT("SYS1003"), 
	NO_READ_RIGHT("SYS1004"), 
	NO_WRITE_RIGHT("SYS1005"), 
	NO_EXECUTE_RIGHT("SYS1006"),
	NO_CUSD_UNIT_CODE("SYS1008"),
	PLACE_TYPE_INVALID("SYS1009"),
	LDAP_AUTHENTICATE_ERROR("SYS2001"),
	UNEXPECTED_EXCEPTION("SYS2002"),
	LOGIN_NO_USER_ID("SYS2003"),
	LOGIN_NO_USER_PWD("SYS2004"),
	SQL_UNEXPECTED_EXCEPTION("DAO1001"),
	SQL_MULTIPLY_RECORD("DAO1002");
	

	public static final String MESSAGE_BUNDLE = "com.css.crm.properties.system_error_message";
	private final String id;

	SystemErrorMessage(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public String getSystemMessage() {
		return getSystemMessage(null);
	}

	public String getSystemMessage(Object[] parameters) {
		return ResourceUtil.getMessageResourceString(MESSAGE_BUNDLE, this.getId(), parameters, Locale.TRADITIONAL_CHINESE);
	}
}
