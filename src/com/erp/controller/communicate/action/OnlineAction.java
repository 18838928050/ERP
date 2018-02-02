package com.erp.controller.communicate.action;

import java.util.LinkedList;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.erp.controller.action.BaseAction;
import com.erp.model.vo.ClieUser;
import com.erp.model.vo.SystemLog;

/**
 * 谁在线  action
 * @author WangEn
 *
 */
public class OnlineAction extends BaseAction<SystemLog>{
	public String toOnlineList(){
		return "toOnlineList";
	}
	
	 

}
