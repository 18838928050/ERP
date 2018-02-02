package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeeBillDAOw extends BaseDAOw<FeeBillVO> {

	public Query findAllByTEN() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query query = null;
		String hql = "from FeeBillVO where tallySetId=2 and enabled='Y' and examined='N'";
		query = session.createQuery(hql);
		return query;

	}

	public void ExaminedTongGuo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update FeeBillVO set examined='Y' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();
	}

	public FeeBillVO ChaZhaoByPayBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "from FeeBillVO where id='" + id + "'";
		return (FeeBillVO) session.createQuery(hql).uniqueResult();
	}

	public List<FeeBillVO> getFeeBillBosByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(FeeBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y")).add(Restrictions.in("tallySetId", 2l));
		criteria.addOrder(Order.desc("feeDate"));
		return criteria.list();
	}

	public List<FeeBillVO> findFeeBillvosByLlimit(Long tallySet) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(FeeBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y")).add(Restrictions.in("tallySetId", tallySet));
		criteria.addOrder(Order.desc("feeDate"));
		return criteria.list();
	}

	public List<FeeBillVO> getFeeBillVOSbylimit(String createrName, long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(FeeBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y"))
				.add(Restrictions.in("tallySetId", tallySetId))
				.add(Restrictions.in("createrName", createrName));
		/*
		 * criteria.add(Restrictions.ge("feeDate", Date.valueOf("2014-08-01")));
		 * criteria.add(Restrictions.le("feeDate", Date.valueOf("2017-09-31")));
		 */
		return criteria.list();
	}

	public List<BankAccountVO> getBankAccountVOSbyFeeBillBankAccountIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BankAccountVO> bankAccountVOs = new ArrayList<BankAccountVO>();
		for (long long2 : ids) {
			bankAccountVOs.add(session.get(BankAccountVO.class, long2));

		}
		return bankAccountVOs;
	}

	// 查找全部已审核的费用单
	public Query findAllYiShenheByTEN() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query query = null;
		String hql = "from FeeBillVO where tallySetId=2 and enabled='Y' and examined='Y'";
		query = session.createQuery(hql);
		return query;

	}

	public void ExaminedShenHeNotTongguo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update FeeBillVO set examined='N' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

}
