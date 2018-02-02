/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CooperBillItemVO;

/**
 * @author： 如约而至 @time：2017年9月4日 下午4:00:38
 *******************************************************************
 @说明：
 *******************************************************************/
public class CooperBillItemDAOw extends BaseDAOw<CooperBillItemVO> {

	private static final String CooperBillItemVO = null;

	/**
	 * @说明：
	 */
	public List<CooperBillItemVO> getCooperBillItemByCooperBillId(long billid) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<CooperBillItemVO> cooperBillItemVOs = session.createQuery(
				"from CooperBillItemVO where billId='" + billid + "'").list();
		session.close();
		return cooperBillItemVOs;
	}

	/**
	 * @param l
	 * @说明：
	 */
	public void isCheckOrNo(Integer isCheckOrNo, long l) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// 将字段改为Y
		if (isCheckOrNo == 1) {
			String hql = "update CooperBillExtVO set examined='Y' where id='" + l + "'";
			Query queryup = session.createQuery(hql);
			int re = queryup.executeUpdate();
			session.getTransaction().commit();
		} else {
			String hql = "update CooperBillExtVO set examined='N' where id='" + l + "'";
			Query queryup = session.createQuery(hql);
			int re = queryup.executeUpdate();
			session.getTransaction().commit();

		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "update CooperBillExtVO set examined='Y' where id=1";
		Query queryup = session.createQuery(hql);
		int re = queryup.executeUpdate();
		session.getTransaction().commit();
		// CooperBillExtVO cooperBillExtVO=(CooperBillExtVO)
		// sqlQuery.addEntity(CooperBillExtVO.class);
	}

	/**
	 * @说明：由CooperBillItemVO中的bbCode获得当前一行记录
	 */
	public List<CooperBillItemVO> getCooperBillItemByBbCode(String bbCode) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<CooperBillItemVO> cooperBillItemVOs = session.createQuery(
				"from CooperBillItemVO where bbCode='" + bbCode + "'").list();
		return cooperBillItemVOs;
	}

	/**
	 * @说明：由多个Bill_id得到多个CBI
	 */
	public List<List<CooperBillItemVO>> getCooperBillItemByBillIDs(List<Long> listCBids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<CooperBillItemVO>> c = new ArrayList<List<CooperBillItemVO>>();
		List<CooperBillItemVO> cooperBillItemVOs = null;
		for (Long long1 : listCBids) {
			cooperBillItemVOs = session.createQuery(
					"from CooperBillItemVO where billId='" + long1 + "'").list();
			c.add(cooperBillItemVOs);
		}
		return c;
	}

	

}
