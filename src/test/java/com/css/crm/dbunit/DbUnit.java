package com.css.crm.dbunit;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.apache.ibatis.session.SqlSession;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.filter.IColumnFilter;
import org.dbunit.ext.oracle.Oracle10DataTypeFactory;
import org.w3c.dom.NamedNodeMap;
import com.css.db.MyBatisConfig;
import com.css.db.utility.DBConfigUtil;

/**
 * DBunit related configuration
 * 
 * @author AIS
 */
public class DbUnit {

	protected IDatabaseConnection connection;
	public final static String TEST_DB_SCHEMA = "SYSVIP";
	private String configPK = null;
	private SqlSession session = null;

	/**
	 * get DBUnit connection object
	 * 
	 * @return
	 * @throws Exception
	 */
	public IDatabaseConnection getConnection() throws Exception {
		if (connection == null) {
			connection = new DatabaseConnection(getDBConnection(), TEST_DB_SCHEMA);
		}
		// if table have no PK, then need to config use which field as pk
		if (configPK != null) {
			connection.getConfig().setProperty(DatabaseConfig.PROPERTY_PRIMARY_KEY_FILTER, new MyPrimaryKeyFilter(configPK));
		}
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());
		return connection;
	}

	/**
	 * use for set table primary key when table structure have none
	 * 
	 * @author Administrator
	 */
	class MyPrimaryKeyFilter implements IColumnFilter {

		private String pseudoKey = null;

		MyPrimaryKeyFilter(String pseudoKey) {
			this.pseudoKey = pseudoKey;
		}

		public boolean accept(String tableName, Column column) {
			return column.getColumnName().equalsIgnoreCase(pseudoKey);
		}
	}

	/**
	 * Get database connection
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getDBConnection() throws Exception {
		NamedNodeMap configMap = DBConfigUtil.readDbConfig();
		String jndiName = configMap.getNamedItem("name").getNodeValue();
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:/comp/env/" + jndiName);
		Connection conn = ds.getConnection();
		return conn;
	}

	/**
	 * manually set jndi
	 * 
	 * @throws Exception
	 */
	public void initJndi() throws Exception {
		NamedNodeMap configMap = DBConfigUtil.readDbConfig();
		String url = configMap.getNamedItem("url").getNodeValue();
		String userName = configMap.getNamedItem("username").getNodeValue();
		String password = configMap.getNamedItem("password").getNodeValue();
		String jndiName = configMap.getNamedItem("name").getNodeValue();
		try {
			// Create initial context
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
			InitialContext ic = new InitialContext();
			ic.createSubcontext("java:");
			ic.createSubcontext("java:/comp");
			ic.createSubcontext("java:/comp/env");
			ic.createSubcontext("java:/comp/env/jdbc");
			// Construct DataSource
			OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
			ds.setURL(url);
			ds.setUser(userName);
			ds.setPassword(password);
			ic.bind("java:/comp/env/" + jndiName, ds);
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * destroy JNDI
	 */
	public void destroyJndi() {
		try {
			// Create initial context
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
			InitialContext ic = new InitialContext();
			ic.destroySubcontext("java:");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * initial sqlSession
	 */
	public void initSession() {
		try {
			session = MyBatisConfig.getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * close sqlSession
	 */
	public void closeSession() {
		session.close();
	}

	public String getConfigPK() {
		return configPK;
	}

	public void setConfigPK(String configPK) {
		this.configPK = configPK;
	}

	public SqlSession getSession() {
		return session;
	}
}
