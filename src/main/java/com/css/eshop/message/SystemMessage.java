package com.css.eshop.message;

import java.util.Locale;
import com.css.crm.utility.ResourceUtil;

/**
 * Messages for information
 * @author Administrator
 *
 */
public enum SystemMessage {
	SYSTEM_SAVE_SUCCEED("msg_save_successful"),	
	SYSTEM_NO_RECORD("msg_search_no_record"),
	SEARCH_MATERIAL_REQUIRED("msg_search_material_required");

	public static final String MESSAGE_BUNDLE = "com.css.crm.properties.system_info_message";
	private final String id;

	SystemMessage(String id) {
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
