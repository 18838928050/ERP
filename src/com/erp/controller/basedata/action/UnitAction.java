package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.UnitMgr;
import com.erp.model.vo.Unit;
import com.opensymphony.xwork2.ActionContext;
/**
 * 材料  计量单位
 * @author WE
 *
 */
public class UnitAction extends BaseAction<Unit>{
	//创建业务逻辑处理对象
	private UnitMgr unitMgr = new UnitMgr();
	/**
	 * 跳转计量单位主页面
	 */
	public String toUnitList(){
		ActionContext.getContext().getValueStack().set("units", unitMgr.findAll());
		return "toUnitList";
	}
	/**
	 * 跳转计量单位新增页面
	 */
	public String toUnitNew(){
		return "toUnitNew";
	}
	/**
	 * 将新增的单位保存到数据库中
	 * @return
	 */
	public String unitNew(){
		unitMgr.saveUnit(getModel());
		return toUnitList();
	}
	/**
	 * 跳转计量单位编辑页面
	 */
	public String toUnitEdit(){
		ActionContext.getContext().getValueStack().set("unit", unitMgr.getById(getModel().getId()));
		return "toUnitEdit";
	}
	/**
	 * 编辑计量单位后，在数据库中进行更新
	 */
	public String updateUnitEdit(){
		unitMgr.updateUnit(getModel());
		return toUnitList();
	}
	
	/**
	 * 删除unit中的某条记录 
	 */
	public String delUnit(){
		
		unitMgr.deleteUnit(getModel().getId());
		return toUnitList();
	}
}
