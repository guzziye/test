package com.css.crm.utility;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility for validation
 * 
 * @author AIS
 */
public class ValidateUtil {

	private static final String EMAIL_FORMAT = "^([a-z0-9A-Z]+[\\.\\_\\-\\*\\^]*)+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	private static final String NUMBER_FORMAT = "[-+]?\\d+(\\.\\d+)?";
	private static final String PHONE_FORMAT = "\\+?\\d{6,11}";

	/**
	 * Validate value by pattern
	 * 
	 * @param s
	 *            String to be validated
	 * @param pattern
	 *            Regular expression represent the pattern
	 * @return True if string match the pattern; False otherwise
	 */
	public static boolean validatePattern(String s, String pattern) {
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(s);
		return matcher.matches();
	}

	/**
	 * Validate email format
	 * 
	 * @param email
	 *            Email in string to be validated
	 * @return True if string match the pattern; False otherwise
	 */
	public static boolean validateEmail(String email) {
		return validatePattern(email, EMAIL_FORMAT);
	}

	/**
	 * Validate number format
	 * 
	 * @param number
	 *            Number in string to be validated
	 * @return True if string match the pattern; False otherwise
	 */
	public static boolean validateNumber(String number) {
		return validatePattern(number, NUMBER_FORMAT);
	}

	/**
	 * validate telephone format
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean validatePhoneNumber(String phone) {
		return validatePattern(phone, PHONE_FORMAT);
	}

	/**
	 * Validate string array contain at least one input
	 * 
	 * @param strArray
	 *            String array to be validated
	 * @return True is string array contain at least one input; False otherwise
	 */
	public static boolean validateLeastOneNotEmpty(String... strArray) {
		boolean flag = false;
		if (strArray != null) {
			for (String str : strArray) {
				if (!isEmpty(str)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * Check if object is empty
	 * 
	 * @param obj
	 * @return true if empty , false if not empty
	 */
	private static boolean isEmpty(Object obj) {
		boolean emptyFlag = true;
		if (obj instanceof String) {
			String string = (String) obj;
			if (!"".equals(string) && !"".equals(string.trim())) {
				emptyFlag = false;
			}
		} else if (obj instanceof List) {
			List<?> list = (List<?>) obj;
			if (list.size() > 0) {
				emptyFlag = false;
			}
		} else {
			if (obj != null) {
				emptyFlag = false;
			}
		}
		return emptyFlag;
	}

	/**
	 * Check if all objects is empty
	 * 
	 * @param objArray
	 *            Object array to be checked
	 * @return True is object array is empty; False otherwise
	 */
	public static boolean isAllEmpty(Object... objArray) {
		boolean flag = true;
		if (objArray != null) {
			for (Object obj : objArray) {
				if (!isEmpty(obj)) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * Check if all objects are not empty
	 * 
	 * @param objArray
	 * @return true if all objects not empty, false if some objects empty
	 */
	public static boolean isRecordIntact(Object... objArray) {
		boolean flag = true;
		if (objArray != null) {
			for (Object obj : objArray) {
				if (isEmpty(obj)) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * Check if two object is equal
	 * 
	 * @param obj
	 * @return true if empty , false if not empty
	 */
	public static boolean isEqual(Object obj1, Object obj2) {
		String string1 = convertToString(obj1);
		String string2 = convertToString(obj2);
		return string1.equals(string2);
	}

	/**
	 * Convert object to string type
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToString(Object obj) {
		String resultString = "";
		if (obj instanceof String) {
			resultString = (String) obj;
		} else if (obj instanceof Number) {
			resultString = obj.toString();
		} else if (obj instanceof Date) {
			resultString = DateUtil.formatDate((Date) obj);
		} else {
			resultString = "";
		}
		return resultString;
	}
}
