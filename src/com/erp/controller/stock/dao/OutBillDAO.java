package com.erp.controller.stock.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.stock.vo.InBillVO;
import com.erp.controller.stock.vo.OutBillVO;
import com.erp.controller.subcontractCancel.vo.GatherBillVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 出库单 dao
 * @author guo
 *
 */
public class OutBillDAO extends BaseDAO<OutBillVO>{
	private OutBillVO outBill=null;
	//	根据条件进行搜索
	public List<OutBillVO> findByBillCode(String billCode) {
		try {
			/**
			 * 货物单号	billCode（待确定）	
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<OutBillVO> outBills =session.createQuery
					("from OutBillVO where billCode like ? ").setString(0, "%"+billCode+"%").list();
			session.close();
			return outBills;
		}catch (Exception e) {
			return null;
		}	
	}

	//	作废单个出库单
	public void updeateEnabled(Long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Query q = session.createQuery("update OutBillVO a set a.enabled='N' where a.id = ?").setLong(0, id);
		q.executeUpdate();
		session.getTransaction().commit();
	}


	//	作废全部出库单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update OutBillVO set enabled = 'N' ");
	}
}