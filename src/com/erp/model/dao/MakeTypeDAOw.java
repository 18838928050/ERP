/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.MakeTypeVO;

/**
 * @author： 如约而至 @time：2017年9月4日 下午3:54:13
 *******************************************************************
 @说明：
 *******************************************************************/
public class MakeTypeDAOw extends BaseDAOw<MakeTypeVO> {

	/**
	 * @说明：由多个id 获得多个maketype
	 */
	public List<MakeTypeVO> getMakeTypeByIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		List<MakeTypeVO> makeTypeVOs = new ArrayList<MakeTypeVO>();
		for (Long long1 : ids) {
			makeTypeVOs.add(session.get(MakeTypeVO.class, long1));
		}
		return makeTypeVOs;
	}

	/**
	 * @param opIds
	 * @return
	 */
	public List<MakeTypeVO> getMT(List<Long> mtIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<MakeTypeVO> makeTypeVOs = new ArrayList<>();
		for (Long long1 : mtIds) {
			makeTypeVOs.add((MakeTypeVO) session.createQuery(
					"from MakeTypeVO where id='" + long1 + "'").uniqueResult());
		}
		return makeTypeVOs;

	}

}
