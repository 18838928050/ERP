/**
 * 
 */
package com.erp.model.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.EstablishmentVO;

/**
 * @author：fu
 * @date 2017年12月20日 下午7:39:51 一份耕耘，一份收获*****
 */
public class YewuduizhangDaoo extends BaseDAO<EstablishmentVO> {

	/**
	 * 
	 */
	public SQLQuery findAlll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "select * from establishment e where e.enabled = 'Y' AND e.est_code LIKE 'F_%' ";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(EstablishmentVO.class);
		return query;
	}

}
