package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.IncomeBill;

/**
 * 其他收入
 * @author JiaQi
 *
 */
public class InComeBillDAO extends BaseDAO<IncomeBill>{
/**
 * 获取 顶但数量
 * @return
 */
	public List<IncomeBill> findAllCanUse(String date1,String date2) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeBill> list= session.createQuery(
				"FROM IncomeBill where enabled = ?").setString(0, "Y")
				.list();
		session.close();
		return list;
	}
}
