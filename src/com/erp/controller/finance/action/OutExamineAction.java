package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.InExamineMgr;
import com.erp.controller.finance.mgr.OutExamineMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 资金借出  审核action
 * @author WangEn
 *
 */
public class OutExamineAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
		private OutExamineMgr outExamineMgr = new OutExamineMgr();
		//遍历数据库
		public String toOutExamineResult(){
				ActionContext.getContext().getValueStack().set("loanBills", outExamineMgr.findAll());
				return "toOutExamineResult";
				
			}

}
