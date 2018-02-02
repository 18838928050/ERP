package com.erp.controller.accounts.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PayBillVO;

/**
 * 费用单	 dao
 * @author guo
 *
 */
public class PayBillDAO extends BaseDAO<PayBillVO>{

	PayBillVO payBill = new PayBillVO();
	
	//	作废单个付款单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			payBill.setId(id);
			payBill.setEnabled("Y");
			session.update(payBill);
	}
//	作废全部付款单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update PayBillVO set enabled = 'N' ");
	}
//	获得所有的激活的数据
	public List<PayBillVO> findAllEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<PayBillVO> payBills = session.createQuery("from PayBillVO where enabled = 'Y' ").list();
		return payBills;
	}
	
//	根据条件进行 付款单位 and 单号 and 付款单位
	public List<PayBillVO> selectPayBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<PayBillVO> payBills =session.createQuery("from PayBillVO where billCode like '%1%' and r.tallySetId= 2  and r.enabled = 'Y' ").list();
			return payBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}