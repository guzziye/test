package com.css.eshop.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

//import org.apache.ibatis.session.SqlSession;

import com.css.db.MyBatisConfig;
//import com.css.db.MyBatisConfig;
import com.css.eshop.dao.PreciousMetalPriceDao;
import com.css.eshop.dao.impl.PreciousMetalPriceImpl;
import com.css.eshop.exception.PreciousMetalException;
import com.css.eshop.exception.SystemException;
import com.css.eshop.message.SystemErrorMessage;
import com.css.eshop.service.PreciousMetalPriceService;
import com.css.eshop.vo.PreciousMetalPriceHistVo;

public class PreciousMetalPriceServiceImpl extends BaseServiceImpl implements
		PreciousMetalPriceService {

	private PreciousMetalPriceDao preciousMetalPriceDao = null;
	private SqlSession session = null;

	public PreciousMetalPriceServiceImpl() {

		session = MyBatisConfig.getSession();

		preciousMetalPriceDao = new PreciousMetalPriceImpl();
		preciousMetalPriceDao.setMyBatisSession(session);
	}

	@Override
	public List<PreciousMetalPriceHistVo> getPreciousMetalPriceHist(
			String token, String currencyCode, String productPriceCalcInd)
			throws SystemException {
		try {
			return preciousMetalPriceDao.getPreciousMetalPriceHist(token,
					currencyCode, productPriceCalcInd);
		} catch (PreciousMetalException e) {
			throw new SystemException(
					SystemErrorMessage.SQL_UNEXPECTED_EXCEPTION, e);
		}
	}

	@Override
	public void updatePreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate, String newUnitRate,
			Date newEffDate) throws SystemException {

		try {
			preciousMetalPriceDao.updatePreciousMetalPriceHist(token, metalId,
					currencyCode, effDate, newUnitRate, newEffDate);
		} catch (PreciousMetalException e) {
			throw new SystemException(
					SystemErrorMessage.SQL_UNEXPECTED_EXCEPTION, e);
		} finally {
			if (session != null) {
				session.commit();

			}
		}
	}

	@Override
	public void delPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate) throws SystemException {
		try {
			preciousMetalPriceDao.delPreciousMetalPriceHist(token, metalId,
					currencyCode, effDate);
		} catch (PreciousMetalException e) {
			throw new SystemException(
					SystemErrorMessage.SQL_UNEXPECTED_EXCEPTION, e);
		} finally {
			if (session != null) {
				session.commit();

			}
		}
	}

	@Override
	public void createPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, String unitRate, Date effDate)
			throws SystemException {

		try {
			preciousMetalPriceDao.createPreciousMetalPriceHist(token, metalId,
					currencyCode, unitRate, effDate);
		} catch (PreciousMetalException e) {
			throw new SystemException(
					SystemErrorMessage.SQL_UNEXPECTED_EXCEPTION, e);
		} finally {
			if (session != null) {
				session.commit();

			}
		}
	}

}
