package com.erp.controller.basedata.action;

import java.util.HashMap;


import java.util.List;
import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.DepartListMgr;
import com.erp.controller.basedata.mgr.ProductMgr;
import com.erp.controller.basedata.mgr.ProductTypeMgr;
import com.erp.controller.basedata.mgr.StafferListMgr;
import com.erp.controller.vto.StafferVTO;
import com.erp.controller.intercepters.utils.Permission;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.StafferVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 部门与员工
 * @author WE
 *
 */

public class DepartStaffAction extends BaseAction<StafferVTO>{
	//创建逻辑处理对象
	private DepartListMgr departListMgr = new DepartListMgr();
	private StafferListMgr stafferListMgr = new StafferListMgr();
	
	/**
	 * 跳转部门与员工主页面
	 */
	public String toMain(){
		return "toStafferMain";
	}
	
	
	/**
	 * 跳转部门列表页面
	 */
	public String toDepartmentList(){
		ActionContext.getContext().getValueStack().set("departList",departListMgr.findAll());
//		ActionContext.getContext().getValueStack().set("departList",departListMgr.get());
		return "toDepartmentList";
	}
	
	
	
	/**
	 * 跳转新增部门页面
	 */
	public String toDepartmentNew(){
		return "toDepartmentNew";
	}
	/**
	  * 将新增的部门保存到数据库中
	  * @return
	  */
	public String DepartmentNew(){
	    departListMgr.saveDepartment(getModel().getDepartment());
		return toDepartmentList();
		}
	
	/**
	 * 跳转编辑部门页面
	 */
	public String toDepartmnetEdit(){
		ActionContext.getContext().getValueStack().set("departList", departListMgr.getById(getModel().getDepartment().getId()));
		return "toDepartmentEdit";
	}
	/**
	  * 编辑部门信息后，在数据库中进行更新
	  */
		public String updateDepartment(){
			departListMgr.updateDepartment(getModel().getDepartment());
			return toDepartmentList();
		}
		/**
		 * 删除department中的某条记录 
		 */
		public String delDepartment(){
			departListMgr.deleteDepartment(getModel().getDepartment().getId());
			return toDepartmentList();
		}
	
	
	/**
	 * 跳转员工列表页面
	 */
	public String toStafferList(){
		List<StafferVO> staffers = stafferListMgr.findByDepartId(getModel().getDepartment().getId());
		//System.out.println(staffers);

		
		
		
		//List<StafferVO> staffers1 = stafferListMgr.findAll();
		//System.out.println(staffers1);
		HashMap<Long, String> staffersSon = new HashMap<>();
		for (StafferVO stafferVO:staffers) {
			//System.out.println(stafferVO.toString());
			staffersSon.put(stafferVO.getId(), stafferVO.getStafferName());
		}
		staffersSon.put((long)0, "");
		for (StafferVO stafferVO2:staffers) {
			long id = stafferVO2.getSuperiorId();
			String name= staffersSon.get(id);
			stafferVO2.setMark(name);
		}
		
		
		
		
 		
		ActionContext.getContext().getValueStack().set("staffers",staffers);
		//System.out.println(stafferListMgr.findByEnabled("Y").size());
		ActionContext.getContext().getValueStack().set("stafferEnable",stafferListMgr.findByEnabled("Y",getModel().getDepartment().getId()).size());
		ActionContext.getContext().getValueStack().set("stafferEnableN",stafferListMgr.findByEnabledN("N",getModel().getDepartment().getId()).size());
//		ActionContext.getContext().getValueStack().set("staffers",staffers1);
		ActionContext.getContext().getValueStack().set("departs", departListMgr.findAll());
		//System.out.println(staffers);
		return "toStafferList";
	}
	
	/**
	 * 跳转新增员工页面
	 */
	public String toStafferNew(){
		return "toStafferNew";
	}
	 /**
	   * 将新增的员工保存到数据库中
	   * @return
	   */
		public String StafferNew(){
			stafferListMgr.saveStaffer(getModel().getStafferVo());
			return toStafferList();
		}
	
	/**
	 * 跳转编辑员工页面
	 */
	public String toStafferEdit(){
		return "toStafferEdit";
	}
	/**
	  * 编辑员工后，在数据库中进行更新
	  */
	public String updateStaffer(){
		stafferListMgr.updateStaffer(getModel().getStafferVo());
		return toStafferList();
	}
	
	/**
	 * 删除staffer中的某条记录 
	 */
	public String delStaffer(){
		stafferListMgr.deleteStaffer(getModel().getStafferVo().getId());
		return toStafferList();
	}
	
	/**
	 * 新增员工页面中  选择上级
	 */
	public String selectSuper(){
		return "toStafferSelect";	
	}
		
	
	
	
	
		


}
