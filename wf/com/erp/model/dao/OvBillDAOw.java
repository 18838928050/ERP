package com.erp.model.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.OvBillVO;

public class OvBillDAOw extends BaseDAOw<OvBillVO>{

	public List<OvBillVO> getShenheUI() {
		Session session=HibernateUtils.getSession();
		String hql="from OvBillVO where examined='N' and enabled='Y'";
		return session.createQuery(hql).list();
	}

	public void shenhe(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String slq="update OvBillVO set examined='Y' where id="+id+"";
		session.createQuery(slq).executeUpdate();
		session.getTransaction().commit();
		
	}
	


	public List<OvBillVO> getFanshenheUI() {
		Session session=HibernateUtils.getSession();
		String hql="from OvBillVO where examined='Y' and enabled='Y'";
		return session.createQuery(hql).list();
		
	}

	public void fanshenhe(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String slq="update OvBillVO set examined='N' where id="+id+"";
		session.createQuery(slq).executeUpdate();
		session.getTransaction().commit();
		
	}

	public List<OvBillVO> yilanbiaoui() {
		Session session=HibernateUtils.getSession();
		String hql="from OvBillVO where enabled='Y'";
		return session.createQuery(hql).list();
		
	}

}
