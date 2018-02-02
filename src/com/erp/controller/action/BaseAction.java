package com.erp.controller.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements Action,ServletRequestAware,ServletResponseAware,ModelDriven<T> {
	//模型驱动
	protected T model;
	
	private HttpServletRequest  request;
	private HttpServletResponse response;
	
	public BaseAction(){
		try{
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public HttpServletResponse getServletResponse() {
		return this.response;
	}
	
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	
	public String execute() throws Exception {
		return null;
	}
	
	/**
	 * 获取模型驱动
	 */
	public T getModel() {
		return model;
	}
	
	public static void main(String[] args) {
		System.out.println(2097152/1024/1024);
	}
}
