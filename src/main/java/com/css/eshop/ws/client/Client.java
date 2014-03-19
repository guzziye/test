package com.css.eshop.ws.client;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.css.crm.utility.DateUtil;
import com.css.eshop.vo.PreciousMetalPriceHistVo;
import com.css.eshop.vo.PreciousMetalResponseVo;
//import com.css.eshop.exception.WebwerviceException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//import de.hybris.platform.core.dto.user.CustomersDTO;

//import de.hybris.platform.core.dto.user.CustomerDTO;
//import de.hybris.platform.core.dto.user.CustomersDTO;

//import com.css.eshop.dao.impl.RestWeServiceLogic;

public class Client extends AbstractRestWeService {

	public static void main(String[] args) {

		Client t = new Client();

		//t.test2();

//		 t.add();
//		t.update();
		t.del();
	}
	
	public void del() {

		WebResource webResource = configWebResource();
		try {
			// "", Long.valueOf("1"),
			// "RMB", "111", DateUtil.parseDate("2014-2-10")
			PreciousMetalPriceHistVo v= new PreciousMetalPriceHistVo();
			v.setMetalId(Long.valueOf(1));
			v.setCurrencyCode("RMB");
			v.setEffDate( DateUtil.parseDateYMdms("2014-3-11 10:59"));
			final ClientResponse result = webResource
					.path("/goldprice/delMetalPriceHist")
					
					//.cookie(tenantCookie)
					// .header(HEADER_AUTH_KEY, HEADER_AUTH_VALUE_BASIC_ADMIN)
					.accept(MediaType.APPLICATION_XML)
					.type(MediaType.APPLICATION_XML)
					.delete(ClientResponse.class,v);
			result.bufferEntity();
			// assertOk(result, false);
			if (200 == result.getStatus() || 204 == result.getStatus()) {
				// ok
			} else {
				throw new RuntimeException("Failed : HTTP error code : "
						+ result.getStatus());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	public void update() {

		WebResource webResource = configWebResource();
		try {
			// "", Long.valueOf("1"),
			// "RMB", "111", DateUtil.parseDate("2014-2-10")

			PreciousMetalPriceHistVo v= new PreciousMetalPriceHistVo();
			v.setMetalId(Long.valueOf(1));
			v.setCurrencyCode("RMB");
			v.setEffDate( DateUtil.parseDateYMdms("2014-3-11 10:51"));
			//v.setUnitRate("476");
			
			v.setNewEffDate(new Date());
			v.setNewUnitRate("222");
			final ClientResponse result = webResource
					.path("/goldprice/updateMetalPriceHist/")
//					.queryParam("token", "token")
//					.queryParam("metalId", "1")
//					.queryParam("currencyCode", "RMB")
//					.queryParam("unitRate", "90000")
//					.queryParam("effDate", DateUtil.formatDateYMdms(new Date()))
					.cookie(tenantCookie)
					// .header(HEADER_AUTH_KEY, HEADER_AUTH_VALUE_BASIC_ADMIN)
					.accept(MediaType.APPLICATION_XML)
					.put(ClientResponse.class,v);
			
			
			result.bufferEntity();
			// assertOk(result, false);
			if (200 == result.getStatus() || 204 == result.getStatus()) {
				// ok
			} else {
				throw new RuntimeException("Failed : HTTP error code : "
						+ result.getStatus());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	

	public void add() {

		WebResource webResource = configWebResource();
		try {
			// "", Long.valueOf("1"),
			// "RMB", "111", DateUtil.parseDate("2014-2-10")
			PreciousMetalPriceHistVo v= new PreciousMetalPriceHistVo();
			v.setMetalId(Long.valueOf(1));
			v.setCurrencyCode("RMB");
			v.setEffDate(new Date());
			
			
			v.setUnitRate("476");
			
			final ClientResponse result = webResource
					.path("/goldprice/addMetalPriceHist/")
					
					.cookie(tenantCookie)
					// .header(HEADER_AUTH_KEY, HEADER_AUTH_VALUE_BASIC_ADMIN)
					.accept(MediaType.APPLICATION_XML)
					.post(ClientResponse.class,v);
			result.bufferEntity();
			// assertOk(result, false);
			if (200 == result.getStatus() || 204 == result.getStatus()) {
				// ok
			} else {
				throw new RuntimeException("Failed : HTTP error code : "
						+ result.getStatus());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void test() {

		WebResource webResource = configWebResource();
		try {
			final ClientResponse result = webResource
					.path("/goldprice/getMetalPriceHist/")
					.queryParam("token", "token")
					.queryParam("currencyCode", "RMB")
					.queryParam("productPriceCalcInd", "Y1")

					.cookie(tenantCookie)
					// .header(HEADER_AUTH_KEY, HEADER_AUTH_VALUE_BASIC_ADMIN)
					.accept(MediaType.APPLICATION_XML)
					.get(ClientResponse.class);
			result.bufferEntity();
			// assertOk(result, false);
			if (200 == result.getStatus()) {
				// ok
			} else {
				throw new RuntimeException("Failed : HTTP error code : "
						+ result.getStatus());
			}
			

//			String xml = result.getEntity(String.class);
//			System.out.println(xml);
			final PreciousMetalResponseVo response = result
					.getEntity(PreciousMetalResponseVo.class);
			List<PreciousMetalPriceHistVo> list = response
					.getPreciousMetalPriceHisList();
			if (list != null) {
				for (PreciousMetalPriceHistVo b : list) {
					System.out.println("metalId:"+b.getMetalId());
					System.out.println("metalType:"+b.getMetalType());
					System.out.println("productPriceCalInd:"+b.getProductPriceCalInd());
					System.out.println("sellInd:"+b.getSellInd());
					System.out.println("currencyCode:"+b.getCurrencyCode());
					System.out.println("effDate:"+b.getEffDate());
					System.out.println("unitRate:"+b.getUnitRate());
					System.out.println("uom:"+b.getUom());
					 System.out.println("======================================");
				}
			}
			// if(response!=null){
			System.out.println(response);
			// }
			// return l;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
