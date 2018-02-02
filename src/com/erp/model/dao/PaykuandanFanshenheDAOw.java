package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PayBillVO;

public class PaykuandanFanshenheDAOw extends BaseDAOw<PayBillDaow> {

	public List<PayBillVO> findAllByTEN(Long tallyset) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PayBillVO.class);
		criteria.add(Restrictions.in("examined", "Y")).add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("tallySetId", tallyset));
		return criteria.list();

	}

	public void ExaminedTongGuo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PayBillVO set examined='N' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

	public PayBillVO ChaZhaoByPayBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "from PayBillVO where id='" + id + "'";
		return (PayBillVO) session.createQuery(hql).uniqueResult();
	}
}