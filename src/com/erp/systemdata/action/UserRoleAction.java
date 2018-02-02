package com.erp.systemdata.action;

import java.util.ArrayList;
import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.intercepters.utils.Permission;
import com.erp.model.dao.StafferDAO;
import com.erp.model.vo.UserVO;
import com.erp.model.vto.UserVTO;
import com.erp.systemdata.mgr.UserRoleMgr;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户权限 
 * @author JiaQi
 * 
 */
public class UserRoleAction extends BaseAction<UserVO>{
//	闯将逻辑处理  mgr 对象
	private UserRoleMgr userRoleMgr = new UserRoleMgr();
	/**
	 * 返回登录页面实例
	 * @return
	 */
	public String Demo(){
		return "Demo";
	}
	
	/**
	 * 跳转主页面
	 */
	public String toMain(){
		return "toMain";
	}
	
	/**
	 * 快速进入系统
	 */
	public String toIndex(){
		return "toIndex";
	}
	
	/**
	 * 跳转用户权限
	 */
	//@Permission(actionName="toUserRole",privilegeValue="SYST_USER")
//	@Permission(actionName="toUserRole",privilegeValue="SYST_USER")
	public String toUserRole(){
		List<UserVTO> userVTOs = new ArrayList<UserVTO>();
		StafferDAO stafferDAO = new StafferDAO();
		int i = 0;
		while (i < userRoleMgr.findAll().size()) {
			UserVTO userVTO = new UserVTO();
			try {
				userVTO.setStaffer(stafferDAO.getById(userRoleMgr.findAll().get(i).getStafferId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			userVTO.setUser(userRoleMgr.findAll().get(i));
			userVTOs.add(userVTO);
			i++;
		}
		ActionContext.getContext().getValueStack().set("users",userVTOs);
		return "toUserRole";
	}
	
	/**
	 * 删除用户
	 */
	public String deletcUser(){
		userRoleMgr.delById(getModel().getId());
		return toUserRole();
	}
	
	/**
	 * 停用用户 
	 */
	public String stopAbled(){
		userRoleMgr.setAbled(getModel().getId(),"N");
		return toUserRole();
	}
	/**
	 * 启用账户
	 */
	public String openAbled(){
		userRoleMgr.setAbled(getModel().getId(),"Y");
		return toUserRole();
	}
	/**
	 * 跳转添加用户
	 */
	public String toUserNew(){
		return "toUserNew";
	}
	/**
	 * 搜索用户
	 */
	public String findUser(){
		List<UserVTO> userVTOs = new ArrayList<UserVTO>();
		StafferDAO stafferDAO = new StafferDAO();
		int i = 0;
		while (i < userRoleMgr.findUser(getModel().getUserName()).size()) {
			UserVTO userVTO = new UserVTO();
			try {
				userVTO.setStaffer(stafferDAO.getById(userRoleMgr.findUser(getModel().getUserName()).get(i).getStafferId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			userVTO.setUser(userRoleMgr.findUser(getModel().getUserName()).get(i));
			userVTOs.add(userVTO);
			i++;
		}
		
		i = 0;
		
		while(i < stafferDAO.findByName(getModel().getUserName()).size()){
			UserVTO userVTO = new UserVTO();
			userVTO.setUser(userRoleMgr.findByStafferId(stafferDAO.findByName(getModel().getUserName()).get(i).getId()));
			userVTO.setStaffer(stafferDAO.findByName(getModel().getUserName()).get(i));
			userVTOs.add(userVTO);
			i++;
		}
		
		ActionContext.getContext().getValueStack().set("users",userVTOs);
		
		return "toUserRole";
	}
	
	/**
	 * 添加用户
	 */
	public String UserNew(){
		UserVO user = userRoleMgr.findByUserNameToVO(getModel().getUserName());
		if(user != null){
			System.out.println("该账号已存在！");
		}else{
			UserVO userVO = new UserVO();
			userVO.setUserName(getModel().getUserName());
			userVO.setPassword(getModel().getPassword());
			userVO.setUseValidity(getModel().getUseValidity());
			userVO.setValidity(getModel().getValidity());
			userVO.setEnabled(getModel().getEnabled());
			userVO.setTimeLimit(getModel().getTimeLimit());
			userVO.setTlStartHour(getModel().getTlEndHour());
			userVO.setTlStartMinute(getModel().getTlStartMinute());
			userVO.setTlEndHour(getModel().getTlEndHour());
			userVO.setTlEndMinute(getModel().getTlEndMinute());
			userVO.setAllowInternet(getModel().getAllowInternet());
			userVO.setUseApp(getModel().getUseApp());
			userRoleMgr.save(userVO);
		}
		return toUserRole();
	}
	
	/**
	 * 编辑用户
	 */
	public String toUserEdit(){
		StafferDAO stafferDAO = new StafferDAO();
		ActionContext.getContext().getValueStack().set("user", userRoleMgr.findById(getModel().getId()));
		try{
			ActionContext.getContext().getValueStack().set("staffer", stafferDAO.getById(userRoleMgr.findById(getModel().getId()).getStafferId()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "toUserEdit";
	}
	/**
	 * 修改用户
	 */
	public String UserEdit(){
		UserVO userVO = userRoleMgr.findById(getModel().getId());
		userVO.setUserName(getModel().getUserName());
		userVO.setPassword(getModel().getPassword());
		userVO.setUseValidity(getModel().getUseValidity());
		userVO.setValidity(getModel().getValidity());
		userVO.setEnabled(getModel().getEnabled());
		userVO.setTimeLimit(getModel().getTimeLimit());
		userVO.setTlStartHour(getModel().getTlEndHour());
		userVO.setTlStartMinute(getModel().getTlStartMinute());
		userVO.setTlEndHour(getModel().getTlEndHour());
		userVO.setTlEndMinute(getModel().getTlEndMinute());
		userVO.setAllowInternet(getModel().getAllowInternet());
		userVO.setUseApp(getModel().getUseApp());
		userRoleMgr.update(userVO);
		System.out.println(userVO);
		return "toUserEdit";
	}
}
