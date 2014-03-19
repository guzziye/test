package com.css.eshop.service;

import org.apache.ibatis.session.SqlSession;

/**
 * Interface for all services. Allow all implemented services to inherit MyBatis SQL session
 * 
 * @author AIS
 */
public interface BaseService {

	/**
	 * Inject session for service
	 * @param session
	 */
	public void setSession(SqlSession session);
}
