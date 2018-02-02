package com.erp.controller.storehouse.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.storehouse.mgr.InExamineMgr;
import com.erp.controller.storehouse.mgr.InTypeMgr;
import com.erp.controller.storehouse.mgr.StorehouseMgr;
import com.erp.model.vo.InBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 入库反审核    controller   
 * @author WangEn
 *
 */
public class InStoreUnExamineAction extends BaseAction<InBill>{
	private InExamineMgr inExamineMgr = new InExamineMgr();
	private StorehouseMgr storehouseMgr = new StorehouseMgr();
	private InTypeMgr inTypeMgr = new InTypeMgr();
	
	public String toInStoreUnExamine(){
		ActionContext.getContext().getValueStack().set("inTypes", inTypeMgr.findAll());
		ActionContext.getContext().getValueStack().set("storehouses", storehouseMgr.findAll());
		ActionContext.getContext().getValueStack().set("inBills", inExamineMgr.findAll());
		return "toInStoreUnExamine";
	}

}
