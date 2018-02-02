/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.PayModeVO;

/**
 @author： 如约而至    @time：2017年9月4日 下午5:18:25 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class PayModeDAOw extends BaseDAOw<PayModeVO>{

	/**
	 * @说明：
	 */
	public List<PayModeVO> getByIds(List<Long> ids) {
		Session session=HibernateUtils.getSession();
		 session.beginTransaction();
		 List<PayModeVO> payModeVOs=new ArrayList<PayModeVO>();
		 for (Long long1 : ids) {
			 payModeVOs.add(session.get(PayModeVO.class, long1));
		 }
		return payModeVOs;
	}

	/**
	 * @说明：
	 */
	public List<PayModeVO> getAll() {
		Session session=HibernateUtils.getSession();
		 session.beginTransaction();
		return session.createQuery("from PayModeVO").list();
	}

}
