package com.erp.controller.system.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.TallySetMgr;
import com.erp.model.vo.TallySetVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 帐套管理
 * @author WE
 *
 */
public class TallySetAction extends BaseAction<TallySetVO>{
	private TallySetMgr tallySetMgr = new TallySetMgr();
	/**
	 * 跳转帐套管理页面
	 */
	public String toTallySetList(){
		ActionContext.getContext().getValueStack().set("tallySet", tallySetMgr.findAll());
		//System.out.println(tallySetMgr.findAll());
		return "toTallySetList";
	}
	/**
	 * 跳转套餐管理新增页面
	 */
	public String toTallySetNew(){
		return "toTallySetNew";
	}
	/**
	 * 将新增的套餐管理保存到数据库中
	 * @return
	 */
	public String tallySetNew(){
		tallySetMgr.saveTallySet(getModel());
		return toTallySetList();
	}
	/**
	 * 跳转套餐管理编辑页面
	 */
	public String toTallySetEdit(){
		ActionContext.getContext().getValueStack().set("tallyset", tallySetMgr.getById(getModel().getId()));
		return "toTallySetEdit";
	}
	/**
	 * 编辑计量单位后，在数据库中进行更新
	 */
	public String updateTallySetEdit(){
		tallySetMgr.updateTallySet(getModel());
		return toTallySetList();
	}
	
	/**
	 * 删除tallyset中的某条记录 
	 */
	public String delTallySet(){
		tallySetMgr.deleteTallySet(getModel().getId());
		return toTallySetList();
	}
	

}
