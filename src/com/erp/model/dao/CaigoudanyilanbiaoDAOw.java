package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillVO;

public class CaigoudanyilanbiaoDAOw extends BaseDAOw<PurchaseBillVO> {

	public List findaAll(long tallySetId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String hql="select id from PurchaseBillExtVO where enabled='Y'";
	List< Long> ids=session.createQuery(hql).list();
	System.out.println(ids);
		Criteria criteria=session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
	criteria.add(Restrictions.in("id", ids));
		criteria.add(Restrictions.like("billCode","N%" ));
		return criteria.list();
	}

	public List findtuiAll(long tallySetId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String hql="select id from PurchaseBillExtVO where enabled='Y'";
	List< Long> ids=session.createQuery(hql).list();
	System.out.println(ids);
		Criteria criteria=session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
	criteria.add(Restrictions.in("id", ids));
		criteria.add(Restrictions.like("billCode","O%" ));
		return criteria.list();
	}
	
}
