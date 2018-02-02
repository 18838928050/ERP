package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.AccessoryMarkMgr;
import com.erp.model.vo.AccessoryMark;
import com.opensymphony.xwork2.ActionContext;

/**
 * 文件说明
 * @author JiaQi
 *
 */
public class AccessoryMarkAction extends BaseAction<AccessoryMark>{
	private AccessoryMarkMgr accessoryMarkMgr = new AccessoryMarkMgr();
	
	/**
	 * 跳转至文件说明页面
	 */
	public String toAccessoryMarkList(){
		ActionContext.getContext().getValueStack().set("accessoryMarks", accessoryMarkMgr.findAll());
		return "toAccessoryMarkList";
	}
	
	/**
	 * 删除文件说明
	 */
	public String delAccessoryMark(){
		accessoryMarkMgr.deleteAccessory(getModel().getId());
		return toAccessoryMarkList();
	}
	
	/**
	 *跳转 编辑 文件说明
	 */
	public String toAccessoryEdit(){
		ActionContext.getContext().getValueStack().set("accessoryMark",accessoryMarkMgr.findById(getModel().getId()));
		return "toAccessoryEdit";
	}
	
	/**
	 * 标记  文件说明
	 */
	public String updateAccessoryMark(){
		AccessoryMark accessoryMark = accessoryMarkMgr.findById(getModel().getId());
		accessoryMark.setMark(getModel().getMark());
		accessoryMark.setSequenceCode(getModel().getSequenceCode());
		
		accessoryMarkMgr.updateAccessoryMark(accessoryMark);
		
		return toAccessoryMarkList();
	}
	
	/**
	 * 跳转新增   文件说明界面
	 */
	public String toAccessoryNew(){
		return "toAccessoryNew";
	}
	
	/**
	 * 新增文件说明界面
	 */
	public String saveAccessoryMark(){
		accessoryMarkMgr.saveAccessoryMark(getModel());
		return toAccessoryMarkList();
	}
}
