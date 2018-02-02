/**
 * 
 */
package com.erp.controller.action;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import antlr.collections.List;

import com.erp.controller.system.mgr.WhoOnelineMgr;
import com.erp.controller.vto.WhoOnelineVTO;
import com.erp.model.vo.SystemLog;
import com.opensymphony.xwork2.ActionContext;

/**
 @author： 如约而至    @time：2017年12月3日 上午11:52:36 
 *******************************************************************
 @说明： 谁在线
 *******************************************************************/
public class WhoOnelineAction extends BaseAction<WhoOnelineVTO>{
	WhoOnelineMgr whoOnelineMgr=new WhoOnelineMgr();
	
	public String getAllOnline(){
		Integer appNum=0;
		java.util.List<SystemLog> sy=whoOnelineMgr.getAllOnlines();
		for (SystemLog systemLog : sy) {
			if(systemLog.getMark().equals("APP")){
				appNum++;
			}
		}
		 Integer pcnum= sy.size()-appNum;
		 ActionContext.getContext().getSession().put("pcnum", pcnum);
		 ActionContext.getContext().getSession().put("appnum",appNum);
		 ActionContext.getContext().getSession().put("allnum",sy.size());
		model.setSystemLogs(whoOnelineMgr.getAllOnlines());
		  return "online";
	}
}
