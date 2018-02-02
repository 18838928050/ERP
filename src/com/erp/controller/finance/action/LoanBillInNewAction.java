package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.LoanInNewMgr;
import com.erp.model.vo.LoanBill;

/**
 * 资金借入单  action
 * @author WangEn
 *
 */
public class LoanBillInNewAction extends BaseAction<LoanBill>{
	private LoanInNewMgr loanInNewMgr = new LoanInNewMgr();
	/**
	 * 跳转到资金借入单新增页面
	 * @return
	 */
	public String toInLoanBill(){
		return "toInLoanBill";
	}
	/**
	 * 将新增的资金借入单保存到数据库中
	 */
	public String toNewLoan(){
		loanInNewMgr.saveLoanBill(getModel());
		return toInLoanBill();
		
	}

}
