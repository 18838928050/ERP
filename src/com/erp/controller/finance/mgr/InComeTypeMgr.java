package com.erp.controller.finance.mgr;
/**
 * 其他收入类型
 * @author JiaQi
 *
 */

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BankAccountDAO;
import com.erp.model.dao.InComeBillDAO;
import com.erp.model.dao.InComeTypeDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccount;
import com.erp.model.vo.IncomeBill;
import com.erp.model.vo.IncomeType;
import com.erp.model.vo.ReceiveBill;
import com.erp.model.vo.Staffer;

public class InComeTypeMgr {
	private InComeTypeDAO inComeTypeDAO = new InComeTypeDAO();
	
	/**
	 * 获取全部可用
	 */
	public List<IncomeType> findAllUseInComeType(){
		return inComeTypeDAO.findAllUseInComeType();
	}
	
	
	/**
	 * 获取可用银行账户
	 */
	public List<BankAccount> findAllUseBankAccount(){
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		return bankAccountDAO.findAllBankAccount();
	}


	public void save(IncomeBill model) {
		InComeBillDAO inComeBillDAO = new InComeBillDAO();
		try {
			inComeBillDAO.save(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取未审核
	 */
	public List<IncomeBill> findAllUnExam(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeBill> incomeBills = session.createQuery("from IncomeBill where enabled = ? and examined = ?").setString(0, "Y").setString(1, "N").list();
		session.close();
		return incomeBills;
	}

	/**
	 * 获取审核
	 */
	public List<IncomeBill> findAllExam(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeBill> incomeBills = session.createQuery("from IncomeBill where enabled = ? and examined = ?").setString(0, "Y").setString(1, "Y").list();
		session.close();
		return incomeBills;
	}

	public IncomeBill findInComeBillById(long id) {
		InComeBillDAO inComeBillDAO = new InComeBillDAO();
		IncomeBill incomeBill = new IncomeBill();
		try {
			incomeBill = inComeBillDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return incomeBill;
	}

/**
 * 审核通过
 * @param incomeBill
 */
	public void inComeBillExmin(IncomeBill incomeBill) {
		InComeBillDAO inComeBillDAO = new InComeBillDAO();
		try {
			inComeBillDAO.update(incomeBill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取全部可用
	 */
	public List<IncomeBill> findAllCanUseInComeBill() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeBill> incomeBills = session.createQuery("from IncomeBill where enabled = ?").setString(0, "Y").list();
		session.close();
		return incomeBills;
	}
	
}
