package com.css.eshop.service;

import java.io.FileInputStream;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import com.css.crm.dbunit.DbUnit;

/**
 * abstract class AbstractCrmServiceTest
 * 
 * @author AIS
 */
public abstract class AbstractCrmServiceTest extends TestCase {

	protected DbUnit dbConfig = new DbUnit();

	/**
	 * Get SQL session for all service test
	 * @return
	 */
	protected SqlSession getTestSession() {
		return dbConfig.getSession();
	}

	/**
	 * @param dataFile
	 * @return
	 * @throws Exception
	 */
	protected IDataSet getDataSet(String dataFile) throws Exception {
		return new FlatXmlDataSetBuilder().build(new FileInputStream(dataFile));
	}

	/*
	 * (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 * get DB ConnecttionPoolDataSource
	 */
	@Override
	protected void setUp() throws Exception {
		dbConfig.initJndi();
		dbConfig.initSession();
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		clearData();
		IDatabaseConnection conn = this.dbConfig.getConnection();
		if (conn != null) {
			conn.close();
		}
		dbConfig.destroyJndi();
		dbConfig.closeSession();
	}

	/**
	 * Clear some test data manually, for subclass to override
	 * 
	 * @throws Exception
	 */
	protected void clearData() throws Exception {
	}
}
