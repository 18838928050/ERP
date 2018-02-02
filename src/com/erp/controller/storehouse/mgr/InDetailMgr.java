package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.InBillDAO;
import com.erp.model.vo.InBill;
import com.erp.model.vo.OutBill;

/**
 * 逻辑处理   入库单一览表
 * @author WangEn
 *
 */
public class InDetailMgr {
	//创建数据库查询对象
	private InBillDAO inDetailDao = new InBillDAO();
	/**
	 * 查询in_bill表
	 * @return
	 */
	public List<InBill> findAll() {
		//创建查询结果对象
		List<InBill> inBills=null;
		try {
			inBills = inDetailDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inBills;
	}

}
