package com.erp.controller.intercepters;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class OldSecutityInterCeptor implements Interceptor {

	@Override
	public void destroy() {		
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("com.erp.controller.interceptor.SecutityInterCeptor.intercept() 权限拦截器开始检查动作权限: ");
		//这个拦截器准备放在所有拦截器前面，所以要invoke迭代器，以继续往下调用其它拦截器
		/*
		 * 
		 * 执行逻辑为
		 * 1、当用户为登录前状态，则判断用户名、密码，返回无权限信息
		 * 2、当用户登录成功，将用户信息存入session
		 * 3、当用户执行除了login外的其它业务逻辑action,则首先看session中是否有此用户，
		 *   无：用户未登录，或离线，此时返回登录页面
		 *   有：判断用户角色，根据角色判断权限，是否有访问此资源的权限，
		 *      无：提示无权限
		 *      有：执行action
		 * 
		 */
		/*
		
		UserVO userVO = new UserVO();
		RolesVO rolesVO = new RolesVO();
		privilegesVO  new ()
		*/
		
		String resultCode = invocation.invoke();
		System.out.println("com.erp.controller.intercepters.SecutityInterCeptor.intercept() 权限拦截器结束检查动作权限: ");

		return resultCode;
	}

}
