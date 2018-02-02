package com.erp.controller.finance.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.finance.mgr.InComeTypeMgr;
import com.erp.controller.finance.mgr.ReceiveBillMgr;
import com.erp.model.dao.InComeTypeDAO;
import com.erp.model.vo.BankAccount;
import com.erp.model.vo.IncomeBill;
import com.erp.model.vo.ReceiveBill;
import com.erp.util.IDTools;
import com.opensymphony.xwork2.ActionContext;

/**
 * 其他收入
 * @author JiaQi
 *
 */
public class InComeBillAction extends BaseAction<IncomeBill>{
	private InComeTypeMgr inComeTypeMgr = new InComeTypeMgr();
	
	/**
	 * 跳转新增其他收入
	 */
	public String toNewInComeBill(){
		ReceiveBillMgr receiveBillMgr = new ReceiveBillMgr();
		
		ActionContext.getContext().getValueStack().set("bankAccounts", inComeTypeMgr.findAllUseBankAccount());
		ActionContext.getContext().getValueStack().set("inComeTypes", inComeTypeMgr.findAllUseInComeType());;
		ActionContext.getContext().getValueStack().set("staffers", receiveBillMgr.findAllStafferCanUse());
		ActionContext.getContext().getValueStack().set("departments", receiveBillMgr.findAllDepatment());
		return "toNewInComeBill";
	}
	/**
	 * 保存其他收入
	 */
	public String saveInComeBill(){
		getModel().setManagerName("测试");//		整合删除
		getModel().setId(IDTools.GetUUID());
		inComeTypeMgr.save(getModel());
		return toNewInComeBill();
	}
	
	/**
	 * 跳转审核
	 */
	public String toIncomeBillListForExamine(){
		ActionContext.getContext().getValueStack().set("inComeBills", inComeTypeMgr.findAllUnExam());
		return "toIncomeBillListForExamine";
	}
	
	/**
	 * 跳转反审核
	 */
	public String toUnIncomeBillListForExamine(){
		ActionContext.getContext().getValueStack().set("inComeBills", inComeTypeMgr.findAllExam());
		return "toUnIncomeBillListForExamine";
	}
	
	/**
	 * 审核
	 */
	public String canExamine(){
		IncomeBill incomeBill = inComeTypeMgr.findInComeBillById(getModel().getId());
		incomeBill.setExamined("Y");
		inComeTypeMgr.inComeBillExmin(incomeBill);
		return toIncomeBillListForExamine();
	}
	
	/**
	 * 反审核
	 */
	public String noExamine(){
		IncomeBill incomeBill = inComeTypeMgr.findInComeBillById(getModel().getId());
		incomeBill.setExamined("N");
		inComeTypeMgr.inComeBillExmin(incomeBill);
		return toUnIncomeBillListForExamine();
	}
	
	/**
	 * 跳转到一览表
	 */
	public String toIncomeBillSearchResult(){
		ActionContext.getContext().getValueStack().set("incomeBills",inComeTypeMgr.findAllCanUseInComeBill());
		return "toIncomeBillSearchResult";
	}
}
