package com.erp.controller.subcontractCancel.mgr;

import java.util.List;


import com.erp.controller.subcontractCancel.dao.CooperBillUnCompDAO;
import com.erp.controller.subcontractCancel.vo.BusinessBill;
import com.erp.controller.subcontractCancel.vo.CooperBill;

/**
 * 逻辑处理    外协反完工
 * @author WE
 *
 */
public class CooperBillUnCompMgr {
	private CooperBillUnCompDAO cooperBillUnCompDao = new CooperBillUnCompDAO();
	/**查询cooperBill表
	 * 
	 * @return
	 */
	public List<BusinessBill> findAll(){
		List<BusinessBill> cooperUnBill = null;
		try {
			cooperUnBill = cooperBillUnCompDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cooperUnBill;
		
	}
	

}
