package com.erp.controller.make.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.DepartListMgr;
import com.erp.controller.basedata.mgr.MakeTypeMgr;
import com.erp.controller.make.mgr.OutputMgr;
import com.erp.controller.make.mgr.WorkCenterMgr;
import com.erp.controller.make.mgr.WorkProcessMgr;
import com.erp.model.vo.WorkProcessVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 产量统计表
 * @author WE
 *
 */
public class MakeCountAction extends BaseAction<WorkProcessVO>{
	
	private MakeTypeMgr makeTypeMgr = new MakeTypeMgr();
	private OutputMgr OutputMgr = new OutputMgr();
	private WorkCenterMgr workCenterMgr = new WorkCenterMgr();
	private WorkProcessMgr workProcessMgr = new WorkProcessMgr();
	private DepartListMgr departListMgr = new DepartListMgr();
	//跳转产量统计表页面
	public String toProducterCount(){
		ActionContext.getContext().getValueStack().set("makeTypes", makeTypeMgr.findAll());
		ActionContext.getContext().getValueStack().set("outPuts", OutputMgr.findAll());
		ActionContext.getContext().getValueStack().set("workCenters", workCenterMgr.findAll());
		ActionContext.getContext().getValueStack().set("workProcesss", workProcessMgr.findAll());
		ActionContext.getContext().getValueStack().set("departs", departListMgr.findAll());
		return "toProducterCount";
	}

}
