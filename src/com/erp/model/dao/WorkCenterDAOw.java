/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.WorkCenterVO;

/**
 * @author： 如约而至 @time：2017年9月13日 下午7:51:26
 *******************************************************************
 @说明：
 *******************************************************************/
public class WorkCenterDAOw extends BaseDAOw<WorkCenterVO> {

	/**
	 * @说明：
	 */
	public List<WorkCenterVO> getByIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<WorkCenterVO> workCenterVOs = new ArrayList<WorkCenterVO>();
		for (Long long1 : ids) {
			workCenterVOs.add(session.get(WorkCenterVO.class, long1));
		}
		return workCenterVOs;
	}

	/**
	 * @param wcIds
	 * @return
	 */
	public List<WorkCenterVO> getWCs(List<Long> wcIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<WorkCenterVO> workCenterVOs = new ArrayList<>();
		for (Long long1 : wcIds) {
			String hString = "from WorkCenterVO where id='" + long1 + "'";
			workCenterVOs.add((WorkCenterVO) session.createQuery(hString).uniqueResult());
		}

		return workCenterVOs;
	}
}
