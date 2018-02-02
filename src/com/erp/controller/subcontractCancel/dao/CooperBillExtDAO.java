package com.erp.controller.subcontractCancel.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.controller.subcontractCancel.vo.CooperBillExtVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 外协单状态 dao
 * @author guo
 *
 */
public class CooperBillExtDAO extends BaseDAO<CooperBillExtVO>{
	
	
private CooperBillExtVO cooperBillExtVO;


	//	作废单个外协单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			cooperBillExtVO.setId(id);
			cooperBillExtVO.setEnabled("Y");
			session.update(cooperBillExtVO);
	}
	
	
//	作废全部外协单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update CooperBillExtVO set enabled = 'N' ");
	}
	
}