/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.OutputVO;

/**
 * @author fu
 *
 */
public class OutPutDAOw extends BaseDAOw<OutputVO> {

	/**
	 * @param bbiIds
	 * @return
	 */
	public List<OutputVO> getOp(List<Long> opItemIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<OutputVO> outputVOs = new ArrayList<>();
		List<List<Long>> opIdss = new ArrayList<>();

		for (Long long1 : opItemIds) {
			String hString = " select id from OutputVO where bbItemId='" + long1 + "'";
			opIdss.add(session.createQuery(hString).list());

		}
		for (List<Long> list : opIdss) {
			for (Long long1 : list) {
				String hqlString = "from OutputVO where id='" + long1 + "'";
				outputVOs.add((OutputVO) session.createQuery(hqlString).uniqueResult());
			}

		}
		return outputVOs;
	}

	/**
	 * @param businessBillItemVO
	 * @return
	 */
	public List<List<OutputVO>> getOp(BusinessBillItemVO businessBillItemVO) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> bbiIds = new ArrayList<>();
		List<List<OutputVO>> outputVOss = new ArrayList<>();
		System.out.println(businessBillItemVO.getBillId());
		bbiIds.addAll(session.createQuery(
				"select id from BusinessBillItemVO where billId='" + businessBillItemVO.getBillId()
						+ "'").list());
		System.out.println(bbiIds);
		for (Long long1 : bbiIds) {
			outputVOss.add(session.createQuery("from OutputVO where bbItemId='" + long1 + "' ")
					.list());

		}

		System.out.println(outputVOss);
		return outputVOss;
	}
}
