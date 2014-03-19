package com.css.eshop.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "preciousMetalPricxeHistVoes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreciousMetalResponseVo {

	@XmlElement(name = "preciousMetalPriceHistVo", nillable = true, required = false)
	private List<PreciousMetalPriceHistVo> preciousMetalPriceHisList;

	public List<PreciousMetalPriceHistVo> getPreciousMetalPriceHisList() {
		return preciousMetalPriceHisList;
	}

	public void setPreciousMetalPriceHisList(
			List<PreciousMetalPriceHistVo> preciousMetalPriceHisList) {
		this.preciousMetalPriceHisList = preciousMetalPriceHisList;
	}

}
