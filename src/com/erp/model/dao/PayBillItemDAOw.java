package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PayBillItemVO;

public class PayBillItemDAOw extends BaseDAOw<PayBillItemVO> {

	public List<PayBillItemVO> getPayBillItemById(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		return session.createQuery("from PayBillItemVO where billId='" + id + "'").list();
	}

}
