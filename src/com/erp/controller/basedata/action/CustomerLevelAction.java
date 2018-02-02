package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.CustomerLevelMgr;
import com.erp.model.vo.EstablishmentLevel;
import com.opensymphony.xwork2.ActionContext;
/**
 * 客户等级
 * @author WE
 *
 */

public class CustomerLevelAction extends BaseAction<EstablishmentLevel>{
	//创建业务逻辑处理对象
	private CustomerLevelMgr customerLevelMgr = new CustomerLevelMgr();
	
	/**
	 * 跳转客户等级主页面
	 */
	public String toCustomLevelMain(){
		ActionContext.getContext().getValueStack().set("customLevels", customerLevelMgr.findAll());
		return "toCustomLevelMain";
	}
	
	/**
	 * 跳转客户等级新增页面
	 */
	public String toCustomLevelNew(){
		return "toCustomLevelNew";
	}
	
	/**
	 * 将新增的客户等级保存到数据库中
	 * @return
	 */
	public String CustomerLevelNew(){
		customerLevelMgr.saveCustomerLevel(getModel());
		return toCustomLevelMain();
	}
	
	/**
	 * 跳转客户等级编辑页面
	 */
	public String toCustomLevelEdit(){
		ActionContext.getContext().getValueStack().set("customLevels", customerLevelMgr.getById(getModel().getId()));
		return "toCustomLevelEdit";
	}
	
	/**
	 * 编辑客户等级后，在数据库中进行更新
	 */
	public String updateCustomerLevelEdit(){
		customerLevelMgr.updateCustomerLevel(getModel());
		return toCustomLevelMain();
	}
	
	/**
	 * 删除establishment_level中的某条记录 
	 */
	public String delestablishmentlevel(){
		
		customerLevelMgr.deletelevel(getModel().getId());
		return toCustomLevelMain();
	}
	
	



}
