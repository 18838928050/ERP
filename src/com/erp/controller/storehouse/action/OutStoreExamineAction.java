package com.erp.controller.storehouse.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.storehouse.mgr.InExamineMgr;
import com.erp.controller.storehouse.mgr.InTypeMgr;
import com.erp.controller.storehouse.mgr.OutExamineMgr;
import com.erp.controller.storehouse.mgr.OutTypeMgr;
import com.erp.controller.storehouse.mgr.StorehouseMgr;
import com.erp.model.vo.OutBill;
import com.opensymphony.xwork2.ActionContext;
/**
 * 出库审核  controller
 * @author WangEn
 *
 */
public class OutStoreExamineAction extends BaseAction<OutBill>{
	
	private OutExamineMgr outExamineMgr = new OutExamineMgr();
	private StorehouseMgr storehouseMgr = new StorehouseMgr();
	private OutTypeMgr outTypeMgr = new OutTypeMgr();
	
	public String toOutStoreExamine(){
		ActionContext.getContext().getValueStack().set("outTypes", outTypeMgr.findAll());
		ActionContext.getContext().getValueStack().set("storehouses", storehouseMgr.findAll());
		ActionContext.getContext().getValueStack().set("outBills", outExamineMgr.findAll());
		
//		System.out.println(outExamineMgr.findAll());
		
		return "toOutStoreExamine";
	}

}
