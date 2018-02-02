package com.erp.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.erp.controller.mgr.LoginMgr;
import com.erp.controller.vto.LoginVTOw;
import com.erp.err.PasswordErrorException;
import com.erp.err.UserNotFoundException;
import com.opensymphony.xwork2.Action;

//还可以实现servletContextAware接口，获得servlet上下文对象
public class LoginAction extends BaseAction<LoginVTOw> {


	// tryNum移到LoginMgr中，尽量把业务逻辑放Mgr中，
	// action中尽量少放业务逻辑，集中处理转发
	private int tryNum = 0;
	private String message;

	private LoginVTOw loginVTO;

	public LoginVTOw getLoginVTO() {
		return loginVTO;
	}

	public void setLoginVTO(LoginVTOw loginVTO) {
		this.loginVTO = loginVTO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// 需要 throws LicenseErrorException,但是ErrorMessage未定义
	// 因此此处抛出Exception

	
	public String execute() throws Exception {

		try {
			System.out.println("com.erp.controller.action.execute() ,userName is :"	+ loginVTO.getUserName());
			LoginMgr loginMgr = new LoginMgr();
			//此处应该判断返回信息,返回信息为值对象loginVTO,String {"error","input","main"};
			loginVTO = loginMgr.login(loginVTO);
			if(null==loginVTO.getUserID()){
				System.out.println("用户名称或密码错误");
				addFieldError("error", "用户名称或密码错误");
				return "login";
			}
			
			message = getText("login.success",new String[] { loginVTO.getUserName() });
			
			System.out.println("com.erp.controller.action.execute() ,userid is "+ loginVTO.getUserID());
			System.out.println("com.erp.controller.action.execute() ,message is "+ message);
			System.out.println("com.erp.controller.action.execute() ,loginVTO is "+ loginVTO.toString());

			this.getServletRequest().getSession().setAttribute("loginVTO", loginVTO);
			// session.put("loginDTO", loginVTO);
			// return SUCCESS;
			return "main";
		} catch (UserNotFoundException e) {
			message = getText("login.user.not.found",
					new String[] { loginVTO.getUserName() });
		} catch (PasswordErrorException e) {
			message = getText("login.password.error");
		}
		return ERROR;
	}

	
	
	
	
	/*
	 * public String execute() throws Exception{
	 * 
	 * try { LoginMgr loginMgr = new LoginMgr();
	 * loginMgr.login(getModel().getUserName(),getModel().getPassWord());
	 * message = getText("login.success",new String[] {loginVTO.getUserName()});
	 * System.out.println("com.erp.controller.action.execute() ,username is " +
	 * loginVTO.getUserName());
	 * System.out.println("com.erp.controller.action.execute() ,message is " +
	 * message);
	 * 
	 * 
	 * return SUCCESS; }catch(UserNotFoundException e) { message =
	 * getText("login.user.not.found",new String[] {loginVTO.getUserName()});
	 * 
	 * }catch(PasswordErrorException e) { message =
	 * getText("login.password.error"); } return ERROR;
	 * 
	 * System.out.println("com.erp.controller.action.LoginAction.execute()" +
	 * "01");
	 * 
	 * 
	 * if ("admin".equals(loginVTO.getUserName()) &&
	 * "admin".equals(loginVTO.getPassWord())) { //登录成功，将用户信息放在session中 request
	 * = this.getServletRequest();
	 * request.getSession().setAttribute("loginVTO",loginVTO); return SUCCESS; }
	 * else {
	 * 
	 * System.out.println("com.erp.controller.action.LoginAction.execute()" +
	 * "02"); System.out.println("loginVTO.username is " +
	 * loginVTO.getUserName()); tryNum = tryNum +1 ; System.out.println(
	 * "com.erp.controller.action.LoginAction.execute() .tryNum is " +
	 * this.tryNum); if (tryNum >= 3) { //此处应该锁定该用户账号然后返回ERROR，锁定时间由预设定决定
	 * System.
	 * out.println("com.erp.controller.action.LoginAction.execute() .tryNum is >3"
	 * + this.tryNum);
	 * 
	 * }else { loginVTO.setTryNum(tryNum); }
	 * 
	 * 
	 * return ERROR; } }
	 */

}
