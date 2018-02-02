package com.erp.controller.finance.mgr;

import java.util.List;


import com.erp.model.dao.InFinanceDAO;
import com.erp.model.vo.LoanBill;

/**
 * 资金借出  审核  逻辑处理
 * @author WangEn
 *
 */
public class OutExamineMgr {
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
			if(loanBills!=null){
				try {
					loanBills = inFinanceDao.findByStatus("N","Y");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				System.out.println("查询失败！");
			}
			return loanBills;
		}

}
