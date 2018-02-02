/**
 * 
 */
package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.DeliverBillVO;

/**
 * @author： 如约而至 @time：2017年12月15日 上午10:26:18
 *******************************************************************
 @说明：
 *******************************************************************/
public class DeliverBillDAOw extends BaseDAO<DeliverBillVO> {

	public List<DeliverBillVO> getAllDeliberBills() {

		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(DeliverBillVO.class);
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.addOrder(org.hibernate.criterion.Order.desc("deliverDate"));
		return criteria.list();
	}

	/**
	 * @说明：
	 */
	public DeliverBillVO getByBillCode(String billCode) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		return (DeliverBillVO) session.createQuery(
				"from DeliverBillVO where billCode='" + billCode + "'").uniqueResult();
	}

}
