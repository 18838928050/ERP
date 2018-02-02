package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.OutResultDAO;
import com.erp.model.vo.OutBill;

/**
 * 逻辑处理  出库单一览表
 * @author WangEn
 *
 */
public class OutResultMgr {
	//创建数据库查询对象
	private OutResultDAO outResultDao = new OutResultDAO();
	
	/**
	 * 查询out_bill表
	 * @return
	 */
	public List<OutBill> findAll() {
		//创建查询结果对象
		List<OutBill> outBills=null;
		try {
			outBills = outResultDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outBills;
	}
	

}
