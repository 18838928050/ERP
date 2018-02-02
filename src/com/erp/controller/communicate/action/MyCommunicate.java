package com.erp.controller.communicate.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.business.mgr.BusinessMgr;
import com.erp.controller.communicate.mgr.MyCommunicateMgr;
import com.erp.controller.vto.LoginVTOw;
import com.erp.model.vo.EstablishmentCommunicate;
import com.opensymphony.xwork2.ActionContext;

/**
 * 我的沟通
 * @author JiaQi
 *
 */
public class MyCommunicate extends BaseAction<EstablishmentCommunicate>{
	private MyCommunicateMgr myCommunicateMgr = new MyCommunicateMgr();
	/**
	 * 获取全部
	 */
	public String toEstabComm(){
		ActionContext.getContext().getValueStack().set("myCommunicates", myCommunicateMgr.findAll());
		return "toEstabComm";
	}
	
	/**
	 * 新增日程
	 */
	public String toNewComm(){
		BusinessMgr businessMgr = new BusinessMgr();
		ActionContext.getContext().getValueStack().set("staffers", businessMgr.findAllStafferCanUse());
		return "toNewComm";
	}
	
	/**
	 * 保存新增
	 */
	public String saveNewComm(){
		LoginVTOw user = (LoginVTOw)this.getServletRequest().getSession().getAttribute("loginVTO");
		getModel().setCreaterName(user.getUserName());
		myCommunicateMgr.save(getModel());
		return toEstabComm();
	}
}
