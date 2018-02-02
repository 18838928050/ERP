package com.erp.model.dao;

import java.util.List;



import org.hibernate.Session;

import com.erp.controller.vto.StafferVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.StafferVO;

/**
 * 员工表 dao
 * @author WE
 *
 */
public class StafferDAO extends BaseDAO<StafferVO>{
	
//	/**
//	 * 通过 userName查找信息
//	 */
//	public StafferVO findByUserName(String userName) {
//		Session session=HibernateUtils.getSession();
//		session.beginTransaction();
//		StafferVO staffer = (StafferVO)session.createQuery("from StafferVO where userName = ?").setString(0, userName).uniqueResult();
//		session.close();
//		return staffer;
//	}

	public List<StafferVO> findByDepartId(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<StafferVO> list= session.createQuery("from StafferVO where departmentId = ?").setLong(0, id).list();
		session.close();
		return list;
	}
	
	public List<StafferVO> findByEnabled(String Y,long id){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<StafferVO> list= session.createQuery("from StafferVO where enabled = ? and departmentId = ?").setString(0, Y).setLong(1, id).list();
		session.close();
		return list;	
	}
	
	public List<StafferVO> findByEnabledN(String N,long id){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<StafferVO> list= session.createQuery("from StafferVO where enabled = ? and departmentId = ?").setString(0, N).setLong(1, id).list();
		session.close();
		return list;	
	}
	
	/**
	 * 通过姓名查询  模糊查询
	 */
	public List<StafferVO> findByName(String userName){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<StafferVO> list= session.createQuery("from StafferVO where stafferName like ?").setString(0, "%"+userName+"%").list();
		session.close();
		return list;
	}

}
