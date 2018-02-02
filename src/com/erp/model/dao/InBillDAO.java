package com.erp.model.dao;

import com.erp.model.vo.InBill;
import java.util.List;
import org.hibernate.Session;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 入库单据
 * @author JiaQi
 *
 */
public class InBillDAO extends BaseDAO<InBill>{
	/**
	 * 根据状态查询InBill表
	 * @param examined
	 * @param enabled
	 * @return
	 * @throws Exception
	 */
	public List<InBill> findByStatus(String examined,String enabled) throws Exception{
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<InBill> list= session.createQuery("FROM InBill where examined=? and enabled=?").setString(0, examined).setString(1, enabled).list();
		session.close();
		return list;
	}
}
