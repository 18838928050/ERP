package com.erp.controller.make.mgr;

import java.util.List;
import com.erp.controller.make.dao.MakeTypeDao;
import com.erp.model.vo.MakeTypeVO;

public class MakeTypeMgr {
	private MakeTypeDao makeTypeDao = new MakeTypeDao();
	
	public List<MakeTypeVO> findAll(){
		List<MakeTypeVO> makeTypes = null;
		try {
			makeTypes = makeTypeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return makeTypes;
	}

}
