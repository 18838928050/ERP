package com.erp.controller.subcontractCancel.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.GatherBillVO;

/**
 * 收货单 dao
 * @author guo
 *
 */
public class GatherBillDAO extends BaseDAO<GatherBillVO>{
	private GatherBillVO gatherBillVO=null;
	//	根据条件进行搜索
	public List<GatherBillVO> findByBillCode(String billCode) {
		try {

			/**
			 * 货物单号	billCode（待确定）	
			 * 账套	TallySetVO类  
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<GatherBillVO> gatherBills =session.createQuery
					("from GatherBillVO where billCode like ? ").setString(0, "%"+billCode+"%").list();
			session.close();
			return gatherBills;
		}catch (Exception e) {
			return null;
		}	
	}
	
	//	作废单个外协单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			gatherBillVO.setId(id);
			gatherBillVO.setEnabled("Y");
			session.update(gatherBillVO);
	}
	
	
//	作废全部外协单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update GatherBillVO set enabled = 'N' ");
	}
}
