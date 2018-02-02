package com.erp.controller.phone.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.DepartmentVO;
/**
 * 部门 dao
 * @author WE
 *
 */
public class DepartmentDAO extends BaseDAO<DepartmentVO>{
	
//	获得部门的root标签
	public List<DepartmentVO> findRootDepartment() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<DepartmentVO> departments =session.createQuery("from DepartmentVO where parentIdr = 0 and enabled ='Y' ").list();
			session.close();
			return departments;
		}catch (Exception e) {
			return null;
		}
	}
	//根据查询部门
	public List<DepartmentVO> findDepartment() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<DepartmentVO> departments =session.createQuery("from DepartmentVO where  enabled ='Y' ").list();
			session.close();
			return departments;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
}
