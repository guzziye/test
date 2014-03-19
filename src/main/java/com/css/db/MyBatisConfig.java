package com.css.db;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis configuration
 * @author AIS
 *
 */
public class MyBatisConfig {

	public MyBatisConfig() {
	}

	/**
	 * Get SqlSession for mybatis
	 * @return
	 */
	public static SqlSession getSession() {
		SqlSession sqlSession = null;
		try {
			String resource = "com/css/db/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}

}
