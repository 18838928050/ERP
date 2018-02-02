package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Department;

/**
 * 部门
 * @author JiaQi
 *
 */
public class DepartmentDAO extends BaseDAO<Department>{

	/**
	 * 获取全部部门
	 * @return
	 */
	public List<Department> findAllDepartment() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<Department> departments = session.createQuery("from Department where enabled = ?").setString(0, "Y").list();
		session.getTransaction().commit();
		return departments;
	}
	
}
