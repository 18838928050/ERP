/**
 * 
 */
package com.erp.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AdjustBillVO;

/**
 @author： 如约而至    @time：2017年9月20日 下午6:28:25 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class AdjustBillDAOw extends BaseDAOw<AdjustBillVO>{

	/**
	 * @说明：
	 */
	public List<AdjustBillVO> getAdjustBillVOsByClientId(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(AdjustBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("clientId", id));
		List<AdjustBillVO> adjustBillVOs=criteria.list();
		for (AdjustBillVO adjustBillVO : adjustBillVOs) {
			System.out.println(adjustBillVO);
		}		
		
		return criteria.list();
	}

	/**
	 * @说明：
	 */
	public List<AdjustBillVO> getAdjustBiByTallIdAndEId(Long tallysetId, long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(AdjustBillVO.class);
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("clientId", id));
		criteria.add(Restrictions.in("tallySetId", tallysetId));
		return criteria.list();
	}


}
