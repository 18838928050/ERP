/**
 * 
 */
package com.erp.model.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AccessoryVO;

/**
 @author： 如约而至    @time：2017年9月14日 下午1:21:21 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class AccessoryDAOw extends BaseDAOw<AccessoryVO>{

	/**
	 * @说明：
	 */
	@SuppressWarnings("unchecked")
	public List<AccessoryVO> getAccessoryByAgaentId(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery("from AccessoryVO where agentId='"+id+"'").list();
	}

	/**
	 * @说明：
	 */
	public List<AccessoryVO> getFujanByEid(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		 Criteria criteria= session.createCriteria(AccessoryVO.class);
		criteria.add(Restrictions.in("id", id));
		return criteria.list();
	}

	/**
	 * @说明：
	 */
	public List<AccessoryVO> getAllAccessByLimit() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		 Criteria criteria= session.createCriteria(AccessoryVO.class);
		 criteria.add(Restrictions.ge("createTime", Date.valueOf("2017-11-01")));//大于等于这个日期
			criteria.add(Restrictions.le("createTime", Date.valueOf("2017-12-02")));//小于等于这个日期【java.sql.Date】
		return criteria.list();
	}

}
