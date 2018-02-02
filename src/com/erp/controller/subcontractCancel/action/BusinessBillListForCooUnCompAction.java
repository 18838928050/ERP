package com.erp.controller.subcontractCancel.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.subcontractCancel.mgr.CooperBillUnCompMgr;
import com.erp.controller.subcontractCancel.vo.BusinessBill;
import com.erp.controller.subcontractCancel.vo.CooperBill;
import com.opensymphony.xwork2.ActionContext;
/**
 * 完工 外协反完工
 * @author WE
 *
 */
public class BusinessBillListForCooUnCompAction extends BaseAction<BusinessBill>{
	private CooperBillUnCompMgr cooperBillUnCompMgr = new CooperBillUnCompMgr();
	/**
	 * 进入外协反完工页面
	 */
	public String toCooperUnComp(){
		ActionContext.getContext().getValueStack().set("cooperUnBill",cooperBillUnCompMgr.findAll());
		return "toCooperUnComp";
	}
	/**
	 * 查看账单信息  注（无页面）
	 */
	public String toLookInfo(){
		return "toLookInfo";	
	}
	

}
