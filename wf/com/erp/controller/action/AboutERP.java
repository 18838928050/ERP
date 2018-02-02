/**
 * 
 */
package com.erp.controller.action;

import org.hibernate.Session;

import com.erp.controller.vto.LoginVTOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.SystemLog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.java.swing.plaf.motif.resources.motif;

/**
 @author： 如约而至    @time：2017年12月3日 下午4:33:26 
 *******************************************************************
 @说明： 关管理易
 *******************************************************************/
public class AboutERP extends ActionSupport{
	public String execute() throws Exception {
		LoginVTOw loginVTOw=(LoginVTOw) ActionContext.getContext().getSession().get("loginVTO");
		SystemLog systemLog=getlastDtime(loginVTOw.getStafferID());
		ActionContext.getContext().put("cateatename", systemLog.getCreaterName());
		ActionContext.getContext().put("lasttime", systemLog.getCreateTime());
		ActionContext.getContext().put("username", loginVTOw.getUserName());
		return "about";
	}
	
	public SystemLog getlastDtime(Long id){
		System.out.println(id+"---");
		Session session=HibernateUtils.getSession();
		 return (SystemLog) session.createQuery("from SystemLog as st where st.createrId="+id+" order by st.createTime desc").setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	
	
	
	
	
	
}
