package com.erp.controller.make.action;
/**
 * 业务单反完工
 * @author WE
 */
import com.erp.controller.action.BaseAction;
import com.erp.controller.make.mgr.BusinessBillMgr;
import com.erp.controller.make.mgr.WorkCenterMgr;
import com.erp.model.vo.BusinessBillVO;
import com.opensymphony.xwork2.ActionContext;

public class BusinessUnFinishAction extends BaseAction<BusinessBillVO>{
	private BusinessBillMgr businessBillMgr = new BusinessBillMgr();
	private WorkCenterMgr workCenterMgr = new WorkCenterMgr();
	public String toBusinessUnFinish(){
		ActionContext.getContext().getValueStack().set("businessBills", businessBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("workCenters", workCenterMgr.findAll());
		return "toBusinessUnFinish";
	}
	public String toInfoForUnComplete(){
		return "toInfoForUnComplete";
	}

}
