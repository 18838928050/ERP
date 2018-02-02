package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.OutTypeDAO;
import com.erp.model.vo.OutType;

public class OutTypeMgr {
	
	/**
	 * 查询outtype表
	 * @return
	 */
	public List<OutType> findAll() {
		OutTypeDAO outTypeDao = new OutTypeDAO();
		//创建查询结果对象
		List<OutType> outTypes=null;
		try {
			outTypes = outTypeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outTypes;
	}

}
