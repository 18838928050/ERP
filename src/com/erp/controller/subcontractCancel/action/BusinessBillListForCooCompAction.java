package com.erp.controller.subcontractCancel.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.subcontractCancel.mgr.CooperBillCompMgr;
import com.erp.controller.subcontractCancel.vo.BusinessBill;
import com.erp.controller.subcontractCancel.vo.CooperBill;
import com.opensymphony.xwork2.ActionContext;
/**
 * 完工  外协完工
 * @author WE
 *
 */
public class BusinessBillListForCooCompAction extends BaseAction<BusinessBill>{
	
	CooperBillCompMgr cooperBillCompMgr = new CooperBillCompMgr();
	/**
	 * 进入外协完工主页面
	 */
	public String toCooperComp(){
		ActionContext.getContext().getValueStack().set("cooperBill",cooperBillCompMgr.findAll());
		return "toCooperComp";
	}
	
	/**
	 * 外协完工单查看
	 */
	public String toCooperCompLook(){
		return "toCooperCompLook";
	}
	
	
	
	

}
