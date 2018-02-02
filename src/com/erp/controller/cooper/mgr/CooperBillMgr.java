package com.erp.controller.cooper.mgr;

import java.util.List;

import com.erp.controller.cooper.dao.CooperBillDao;
import com.erp.model.vo.CooperBillVO;

public class CooperBillMgr {
	private CooperBillDao cooperBillDao = new CooperBillDao();
	/**
	 * 查询cooper_bill表
	 * @return
	 */
	public List<CooperBillVO> findAll(){
		List<CooperBillVO> cooperBills = null;
		try {
			cooperBills = cooperBillDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cooperBills;
		
	}

}
