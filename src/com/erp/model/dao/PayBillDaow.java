package com.erp.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.StafferVO;

public class PayBillDaow extends BaseDAOw<PayBillVO> {
	/**
	 * 
	 * @return
	 */
	public Query findAAll() {
		Query query = null;
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		query = session.createQuery("FROM  PayBillVO");
		return query;
	}

	public List<BankAccountVO> findBankAccountAndAccountName() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql1 = "select bankAccountId from PayBillVO";
		List<Long> ids = session.createQuery(hql1).list();
		Criteria criteria = session.createCriteria(BankAccountVO.class);
		criteria.add(Restrictions.in("id", ids));
		List<BankAccountVO> list = criteria.list();
		return list;
	}

	/**
	 * @return
	 * 
	 */
	public List<EstablishmentVO> findEst() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql2 = "select receiverId from PayBillVO";
		List<Long> ids = session.createQuery(hql2).list();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("id", ids));
		List<EstablishmentVO> list = criteria.list();
		return list;

	}

	public List<PayBillVO> getAllPayBillByLimit() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PayBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.ge("payDate", Date.valueOf("2014-08-01")));
		criteria.add(Restrictions.le("payDate", Date.valueOf("2017-10-01")));
		return criteria.list();

	}

	/**
	 * 
	 * @return
	 */
	public List<StafferVO> findCreater() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql2 = "select createrId from PayBillVO";
		List<Long> ids = session.createQuery(hql2).list();
		Criteria criteria = session.createCriteria(StafferVO.class);
		criteria.add(Restrictions.in("id", ids));
		List<StafferVO> list = criteria.list();
		return list;

	}

	public static List<PayBillVO> findAllByTEN(Long tallyset) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PayBillVO.class);
		criteria.add(Restrictions.in("examined", "N")).add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("tallySetId", tallyset));
		return criteria.list();
	}

	public void ExaminedTongGuo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PayBillVO set examined='Y' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

	public PayBillVO ChaZhaoByPayBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "from PayBillVO where id='" + id + "'";
		return (PayBillVO) session.createQuery(hql).uniqueResult();
	}

	public Object getPayTypeByFeeBillitemBillIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<PayBillVO> list = new ArrayList<PayBillVO>();
		for (Long long1 : ids) {
			list.add(session.get(PayBillVO.class, long1));

		}
		return list;
	}

	/**
	 * @说明：付款记录
	 */
	public List<PayBillVO> getPayBillVOsByReceiveId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PayBillVO.class);
		criteria.add(Restrictions.in("receiverId", id));
		criteria.add(Restrictions.in("enabled", "Y"));
		return criteria.list();
	}

	/**
	 * @说明：
	 */
	public List<PayBillVO> getPayBillByTallIdAndEId(Long tallysetId, long eid) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PayBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallysetId));
		criteria.add(Restrictions.in("receiverId", eid));
		criteria.add(Restrictions.in("enabled", "Y"));
		return criteria.list();
	}
}
