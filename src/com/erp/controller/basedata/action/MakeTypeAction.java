package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.MakeTypeMgr;
import com.erp.model.vo.MakeType;
import com.opensymphony.xwork2.ActionContext;

/**
 * 项目类型
 * @author JiaQi
 *
 */
public class MakeTypeAction extends BaseAction<MakeType>{
	private MakeTypeMgr makeTypeMgr = new MakeTypeMgr();
	/**
	 * 跳转主界面面
	 * @return
	 */
	public String toMain(){
		return "toMain";
	}
	/**
	 * 跳转项目类型界面
	 */
	public String toMakeTypeList(){
//		获取全部工作中心
		ActionContext.getContext().getValueStack().set("workCenters", makeTypeMgr.getAllWorkCenter());
//		通过上级Id获取全部项目类型
		ActionContext.getContext().getValueStack().set("makeTypes", makeTypeMgr.findByParentId(0));
		return "MakeTypeList";
	}
	
	/**
	 * 查询子分类
	 */
	public String findCildrenType(){
//		获取全部工作中心
		ActionContext.getContext().getValueStack().set("workCenters", makeTypeMgr.getAllWorkCenter());
//		通过上级Id获取全部项目类型
		ActionContext.getContext().getValueStack().set("makeTypes", makeTypeMgr.findByParentId(getModel().getId()));
		return "MakeTypeList";
		
	}
	
	/**
	 * 删除 项目类型
	 */
	public String delMakeType(){
		makeTypeMgr.delMakeType(getModel().getId());
		return toMakeTypeList();
	}
	
	/**
	 * 编辑项目类型
	 */
	public String toMakeTypeEdit(){
		ActionContext.getContext().getValueStack().set("woekCenters", makeTypeMgr.getAllUseWorkCenter());
		ActionContext.getContext().getValueStack().set("makeType", makeTypeMgr.findById(getModel().getId()));
		return "toMakeTypeEdit";
	}
	
	/**
	 * 保存修改项目
	 */
	public String updateMakeType(){
		MakeType makeType = makeTypeMgr.findById(getModel().getId());
		makeType.setAutoStoc(getModel().getAutoStoc());
		makeType.setType(getModel().getType());
		makeType.setLossRate(getModel().getLossRate());
		makeType.setWorkCenterId(getModel().getWorkCenterId());
		makeType.setUnit(getModel().getUnit());
		makeType.setSequCode(getModel().getSequCode());
		makeType.setTypeName(getModel().getTypeName());
		makeTypeMgr.update(makeType);
		return toMakeTypeList();
	}
	
	/**
	 * 跳转新增项目类型
	 */
	public String toMakeTypeNew(){
		ActionContext.getContext().getValueStack().set("woekCenters", makeTypeMgr.getAllUseWorkCenter());
		return "toMakeTypeNew";
	}
	/**
	 * 保存 新增项目
	 */
	public String saveMakeTypeNew(){
		makeTypeMgr.save(getModel());
		return toMakeTypeList();
	}
}
