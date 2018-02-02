package com.erp.controller.accounts.dao;


import java.util.List;

import org.hibernate.Session;

import com.erp.controller.accounts.vo.AdjustBillVO;
import com.erp.controller.accounts.vo.IncomeBillVO;
import com.erp.controller.accounts.vo.TransferBillVO;
import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.phone.vo.PhoneBookVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 转账取款	 dao
 * @author guo
 *
 */
public class TransferBillDAO extends BaseDAO<TransferBillVO>{

	TransferBillVO transferBill = new TransferBillVO();
	
	//	作废单个转账取款
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			transferBill.setId(id);
			transferBill.setEnabled("Y");
			session.update(transferBill);
	}
//	作废全部转账取款
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update TransferBillVO set enabled = 'N' ");
	}
//	获得所有的激活的数据
	public List<TransferBillVO> findAllEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<TransferBillVO> transferBills = session.createQuery("from TransferBillVO where enabled = 'Y' ").list();
		return transferBills;
	}
	
//	根据条件进行 付款单位 and 单号 and 付款单位
	public List<TransferBillVO> selectTransferBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<TransferBillVO> transferBills =session.createQuery("from TransferBillVO where billCode like '%1%' or payerName like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' ").list();
			return transferBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}