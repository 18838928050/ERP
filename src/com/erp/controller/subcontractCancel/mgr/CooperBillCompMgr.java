package com.erp.controller.subcontractCancel.mgr;

import java.util.List;


import com.erp.controller.subcontractCancel.dao.CooperBillCompDAO;
import com.erp.controller.subcontractCancel.vo.BusinessBill;
import com.erp.controller.subcontractCancel.vo.CooperBill;

/**
 * 逻辑处理  外协完工
 * @author WE
 *
 */
public class CooperBillCompMgr {
	private CooperBillCompDAO cooperBillCompDao = new CooperBillCompDAO();
	
	/**
	 * 查询外协账单
	 */
	public List<BusinessBill> findAll(){
		List<BusinessBill> cooperBill = null;
		try {
			cooperBill=cooperBillCompDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cooperBill;
	}
	

}
