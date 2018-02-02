package com.erp.controller.accounts.dao;


import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.FeeBillVO;

/**
 * 费用单	 dao
 * @author guo
 *
 */
public class FeeBillDAO extends BaseDAO<FeeBillVO>{

	FeeBillVO feeBill = new FeeBillVO();
	
	//	作废单个费用单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			feeBill.setId(id);
			feeBill.setEnabled("Y");
			session.update(feeBill);
	}
	
	
//	作废全部费用单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update FeeBillVO set enabled = 'N' ");
	}
	
//	获得所有的激活的数据
	public List<FeeBillVO> findAllEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<FeeBillVO> feeBills = session.createQuery("from FeeBillVO where enabled = 'Y' ").list();
		return feeBills;
	}
	
//	根据条件进行 付款单位 and 单号 and 付款单位
	public List<FeeBillVO> selectFeeBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<FeeBillVO> feeBills =session.createQuery("from FeeBillVO where billCode like '%1%' or payerName like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' ").list();
			return feeBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}