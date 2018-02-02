package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.IncomeType;

/**
 * 收入类型
 * @author JiaQi
 *
 */
public class InComeTypeDAO extends BaseDAO<IncomeType>{
	
	/**
	 * 获取全部可用的
	 */
	public List<IncomeType> findAllUseInComeType(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeType> list= session.createQuery("from IncomeType where enabled = ?").setString(0, "Y")
				.list();
		session.close();
		return list;
	}

}
