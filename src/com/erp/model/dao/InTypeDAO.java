package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.InType;

/**
 * 入库类型
 * @author JiaQi
 *
 */
public class InTypeDAO extends BaseDAO<InType>{

	/**
	 * 获取全部可用的 入库类型
	 * @return
	 */
	public List<InType> findAllCanUseInType() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<InType> inTypes = session.createQuery("from InType where enabled = ?").setString(0, "Y").list();
		session.getTransaction().commit();
		return inTypes;
	}
	
//	public List<InType> findByStatus(String enabled) throws Exception{
//	Session session=HibernateUtils.getSession();
//	session.beginTransaction();
//	List<InType> list= session.createQuery("FROM InBill where enabled=?").setString(0, enabled).list();
//	session.close();
//	return list;
//}
}
