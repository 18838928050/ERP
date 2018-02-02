package com.erp.controller.customerBusiness.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.controller.customerBusiness.vo.StafferVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 员工 dao
 * @author guo
 *
 */
public class StafferDAO extends BaseDAO<StafferVO>{
	/**
	 * 通过员工名查找信息
	 */
	public List<StafferVO> findByStafferName(String stafferName) {
		Session session=HibernateUtils.getSession();
		List<StafferVO> Staffers = session.createQuery("from StafferVO where stafferName like ?").setString(0, "%"+stafferName+"%").list();
		session.close();
		return Staffers;
	}
//	通过部门编号查询员工
	public List<StafferVO> findByDepartId(Long departmentId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<StafferVO> list= session.createQuery("from StafferVO where departmentId = ? order by id desc").setLong(0, departmentId).list();
		session.close();
		return list;
	}
}
