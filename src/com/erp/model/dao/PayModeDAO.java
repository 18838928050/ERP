package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PayMode;

/**
 * 
 * 付款方式
 * @author JiaQi
 *
 */
public class PayModeDAO extends BaseDAO<PayMode>{
	/**
	 * 获取全部可用的付款方式
	 */
	public List<PayMode> findAllCanUse(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<PayMode> payModes = session.createQuery("from PayMode where enabled = ?").setString(0, "Y").list();
		session.close();
		return payModes;
	}
}
