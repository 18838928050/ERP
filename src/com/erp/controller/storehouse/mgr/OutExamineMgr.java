package com.erp.controller.storehouse.mgr;

import java.util.List;

import com.erp.model.dao.OutBillDAO;
import com.erp.model.vo.OutBill;

/**
 * 出库审核  逻辑处理
 * @author WangEn
 *
 */
public class OutExamineMgr {
	//创建数据库查询对象
	private OutBillDAO outBillDao = new OutBillDAO();
	/**
	 * 查询out_bill表
	 * @return
	 */
	public List<OutBill> findAll() {
		//创建查询结果对象
		List<OutBill> outBills=null;
		try {
			outBills = outBillDao.findByStatus("N","Y");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outBills;
	}

}
