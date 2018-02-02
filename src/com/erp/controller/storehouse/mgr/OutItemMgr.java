package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.OutBillItemDAO;
import com.erp.model.vo.OutBillItem;



/**
 * 出库单详情一览表  逻辑处理
 * @author WangEn
 *
 */
public class OutItemMgr {
	private OutBillItemDAO outItemDao = new OutBillItemDAO();
	
	public List<OutBillItem> findAll(){
		List<OutBillItem> outItems = null;
		
		try {
			outItems = outItemDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outItems;
		
	}
	

}
