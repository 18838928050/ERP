package com.erp.controller.finance.mgr;

import java.util.List;


import com.erp.model.dao.InFinanceDAO;
import com.erp.model.vo.LoanBill;

/**
 * 
 * @author WangEn
 *
 */
public class OutDetailMgr {
	//创建数据库查询对象
	private InFinanceDAO inFinanceDao = new InFinanceDAO();
	/**
	 * 查询loan_bill表
	 * @return
	 */
	public List<LoanBill> findAll() {
		//创建查询结果对象
		List<LoanBill> loanBills=null;
		try {
			loanBills = inFinanceDao.findByType("OUT");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanBills;
	}
	

}
