package com.css.crm.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for DateUtil
 * 
 * @author AIS
 */
public class DateUtilTest {

	/**
	 * Test for com.css.crm.utility.DateUtil#parseDate(String) Parse String To Date date format yyyy-MM-dd param String return Date
	 * 
	 * @throws ParseException
	 **/
	@Test
	public void testParseDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON);
		Assert.assertEquals(sdf.parse("2012-12-12"), DateUtil.parseDate("2012-12-12"));
		Assert.assertEquals(null, DateUtil.parseDate(""));
		Assert.assertEquals(null, DateUtil.parseDate("abcdef"));
	}

	/**
	 * Test for com.css.crm.utility.DateUtil#formatDate(Date) Parse Date To String date format yyyy-MM-dd param Date return String
	 * 
	 * @throws ParseException
	 **/
	@Test
	public void testFormatDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtil.DATE_FORMAT_COMMON);
		Assert.assertEquals(sdf.format(new Date()), DateUtil.formatDate(new Date()));
		Assert.assertEquals(null, DateUtil.formatDate(null));
	}

	/**
	 * Test for com.css.crm.utility.DateUtil#getMonthOfDate(Date) param Date return String
	 * 
	 * @throws ParseException
	 **/
	@Test
	public void testGetMonthOfDate() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 11, 12);
		Assert.assertEquals("12", DateUtil.getMonthOfDate(calendar.getTime()));
		calendar.set(2013, 0, 12);
		Assert.assertEquals("01", DateUtil.getMonthOfDate(calendar.getTime()));
		Assert.assertEquals(null, DateUtil.getMonthOfDate(null));
	}

	/**
	 * Test for com.css.crm.utility.DateUtil#getDayOfDate(Date) param Date return String
	 * 
	 * @throws ParseException
	 **/
	@Test
	public void testGetDayOfDate() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, 11, 12);
		Assert.assertEquals("12", DateUtil.getDayOfDate(calendar.getTime()));
		calendar.set(2013, 0, 01);
		Assert.assertEquals("01", DateUtil.getDayOfDate(calendar.getTime()));
		Assert.assertEquals(null, DateUtil.getDayOfDate(null));
	}
}
