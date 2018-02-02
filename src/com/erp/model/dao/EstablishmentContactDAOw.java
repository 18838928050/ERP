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
import com.erp.model.vo.EstablishmentContactVO;

/**
 * @author： 如约而至 @time：2017年10月7日 下午3:06:11
 *******************************************************************
 @说明：
 *******************************************************************/
public class EstablishmentContactDAOw extends BaseDAOw<EstablishmentContactVO> {

	/**
	 * @说明：
	 */
	public List<EstablishmentContactVO> getEstabliContactVosByEstId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session
				.createCriteria(EstablishmentContactVO.class);
		criteria.add(Restrictions.in("estId", id));
		return criteria.list();
	}

	/**
	 * @说明：
	 */

	public void editSaveEstablistmentContactVos(
			List<EstablishmentContactVO> eeee) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		for (EstablishmentContactVO e : eeee) {
			String hql = "UPDATE EstablishmentContactVO "
					+ "	SET  contact_name = '" + e.getContactName()
					+ "',sex = '" + e.getSex() + "' , est_id = '"
					+ e.getEstId() + "', possie = '" + e.getPossie()
					+ "', mobile ='" + e.getMobile() + "', email = '"
					+ e.getEmail() + "',phone = '" + e.getPhone() + "', im = '" + e.getIm() + "',mark ='" + e.getMark() + "', is_main = '" + e.getIsMain() + 
					"', tmp_code ='" + e.getTmpCode() + "' WHERE id = '" + e.getId() + "'";
			session.createQuery(hql).executeUpdate();
		}
		session.getTransaction().commit();

	}


}
