package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Establishment;

/**
 * Establishment  客户
 * @author JiaQi
 *
 */
public class EstablishmentDAO extends BaseDAO<Establishment>{
	/**
	 * 获取全部可以使用的客户
	 */
	public List<Establishment> findAllCanUse(){
		
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Establishment> establishments = session.createQuery("from Establishment where enabled = ?").setString(0, "Y").list();
		session.close();
		return establishments;
	}

}
