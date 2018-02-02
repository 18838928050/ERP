package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.WorkCenter;

/**
 * 工作中心
 * @author JiaQi
 *
 */
public class WorkCenterDAO extends BaseDAO<WorkCenter>{
	/**
	 * 获取可用的工作中心
	 */
	public List<WorkCenter> findAllUseWorkCenter(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<WorkCenter> workCenters =  session.createQuery("from WorkCenter where enabled = ?").setString(0, "Y").list();
//		session.getTransaction().commit();
		session.close();
		return workCenters;
	}
}
