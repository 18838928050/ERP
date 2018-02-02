package com.erp.model.dao;

import java.util.List;


import org.hibernate.Session;

import com.erp.model.vo.LoanBill;
import com.erp.model.vo.InBill;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 资金借入一览表  dao
 * @author WangEn
 *
 */

public class InFinanceDAO extends BaseDAO<LoanBill>{
	/**
	 * 根据状态查询loanBill表
	 * @param billType
	 * @return
	 * @throws Exception
	 */
	public List<LoanBill> findByType(String billType) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<LoanBill> list= session.createQuery("FROM LoanBill where billType=?").setString(0, billType).list();
		session.close();
		return list;
	}
	/**
	 * 根据状态查询LoanBill表
	 * @param examined
	 * @param enabled
	 * @return
	 * @throws Exception
	 */
	public List<LoanBill> findByStatus(String examined,String enabled) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<LoanBill> list= session.createQuery("FROM LoanBill where examined=? and enabled=?").setString(0, examined).setString(1, enabled).list();
		session.close();
		return list;
	}

}
