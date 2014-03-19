package com.css.eshop.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.css.eshop.exception.PreciousMetalException;
import com.css.eshop.vo.PreciousMetalPriceHistVo;

public interface PreciousMetalPriceDao extends BaseDao {

	public List<PreciousMetalPriceHistVo> getPreciousMetalPriceHist(
			String token, String currencyCode, String productPriceCalcInd)
			throws PreciousMetalException;

	public int updatePreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate, String newUnitRate,
			Date newEffDate) throws PreciousMetalException;

	public int delPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate) throws PreciousMetalException;

	public int createPreciousMetalPriceHist(String token, Long metalId,
			String currencyCodes, String unitRate, Date effDate)
			throws PreciousMetalException;

}