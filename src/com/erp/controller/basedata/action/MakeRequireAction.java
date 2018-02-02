package com.erp.controller.basedata.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.MakeRequireMgr;
import com.erp.model.vo.MakeRequire;
import com.opensymphony.xwork2.ActionContext;

/**
 * 制作要求
 * @author JiaQi
 *
 */
public class MakeRequireAction extends BaseAction<MakeRequire>{
	private MakeRequireMgr makeRequireMgr = new MakeRequireMgr();
	/**
	 * 跳转  制作要求列表界面
	 */
	public String toMakeRequireList(){
		makeRequireMgr.findAll();
		ActionContext.getContext().getValueStack().set("makeRequires", makeRequireMgr.findAll());
		return "toMakeRequireList";
	}
	
	/**
	 * 删除制作要求
	 */
	public String delMakeReqire(){
		makeRequireMgr.delete(getModel().getId());
		return toMakeRequireList();
	}
	/**
	 * 编辑制作要求
	 */
	public String toMakeReqireEdit(){
		ActionContext.getContext().getValueStack().set("makeRequire", makeRequireMgr.findById(getModel().getId()));
		return "toMakeReqireEdit";
	}
	/**
	 * 更新制作要求
	 */
	public String updateMakeReqireEdit(){
		MakeRequire makeRequire = makeRequireMgr.findById(getModel().getId());
		makeRequire.setCode(getModel().getCode());
		makeRequire.setPrice(getModel().getPrice());
		makeRequire.setRequireContent(getModel().getRequireContent());
		makeRequire.setSequenceCode(getModel().getSequenceCode());
		makeRequireMgr.updateMakeReqire(makeRequire);
		return toMakeRequireList();
	}
	
	/**
	 * 跳转新增页面
	 */
	public String toMakeReqireNew(){
		return "toMakeReqireNew";
	}
	/**
	 * 保存新增项目要求
	 */
	public String makeRequireNew(){
		
		makeRequireMgr.saveMakeRequire(getModel());
		
		return toMakeRequireList();
	}
}
