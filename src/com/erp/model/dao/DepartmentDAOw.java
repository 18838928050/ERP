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
import com.erp.model.vo.DepartmentVO;

/**
 * @author： 如约而至 @time：2017年9月4日 下午10:15:40
 *******************************************************************
 @说明：
 *******************************************************************/
@SuppressWarnings("unchecked")
public class DepartmentDAOw extends BaseDAOw<DepartmentVO> {

	/**
	 * @说明：
	 */
	public List<DepartmentVO> getAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery("from DepartmentVO").list();
	}

	public DepartmentVO getDepartmentsByDepatementId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(DepartmentVO.class);
		criteria.add(Restrictions.in("id", id));
		return (DepartmentVO) criteria.uniqueResult();
	}

}
