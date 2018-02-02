package com.erp.model.dao;

import com.erp.model.vo.OutBill;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.vo.InBill;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 出库单
 * @author JiaQi
 *
 */
public class OutBillDAO extends BaseDAO<OutBill>{
	/**
	 * 根据状态查询OutBill表
	 * @param examined
	 * @param enabled
	 * @return
	 * @throws Exception
	 */
	public List<OutBill> findByStatus(String examined,String enabled) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<OutBill> list= session.createQuery("FROM OutBill where examined=? and enabled=?").setString(0, examined).setString(1, enabled).list();
		session.close();
		return list;
	}

}
