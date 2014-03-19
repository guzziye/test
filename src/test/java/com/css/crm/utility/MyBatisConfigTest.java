package com.css.crm.utility;

import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import com.css.crm.dbunit.DbUnit;
import com.css.db.MyBatisConfig;

/*
 * Test for MyBatisConfig
 * @author AIS
 *
 */
public class MyBatisConfigTest extends TestCase {

	DbUnit dbConfig = new DbUnit();

	/**
	 * Test for com.css.crm.utility.MyBatisConfig#getSession()
	 * return SqlSession
	 * 
	 * @throws Exception
	 **/
	public void testGetSession() throws Exception {
		SqlSession sqlSession = MyBatisConfig.getSession();
		Assert.assertNotNull(sqlSession);
	}

	@Override
	protected void setUp() throws Exception {
		dbConfig.initJndi();
	}

	@Override
	protected void tearDown() throws Exception {
		dbConfig.destroyJndi();
	}
}
