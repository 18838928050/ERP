package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.InDetailMgr;
import com.erp.controller.finance.mgr.InExamineMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 资金借入  审核action
 * @author WangEn
 *
 */
public class InExamineAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
	private InExamineMgr inExamineMgr = new InExamineMgr();
	//遍历数据库
	public String toInExamineResult(){
			ActionContext.getContext().getValueStack().set("loanBills", inExamineMgr.findAll());
			return "toInExamineResult";
			
		}

}
