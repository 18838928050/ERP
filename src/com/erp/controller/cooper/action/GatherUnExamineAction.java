package com.erp.controller.cooper.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.cooper.mgr.CooperBillMgr;
import com.erp.controller.cooper.mgr.GatherBillMgr;
import com.erp.model.vo.GatherBillVO;
import com.opensymphony.xwork2.ActionContext;

public class GatherUnExamineAction extends BaseAction<GatherBillVO>{
	
	private GatherBillMgr gatherBillMgr = new GatherBillMgr();
	private CooperBillMgr cooperBillMgr = new CooperBillMgr();
	/**
	 * 跳转收货单反审核
	 * @return
	 */
	public String toGatherUnExamine(){
		ActionContext.getContext().getValueStack().set("gatherBills", gatherBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBillMgr.findAll());
		return "toGatherUnExamine";
	}
	/**
	 * 跳转收货单反审核中的反审核页面
	 */
	public String toGatherBillInfoForUnExamine(){
		return "toGatherBillInfoForUnExamine";
	}

}
