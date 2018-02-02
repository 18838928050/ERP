/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccountVO;

/**
 * @author： 如约而至 @time：2017年8月31日 下午10:17:46
 *******************************************************************
 @说明：
 *******************************************************************/
@SuppressWarnings("unchecked")
public class BankAccountDAOw extends BaseDAOw<BankAccountVO> {
	/**
	 * @throws Exception
	 * @说明：停止账户
	 */
	public void stopBankAccountById(long id, Integer str) throws Exception {
		BankAccountVO bankAccountVO = getById(id);
		if (str == 1) {
			bankAccountVO.setStatus(new String("N"));
		} else {
			bankAccountVO.setStatus(new String("Y"));
		}
		update(bankAccountVO);

	}

	/**
	 * @说明：查询所有银行账户 并对结果按照sequenceCode进行升序
	 */

	public SQLQuery findAllOderyBySequenceCode() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		SQLQuery query = session
				.createSQLQuery("select * from bank_account  where enabled='Y' order by sequence_code asc");
		query.addEntity(BankAccountVO.class);
		return query;
	}

	/**
	 * @说明：
	 */
	@SuppressWarnings("rawtypes")
	public int getBankAccountSequenceCodeMax() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Object i = session.createQuery("select Max(sequenceCode) from  BankAccountVO")
				.uniqueResult();
		return (int) i;
	}

	/**
	 * @param listPayIds
	 * @return
	 */
	public List<List<BankAccountVO>> getBanksByPayBankAccountIds(List<Long> listBankIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<BankAccountVO>> b = new ArrayList<List<BankAccountVO>>();
		for (Long long1 : listBankIds) {
			b.add(session.createQuery("from BankAccountVO where id='" + long1 + "'").list());
		}
		return b;
	}

	public List<BankAccountVO> getBankAccountsByFeebillBankAccouIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BankAccountVO> b = new ArrayList<BankAccountVO>();
		for (Long long1 : ids) {
			b.add(session.get(BankAccountVO.class, long1));
		}

		return b;
	}

	public BankAccountVO getBankAccountByFbBankAccId(long id) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		return session.get(BankAccountVO.class, id);
	}

	public List<BankAccountVO> setsetBankAccountVOS(List<Long> ids) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BankAccountVO> l = new ArrayList<BankAccountVO>();
		for (long long1 : ids) {
			l.add(session.get(BankAccountVO.class, long1));
		}
		return l;
	}

	public BankAccountVO findBankByPbId(long id) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hqlString = "select bankAccountId from PurchaseBillVO where id='" + id + "'";
		long id2 = (long) session.createQuery(hqlString).uniqueResult();
		Criteria criteria = session.createCriteria(BankAccountVO.class);
		criteria.add(Restrictions.in("id", id2));
		return (BankAccountVO) criteria.uniqueResult();
	}
}
