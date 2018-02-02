package com.erp.controller.finance.mgr;

import java.util.List;


import com.erp.model.dao.BankAccountDAO;
import com.erp.model.dao.InFinanceDAO;
import com.erp.model.vo.BankAccount;
import com.erp.model.vo.LoanBill;

/**
 * 
 * @author WangEn
 *
 */
public class BankAccountMgr {
	    //创建数据库查询对象
		private BankAccountDAO bankDao = new BankAccountDAO();
		/**
		 * 查询bank_account表
		 * @return
		 */
		public List<BankAccount> findAll() {
			//创建查询结果对象
			List<BankAccount> bankAccounts=null;
			try {
				bankAccounts = bankDao.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bankAccounts;
		}

}
