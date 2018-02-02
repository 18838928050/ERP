package com.erp.systemdata.action;

import com.erp.controller.action.BaseAction;
import com.erp.model.dao.PayModeDAO;
import com.erp.model.vo.PayMode;
import com.erp.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
/**
 * 付款方式
 * @author JiaQi
 *
 */
public class PayModeAction extends BaseAction<PayMode>{
	private PayModeDAO payModeDAO = new PayModeDAO();
	/**
	 * 跳转到付款方式
	 */
	public String toPayModeList(){
		ActionContext.getContext().getValueStack().set("payModes",payModeDAO.findAllCanUse());
		return "toPayModeList";
	}
	
	/**
	 * 跳转新增付款方式
	 */
	public String toNew(){
		return "toNew";
	}
	
	/**
	 * 新增
	 */
	public String doNew(){
		try {
//			获取UUID
			getModel().setId(IDTools.GetUUID());
			payModeDAO.save(getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toPayModeList();
	}
	
	/**
	 * 删除
	 */
	public String del(){
		try {
			payModeDAO.delete(getModel().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toPayModeList();
	}
	
	/**
	 * 跳转编辑界面
	 */
	public String toEdit(){
		try {
			ActionContext.getContext().getValueStack().set("payMode",payModeDAO.getById(getModel().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toEdit";
	}
	
	/**
	 * 保存编辑
	 */
	public String doSave(){
		
		try {
			PayMode paymode = payModeDAO.getById(getModel().getId());
			paymode.setModeName(getModel().getModeName());
			paymode.setSequenceCode(getModel().getSequenceCode());
			payModeDAO.update(paymode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return toPayModeList();
	}
}
