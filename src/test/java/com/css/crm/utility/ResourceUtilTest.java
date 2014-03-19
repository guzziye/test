package com.css.crm.utility;

import java.util.Locale;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for ResourceUtil
 * 
 * @author AIS
 */
public class ResourceUtilTest {

	/**
	 * Test for com.css.crm.utility.ResourceUtil#getSystemConfig()
	 * **/
	@Test
	public void testGetSystemConfig() {
		Properties properties = ResourceUtil.getSystemConfig();
		Assert.assertNotNull(properties);
		Assert.assertEquals("20", properties.getProperty("table_rows_display"));
	}

	/**
	 * Test for com.css.crm.utility.ResourceUtil#getSolrConfig()
	 * **/
	@Test
	public void testGetSolrConfig() {
		Properties properties = ResourceUtil.getSolrConfig();
		Assert.assertNotNull(properties);
		Assert.assertEquals("N", properties.getProperty("distrib"));
	}

	/**
	 * Test for com.css.crm.utility.ResourceUtil#getMessageResourceString(String
	 * bundleName, String key, Object params[], Locale locale) return String
	 * **/
	@Test
	public void testGetMessageResourceString() {
//		String MESSAGE_BUNDLE = "com.css.crm.properties.system_info_message";
//		Object params[] = {};
//		String key = "msg_make_sure_not_save";
//		String result = ResourceUtil.getMessageResourceString(MESSAGE_BUNDLE, key, params, Locale.TRADITIONAL_CHINESE);
//		Assert.assertEquals("绾板搫鐣鹃弨鐐棄鐎涙ê鍔滈敍锟� result);
//
//		key = "abcde";
//		String exceptionText = "?? key " + key + " not found ??";
//		String invalidResult = ResourceUtil.getMessageResourceString(MESSAGE_BUNDLE, key, params, Locale.TRADITIONAL_CHINESE);
//		Assert.assertEquals(exceptionText, invalidResult);
	}

	/**
	 * Test for com.css.crm.utility.ResourceUtil#getLabelString(String key)
	 * return String
	 * **/
//	@Test
//	public void testGetLabelString() {
//		String key = "button_ok";
//		String result = ResourceUtil.getLabelString(key);
//		Assert.assertEquals("绾板搫鐣�, result);
//		key = "abced";
//		String exceptionText = "?? key " + key + " not found ??";
//		String invalidResult = ResourceUtil.getLabelString(key);
//		Assert.assertEquals(exceptionText, invalidResult);
//	}
}
