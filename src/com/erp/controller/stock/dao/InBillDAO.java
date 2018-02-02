package com.erp.controller.stock.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.stock.vo.InBillVO;
import com.erp.controller.subcontractCancel.vo.GatherBillVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 入库单 dao
 * @author guo
 *
 */
public class InBillDAO extends BaseDAO<InBillVO>{
	private InBillVO inBill=null;
//	根据条件进行搜索
	public List<InBillVO> findByBillCode(String billCode) {
		try {

			/**
			 * 货物单号	billCode（待确定）	
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<InBillVO> gatherBills =session.createQuery
					("from InBillVO where billCode like ? ").setString(0, "%"+billCode+"%").list();
			session.close();
			return gatherBills;
		}catch (Exception e) {
			return null;
		}	
	}
	
	//	作废单个调拨单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			Query q = session.createQuery("update InBillVO a set a.enabled='N' where a.id = ?").setLong(0, id);
			q.executeUpdate();
			session.getTransaction().commit();
	}
	
	
//	作废全部入库单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update InBillVO set enabled = 'N' ");
	}
}
