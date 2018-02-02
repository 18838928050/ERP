package com.erp.controller.storehouse.mgr;

import java.util.List;


import com.erp.model.dao.InBillDAO;
import com.erp.model.vo.InBill;

/**
 * 入库反审核   逻辑处理
 * @author WangEn
 *
 */
public class InUnExamineMgr {
	//创建数据库查询对象
	private InBillDAO inBillDao = new InBillDAO();
	/**
	 * 查询in_bill表
	 * @return
	 */
	public List<InBill> findAll() {
		//创建查询结果对象
		List<InBill> inBills=null;
		try {
			inBills = inBillDao.findByStatus("Y","Y");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inBills;
	}

}
