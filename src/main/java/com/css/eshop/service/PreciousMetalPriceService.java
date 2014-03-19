package com.css.eshop.service;

import java.util.Date;
import java.util.List;

import com.css.eshop.exception.SystemException;
import com.css.eshop.vo.PreciousMetalPriceHistVo;

public interface PreciousMetalPriceService extends BaseService {

	public List<PreciousMetalPriceHistVo> getPreciousMetalPriceHist(
			String token, String currencyCode, String productPriceCalcInd)
			throws SystemException;

	public void updatePreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate, String newUnitRate,
			Date newEffDate) throws SystemException;

	public void delPreciousMetalPriceHist(String token, Long metalId,
			String currencyCode, Date effDate) throws SystemException;

	public void createPreciousMetalPriceHist(String token, Long metalId,
			String currencyCodes, String unitRate, Date effDate)
			throws SystemException;

}
