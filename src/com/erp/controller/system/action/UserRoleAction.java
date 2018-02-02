package com.erp.controller.system.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.intercepters.utils.Permission;
import com.erp.controller.system.mgr.UserRoleMgr;
import com.erp.model.vo.UserVO;
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
	/*@Permission(actionName="toUserRole",privilegeValue="SYST_USER")*/
	public String toUserRole(){
		ActionContext.getContext().getValueStack().set("users",userRoleMgr.findAll());
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
		ActionContext.getContext().getValueStack().set("users",userRoleMgr.findUser(getModel().getUserName()));
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
		ActionContext.getContext().getValueStack().set("user", userRoleMgr.findById(getModel().getId()));
		System.out.println(userRoleMgr.findById(getModel().getId()).getId());
		return "toUserEdit";
	}
	/**
	 * 修改用户
	 */
	public String UserEdit(){
		UserVO userVO = userRoleMgr.findById(getModel().getId());
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
		return toUserRole();
	}
}
