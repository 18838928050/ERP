package com.erp.systemdata.action;

import com.erp.controller.action.BaseAction;
import com.erp.model.dao.StorehouseDAO;
import com.erp.model.dao.TallySetDAO;
import com.erp.model.vo.Storehouse;
import com.opensymphony.xwork2.ActionContext;

/**
 * 仓库
 * @author JiaQi
 *
 */
public class StoreHousAction extends BaseAction<Storehouse>{
	private TallySetDAO tallySetDAO = new TallySetDAO();
	private StorehouseDAO storehouseDAO = new StorehouseDAO();
	/**
	 * 跳转至仓库
	 */
	public String toStorehouse(){
		ActionContext.getContext().getValueStack().set("tallySet", tallySetDAO.getTallySetList());
		ActionContext.getContext().getValueStack().set("storehouses", storehouseDAO.findAllCanUse());
		return "toStorehouse";
	}
	
	/**
	 * 删除
	 */
	public String doDel(){
		try {
			storehouseDAO.delete(getModel().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toStorehouse();
	}
	/**
	 * 跳转到编辑界面
	 */
	public String toEdit(){
		try {
			ActionContext.getContext().getSession().put("tallySets", tallySetDAO.findAll());
			ActionContext.getContext().getValueStack().set("storehouse", storehouseDAO.getById(getModel().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toEdit";
	}
}
