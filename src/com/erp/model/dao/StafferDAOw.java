/**@author fu 
 * @说明：
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.StafferVO;

/**
 * @author fu
 *
 */
public class StafferDAOw extends BaseDAOw<StafferVO> {

	/**
	 * @param listStafferIds
	 * @return
	 */
	public List<List<StafferVO>> getStafferNameByCreaterIds(List<Long> listStafferIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<StafferVO>> s = new ArrayList<List<StafferVO>>();

		for (long long1 : listStafferIds) {
			s.add(session.createQuery("from StafferVO where id='" + long1 + "'").list());
		}
		return s;
	}
}
