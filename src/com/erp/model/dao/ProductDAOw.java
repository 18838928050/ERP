package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ProductVO;

public class ProductDAOw extends BaseDAOw<ProductVO> {

	public List<ProductVO> findProductByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		String hql1 = "select productId from PurchaseBillItemVO where billId='" + id + "'";
		List<Long> id1s = session.createQuery(hql1).list();
		Criteria criteria = session.createCriteria(ProductVO.class);
		criteria.add(Restrictions.in("id", id1s));
		return criteria.list();
	}

	public List<List<ProductVO>> findProductVOssByPbIIds(List<Long> billids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> zhuanzheids = new ArrayList<Long>();
		List<List<Long>> productIds = new ArrayList<List<Long>>();
		for (Long long1 : billids) {
			zhuanzheids = session.createQuery(
					"select productId from PurchaseBillItemVO where billId='" + long1 + "'").list();
			productIds.add(zhuanzheids);
		}
		List<ProductVO> productVOs = new ArrayList<ProductVO>();
		List<List<ProductVO>> productVOss = new ArrayList<List<ProductVO>>();
		for (List<Long> long1 : productIds) {
			for (Long long2 : long1) {
				productVOs = session.createQuery(
						"from ProductVO where id='" + long2 + "' group by productCode").list();
				productVOss.add(productVOs);
			}
		}
		return productVOss;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<ProductVO> productVOs = new ArrayList<ProductVO>();
		ProductVO productVO = new ProductVO();
		String productCode = "C27-0001";
		productVO = (ProductVO) session.createQuery(
				"from ProductVO where productCode='" + productCode + "' group by productCode")
				.uniqueResult();
		System.out.println(productVO);
	}

	/**
	 * @说明：
	 */
	public List<List<ProductVO>> getProductVosByIds(List<List<Long>> ids) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<ProductVO>> productVOs = new ArrayList<List<ProductVO>>();
		for (List<Long> list : ids) {
			List<ProductVO> ppp = new ArrayList<ProductVO>();
			for (Long long1 : list) {
				ppp.add(session.get(ProductVO.class, long1));
			}
			productVOs.add(ppp);
		}

		for (List<ProductVO> list : productVOs) {
			for (ProductVO productVO : list) {
				System.out.println(productVO);
			}
		}
		return productVOs;
	}

}
