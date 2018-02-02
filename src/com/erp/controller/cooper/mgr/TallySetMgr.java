package com.erp.controller.cooper.mgr;

import java.util.List;

import com.erp.controller.cooper.dao.TallySetDao;
import com.erp.model.vo.TallySetVO;

public class TallySetMgr {
	private TallySetDao tallySetDao = new TallySetDao();
	
	public List<TallySetVO> findAll(){
		List<TallySetVO> tallySets =null;
		try {
			tallySets = tallySetDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tallySets;
		
	}

}
