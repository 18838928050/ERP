package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.BankAccountMgr;
import com.erp.controller.finance.mgr.DepartmentMgr;
import com.erp.controller.finance.mgr.InDetailMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 入库单一览表  action
 * @author WangEn
 *
 */
public class InDetailAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
	private InDetailMgr inDetailMgr = new InDetailMgr();
	private DepartmentMgr departmentMgr = new DepartmentMgr();
	private BankAccountMgr bankAccountMgr = new BankAccountMgr();
	//遍历数据库
	public String toLoanBillResult(){
		ActionContext.getContext().getValueStack().set("departs", departmentMgr.findAll());
		ActionContext.getContext().getValueStack().set("bankAccounts", bankAccountMgr.findAll());
		ActionContext.getContext().getValueStack().set("loanBills", inDetailMgr.findAll());
		return "toLoanBillResult";
		
	}
	
	
	

}
