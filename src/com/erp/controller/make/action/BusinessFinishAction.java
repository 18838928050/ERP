package com.erp.controller.make.action;
/**
 * 业务单完工
 * @author WE
 */
import com.erp.controller.action.BaseAction;
import com.erp.controller.make.mgr.BusinessBillMgr;
import com.erp.controller.make.mgr.WorkCenterMgr;
import com.erp.model.vo.BusinessBillVO;
import com.opensymphony.xwork2.ActionContext;

public class BusinessFinishAction extends BaseAction<BusinessBillVO>{
	
	private BusinessBillMgr businessBillMgr = new BusinessBillMgr();
	private WorkCenterMgr workCenterMgr = new WorkCenterMgr();
	public String toBusinessFinish(){
		ActionContext.getContext().getValueStack().set("businessBills", businessBillMgr.findAll());
		ActionContext.getContext().getValueStack().set("workCenters", workCenterMgr.findAll());
		return "toBusinessFinish";
	}
	
	public String toInOutItemList(){
		return "toInOutItemList";
	}
	
	public String toInfoForLabel(){
		return "toInfoForLabel";
	}
	public String toInfoForComplete(){
		return "toInfoForComplete";
	}
	public String toFeeBillNew(){
		return "toFeeBillNew";
	}

}
