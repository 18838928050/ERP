package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;


import com.erp.controller.finance.mgr.LoanOutNewMgr;
import com.erp.model.vo.LoanBill;

/**
 * 资金借出单  action
 * @author WangEn
 *
 */
public class LoanBillOutNewAction extends BaseAction<LoanBill>{
	private LoanOutNewMgr loanInNewMgr = new LoanOutNewMgr();
	/**
	 * 跳转到资金借出单新增页面
	 * @return
	 */
	public String toOutLoanBill(){
		return "toOutLoanBill";
	}
	/**
	 * 将新增的资金借出单保存到数据库中
	 */
	public String toNewOutLoan(){
		loanInNewMgr.saveLoanBill(getModel());
		return toOutLoanBill();
		
	}

}
