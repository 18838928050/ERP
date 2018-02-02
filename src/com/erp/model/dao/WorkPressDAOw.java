/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.WorkProcessVO;

/**
 * @author fu
 *
 */
public class WorkPressDAOw extends BaseDAOw<WorkProcessVO> {

	/**
	 * @param wpIdsList
	 * @return
	 */
	public List<WorkProcessVO> getWPs(List<Long> wpIdsList) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<WorkProcessVO> workProcessVOs = new ArrayList<WorkProcessVO>();
		for (Long long1 : wpIdsList) {
			workProcessVOs.add((WorkProcessVO) session.createQuery(
					"from WorkProcessVO where id='" + long1 + "' ").uniqueResult());
		}
		// TODO Auto-generated method stub
		return workProcessVOs;
	}
	
	
	/**
	 * 通过 WorkCenter获取
	 * JiaQi
	 */
	public List<WorkProcessVO> getByWC(long WCId,String enable) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<WorkProcessVO> workProcessVOs = new ArrayList<WorkProcessVO>();
		workProcessVOs = session.createQuery("from WorkProcessVO where workCenterId = ? and enabled = ?").setLong(0, WCId).setString(1, enable).list();
		return workProcessVOs;
	}

}
