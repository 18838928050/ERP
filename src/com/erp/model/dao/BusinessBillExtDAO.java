package com.erp.model.dao;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExt;

/**
 * 账单状态
 * @author JiaQi
 *
 */
public class BusinessBillExtDAO extends BaseDAO<BusinessBillExt>{
	

	/**
	 * guo
	 * @param id
	 * @return	BusinessBillExt中的delivered中的状态码
	 */
	public String getBusinessBillExtDelivered(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		BusinessBillExt businessBillVO = (BusinessBillExt) session.createQuery(
				"from BusinessBillExt where id='" + id + "'").uniqueResult();
		session.close();
		return businessBillVO.getDelivered();
	}
	
}
