package com.erp.controller.accounts.dao;


import java.util.List;

import org.hibernate.Session;

import com.erp.controller.accounts.vo.AdjustBillVO;
import com.erp.controller.accounts.vo.IncomeBillVO;
import com.erp.controller.accounts.vo.LoanBillVO;
import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.phone.vo.PhoneBookVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 资金借入出	 dao
 * @author guo
 *
 */
public class LoanBillDAO extends BaseDAO<LoanBillVO>{

	LoanBillVO loanBill = new LoanBillVO();
	
	//	作废单个资金借入出
	public void updeateInEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			loanBill.setId(id);
			loanBill.setEnabled("Y");
			session.update(loanBill);
	}
	//	作废单个资金借入出
	public void updeateOutEnabled(Long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		loanBill.setId(id);
		loanBill.setEnabled("Y");
		session.update(loanBill);
	}
	
//	作废全部资金借入
	public void updeateInEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update LoanBillVO set enabled = 'N'  and billType ='IN' ");
	}
//	作废全部资金借出
	public void updeateOutEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update LoanBillVO set enabled = 'N'  and billType ='OUT' ");
	}
//	获得所有的激活的数据金借入
	public List<LoanBillVO> findAllInEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<LoanBillVO> loanBills = session.createQuery("from LoanBillVO where enabled = 'Y' and billType ='IN' ").list();
		return loanBills;
	}
//	获得所有的激活的数据金借出
	public List<LoanBillVO> findAllOutEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<LoanBillVO> loanBills = session.createQuery("from LoanBillVO where enabled = 'Y' and billType ='OUT' ").list();
		return loanBills;
	}
	
//	根据条件进行 付款单位 and 单号 and 付款单位 借入
	public List<LoanBillVO> selectInLoanBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<LoanBillVO> loanBills =session.createQuery("from LoanBillVO where billCode like '%1%' or payerName like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' and billType ='IN'").list();
			return loanBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	根据条件进行 付款单位 and 单号 and 付款单位 借出
	public List<LoanBillVO> selectOutLoanBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<LoanBillVO> loanBills =session.createQuery("from LoanBillVO where billCode like '%1%' or payerName like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' and billType ='OUT' ").list();
			return loanBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}