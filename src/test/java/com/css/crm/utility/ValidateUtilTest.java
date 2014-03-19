package com.css.crm.utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for ValidateUtil
 * 
 * @author AIS
 */
public class ValidateUtilTest {

	/**
	 * Test for
	 * com.css.crm.utility.ValidateUtil#validatePattern(java.lang.String
	 * ,java.lang.String)
	 **/
	@Test
	public void testValidatePattern() {
		Assert.assertEquals(true, ValidateUtil.validatePattern("12", "[-+]?\\d+(\\.\\d+)?"));
		Assert.assertEquals(false, ValidateUtil.validatePattern("abc", "[-+]?\\d+(\\.\\d+)?"));
	}

	/**
	 * Test for com.css.crm.utility.ValidateUtil#validateEmail(java.lang.String)
	 **/
	@Test
	public void testValidateEmail() {
		Assert.assertEquals(false, ValidateUtil.validateEmail("12"));
		Assert.assertEquals(true, ValidateUtil.validateEmail("test@test.com"));
		Assert.assertEquals(false, ValidateUtil.validateEmail("test@@test.com"));
		Assert.assertEquals(false, ValidateUtil.validateEmail("test@@test..com"));
	}

	/**
	 * Test for
	 * com.css.crm.utility.ValidateUtil#validateNumber(java.lang.String)
	 **/
	@Test
	public void testValidateNumber() {
		Assert.assertEquals(true, ValidateUtil.validateNumber("12"));
		Assert.assertEquals(false, ValidateUtil.validateNumber("abc"));
	}

	/**
	 * Test for com.css.crm.utility.ValidateUtil#convertToString(Object obj)
	 **/
	@Test
	public void testConvertToString() {
		Object obj = "12";
		Assert.assertEquals("12", ValidateUtil.convertToString(obj));
		obj = 12;
		Assert.assertEquals("12", ValidateUtil.convertToString(obj));
		obj = BigDecimal.valueOf(12);
		Assert.assertEquals("12", ValidateUtil.convertToString(obj));
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 11, 12);
		obj = calendar.getTime();
		Assert.assertEquals("2012-12-12", ValidateUtil.convertToString(obj));
		Assert.assertEquals("", ValidateUtil.convertToString(null));
		Assert.assertEquals("", ValidateUtil.convertToString(""));

	}

	/**
	 * Test for
	 * com.css.crm.utility.ValidateUtil#validateNumber(java.lang.String)
	 **/
	@Test
	public void testValidatePhoneNumber() {
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber(""));// empty
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("12345"));// 5
																				// number
																				// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("123456"));// 6
																				// number
																				// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("1234567"));// 7
																				// number
																				// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("12345678"));// 8
																				// number
																				// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("123456789"));// 9
																					// number
																					// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("1234567899"));// 10
																					// number
																					// telephone
		Assert.assertEquals(true, ValidateUtil.validatePhoneNumber("18689467278"));// 11
																					// number
																					// telephone
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("186894672781"));// 12
																						// number
																						// telephone
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("186894672780"));
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("1868946727a"));
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("1868946727."));
		Assert.assertEquals(false, ValidateUtil.validatePhoneNumber("1868946727*"));
	}

	/**
	 * Test for
	 * com.css.crm.utility.ValidateUtil#validateLeastOneNotEmpty(String...
	 * strArray)
	 **/
	@Test
	public void testValidateLeastOneNotEmpty() {
		Assert.assertEquals(false, ValidateUtil.validateLeastOneNotEmpty(null));
		Assert.assertEquals(false, ValidateUtil.validateLeastOneNotEmpty(""));
		Assert.assertEquals(false, ValidateUtil.validateLeastOneNotEmpty(" "));
		Assert.assertEquals(true, ValidateUtil.validateLeastOneNotEmpty("", "ab"));
		Assert.assertEquals(false, ValidateUtil.validateLeastOneNotEmpty("", ""));
	}

	/**
	 * Test for com.css.crm.utility.ValidateUtil#isAllEmpty(String... strArray)
	 **/
	@Test
	public void testIsAllEmpty() {
		Assert.assertEquals(true, ValidateUtil.isAllEmpty(null));
		Assert.assertEquals(true, ValidateUtil.isAllEmpty(""));
		Assert.assertEquals(false, ValidateUtil.isAllEmpty("ab"));
		Assert.assertEquals(false, ValidateUtil.isAllEmpty(1));
		Assert.assertEquals(false, ValidateUtil.isAllEmpty(false));
		Assert.assertEquals(true, ValidateUtil.isAllEmpty("", null));
	}

	/**
	 * Test for com.css.crm.utility.ValidateUtil#isEqual(Object obj1, Object
	 * obj2)
	 **/
	@Test
	public void testIsEqual() {
		Assert.assertEquals(true, ValidateUtil.isEqual(null, null));
		Assert.assertEquals(true, ValidateUtil.isEqual("", ""));
		Assert.assertEquals(true, ValidateUtil.isEqual("abc", "abc"));
		Assert.assertEquals(true, ValidateUtil.isEqual(new String("abc"), new String("abc")));
		Assert.assertEquals(true, ValidateUtil.isEqual(11, 11));
		Assert.assertEquals(true, ValidateUtil.isEqual("", null));

		Assert.assertEquals(false, ValidateUtil.isEqual("abc", null));
		Assert.assertEquals(false, ValidateUtil.isEqual("abc", ""));
		Assert.assertEquals(false, ValidateUtil.isEqual("abc", "abcd"));
		Assert.assertEquals(false, ValidateUtil.isEqual(new String("abcd"), new String("abc")));
		Assert.assertEquals(false, ValidateUtil.isEqual(11, 12));
	}

	/**
	 * Test for com.css.crm.utility.ValidateUtil#isRecordIntact(String...
	 * strArray)
	 **/
	@Test
	public void testIsRecordIntact() {
		Assert.assertEquals(true, ValidateUtil.isRecordIntact(null));
		Assert.assertEquals(false, ValidateUtil.isRecordIntact(""));
		Assert.assertEquals(false, ValidateUtil.isRecordIntact(" "));
		Assert.assertEquals(true, ValidateUtil.isRecordIntact("ab"));
		Assert.assertEquals(true, ValidateUtil.isRecordIntact(1));
		Assert.assertEquals(true, ValidateUtil.isRecordIntact(false));
		Assert.assertEquals(false, ValidateUtil.isRecordIntact("", null));
		Assert.assertEquals(true, ValidateUtil.isRecordIntact(BigDecimal.ONE));
		List list = new ArrayList();
		list.add("ab");
		Assert.assertEquals(true, ValidateUtil.isRecordIntact(list));
		List emptyList = new ArrayList();
		Assert.assertEquals(false, ValidateUtil.isRecordIntact(emptyList));
	}
}
