package com.erp.controller.make.mgr;

import java.util.List;

import com.erp.controller.make.dao.BusinessBillDao;
import com.erp.model.vo.BusinessBillVO;

public class BusinessBillMgr {
	private BusinessBillDao businessBillDao = new BusinessBillDao();
	
	public List<BusinessBillVO> findAll(){
		List<BusinessBillVO> businessBills = null;
		
		try {
			businessBills = businessBillDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return businessBills;
		
	}

}
