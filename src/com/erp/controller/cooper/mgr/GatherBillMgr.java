package com.erp.controller.cooper.mgr;

import java.util.List;

import com.erp.controller.cooper.dao.GatherExamineDao;
import com.erp.model.vo.GatherBillVO;

public class GatherBillMgr {
	private GatherExamineDao gatherExamineDao = new GatherExamineDao();
	/**
	 * 查询gather_bill表
	 * @return
	 */
	public List<GatherBillVO> findAll(){
		List<GatherBillVO> gatherBills = null;
		try {
			gatherBills = gatherExamineDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gatherBills;
	
	}
}
