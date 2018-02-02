package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.InTypeDAO;
import com.erp.model.vo.InType;
import com.erp.model.vo.Storehouse;

/**
 * 入库类型  
 * @author WangEn
 *
 */
public class InTypeMgr {
	private InTypeDAO inTypeDao = new InTypeDAO();
	/**
	 * 查询intype表
	 * @return
	 */
	public List<InType> findAll() {
		//创建查询结果对象
		List<InType> inTypes=null;
		try {
			inTypes = inTypeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inTypes;
	}
	

}
