package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Storehouse;

/**
 * 仓库
 * @author JiaQi
 *
 */
public class StorehouseDAO extends BaseDAO<Storehouse>{

	/**
	 * 获取可用的仓库
	 * @return
	 */
	public List<Storehouse> findAllCanUse() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<Storehouse> storehouses =  session.createQuery("from Storehouse where enabled = ?").setString(0,"Y").list();
		session.getTransaction().commit();
		return storehouses;
	}
}
