package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;

public class PurchaseBillDAOw extends BaseDAOw<PurchaseBillVO> {

	public List findPbs2(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from PurchaseBillExtVO where examined='N' and enabled='Y'";
		List<Long> ids = session.createQuery(hql).list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.like("billCode", "O%"));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();

	}

	public void shenhetongguo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set examined='Y' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();
	}

	public PurchaseBillVO findPbByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("id", id));

		return (PurchaseBillVO) criteria.uniqueResult();
	}

	public List<PurchaseBillItemVO> findPBIS(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "from PurchaseBillItemVO where billId='" + id + "' ";
		Criteria criteria = session.createCriteria(PurchaseBillItemVO.class);
		criteria.add(Restrictions.in("billId", id));
		return criteria.list();
	}

	public void shenhebutongguo(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set examined='N' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

	public List findPbs(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from PurchaseBillExtVO where examined='N' and enabled='Y'";
		List<Long> ids = session.createQuery(hql).list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.like("billCode", "N%"));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();

	}

	public List findIsYPbsfan(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from PurchaseBillExtVO where examined='Y' and enabled='Y'";
		List<Long> ids = session.createQuery(hql).list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.like("billCode", "O%"));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();

	}

	public List findIsYPbs(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from PurchaseBillExtVO where examined='Y' and enabled='Y'";
		List<Long> ids = session.createQuery(hql).list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.like("billCode", "N%"));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();

	}

	public void setcaigoudanruku(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set stoc='Y' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();
	}

	public void setcaigoudanfanruku(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set stoc='N' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();
	}

	public void settuihuodanchuku(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set stoc='N' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

	public void settuihuodanfanchuku(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.createQuery("update PurchaseBillExtVO set stoc='Y' where id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

	public List<PurchaseBillVO> findPurchaseBillsByLimit(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> ids = session.createQuery(
				"select id from PurchaseBillExtVO where examined='Y' and enabled='Y'").list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	public List<PurchaseBillVO> findPurchaseBillVOs2(List<Long> pbIds) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<PurchaseBillVO> purchaseBillVOs = new ArrayList<PurchaseBillVO>();
		PurchaseBillVO purchaseBillVO = new PurchaseBillVO();
		for (Long long1 : pbIds) {
			purchaseBillVO = (PurchaseBillVO) session.createQuery(
					"from PurchaseBillVO where id='" + long1 + "'").uniqueResult();
			purchaseBillVOs.add(purchaseBillVO);
		}
		return purchaseBillVOs;
	}

	/**
	 * @说明：
	 */
	public List<PurchaseBillVO> getPurchaseBillVOsByProviderIds(Long ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PurchaseBillVO where providerId='" + ids + "'");
		List<PurchaseBillVO> p = query.list();
		for (PurchaseBillVO purchaseBillVO : p) {
			System.out.println(purchaseBillVO);
		}

		return query.list();
	}

	/**
	 * @说明：
	 */
	public List<PurchaseBillVO> getPurchaseBillVOS(long tallySetId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> ids = session.createQuery(
				"select id from PurchaseBillExtVO where examined='Y' and enabled='Y'").list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySetId));
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	/**
	 * 辅助采购单作废 查询 与Pb 对应的 Pbe中enable=Y的订单
	 */

	public List<Long> getIds() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PurchaseBillExtVO.class);
		// 利用投影 只查找几个字段值
		criteria.add(Restrictions.in("enabled", "N"));
		List<PurchaseBillExtVO> ps = criteria.list();
		List<Long> ids = new ArrayList<Long>();
		for (PurchaseBillExtVO purchaseBillExtVO : ps) {
			ids.add(purchaseBillExtVO.getId());
		}
		return ids;
	}

	/**
	 * @说明： 查询采购单作废
	 */
	public List<PurchaseBillVO> getPurchaseBillsByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.not(Restrictions.in("id", getIds())));
		criteria.add(Restrictions.like("billCode", "N%"));
		return criteria.list();
	}

	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> ids = session.createQuery(
				"select id from PurchaseBillExtVO where examined='Y' and enabled='Y'").list();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.in("id", ids));
		System.out.println(ids);
	}

	/**
	 * @说明：TK 退款
	 */
	public List<PurchaseBillVO> getPurchaseBillsForTKByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(PurchaseBillVO.class);
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.not(Restrictions.in("id", getIds())));
		criteria.add(Restrictions.like("billCode", "O%"));
		return criteria.list();
	}

}
