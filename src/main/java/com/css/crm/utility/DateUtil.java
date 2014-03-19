/**
 * 
 */
package com.css.crm.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility for date operation
 * @author AIS
 * 
 */
public class DateUtil {
	private static Logger log = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * parse string to date
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON);
			return sdf.parse(dateString);
		} catch (ParseException e) {
			log.error("parse date error:" + e);
			return null;
		}

		

	}

	/**
	 * format date type to string
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON);
		return sdf.format(date);
	}
	
	/**
	 * format date type to string
	 * @param date
	 * @return
	 */
	public static String formatDateYMdms(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON_YMDSM);
		return sdf.format(date);
	}
	/**
	 * parse string to date
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateYMdms(String dateString) {
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON_YMDSM);
			return sdf.parse(dateString);
		} catch (ParseException e) {
			log.error("parse date error:" + e);
			return null;
		}

		

	}

	/**
	 * get month part of date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMonthOfDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat monSdf = new SimpleDateFormat("MM");
		return monSdf.format(date);
	}

	/**
	 * get day part of date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getDayOfDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat monSdf = new SimpleDateFormat("dd");
		return monSdf.format(date);
	}
}
