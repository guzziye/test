package com.css.eshop.service.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.css.eshop.service.BaseService;

/**
 * Implementation of BaseService
 * 
 * @author AIS
 */
public class BaseServiceImpl implements BaseService {

	private SqlSession session;

	/**
	 * get service session
	 * @return
	 */
	public SqlSession getSession() {
		return session;
	}
	
	/* (non-Javadoc)
	 * @see com.css.crm.service.BaseService#setSession(org.apache.ibatis.session.SqlSession)
	 */
	public void setSession(SqlSession session) {
		this.session = session;
		initDaoSession();
	}

	/**
	 * Initial session for all DAO object the service used
	 */
	protected void initDaoSession() {
	}
}
