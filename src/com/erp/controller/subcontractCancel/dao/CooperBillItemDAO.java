package com.erp.controller.subcontractCancel.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CooperBillItemVO;

public class CooperBillItemDAO extends BaseDAO<CooperBillItemVO>{
	/**
	 * 通过  外泄但 ID 获取明细
	 */
	public List<CooperBillItemVO> findByCopperBillId(long id){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<CooperBillItemVO> list= session.createQuery("from CooperBillItemVO where billId = ?").setLong(0, id)
				.list();
		session.close();
		return list;
	}
}
