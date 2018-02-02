package com.erp.controller.finance.mgr;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BankAccountDAO;
import com.erp.model.dao.DepartmentDAO;
import com.erp.model.dao.EstablishmentDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccount;
import com.erp.model.vo.Department;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.ReceiveBill;
import com.erp.model.vo.Staffer;

/**
 * 收款单   mgr
 * @author JiaQi
 *
 */
public class ReceiveBillMgr {
	
	/**
	 * 获取全部可用的银行账号
	 */
	public List<BankAccount> findAllBankAccount(){
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		return bankAccountDAO.findAllBankAccount();
	}
	
	/**
	 * 获取全部员工
	 */
	public List<Staffer> findAllStafferCanUse(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Staffer> staffers = session.createQuery("from Staffer where enabled = ?").setString(0, "Y").list();
		session.close();
		return staffers;
	}
	
	/**
	 * 获取全部可用部门
	 */
	public List<Department> findAllDepatment(){
		DepartmentDAO departmentDAO = new DepartmentDAO();
		return departmentDAO.findAllDepartment();
	}
	
	/**
	 * 获取全部可用客户
	 */
	public List<Establishment> findAllEstablishment(){
		EstablishmentDAO establishmentDAO = new EstablishmentDAO();
		return establishmentDAO.findAllCanUse();
	}

	/**
	 * 获取未审核
	 */
	public List<ReceiveBill> findUnExmin() {
		
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<ReceiveBill> receiveBills = session.createQuery("from ReceiveBill where enabled = ? and examined = ?").setString(0, "Y").setString(1, "N").list();
		session.close();
		
		return receiveBills;
	}

	/**
	 * 制定审核
	 * @param id
	 */
	public void receiveBillExmin(ReceiveBill receiveBill) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update(receiveBill);
		session.getTransaction().commit();
	}

	/**
	 * 通过id获取 ReceiveBill
	 * @param id
	 * @return
	 */
	public ReceiveBill findReceiveBillById(long id) {
		
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		ReceiveBill receiveBill = (ReceiveBill)session.createQuery("from ReceiveBill where id = ?").setLong(0, id).uniqueResult();
		session.close();
		return receiveBill;
	}

	/**
	 * 获取审核
	 */
	public List<ReceiveBill> findExmin() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<ReceiveBill> receiveBills = session.createQuery("from ReceiveBill where enabled = ? and examined = ?").setString(0, "Y").setString(1, "Y").list();
		session.close();
		return receiveBills;
	}

	/**
	 * 获取全部
	 * @return
	 */
	public List<ReceiveBill> findAllReceive() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<ReceiveBill> receiveBills = session.createQuery("from ReceiveBill where enabled = ?").setString(0, "Y").list();
		session.close();
		return receiveBills;
	}
}
