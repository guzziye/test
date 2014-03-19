package com.css.eshop.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

//import com.css.crm.dao.AbstractCrmDaoTest;
import com.css.crm.utility.DateUtil;
//import com.css.crm.dao.impl.CustomerActivityDaoImpl;
import com.css.eshop.dao.impl.PreciousMetalPriceImpl;
import com.css.eshop.exception.PreciousMetalException;
//import com.css.eshop.vo.PreciousMetalPriceHistVo;
import com.css.eshop.vo.PreciousMetalPriceHistVo;

public class PreciousMetalPriceDaoTest extends AbstractCrmDaoTest {

	private PreciousMetalPriceDao dao;

	@Override
	protected InputStream getTestXml() throws FileNotFoundException {
		return null;
	}

//	public void testGetPreciousMetalPriceHist() {
//		try {
//			List<PreciousMetalPriceHistVo> l = dao.getPreciousMetalPriceHist(
//					"", "RMB", "Y");
//
//			if (l != null) {
//				for (PreciousMetalPriceHistVo bean : l) {
//					System.out.println(bean.getCurrencyCode());
//					System.out.println(bean.getMetalType());
//					System.out.println(bean.getProductPriceCalInd());
//
//				}
//			}
//		} catch (PreciousMetalException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// public void testUpdatePreciousMetalPriceHist(){
	//
	// try {
	// int i= dao.updatePreciousMetalPriceHist("", Long.valueOf("1"), "RMB",
	// DateUtil.parseDate("2014-3-12"), "2000", new Date());
	// dao.getMyBatisSession().commit();
	// System.out.println(i);
	// } catch (NumberFormatException | PreciousMetalException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	 public void testDeletePreciousMetalPriceHist(){
	
	 try {
		 System.out.println("1");
	 int i= dao.delPreciousMetalPriceHist("", Long.valueOf("1"), "RMB",
	 DateUtil.parseDate("2014-3-10"));
	 System.out.println("2");
	 dao.getMyBatisSession().commit();
	 System.out.println(i);
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }

//	 public void testInsertPreciousMetalPriceHist() {
//	
//	 try {
//	 int i = dao.createPreciousMetalPriceHist("", Long.valueOf("1"),
//	 "RMB", "111", DateUtil.parseDate("2014-2-10"));
//	
//	 dao.getMyBatisSession().commit();
//	 System.out.println(i);
//	 } catch (Exception e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new PreciousMetalPriceImpl();
		dao.setMyBatisSession(getTestSession());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;

	}

}
