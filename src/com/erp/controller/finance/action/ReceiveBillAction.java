package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.finance.mgr.ReceiveBillMgr;
import com.erp.controller.vto.ReceiveBillVTO;
import com.erp.model.vo.ReceiveBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 收款单
 * @author JiaQi
 *
 */
public class ReceiveBillAction extends BaseAction<ReceiveBillVTO>{
	private ReceiveBillMgr receiveBillMgr = new ReceiveBillMgr();
	/**
	 * 跳转到新增入库单
	 */
	public String toReceiveBillNew(){
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBillMgr.findAllBankAccount());
		ActionContext.getContext().getValueStack().set("staffers", receiveBillMgr.findAllStafferCanUse());
		ActionContext.getContext().getValueStack().set("departments", receiveBillMgr.findAllDepatment());
		ActionContext.getContext().getValueStack().set("establishments", receiveBillMgr.findAllEstablishment());
		return "toReceiveBillNew";
	}
	
	/**
	 * 跳转到审核列表
	 */
	public String toNoReceiveBillList(){
		ActionContext.getContext().getValueStack().set("departments", receiveBillMgr.findAllDepatment());
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBillMgr.findUnExmin());
		return "toNoReceiveBillList";
	}
	
	/**
	 * 审核通过
	 */
	public String receiveBillExmin(){
		ReceiveBill receiveBill = receiveBillMgr.findReceiveBillById(getModel().getReceiveBill().getId());
		receiveBill.setExamined("Y");
		receiveBillMgr.receiveBillExmin(receiveBill);
		return toNoReceiveBillList();
	}
	
	/**
	 * 跳转到反审核
	 */
	public String toCanReceiveBillList(){
		ActionContext.getContext().getValueStack().set("departments", receiveBillMgr.findAllDepatment());
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBillMgr.findExmin());
		return "toCanReceiveBillList";
		
	}
	
	/**
	 * 反审核
	 */
	public String unReceiveBillExmin(){
		ReceiveBill receiveBill = receiveBillMgr.findReceiveBillById(getModel().getReceiveBill().getId());
		receiveBill.setExamined("N");
		receiveBillMgr.receiveBillExmin(receiveBill);
		return toCanReceiveBillList();
	}
	
	/**
	 * 跳转到一览表
	 */
	public String toReceiveBillResult(){
		
		ActionContext.getContext().getValueStack().set("departments", receiveBillMgr.findAllDepatment());
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBillMgr.findAllReceive());
		
		return "toReceiveBillResult";
	}
}
