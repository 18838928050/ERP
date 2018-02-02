package com.erp.controller.cooper.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.cooper.mgr.CooperBillMgr;
import com.erp.controller.cooper.mgr.GatherBillMgr;
import com.erp.model.vo.GatherBillVO;
import com.opensymphony.xwork2.ActionContext;

public class GatherDetailAction extends BaseAction<GatherBillVO>{
	private GatherBillMgr gatherBillMgr = new GatherBillMgr();
	private CooperBillMgr cooperBillMgr = new CooperBillMgr();
	
	public String toGatherDetail(){
		ActionContext.getContext().getValueStack().set("gatherBills", gatherBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBillMgr.findAll());
		return "toGatherDetail";
	}
	/**
	 * 跳转收货单一览表中的反审核页面
	 * @return
	 */
	public String toGatherBillForUnExamine(){
		return "toGatherBillForUnExamine";
	}
	/**
	 * 跳转到收货单一览表中的修改页面
	 * @return
	 */
	public String toGatherBillEdit(){
		return "toGatherBillEdit";
	}

}
