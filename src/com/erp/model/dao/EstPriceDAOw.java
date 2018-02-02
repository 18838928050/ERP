package com.erp.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.EstPriceVO;

public class EstPriceDAOw extends BaseDAOw<EstPriceVO> {

	@SuppressWarnings("unchecked")
	public List<EstPriceVO> findAllOderyBySequenceCode() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from EstPriceVO order by id asc");

		return query.list();
	}

	public List<EstPriceVO> getEstPriceList() {
		return findAllOderyBySequenceCode();
	}

	public int getEstPriceSequenceCodeMax() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Object i = session.createQuery(
				"select Max(sequenceCode) from EstPriceVO").uniqueResult();
		System.out.println(i + ".......");
		return (int) i;
	}

	public void DeleteEstPriceVOById(long id) throws Exception {
		delete(id);

	}

	public Query getQuery() {
		Query query = null;
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		query = session.createQuery("From EstPriceVO");
		return query;
	}

}
