package com.css.eshop.ws;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.css.crm.utility.DateUtil;
import com.css.eshop.exception.SystemException;
import com.css.eshop.service.serviceImpl.PreciousMetalPriceServiceImpl;
import com.css.eshop.vo.PreciousMetalPriceHistVo;
import com.css.eshop.vo.PreciousMetalResponseVo;

@Path(value = "/goldprice")
public class PreciousMetalPriceWS {
	private static Logger logger = Logger.getLogger(PreciousMetalPriceWS.class);

	@GET
	@Path("/getMetalPriceHist")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PreciousMetalResponseVo getPreciousMetalPriceHist(
			@QueryParam("token") String token,
			@QueryParam("currencyCode") String currencyCode,
			@QueryParam("productPriceCalcInd") String productPriceCalcInd) {

		PreciousMetalPriceServiceImpl service = new PreciousMetalPriceServiceImpl();
		System.out.println("add MetalPrice Hist Receieving : Token:" + token
				+ " ,CurrencyCode:" + currencyCode + ",productPriceCalcInd:"
				+ productPriceCalcInd);
		try {
			List<PreciousMetalPriceHistVo> voList = service
					.getPreciousMetalPriceHist(token, currencyCode,
							productPriceCalcInd);

			PreciousMetalResponseVo responVo = new PreciousMetalResponseVo();
			responVo.setPreciousMetalPriceHisList(voList);

			return responVo;
		} catch (SystemException e) {
			return null;
		}
	}

	@POST
	@Path("addMetalPriceHist")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void addPreciousMetalPriceHist(PreciousMetalPriceHistVo dto) {

		PreciousMetalPriceServiceImpl service = new PreciousMetalPriceServiceImpl();
		System.out.println("Post MetalPrice Hist Receieving : Token:"
				+ dto.getToken() + " ,MetalId:" + dto.getMetalId()
				+ " ,CurrencyCode:" + dto.getCurrencyCode() + ",UnitRate:"
				+ dto.getUnitRate() + ",EffDate:" + DateUtil.formatDateYMdms( dto.getEffDate()));

		try {

			service.createPreciousMetalPriceHist(dto.getToken(),
					dto.getMetalId(), dto.getCurrencyCode(), dto.getUnitRate(),
					dto.getEffDate());

		} catch (SystemException e) {
			e.printStackTrace();
		}

	}

	@PUT
	@Path("updateMetalPriceHist")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void updatePreciousMetalPriceHist(PreciousMetalPriceHistVo dto) {

		PreciousMetalPriceServiceImpl service = new PreciousMetalPriceServiceImpl();
		System.out.println("update MetalPrice Hist Receieving : Token:"
				+ dto.getToken() + " ,MetalId:" + dto.getMetalId()
				+ " ,CurrencyCode:" + dto.getCurrencyCode() + ",UnitRate:"
				+ dto.getUnitRate() + ",EffDate:" + dto.getEffDate()

				+ ",getNewEffDate:" + dto.getNewEffDate() + ",getNewUnitRate:"
				+ dto.getNewUnitRate());
		if (dto != null) {
			try {
				service.updatePreciousMetalPriceHist(dto.getToken(),
						dto.getMetalId(), dto.getCurrencyCode(),
						dto.getEffDate(), dto.getNewUnitRate(),
						dto.getNewEffDate());
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	@DELETE
	@Path("delMetalPriceHist")
	//@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Produces("text/plain")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	public void deletePreciousMetalPriceHist(PreciousMetalPriceHistVo dto) {
		{
			System.out.println("del MetalPrice Hist Receieving : Token:"
					+ dto.getToken() + " ,MetalId:" + dto.getMetalId()
					+ " ,CurrencyCode:" + dto.getCurrencyCode() + ",UnitRate:"
					+ dto.getUnitRate() + ",EffDate:" + dto.getEffDate());
			PreciousMetalPriceServiceImpl service = new PreciousMetalPriceServiceImpl();
			if (dto != null) {
				try {
					service.delPreciousMetalPriceHist(dto.getToken(),
							dto.getMetalId(), dto.getCurrencyCode(),
							dto.getEffDate());
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
