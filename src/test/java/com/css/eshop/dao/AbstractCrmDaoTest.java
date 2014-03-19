package com.css.eshop.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import com.css.crm.dbunit.DbUnit;

/**
 * Abstract class for all DAO class test
 * 
 * @author Administrator
 */
public abstract class AbstractCrmDaoTest extends DatabaseTestCase {

	public IDataSet dataSet = null;
	public IDataSet prepareDataSet = null;
	protected DbUnit dbConfig = new DbUnit();

	public AbstractCrmDaoTest() {
	}

	public IDatabaseConnection getConnection() throws Exception {
		return dbConfig.getConnection();
	}

	@Override
	protected void setUp() throws Exception {
		dbConfig.initJndi();
		dbConfig.initSession();
		super.setUp();
		prepareDataSet();		
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		removePrepareDataSet();
		dbConfig.destroyJndi();
		dbConfig.closeSession();
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.DELETE;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		if (getTestXml() != null)
			dataSet = new FlatXmlDataSetBuilder().build(getTestXml());
		return dataSet;
	}
	
	protected IDataSet getExpectedDataSet(String expectedFile) throws Exception {		
		return new FlatXmlDataSetBuilder().build(new FileInputStream(expectedFile));
	}
	
	protected SqlSession getTestSession() {
		return dbConfig.getSession();
	}

	protected abstract InputStream getTestXml() throws FileNotFoundException;
	
	/**
	 * Prepare relative data current test need
	 * 
	 * @throws Exception
	 */
	protected void prepareDataSet() throws Exception {
		if (StringUtils.isNotEmpty(getPrepareDataFile())) {
			prepareDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream(getPrepareDataFile()));
			DatabaseOperation.INSERT.execute(getConnection(), prepareDataSet);
		}
	}

	/**
	 * remove prepare data after test
	 * 
	 * @throws Exception
	 */
	protected void removePrepareDataSet() throws Exception {
		if (prepareDataSet != null) {
			IDatabaseConnection databaseConnection = new DatabaseConnection(dbConfig.getDBConnection(), DbUnit.TEST_DB_SCHEMA);
			DatabaseOperation.DELETE.execute(databaseConnection, prepareDataSet);
			databaseConnection.close();
		}
	}

	public void setPrepareDataSet(IDataSet prepareDataSet) {
		this.prepareDataSet = prepareDataSet;
	}

	protected String getPrepareDataFile() {
		return null;
	}
}
