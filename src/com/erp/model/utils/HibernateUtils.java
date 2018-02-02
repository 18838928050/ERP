package com.erp.model.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	//为什么单独抽取一个utils类？因为要把sessionFactory和session作为单例对象.
	//否则session和sessionFactory是重量型对象，多例非常耗内存。
	private static SessionFactory sessionFactory;

	public static Session getSession() {
//		return getSessionFactory().getCurrentSession();
		return getSessionFactory().openSession();
		
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null || sessionFactory.isClosed()) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
}
