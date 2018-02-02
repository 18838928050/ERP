package com.erp.controller.business.mgr;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.EstablishmentDAO;
import com.erp.model.dao.MakeTypeDAO;
import com.erp.model.dao.PayModeDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Department;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.MakeType;
import com.erp.model.vo.PayMode;
import com.erp.model.vo.Staffer;

/**
 * 客户
 * @author JiaQi
 *
 */
public class BusinessMgr {
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
/**
 * 获取全部客户信息
 */
	public List<Establishment> findAllBusiness() {
		List<Establishment> establishments = null;
		try {
			establishments = establishmentDAO.findAll();
		} catch (Exception e) {
			System.out.println("获取全部客户失败！");
			e.printStackTrace();
		}
		return establishments;
	}
	
	/**
	 * 通过id 获取对应的客户信息
	 */
	public Establishment findById(Long id){
		Establishment establishment = null;
		try {
			establishment = establishmentDAO.getById(id);
		} catch (Exception e) {
			System.out.println("获取客户失败！");
			e.printStackTrace();
		}
		return establishment;
	}
	
	/**
	 * 获取全部部门
	 */
	public List<Department> findAllDepartmentCanUse(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Department> departments = session.createQuery("from Department where enabled = ?").setString(0, "Y").list();
		session.close();
		return departments;
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
	 * 获取可用的支付方式
	 */
	public List<PayMode> findAllCanUsePayMode(){
		PayModeDAO payModeDAO = new PayModeDAO();
		return payModeDAO.findAllCanUse();
	}
	/**
	 * 获取可用的 部门
	 * @return
	 */
	public List<Establishment> findAllCanUse() {
		return establishmentDAO.findAllCanUse();
	}
	/**
	 * huoqu可用制作要求
	 * @return
	 */
	public List<MakeType> findAllCanUserMakeType() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<MakeType> makeTypes = session.createQuery("from MakeType where enabled = ?").setString(0, "Y").list();
		session.close();
		return makeTypes;
	}
}
