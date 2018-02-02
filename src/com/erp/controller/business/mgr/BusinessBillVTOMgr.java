package com.erp.controller.business.mgr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;

import com.erp.controller.vto.BusinessBillVTO;
import com.erp.model.dao.BusinessBillDAO;
import com.erp.model.dao.BusinessBillExtDAO;
import com.erp.model.dao.BusinessBillItemDAO;
import com.erp.model.dao.EstablishmentDAO;
import com.erp.model.dao.MakeTypeDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBill;
import com.erp.model.vo.BusinessBillExt;
import com.erp.model.vo.BusinessBillItem;
import com.erp.model.vo.MakeType;
import com.erp.util.IDTools;

/**
 * 客户业务单
 * @author JiaQi
 *
 */
public class BusinessBillVTOMgr {
	private BusinessBillDAO bussinessBillDAO = new BusinessBillDAO();
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	private BusinessBillExtDAO businessBillExtDAO = new BusinessBillExtDAO();
//	支付形式
	/**
	 * 获取全部 信息
	 */
	public List<BusinessBillVTO> findAll(){
		List<BusinessBillVTO> businessBillVTOs = new ArrayList<BusinessBillVTO>();
		List<BusinessBill> businessBills = null;
		try {
			businessBills = bussinessBillDAO.findAll();
			for (int i = 0; i < businessBills.size(); i++) {
				BusinessBillVTO businessBillVTO = new BusinessBillVTO();
				businessBillVTO.setBusinessBill(businessBills.get(i));
				businessBillVTO.setEstablishment(establishmentDAO.getById(businessBills.get(i).getClientId()));
				businessBillVTO.setBusinessBillExt(businessBillExtDAO.getById(businessBills.get(i).getId()));
				businessBillVTOs.add(businessBillVTO);
			}
		} catch (Exception e) {
			System.out.println("获取全部业务单失败！");
			e.printStackTrace();
		}
		return businessBillVTOs;
	}
	
	/**
	 * 获取全部制作要求
	 */
	public List<MakeType> findAllCanUserMakeType(){
		
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<MakeType> makeTypes = session.createQuery("from MakeType where enabled = ?").setString(0, "Y").list();
		session.close();
		return  makeTypes;
	}

	//保存   开单信息
	public void save(BusinessBillVTO businessBillVTO) {
		try {
			System.out.println(IDTools.GetUUID());
//			放置ID
//			businessBillVTO.getBusinessBill().setId(IDTools.GetUUID());
			bussinessBillDAO.save(businessBillVTO.getBusinessBill());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void saveLength(List<BusinessBillItem> length) {
		BusinessBillItemDAO businessBillItemDAO = new BusinessBillItemDAO();
		for (int i = 0; i < length.size(); i++) {
			try {
				businessBillItemDAO.save(length.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 保存状态信息
	 */
	public void saveBusinessBillExt(BusinessBillExt businessBillExt){
		try {
			businessBillExtDAO.save(businessBillExt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取未审核
	 * @return
	 */
	public List<BusinessBillVTO> findNoExaminer() {
		List<BusinessBillVTO> businessBillVTOs = new ArrayList<BusinessBillVTO>();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillExt> businessBillExts = session.createQuery("from BusinessBillExt where examined = ? and enabled = ?").setString(0,"N").setString(1, "Y").list();
		session.close();
		
//		获取全部
		for (int i = 0; i < businessBillExts.size(); i++) {
			BusinessBillVTO businessBillVTO = new BusinessBillVTO();
			try {
				businessBillVTO.setBusinessBill(bussinessBillDAO.getById(businessBillExts.get(i).getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			businessBillVTO.setBusinessBillExt(businessBillExts.get(i));
			businessBillVTOs.add(businessBillVTO);
		}
		
		return businessBillVTOs;
	}
	
	/**
	 * 获取审核
	 * @return
	 */
	public List<BusinessBillVTO> findExaminer() {
		List<BusinessBillVTO> businessBillVTOs = new ArrayList<BusinessBillVTO>();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillExt> businessBillExts = session.createQuery("from BusinessBillExt where examined = ? and enabled = ?").setString(0,"Y").setString(1, "Y").list();
		session.close();
		
//		获取全部
		for (int i = 0; i < businessBillExts.size(); i++) {
			BusinessBillVTO businessBillVTO = new BusinessBillVTO();
			try {
				businessBillVTO.setBusinessBill(bussinessBillDAO.getById(businessBillExts.get(i).getId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			businessBillVTO.setBusinessBillExt(businessBillExts.get(i));
			businessBillVTOs.add(businessBillVTO);
		}
		
		return businessBillVTOs;
	}
	
	/**
	 * 通过id获取BusinessBillExt
	 * @param id
	 */
	public BusinessBillExt findBusinessBillExt(long id) {
		BusinessBillExt businessBillExt = null;
		try {
			businessBillExt = businessBillExtDAO.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return businessBillExt;
	}

	/**
	 * 更新
	 * @param businessBillExt
	 */
	public void updateBusinessBillExt(BusinessBillExt businessBillExt) {
		try {
			businessBillExtDAO.update(businessBillExt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
