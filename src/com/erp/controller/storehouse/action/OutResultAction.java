package com.erp.controller.storehouse.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.storehouse.mgr.OutResultMgr;
import com.erp.controller.storehouse.mgr.OutTypeMgr;
import com.erp.controller.storehouse.mgr.StorehouseMgr;
import com.erp.model.vo.OutBill;
import com.opensymphony.xwork2.ActionContext;
/**
 * 出库单一览表  controller
 * @author WangEn
 *
 */
public class OutResultAction extends BaseAction<OutBill>{
	//创建逻辑处理对象
	private OutResultMgr outResultMgr = new OutResultMgr();
	private StorehouseMgr storehouseMgr = new StorehouseMgr();
	private OutTypeMgr outTypeMgr = new OutTypeMgr();
	//遍历数据库
	public String toOutResult(){
		ActionContext.getContext().getValueStack().set("outTypes", outTypeMgr.findAll());
		ActionContext.getContext().getValueStack().set("storehouses", storehouseMgr.findAll());
		ActionContext.getContext().getValueStack().set("outBills", outResultMgr.findAll());
		return "toOutResult";		
	}
	//跳转修改页面
	public String toOutBillEdit(){
		return "toOutBillEdit";
	}
	//跳转状态页面
	public String tohadExamine(){
		return "tohadExamine";
	}

}
