package com.erp.controller.intercepters;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.erp.controller.intercepters.utils.Permission;
import com.erp.controller.vto.LoginVTOw;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SecutityInterCeptor implements Interceptor {


	public void destroy() {		
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("com.erp.controller.interceptor.SecutityInterCeptor.intercept() 权限拦截器开始检查动作权限: ");
		//这个拦截器准备放在所有拦截器前面，所以要invoke迭代器，以继续往下调用其它拦截器
	
		//获取当前执行的method名字
	
		String methodName = invocation.getProxy().getMethod();
		Method currentMethod = invocation.getAction()
				.getClass().getMethod(methodName, null);
		
		System.out.println("methodName:"+methodName);
		System.out.println("currentMethod:"+currentMethod);
		
		
		//判断用户是否登陆,从session获取当前用户登录信息
		ActionContext ctx=invocation.getInvocationContext();
		Map session = ctx.getSession();
		LoginVTOw loginVTO = (LoginVTOw) session.get("loginVTO");
		if(loginVTO == null) {
			System.out.println("客户还没登陆或登陆已超时！！！");
			return Action.LOGIN;
		}
		//进行权限控制判断
		//判断该请求方法是否需要进行验证
		if(currentMethod.isAnnotationPresent(Permission.class)){ 
			//获取权限校验的注解
			Permission permission = currentMethod
					.getAnnotation(Permission.class);
			//获取当前请求的注解的actionName
			String actionName = permission.actionName();
			//获取当前请求需要的权限
			String privilege = permission.privilegeValue();
			System.out.println("privilege:"+privilege);
			
			/*
			 * 判断当前客户是否拥有对应的权限， 如没有
			 * 跳到指定的无权限提示页面，有,则继续往下执行。    
			 */
			
			/*
			 * select up.user_id,up.privilege_code,u.user_name,
			 * p.privilege_name from t_user u,privilege p,
			 * user_privilege up where u.id = 5 and up.user_id = u.id
			 *  and up.privilege_code = p.privilege_code;
			 * 
			 */
			List<String> list = loginVTO.getPrivileges();
			if(list.contains(privilege)) {
				System.out.println("拦截器中 权限匹配成功");
				//该用户拥有执行这个action里面的这个方法权限
				String resultCode = invocation.invoke();
				}else{
					System.out.println("拦截器中 权限匹配不成功");
					return Action.ERROR;
	            }  
            }
		System.out.println("com.erp.controller.intercepters.SecutityInterCeptor.intercept() 权限拦截器结束检查动作权限: ");
		return invocation.invoke();
	}
}
