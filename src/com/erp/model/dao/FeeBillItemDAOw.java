package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.FeeBillItemVO;

public class FeeBillItemDAOw extends BaseDAOw<FeeBillItemVO> {

	public List<FeeBillItemVO> getFeeBillItemById(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		return session.createQuery("from FeeBillItemVO where billId='" + id + "'").list();
	}

}
