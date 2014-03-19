package com.css.eshop.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * Interface for all DAOs. Allow all implemented DAOs to inherit MyBatis SQL
 * session
 * 
 * @author AIS
 */
public interface BaseDao {

	/**
	 * Retrieve current MyBatis SQL session
	 * 
	 * @return MyBatis SQL session
	 */
	public SqlSession getMyBatisSession();

	/**
	 * Set session by MyBatis SQL session
	 * 
	 * @param session
	 *            MyBatis SQL session
	 */
	public void setMyBatisSession(SqlSession session);
}
