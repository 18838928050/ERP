package com.erp.controller.cooper.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.cooper.mgr.CooperBillMgr;
import com.erp.controller.cooper.mgr.GatherBillMgr;
import com.erp.model.vo.CooperBillVO;
import com.opensymphony.xwork2.ActionContext;

public class CooperGatherAction extends BaseAction<CooperBillVO>{
	
	private CooperBillMgr cooperBillMgr = new CooperBillMgr();
	private GatherBillMgr gatherBillMgr = new GatherBillMgr();
	//跳转外协收货页面
	public String toCooperGather(){
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("gatherBills", gatherBillMgr.findAll());
		return "toCooperGather";
	}
	/**
	 * 跳转外协收货中的查看页面
	 * @return
	 */
	public String toCooperRelBill(){
		return "toCooperRelBill";
	}
	/**
	 * 跳转外协收货中的收获页面
	 * @return
	 */
	public String toGatherBillNew(){
		return "toGatherBillNew";
	}

}
