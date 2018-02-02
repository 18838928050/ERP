package com.erp.systemdata.action;

import java.util.ArrayList;
import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.model.dao.DepartmentDAO;
import com.erp.model.dao.StorehouseDAO;
import com.erp.model.dao.WorkCenterDAO;
import com.erp.model.dao.WorkPressDAOw;
import com.erp.model.vo.WorkCenter;
import com.erp.model.vo.WorkProcessVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 工作中心
 * @author JiaQi
 *
 */
public class WorkCenterAction extends BaseAction<WorkCenter>{
	private WorkCenterDAO workCenterDAO = new WorkCenterDAO();
//	记录选择框选中状态
	private String allView = "N";
//	从前台获取是否选中
	public String isAllView = null;
	
	public String getIsAllView() {
		return isAllView;
	}

	public void setIsAllView(String isAllView) {
		this.isAllView = isAllView;
	}

	/**
	 * 跳转到工作中心界面
	 * 未选中
	 */
	public String toWorkCenter(){
//		获取所有工作中心
		ActionContext.getContext().getValueStack().set("workCenters",workCenterDAO.findAllUseWorkCenter());
//		获取所有仓库
		StorehouseDAO storehouseDAO = new StorehouseDAO();
		try {
			ActionContext.getContext().getValueStack().set("storehouses", storehouseDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		设定是否勾选全部显示（已停用） 未选中
		allView = "N";
		ActionContext.getContext().getValueStack().set("allView",allView);
		return "toWorkCenter";
	}
	
	/**
	 * 跳转到工作中心界面
	 * 选中
	 */
	public String toNoWorkCenter(){
		try {
//		获取所有工作中心
			ActionContext.getContext().getValueStack().set("workCenters",workCenterDAO.findAll());
//		获取所有仓库
			StorehouseDAO storehouseDAO = new StorehouseDAO();
			ActionContext.getContext().getValueStack().set("storehouses", storehouseDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		设定是否勾选全部显示（已停用） 已选中
		allView = "Y";
		ActionContext.getContext().getValueStack().set("allView",allView);
		return "toWorkCenter";
	}
	
	/**
	 * 删除
	 * 未选中
	 */
	public String delWorkCenter(){
		try {
//			获取要删除的对象
			workCenterDAO.delete(getModel().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toWorkCenter();
	}
	
	/**
	 * 删除
	 * 选中
	 */
	public String delNoWorkCenter(){
		try {
//			获取要删除的对象
			workCenterDAO.delete(getModel().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		判断选项框是否勾选
			return toNoWorkCenter();
	}
	
	/**
	 * 停止
	 * 未选中
	 */
	public String sotpWorkCenter(){
		try{
			WorkCenter workCenter = workCenterDAO.getById(getModel().getId());
			if(workCenter.getEnabled().equals("Y")){
				workCenter.setEnabled("N");
			}else if(workCenter.getEnabled().equals("N")){
				workCenter.setEnabled("Y");
			}
			workCenterDAO.update(workCenter);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return toWorkCenter();
	}
	
	/**
	 * 停止
	 * 选中
	 */
	public String sotpNoWorkCenter(){
		try{
			WorkCenter workCenter = workCenterDAO.getById(getModel().getId());
			if(workCenter.getEnabled().equals("Y")){
				workCenter.setEnabled("N");
			}else if(workCenter.getEnabled().equals("N")){
				workCenter.setEnabled("Y");
			}
			workCenterDAO.update(workCenter);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return toNoWorkCenter();
	}
	
	/**
	 * 跳转到新增
	 */
	public String toNew(){
		StorehouseDAO storehouseDAO = new StorehouseDAO();
		try {
			ActionContext.getContext().getValueStack().set("storehouses", storehouseDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toNew";
	}
	
	/**
	 * 新增
	 */
	public String doNew(){
		try {
			workCenterDAO.save(getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toWorkCenter();
	}
	
	/**
	 * 跳转到编辑
	 */
	public String toEdit(){
		StorehouseDAO storehouseDAO = new StorehouseDAO();
		try {
			ActionContext.getContext().getValueStack().set("workCenter", workCenterDAO.getById(getModel().getId()));
			ActionContext.getContext().getValueStack().set("storehouses", storehouseDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toEdit";
	}
	
	/**
	 * 编辑
	 */
	public String doEdit(){
		try {
			WorkCenter workCenter = workCenterDAO.getById(getModel().getId());
			workCenter.setEnabled(getModel().getEnabled());
			workCenter.setMark(getModel().getMark());
			workCenter.setStorehouseId(getModel().getStorehouseId());
			workCenter.setWcName(getModel().getWcName());
			workCenterDAO.update(workCenter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toWorkCenter();
	}
	
	/**
	 * 跳转到工序编辑
	 * JiaQi
	 */
	public String toWorkProcessEdit(){
		
		return "toWorkProcessEdit";
	}
	
	/**
	 * 跳转到工序设置
	 */
	public String toWorkProcessList(){
		WorkPressDAOw workPressDAO = new WorkPressDAOw();
		DepartmentDAO departmentDAO = new DepartmentDAO();
//		获取全部部门
		try {
			ActionContext.getContext().getValueStack().set("departments", departmentDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(isAllView+"---------------------------");
		if(isAllView == null){
			ActionContext.getContext().getValueStack().set("allView", "N");
			ActionContext.getContext().getValueStack().set("workPresses",workPressDAO.getByWC(getModel().getId(),"Y"));
		}else if(isAllView.equals("Y")){
			ActionContext.getContext().getValueStack().set("allView", "Y");
			List<WorkProcessVO> workProcesses = workPressDAO.getByWC(getModel().getId(),"Y");
//			拼接list
			ActionContext.getContext().getValueStack().set("workPresses",workProcesses.addAll(workPressDAO.getByWC(getModel().getId(),"N")));
		}else if(isAllView.equals("N")){
			ActionContext.getContext().getValueStack().set("allView", "N");
			ActionContext.getContext().getValueStack().set("workPresses",workPressDAO.getByWC(getModel().getId(),"Y"));
		}else {
			ActionContext.getContext().getValueStack().set("allView", "N");
			ActionContext.getContext().getValueStack().set("workPresses",workPressDAO.getByWC(getModel().getId(),"Y"));
		}
		return "toWorkProcessList";
	}
	
	/**
	 * 删除工序
	 * JiaQi
	 */
	public String delWorkPress(){
		WorkPressDAOw workPressDAOw = new WorkPressDAOw();
		try {
			workPressDAOw.delete(getModel().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toWorkProcessList();
	}
	
	/**
	 * 停用
	 */
	public String openWorkPress(){
		WorkPressDAOw workPressDAOw = new WorkPressDAOw();
		try {
			WorkProcessVO workProcessVO =  workPressDAOw.getById(getModel().getId());
			if(workProcessVO.getEnabled().equals("Y")){
				workProcessVO.setEnabled("N");
			}else if(workProcessVO.getEnabled().equals("N")){
				workProcessVO.setEnabled("Y");
			}
			workPressDAOw.update(workProcessVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toWorkProcessList();
	}
}
