/**
 * 
 */
package com.erp.model.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillVO;

/**
 * @author： 如约而至 @time：2017年9月7日 上午9:22:18
 *******************************************************************
 @说明：
 *******************************************************************/
public class CopyOfBusinessBillDAOw extends BaseDAOw<BusinessBillVO> {

	/**
	 * @说明：由BusinessBillVO中的billCode获得当前一行数据
	 */
	public BusinessBillVO getBusinessBillByBillCode(String billCode) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		BusinessBillVO businessBillVO = (BusinessBillVO) session.createQuery(
				"from BusinessBillVO where billCode='" + billCode + "'")
				.uniqueResult();
		session.close();

		return businessBillVO;
	}

	/**
	 * @说明：手动设置条件
	 */
	public List<BusinessBillVO> getBusinessBillsByLimit() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		// 选出BBE中enabled为N的记录的id，由于BB.id=BBE.id,然后 在BB中不包含这些记录
		Collection<Long> getBBEIdsAsEnabledIsN = new ArrayList<Long>();
		Query sqlQuery = session
				.createQuery("select b.id from BusinessBillExtVO as b where b.enabled='n'");
		// 查出所有enabled为N的记录的Ids
		getBBEIdsAsEnabledIsN = sqlQuery.list();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(BusinessBillVO.class);

		criteria.add(Restrictions.ge("checkDate", Date.valueOf("2017-08-01")));
		criteria.add(Restrictions.le("checkDate", Date.valueOf("2017-08-03")));
		criteria.add(Restrictions.not(Restrictions.in("id",
				getBBEIdsAsEnabledIsN)));
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.addOrder(Order.desc("orderDate"));

		List<BusinessBillVO> businessBillVOs = criteria.list();
		return businessBillVOs;
	}

	// 查询测试汇总
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		criteria.add(Restrictions.ge("checkDate", Date.valueOf("2017-08-01")));
		criteria.add(Restrictions.le("checkDate", Date.valueOf("2017-08-03")));

	}

}
