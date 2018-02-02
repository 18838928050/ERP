package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.MakeType;

import net.sf.ehcache.hibernate.HibernateUtil;

/**
 * 项目制作  DAO
 * @author JiaQi
 *
 */
public class MakeTypeDAO extends BaseDAO<MakeType>{
	/**
	 * 通过ID获取
	 * @param id
	 * @return
	 */
	public List<MakeType> findfindByParentId(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		 List<MakeType> makeTypes = session.createQuery("from MakeType where parentId = ?").setLong(0,id).list();
		session.getTransaction().commit();
		session.close();
		return makeTypes;
	}
	
	/**
	 * 获取可用
	 * @return
	 */
	public List<MakeType> findCanUse() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		 List<MakeType> makeTypes = session.createQuery("from MakeType where enabled = 'Y'").list();
		session.getTransaction().commit();
		session.close();
		return makeTypes;
	}
}
