package com.erp.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.opensymphony.xwork2.ActionContext;

public class PurchaseBillItemDAOw extends BaseDAOw<PurchaseBillItemVO> {

	public List<List<ProductVO>> findProductVOssByPBids(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<ProductVO>> pLists = new ArrayList<List<ProductVO>>();
		List<ProductVO> productVOs = new ArrayList<ProductVO>();
		for (long long1 : ids) {
			productVOs = session.createQuery("from ProductVO where id='" + long1 + "'").list();
			pLists.add(productVOs);
		}
		return pLists;
	}

	public List<List<PurchaseBillItemVO>> findPBIss(List<Long> iList) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<PurchaseBillItemVO> purchaseBillItemVOs = new ArrayList<PurchaseBillItemVO>();
		List<List<PurchaseBillItemVO>> pList = new ArrayList<List<PurchaseBillItemVO>>();
		for (long long1 : iList) {
			purchaseBillItemVOs = session.createQuery(
					"from PurchaseBillItemVO where billId='" + long1 + "'").list();
			pList.add(purchaseBillItemVOs);
		}
		return pList;
	}

	public List<List<PurchaseBillItemVO>> findPBIss2(List<PurchaseBillVO> purchaseBillVOs) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> PbiBILLIds = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			PbiBILLIds.add(purchaseBillVO.getId());
		}
		List<Long> pbiIds = new ArrayList<Long>();

		List<List<Long>> pbiIdss = new ArrayList<List<Long>>();
		for (Long long1 : PbiBILLIds) {
			pbiIds = session.createQuery(
					"select id from PurchaseBillItemVO where billId='" + long1 + "'").list();
			pbiIdss.add(pbiIds);
		}

		List<PurchaseBillItemVO> purchaseBillItemVOs = new ArrayList<PurchaseBillItemVO>();
		List<List<PurchaseBillItemVO>> purchaseBillItemVOss = new ArrayList<List<PurchaseBillItemVO>>();
		for (List<Long> long1 : pbiIdss) {
			for (Long long2 : long1) {
				purchaseBillItemVOs = session.createQuery(
						"from PurchaseBillItemVO where id='" + long2 + "'").list();
				purchaseBillItemVOss.add(purchaseBillItemVOs);
			}
		}
		return purchaseBillItemVOss;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query query = (Query) session
				.createSQLQuery(
						"SELECT purchase_bill.id purchase_bill.bill_code,00purchase_bill.bill_type purchase_bill_item.amount purchase_bill_item.unit_price purchase_bill_item.cost FROM purchase_bill,purchase_bill_item,purchase_bill_ext WHERE purchase_bill.tally_set_id = 2 AND purchase_bill_item.bill_id IN (select id from purchase_bill where tally_set_id=2l")
				.list();
		System.out.println(query);

	}

	/**
	 * @说明：
	 */
	@SuppressWarnings("unchecked")
	public List<List<PurchaseBillItemVO>> getPurchaseBillItemVOsByBillIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		List<List<PurchaseBillItemVO>> ls = new ArrayList<List<PurchaseBillItemVO>>();
		for (Long long1 : ids) {
			ls.add(session.createQuery("from PurchaseBillItemVO where billId='" + long1 + "'")
					.list());
		}

		return ls;
	}

	/**
	 * @说明：
	 */
	public List<PurchaseBillItemVO> getgetPBIByBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PurchaseBillItemVO.class);
		criteria.add(Restrictions.in("billId", id));
		// 在这里计算合计PBI.cost
		List<PurchaseBillItemVO> ss = criteria.list();
		BigDecimal bigDecimal = new BigDecimal(0);
		for (PurchaseBillItemVO purchaseBillItemVO : ss) {
			bigDecimal = bigDecimal.add(purchaseBillItemVO.getCost());
		}
		// 采购单作废中 查看 --》 金额合计
		ActionContext.getContext().put("allcost", bigDecimal);
		return criteria.list();
	}

}
