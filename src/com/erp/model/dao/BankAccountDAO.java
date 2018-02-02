package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccount;
import com.erp.model.vo.Establishment;

/**
 * 银行账户
 * @author JiaQi
 *
 */
public class BankAccountDAO extends BaseDAO<BankAccount>{

	/**
	 * 获取全部可用的银行账户
	 * @return
	 */
	public List<BankAccount> findAllBankAccount() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<BankAccount> bankAccounts = session.createQuery("from BankAccount where enabled = ?").setString(0, "Y").list();
		session.getTransaction().commit();
		return bankAccounts;
	}

}
