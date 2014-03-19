package com.css.eshop.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "preciousMetalPriceHistVo")
public class PreciousMetalPriceHistVo {
	private Long metalId;

	// Type of precious metal (Gold, Silver, Platinum鈥�)
	private String metalType;

	// Buy/Sell Rate for CSS
	private String sellInd;

	// Y/N , if Y for calculation of product price, if N for showing in the
	// website Gold Price Widget
	private String productPriceCalInd;

	// The unit of the product (dictated by the website, in HKG use tael, in PRC
	// use gram);
	private String uom;
	// System generated number (PK)
	// private BigDecimal metalId;

	// The currency used in the web site. HKG website use HK$, PRC website use
	// RMB
	private String currencyCode;

	// The amount per unit of the product
	private String unitRate;
	private String newUnitRate;
	// The effective date/time of the price. Note that only the latest version
	// is needed in the table
	
	private Date effDate;
	private Date newEffDate;

	private String token;

	@XmlElement
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@XmlElement
	public String getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(String unitRate) {
		this.unitRate = unitRate;
	}

	@XmlElement
	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public String getNewUnitRate() {
		return newUnitRate;
	}

	public void setNewUnitRate(String newUnitRate) {
		this.newUnitRate = newUnitRate;
	}

	public Date getNewEffDate() {
		return newEffDate;
	}

	public void setNewEffDate(Date newEffDate) {
		this.newEffDate = newEffDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@XmlElement
	public Long getMetalId() {
		return metalId;
	}

	public void setMetalId(Long metalId) {
		this.metalId = metalId;
	}

	@XmlElement
	public String getMetalType() {
		return metalType;
	}

	public void setMetalType(String metalType) {
		this.metalType = metalType;
	}

	@XmlElement
	public String getSellInd() {
		return sellInd;
	}

	public void setSellInd(String sellInd) {
		this.sellInd = sellInd;
	}

	@XmlElement
	public String getProductPriceCalInd() {
		return productPriceCalInd;
	}

	public void setProductPriceCalInd(String productPriceCalInd) {
		this.productPriceCalInd = productPriceCalInd;
	}

	@XmlElement
	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}
