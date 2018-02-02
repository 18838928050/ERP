/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.GatherBillVO;

/**
 * @author： 如约而至 @time：2017年9月11日 下午3:06:03
 *******************************************************************
 @说明：
 *******************************************************************/
public class GatherBillDAOw extends BaseDAOw<GatherBillVO> {

	/**
	 * @说明：由多个cooper_bill_id得到多个gather_bill
	 */
	public List<GatherBillVO> getGatherBillByCooperBillIds(List<Long> listCBids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<GatherBillVO> gatherBillVOs = new ArrayList<GatherBillVO>();
		for (Long long1 : listCBids) {
			gatherBillVOs.add((GatherBillVO) session.createQuery(
					"from GatherBillVO where cooperBillId='" + long1 + "'").uniqueResult());
		}
		return gatherBillVOs;
	}

}
