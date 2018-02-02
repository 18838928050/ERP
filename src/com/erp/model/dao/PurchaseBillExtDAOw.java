package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillExtVO;

public class PurchaseBillExtDAOw  extends BaseDAOw<PurchaseBillExtVO>{

	public List<PurchaseBillExtVO> findPbesByPbIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(PurchaseBillExtVO.class);
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}


	public PurchaseBillExtVO findPbeByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(PurchaseBillExtVO.class);
		criteria.add(Restrictions.in("id", id));
		return (PurchaseBillExtVO) criteria.uniqueResult();
	}


	/**
	 * @说明：
	 */
	@Test
	public void setCancleByPEBid(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql="update PurchaseBillExtVO set enabled ='N' where id='"+id+"'";
		session.createQuery(hql).executeUpdate();
		session.getTransaction().commit();
	}

}
