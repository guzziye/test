package com.css.eshop.dao.impl;

import org.apache.ibatis.session.SqlSession;
//import com.css.crm.dao.BaseDao;

import com.css.eshop.dao.BaseDao;

/**
 * Implementation of BaseDao
 * 
 * @author AIS
 */
public class BaseDaoImpl implements BaseDao {

	private SqlSession session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.css.crm.dao.BaseDao#getMyBatisSession()
	 */
	@Override
	public SqlSession getMyBatisSession() {
		return session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.css.crm.dao.BaseDao#setMyBatisSession(org.apache.ibatis.session.
	 * SqlSession)
	 */
	@Override
	public void setMyBatisSession(SqlSession session) {
		this.session = session;
	}
}
