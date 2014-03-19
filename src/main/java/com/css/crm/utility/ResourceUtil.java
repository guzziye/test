package com.css.crm.utility;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility for read configuration file
 * 
 * @author AIS
 */
public class ResourceUtil {

	private static Logger log = LoggerFactory.getLogger(ResourceUtil.class);
	private static final String SOLR_CONFIG_FILE = "com/css/crm/config/solr.properties";
	private static final String SYSTEM_CONFIG_FILE = "com/css/crm/config/system.properties";
	public static final String LABEL_BUNDLE = "com.css.crm.properties.system_label";

	protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	/**
	 * get label value by key from specific properties file
	 * 
	 * @param bundleName
	 * @param key
	 * @param params
	 * @param locale
	 * @return
	 */
	public static String getMessageResourceString(String bundleName, String key, Object params[], Locale locale) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale, getCurrentClassLoader(params));
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = "?? key " + key + " not found ??";
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	/**
	 * get label value by key from system_label.properties
	 * 
	 * @param key
	 * @return
	 */
	public static String getLabelString(String key) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(LABEL_BUNDLE, Locale.TRADITIONAL_CHINESE, getCurrentClassLoader(null));
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = "?? key " + key + " not found ??";
		}
		return text;
	}

	/**
	 * load solr.properties file
	 * 
	 * @return
	 */
	public static Properties getSolrConfig() {
		return loadProperties(SOLR_CONFIG_FILE);
	}

	/**
	 * load system.properties file
	 * 
	 * @return
	 */
	public static Properties getSystemConfig() {
		return loadProperties(SYSTEM_CONFIG_FILE);
	}

	/**
	 * load properties file object by file name
	 * 
	 * @param propertiesFile
	 * @return
	 */
	private static Properties loadProperties(String propertiesFile) {
		Properties properties = new Properties();
		ClassLoader cl = ResourceUtil.class.getClassLoader();
		URL url = cl.getResource(propertiesFile);
		try {
			properties.load(url.openStream());
		} catch (IOException e) {
			log.error("get system config file error: " + e);
		}
		return properties;
	}
}
