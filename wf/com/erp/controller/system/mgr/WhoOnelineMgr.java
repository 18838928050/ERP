/**
 * 
 */
package com.erp.controller.system.mgr;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.erp.model.dao.SystemLogDAO;
import com.erp.model.dao.UserDAOw;
import com.erp.model.vo.SystemLog;
import com.erp.model.vo.UserVO;

/**
 @author： 如约而至    @time：2017年12月3日 上午11:53:46 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class WhoOnelineMgr {
	UserDAOw userDAOw=new UserDAOw();
	SystemLogDAO systemLogDAO=new SystemLogDAO();
	
	
	
	public List<UserVO> getAllUserEnabledY(){
		return userDAOw.getAllUserEnabledY();
	}
	
	public SystemLog getSyslog(long staffedid){
		return  systemLogDAO.getByStaid(staffedid);
	}

	
	/**
	 * @说明：所有
	 */
	public List<SystemLog> getAllOnlines() {
		List<UserVO> users=getAllUserEnabledY();
		List<SystemLog> systemLogs=new ArrayList<SystemLog>();
		for (UserVO u : users) {
				SystemLog s=	systemLogDAO.getByStaid(u.getStafferId());
			 if(s!=null){
				 systemLogs.add(s);
			 }
		}
		return systemLogs;
	}
	

}
