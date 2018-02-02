package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.finance.mgr.InUnExamineMgr;
import com.erp.controller.finance.mgr.OutUnExamineMgr;
import com.erp.model.vo.LoanBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 资金借入出  反审核action
 * @author WangEn
 *
 */
public class OutUnExamineAction extends BaseAction<LoanBill>{
	//创建逻辑处理对象
		private OutUnExamineMgr outUnExamineMgr = new OutUnExamineMgr();
		//遍历数据库
		public String toOutUnExamineResult(){
				ActionContext.getContext().getValueStack().set("loanBills", outUnExamineMgr.findAll());
				return "toOutUnExamineResult";
				
			}

}
