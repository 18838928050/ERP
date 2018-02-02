package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.CustomerTypeMgr;
import com.erp.model.vo.EstablishmentType;
import com.opensymphony.xwork2.ActionContext;
/**
 * 客户类型
 * @author WE
 *
 */
public class CustomerTypeAction extends BaseAction<EstablishmentType>{
	//创建业务逻辑处理对象
	private CustomerTypeMgr customerTypeMgr = new CustomerTypeMgr();
	/**
	 * 跳转客户类型主页面
	 */
	public String toCustomTypeMain(){
		ActionContext.getContext().getValueStack().set("customTypes",customerTypeMgr.findAll());
		return "toCustomTypeMain";
	}
	
	/**
	 * 跳转主页面中的新增页面
	 */
	public String toCustomTypeNew(){
		return "toCustomTypeNew";
    }
	
	/**
	 * 将新增的单位类别保存到数据库中
	 * @return
	 */
	public String CustomerTypeNew(){
		customerTypeMgr.saveCustomerType(getModel());
		return toCustomTypeMain();
	}

	/**
	 * 跳转单位类别编辑页面
	 */
	public String toCustomTypeEdit(){
		ActionContext.getContext().getValueStack().set("customTypes", customerTypeMgr.getById(getModel().getId()));
		return "toCustomTypeEdit";
	}
	
	/**
	 * 编辑单位类别后，在数据库中进行更新
	 */
	public String updateCustomerTypeEdit(){
		customerTypeMgr.updateCustomerType(getModel());
		return toCustomTypeMain();
	}
	
	/**
	 * 删除establishment_type中的某条记录 
	 */
	public String delEstablishmentType(){
		
		customerTypeMgr.deleteType(getModel().getId());
		return toCustomTypeMain();
	}
}