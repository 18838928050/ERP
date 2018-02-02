package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillVO;

public class PurchaseDAOw extends BaseDAOw<PurchaseBillVO> {

	public static List<PurchaseBillVO> getPurchaseBillVOsByLimits(long prividerId, long tallyset) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String hql="select id from PurchaseBillExtVO where paied='N' and examined='Y'";
		List<Long> ids=session.createQuery(hql).list();
		
		Criteria criteria=session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("id", ids));
		criteria.add(Restrictions.in("providerId", prividerId));
		criteria.add(Restrictions.in("tallySetId", tallyset));
		return criteria.list();
	}

}
