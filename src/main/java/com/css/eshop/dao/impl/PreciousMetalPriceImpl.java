package com.css.eshop.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.css.eshop.dao.PreciousMetalPriceDao;
import com.css.eshop.exception.PreciousMetalException;
import com.css.eshop.vo.PreciousMetalPriceHistVo;

public class PreciousMetalPriceImpl extends BaseDaoImpl implements
		PreciousMetalPriceDao {

	@Override
	public List<PreciousMetalPriceHistVo> getPreciousMetalPriceHist(
			String token, String currencyCode, String productPriceCalcInd)
			throws PreciousMetalException {
		SqlSession session = getMyBatisSession();
		List<PreciousMetalPriceHistVo> list = null;
		try {
			PreciousMetalPriceHistVo vo = new PreciousMetalPriceHistVo();
			vo.setProductPriceCalInd(productPriceCalcInd);
			vo.setCurrencyCode(currencyCode);
			list = session.selectList(
					"preciousMetalPrice.getPreciousMetalPriceHist", vo);
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PreciousMetalException();
		}

	}

	@Override
	public int updatePreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate, String newUnitRate,
			Date newEffDate) throws PreciousMetalException {
		SqlSession session = getMyBatisSession();
		try {

			PreciousMetalPriceHistVo vo = new PreciousMetalPriceHistVo();
			vo.setNewEffDate(newEffDate);
			vo.setNewUnitRate(newUnitRate);
			vo.setMetalId(metalId);
			vo.setCurrencyCode(currencyCode);
			vo.setEffDate(effDate);
			return session.update(
					"preciousMetalPrice.updatePreciousMetalPriceHist", vo);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PreciousMetalException();
		}
	}

	@Override
	public int delPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate) throws PreciousMetalException {
		SqlSession session = getMyBatisSession();

		try {

			PreciousMetalPriceHistVo vo = new PreciousMetalPriceHistVo();
			vo.setMetalId(metalId);
			vo.setCurrencyCode(currencyCode);
			vo.setEffDate(effDate);
			return session.delete("preciousMetalPrice.deletePreciousMetalPriceHist",
					vo);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PreciousMetalException();
		}
	}

	@Override
	public int createPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, String unitRate, Date effDate)
			throws PreciousMetalException {
		SqlSession session = getMyBatisSession();

		try {

			PreciousMetalPriceHistVo vo = new PreciousMetalPriceHistVo();
			vo.setMetalId(metalId);
			vo.setCurrencyCode(currencyCode);
			vo.setEffDate(effDate);
			vo.setUnitRate(unitRate); 
			return session.insert("preciousMetalPrice.insertPreciousMetalPriceHist",
					vo);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PreciousMetalException();
		}
	}

}
