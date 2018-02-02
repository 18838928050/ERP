package com.erp.controller.make.action;
/**
 * 生产进度管理
 * @author WE
 */
import com.erp.controller.action.BaseAction;
import com.erp.controller.make.mgr.BusinessBillMgr;
import com.erp.model.vo.BusinessBillVO;
import com.opensymphony.xwork2.ActionContext;

public class BusinessBillForTaskAction extends BaseAction<BusinessBillVO>{
	
	private BusinessBillMgr businessBillMgr = new BusinessBillMgr();
	
	public String toBusinessBillForTask(){
		ActionContext.getContext().getValueStack().set("businessBills", businessBillMgr.findAll());
		return "toBusinessBillForTask";
		
	}

}
