package com.erp.controller.stock.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.erp.controller.customerBusiness.vo.AreaVO;
import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.subcontractCancel.vo.GatherBillVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 调拨单 dao
 * @author guo
 *
 */
public class AlloBillDAO extends BaseDAO<AlloBillVO>{
	private AlloBillVO alloBill=new AlloBillVO();
//	根据条件进行搜索
	public List<AlloBillVO> findByBillCode(String billCode) {
		try {
			/**
			 * 货物单号	billCode（待确定）	
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<AlloBillVO> alloBills =session.createQuery
					("from AlloBillVO where billCode like ? ").setString(0, "%"+billCode+"%").list();
			session.close();
			return alloBills;
		}catch (Exception e) {
			return null;
		}	
	}
	
	//	作废单个调拨单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			Query q = session.createQuery("update AlloBillVO a set a.enabled='N' where a.id = ?").setLong(0, id);
			q.executeUpdate();
			session.getTransaction().commit();
	}
	

	
	
//	作废全部调拨单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update AlloBillVO set enabled = 'N' ");
	}
}
