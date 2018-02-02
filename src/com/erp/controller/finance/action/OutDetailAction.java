package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.BankAccountMgr;
import com.erp.controller.finance.mgr.DepartmentMgr;
import com.erp.controller.finance.mgr.OutDetailMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 资金借出一览表  action
 * @author WangEn
 *
 */
public class OutDetailAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
		private OutDetailMgr outDetailMgr = new OutDetailMgr();
		private DepartmentMgr departmentMgr = new DepartmentMgr();
		private BankAccountMgr bankAccountMgr = new BankAccountMgr();
		//遍历数据库
		public String toOutBillResult(){
			ActionContext.getContext().getValueStack().set("departs", departmentMgr.findAll());
			ActionContext.getContext().getValueStack().set("bankAccounts", bankAccountMgr.findAll());
			ActionContext.getContext().getValueStack().set("loanBills", outDetailMgr.findAll());
			return "toOutBillResult";
			
		}

}
