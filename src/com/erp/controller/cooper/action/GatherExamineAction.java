package com.erp.controller.cooper.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.cooper.mgr.CooperBillMgr;
import com.erp.controller.cooper.mgr.GatherBillMgr;
import com.erp.model.vo.GatherBillVO;
import com.opensymphony.xwork2.ActionContext;

public class GatherExamineAction extends BaseAction<GatherBillVO>{
	
	private GatherBillMgr gatherBillMgr = new GatherBillMgr();
	private CooperBillMgr cooperBillMgr = new CooperBillMgr();
	
	public String toGatherExamine(){
		ActionContext.getContext().getValueStack().set("gatherBills", gatherBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBillMgr.findAll());
		return "toGatherExamine";
	}
	/**
	 * 跳转到收货单审核的查看页面
	 */
	public String toGatherBillInfo(){
		return "toGatherBillInfo";
	}

}
