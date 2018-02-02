/**
 * 
 */
package com.erp.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CooperBillVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： 如约而至 @time：2017年9月4日 上午10:54:39
 *******************************************************************
 @说明：
 *******************************************************************/
public class CooperBillDAOw extends BaseDAOw<CooperBillVO> {

	/**
	 * @throws Exception
	 * @说明：
	 */
	public List<CooperBillVO> findAllByMyAdjust() throws Exception {
		List<CooperBillVO> cs = findAll();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		for (int i = 0; i < cs.size(); i++) {
			Long esid = cs.get(i).getCooperatorId();
			String name = (String) session.createQuery(
					"select estName from EstablishmentVO where id='" + esid + "'").uniqueResult();
			cs.get(i).setEstName(name);
		}
		session.close();
		return cs;
	}

	/**
	 * @说明：
	 */
	public CooperBillVO getCooperBillByBillCode(String billCode) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		CooperBillVO cooperBillVO = (CooperBillVO) session.createQuery(
				"from CooperBillVO where billCode='" + billCode + "'").uniqueResult();
		session.close();
		return cooperBillVO;
	}

	/**
	 * @说明：查询说有已经审核（examined=''）的记录
	 */
	public Query getAllQuery() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Integer isCheck = (Integer) ActionContext.getContext().getSession().get("isCheck");
		System.out.println(isCheck + "============");
		char examined = (isCheck == 1 ? 'N' : 'Y');
		SQLQuery sqlQueryquery = session
				.createSQLQuery("select b.* from cooper_bill_ext c,cooper_bill b WHERE c.id=b.id and c.examined='"
						+ examined + "'");
		sqlQueryquery.addEntity(CooperBillVO.class);
		return sqlQueryquery;
	}

	/**
	 * @说明：按照cooperatorId 和 排序方式sort=asc desc ,时间限制进行查询
	 */
	public List<CooperBillVO> getCooperBillByCooperatorIdAndTimeSort(long cooperatorId,
			String sort, String timeLimit) {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(CooperBillVO.class);

		criteria.add(Restrictions.in("cooperatorId", cooperatorId));
		// !!!!!!!!!!!!!!!!!!!!这个暂且按照更新时间计算！！！！？？？！！！
		criteria.add(Restrictions.ge("createTime", Date.valueOf("2017-08-01")));
		criteria.add(Restrictions.le("createTime", Date.valueOf("2017-08-31")));
		if (sort == null || sort == "asc") {
			criteria.addOrder(Order.asc("createTime"));
		} else {
			criteria.addOrder(Order.desc("createTime"));
		}
		List<CooperBillVO> cooperBillVOs = criteria.list();
		// 返回查询结果
		return cooperBillVOs;
	}

	/**
	 * @说明：按照cooperatorId 和 排序方式sort=asc desc ,时间限制,是否付完款，账套，进行查询
	 */
	public List<CooperBillVO> getCooperBillByCooperatorIdAndTimeSortTallySetifHasPay(
			long cooperatorId, String sort, Long tallyset, String timeLimit, String hasPay) {

		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(CooperBillVO.class);
		// 查询所有没有交费的记录的ids
		Collection<Long> getBBEIdsAsNotHasPay = new ArrayList<Long>();
		Collection<Long> getBBEIdsAsHasPay = new ArrayList<Long>();

		Query query = session
				.createQuery("select c.id from CooperBillExtVO as c where c.hasPay='y'");
		getBBEIdsAsHasPay = query.list();

		criteria.add(Restrictions.in("cooperatorId", cooperatorId));
		// !!!!!!!!!!!!!!!!!!!!这个暂且按照更新时间计算！！！！？？？！！！这里

		criteria.add(Restrictions.ge("updateTime", Date.valueOf("2017-09-01")));
		criteria.add(Restrictions.le("updateTime", Date.valueOf("2017-09-13")));
		if (sort == null || sort == "asc") {
			System.out.println("第一个大if");
			if (hasPay == "只显示未付完款的外协单") {
				criteria.addOrder(Order.asc("updateTime"));
				if (getBBEIdsAsHasPay.size() != 0) {

					// 去掉已经付完款的外协单
					criteria.add(Restrictions.not(Restrictions.in("id", getBBEIdsAsHasPay)));
				}
				criteria.add(Restrictions.eq("tallySetId", tallyset));
				List<CooperBillVO> cooperBillVOs = criteria.list();

			} else {
				System.out.println("进入的");// 假设进入了这个
				criteria.addOrder(Order.asc("updateTime"));
				criteria.add(Restrictions.eq("tallySetId", tallyset));
				List<CooperBillVO> cooperBillVOs = criteria.list();
			}

		} else {
			System.out.println("第二个小if");
			if (hasPay == "只显示未付完款的外协单") {
				System.out.println("2");

				System.out.println();
				criteria.addOrder(Order.desc("updateTime"));
				if (getBBEIdsAsNotHasPay.size() != 0) {
					criteria.add(Restrictions.not(Restrictions.in("id", getBBEIdsAsHasPay)));
				}

				criteria.add(Restrictions.eq("tallySetId", tallyset));
				List<CooperBillVO> cooperBillVOs = criteria.list();

			} else {
				System.out.println("第三个小if");
				criteria.addOrder(Order.desc("updateTime"));
				criteria.add(Restrictions.eq("tallySetId", tallyset));
				List<CooperBillVO> cooperBillVOs = criteria.list();
			}
		}

		List<CooperBillVO> cooperBillVOs = criteria.list();
		// 返回查询结果
		return cooperBillVOs;
	}

	public List<CooperBillVO> getCooperBillsByLimits(Long bankAccountId, long EstablishmentId,
			long tallySet) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from CooperBillExtVO where paied='N' and examined='Y'";
		List<Long> ids = session.createQuery(hql).list();

		Criteria criteria = session.createCriteria(CooperBillVO.class);
		criteria.add(Restrictions.in("id", ids));
		criteria.add(Restrictions.in("cooperatorId", EstablishmentId));
		criteria.add(Restrictions.in("bankAccountId", bankAccountId));
		criteria.add(Restrictions.in("tallySetId", tallySet));
		return criteria.list();
	}

	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select id from CooperBillExtVO where paied='N' and examined='Y'";
		List<Long> ids = session.createQuery(hql).list();

		Criteria criteria = session.createCriteria(CooperBillVO.class);
		criteria.add(Restrictions.in("id", ids));
		criteria.add(Restrictions.in("cooperatorId", 763l));
		criteria.add(Restrictions.in("bankAccountId", 18l));
		criteria.add(Restrictions.in("tallySetId", 2l));
		System.out.println(criteria.list());
	}

	public void saveCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Integer updateNum = 0;
		for (CooperBillVO c : cooperBillVOs) {
			String hql = " update CooperBillVO set bill_code='" + c.getBillCode()
					+ "',cooperator_id='" + "" + c.getCooperatorId() + "',cooper_date='"
					+ c.getCooperDate() + "',gather_date='" + c.getGatherDate() + "',linkman='"
					+ c.getLinkman() + "',phone='" + c.getPhone() + "',address='" + c.getAddress()
					+ "',content='" + c.getContent() + "',fav_cost='" + c.getFavCost() + "',cost='"
					+ c.getCost() + "',bank_account_id='" + "" + c.getBankAccountId()
					+ "',imprest='" + c.getImprest() + "',department_id='" + c.getDepartmentId()
					+ "',manager_id='" + c.getManagerId() + "'	,manager_name=" + "'"
					+ c.getManagerName() + "'	,gather_require='" + c.getGatherRequire()
					+ "',setup_require='" + c.getSetupRequire() + "',pay_mode_id='"
					+ c.getPayModeId() + "'	,mark='" + c.getMark() + "',amount='" + c.getAmount()
					+ "',leng_m='" + c.getLengM() + "',square='" + c.getSquare()
					+ "'	,creater_id='" + c.getCreaterId() + "'	,creater_name='"
					+ c.getCreaterName() + "',update_time='" + c.getUpdateTime()
					+ "',tally_set_id='" + c.getTallySetId() + "'	,modifier_id='"
					+ c.getModifierId() + "',modifier_name='" + c.getModifierName()
					+ "',modify_time='" + c.getModifyTime() + "',create_time='" + c.getCreateTime()
					+ "',leng_cm=" + "'" + c.getLengCm() + "' where id='" + c.getId() + "'";
			updateNum += session.createQuery(hql).executeUpdate();
		}
		session.getTransaction().commit();
		System.out.println("更新条数：" + updateNum);
	}

	public List<CooperBillVO> getCooperBillByCooperatorId(long id) {
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(CooperBillVO.class);
		criteria.add(Restrictions.in("cooperatorId", id));
		return criteria.list();
	}

}
