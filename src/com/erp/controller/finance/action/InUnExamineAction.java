package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.InExamineMgr;
import com.erp.controller.finance.mgr.InUnExamineMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 资金借入  反审核action
 * @author WangEn
 *
 */
public class InUnExamineAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
	private InUnExamineMgr inUnExamineMgr = new InUnExamineMgr();
	//遍历数据库
	public String toInUnExamineResult(){
			ActionContext.getContext().getValueStack().set("loanBills", inUnExamineMgr.findAll());
			return "toInUnExamineResult";
			
		}

}
