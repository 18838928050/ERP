package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.controller.stock.vo.OutBillVO;
import com.erp.model.utils.HibernateUtils;

/**
 @author： fu    @time：2017年12月3日 下午2:33:20 
 @说明： 一份耕耘，一份收获
 **/
public class OutbillDaoByfu extends BaseDAO<OutBillVO> {

	/**
	 * @说明：
	 */
	public List<OutBillVO> getOutBillVOS(String productCode) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Long productId=(Long) session.createQuery("select id from ProductVO where productCode='"+productCode+"'").uniqueResult();
		
		
		String hqlString="select billId from OutBillItem where productId='"+productId+"'";
		List<Long> outBillItemIds=session.createQuery(hqlString).list();
		for (Long long1 : outBillItemIds) {
			System.out.println(long1);
		}
		Criteria criteria= session.createCriteria(OutBillVO.class);
		criteria.add(Restrictions.in("id", outBillItemIds));
		return criteria.list();
	}

	@Test
	public void testName() throws Exception {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Long productId=(Long) session.createQuery("select id from ProductVO where productCode='C93-0003'").uniqueResult();
		
		System.out.println("productId:________________________________"+productId);
		
		String hqlString="select billId from OutBillItem where productId='"+productId+"'";
		List<Long> outBillItemIds=session.createQuery(hqlString).list();
		for (Long long1 : outBillItemIds) {
			System.out.println(long1);
		}
		Criteria criteria= session.createCriteria(OutBillVO.class);
		criteria.add(Restrictions.in("id", outBillItemIds));
		System.out.println(criteria.list());
		
	}
	
	
	
}



