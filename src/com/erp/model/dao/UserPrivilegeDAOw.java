package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;

/**
 @author： 半缘修道半缘君    @time：2017年8月28日 下午3:22:33 
 **************************************************************************************************************************************
 @说明：增加
 **************************************************************************************************************************************/
public class UserPrivilegeDAOw {
	
	public List<String> getPrivileges(Long userID) {
		try {
			Session session = HibernateUtils.getSession();
			//session.beginTransaction();
			List<String> privileges = session
					.getNamedQuery("selectPrivileges")
					.setLong("myID", userID).list();
			System.out.println("com.erp.model.dao.UserPrivilegeDAO.getPrivileges().privileges :"
					+ privileges.toString());
			session.close();
			return privileges;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}		
		}	
	
	

}
