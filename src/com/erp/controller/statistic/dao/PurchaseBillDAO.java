package com.erp.controller.statistic.dao;


import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillVO;

/**
 *采购单 dao
 * @author guo
 *
 */
public class PurchaseBillDAO extends BaseDAO<PurchaseBillVO>{
	
	public List<PurchaseBillVO> findAllPurchaseBill() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<PurchaseBillVO> purchaseBills =  session.createQuery("from PurchaseBillVO").list();
			session.close();
			return purchaseBills;
		}catch (Exception e) {
			return null;
		}	
	}		
}
