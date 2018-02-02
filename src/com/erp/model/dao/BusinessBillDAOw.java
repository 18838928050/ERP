/**
 * 
 */
package com.erp.model.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.SerarchBeans;

/**
 * @author： 如约而至 @time：2017年9月7日 上午9:22:18
 *******************************************************************
 @说明：
 *******************************************************************/
public class BusinessBillDAOw extends BaseDAOw<BusinessBillVO> {

	/**
	 * @说明：由BusinessBillVO中的billCode获得当前一行数据
	 */
	public BusinessBillVO getBusinessBillByBillCode(String billCode) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		BusinessBillVO businessBillVO = (BusinessBillVO) session.createQuery(
				"from BusinessBillVO where billCode='" + billCode + "'").uniqueResult();

		session.close();

		return businessBillVO;
	}

	/**
	 * @说明：无条件 因为他默认查询 这里可以直接硬写 默认查询条件
	 */
	public List<BusinessBillVO> getBusinessBillsByLimit() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		// 选出BBE中enabled为N的记录的id，由于BB.id=BBE.id,然后 在BB中不包含这些记录
		Collection<Long> getBBEIdsAsEnabledIsN = new ArrayList<Long>();
		Query sqlQuery = session
				.createQuery("select b.id from BusinessBillExtVO as b where b.enabled='n'");
		// 查出所有enabled为N的记录的Ids
		getBBEIdsAsEnabledIsN = sqlQuery.list();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		criteria.add(Restrictions.not(Restrictions.in("id", getBBEIdsAsEnabledIsN)));
		criteria.add(Restrictions.ge("checkDate", Date.valueOf("2016-08-01")));
		criteria.add(Restrictions.le("checkDate", Date.valueOf("2017-12-03")));
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.addOrder(Order.desc("orderDate"));
		List<BusinessBillVO> businessBillVOs = criteria.list();
		System.out.println(businessBillVOs.size()+"-------");
		return businessBillVOs;
	}

	// 查询测试汇总
	@Test
	public void testNameall() throws Exception {
		SerarchBeans se = new SerarchBeans();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		Collection<Long> getBBEIdsAsEnabledIsN = new ArrayList<Long>();
		Criteria ccc = session.createCriteria(BusinessBillExtVO.class);
		// 查出所有enabled为N的记录的Ids
		ccc.add(Restrictions.in("enabled", "n"));
		/************************** bbe条件 *******************************************/
		// 这里添加完工时间 但是不对
		/*
		 * ccc.add(Restrictions.ge("completeTime", Date.valueOf("2016-08-07")));
		 * ccc.add(Restrictions.le("completeTime", Date.valueOf("2017-08-07")));
		 */
		// 打印状态 找不到
		// ccc.add(Restrictions.not(Restrictions.in("printNum",0)));
		// ccc.add(Restrictions.in("printNum",0));
		// ccc.add(Restrictions.not(Restrictions.in("printNum",0)));
		/************************** bbe结束 *************************************************/
		List<BusinessBillExtVO> aaaBillExtVOs = ccc.list();
		for (BusinessBillExtVO businessBillExtVO : aaaBillExtVOs) {
			getBBEIdsAsEnabledIsN.add(businessBillExtVO.getId());
		}

		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		criteria.add(Restrictions.not(Restrictions.in("id", getBBEIdsAsEnabledIsN)));
		/*************************************/
		// e.estName 订货单位暂时无法查询 BBE.completeTime 完工日期 暂时无法查询
		/******************************* 条件添加 *****************************************************/
		se.setTallySetId(2);
		// se.setOrderDateStart("2016-08-07");
		// se.setOrderDateEnd("2017-08-03");
		// se.setBillCode("E2016080035");
		// se.setDeliverDateStart("2016-08-07");
		// se.setDeliverDateEnd("2017-08-07");

		/******************************* 条件开始 *****************************************************/
		// 暂时使用billconde
		criteria.addOrder(Order.desc("billCode"));

		// 按照付款方式 注意 付款方式返回的是 数字 或是id
		if (se.getPayModeId() != 0) {
			criteria.add(Restrictions.in("payModeId", se.getPayModeId()));
		}

		// 按照摘要
		if (se.getMark() != null) {
			criteria.add(Restrictions.in("mark", se.getMark()));
		}

		// 按照电话
		if (se.getPhone() != null) {
			criteria.add(Restrictions.in("phone", se.getPhone()));
		}

		// 按照联系人
		if (se.getLinkMan() != null) {
			criteria.add(Restrictions.in("linkman", se.getLinkMan()));
		}

		// 按照合同号
		if (se.getContractCode() != null) {
			criteria.add(Restrictions.in("contractCode", se.getBillCode()));
		}

		// 交货日期查找
		if (se.getDeliverDateStart() != null && se.getDeliverDateEnd() != null) {
			criteria.add(Restrictions.ge("deliverDate", Date.valueOf(se.getDeliverDateStart())));
			// 结束日期 不太对应 日 有时要加1
			criteria.add(Restrictions.le("deliverDate", Date.valueOf(se.getDeliverDateEnd())));
		}
		// 按照业务单号
		if (se.getBillCode() != null) {
			criteria.add(Restrictions.in("billCode", se.getBillCode()));
		}

		// 按照订单查找
		if (se.getOrderDateEnd() != null && se.getOrderDateStart() != null) {
			// 注意：此处写checkDate时 查询结果才正确 其他都试过了
			criteria.add(Restrictions.ge("checkDate", Date.valueOf(se.getOrderDateStart())));
			criteria.add(Restrictions.le("checkDate", Date.valueOf(se.getOrderDateEnd())));
		}
		// 按账套 条件：se.getTallySetId 默认为0 就是不用管
		if (se.getTallySetId() != 0) {
			criteria.add(Restrictions.in("tallySetId", se.getTallySetId()));
		}

		/********************************* 条件结束 ***************************************************/
		List<BusinessBillVO> businessBillVOs = criteria.list();
		int sum = 0;
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			sum++;
			System.out.println(businessBillVO);
		}

		System.out.println("数据：" + sum);
		System.out.println(se.getOrderDateEnd());

	}

	/**
	 * @说明：利用条件 进行查询
	 */
	public List<BusinessBillVO> getBusinessBillsSearch(SerarchBeans se) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Collection<Long> getBBEIdsAsEnabledIsN = new ArrayList<Long>();
		Criteria ccc = session.createCriteria(BusinessBillExtVO.class);
		// 查出所有enabled为N的记录的Ids
		ccc.add(Restrictions.in("enabled", "n"));
		/************************** bbe条件 *******************************************/
		// 这里添加完工时间 但是不对
		/*
		 * ccc.add(Restrictions.ge("completeTime", Date.valueOf("2016-08-07")));
		 * ccc.add(Restrictions.le("completeTime", Date.valueOf("2017-08-07")));
		 */
		// 打印状态 找不到
		// ccc.add(Restrictions.not(Restrictions.in("printNum",0)));
		// ccc.add(Restrictions.in("printNum",0));
		// ccc.add(Restrictions.not(Restrictions.in("printNum",0)));
		/************************** bbe结束 *************************************************/
		List<BusinessBillExtVO> aaaBillExtVOs = ccc.list();
		for (BusinessBillExtVO businessBillExtVO : aaaBillExtVOs) {
			getBBEIdsAsEnabledIsN.add(businessBillExtVO.getId());
		}

		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		criteria.add(Restrictions.not(Restrictions.in("id", getBBEIdsAsEnabledIsN)));
		/*************************************/
		// e.estName 订货单位暂时无法查询 BBE.completeTime 完工日期 暂时无法查询
		/******************************* 条件添加 *****************************************************/
		se.setTallySetId(2);
		// se.setOrderDateStart("2016-08-07");
		// se.setOrderDateEnd("2017-08-03");
		// se.setBillCode("E2016080035");
		// se.setDeliverDateStart("2016-08-07");
		// se.setDeliverDateEnd("2017-08-07");

		/******************************* 条件开始 *****************************************************/
		// 暂时使用billconde
		criteria.addOrder(Order.desc("billCode"));

		// 按照付款方式 注意 付款方式返回的是 数字 或是id
		if (se.getPayModeId() != 0) {
			criteria.add(Restrictions.in("payModeId", se.getPayModeId()));
		}

		// 按照摘要
		if (se.getMark() != null) {
			criteria.add(Restrictions.in("mark", se.getMark()));
		}

		// 按照电话
		if (se.getPhone() != null) {
			criteria.add(Restrictions.in("phone", se.getPhone()));
		}

		// 按照联系人
		if (se.getLinkMan() != null) {
			criteria.add(Restrictions.in("linkman", se.getLinkMan()));
		}

		// 按照合同号
		if (se.getContractCode() != null) {
			criteria.add(Restrictions.in("contractCode", se.getBillCode()));
		}

		// 交货日期查找
		if (se.getDeliverDateStart() != null && se.getDeliverDateEnd() != null) {
			criteria.add(Restrictions.ge("deliverDate", Date.valueOf(se.getDeliverDateStart())));
			// 结束日期 不太对应 日 有时要加1
			criteria.add(Restrictions.le("deliverDate", Date.valueOf(se.getDeliverDateEnd())));
		}
		// 按照业务单号
		if (se.getBillCode() != null) {
			criteria.add(Restrictions.in("billCode", se.getBillCode()));
		}

		// 按照订单查找
		if (se.getOrderDateEnd() != null && se.getOrderDateStart() != null) {
			// 注意：此处写checkDate时 查询结果才正确 其他都试过了
			criteria.add(Restrictions.ge("checkDate", Date.valueOf(se.getOrderDateStart())));
			criteria.add(Restrictions.le("checkDate", Date.valueOf(se.getOrderDateEnd())));
		}
		// 按账套 条件：se.getTallySetId 默认为0 就是不用管
		if (se.getTallySetId() != 0) {
			criteria.add(Restrictions.in("tallySetId", se.getTallySetId()));
		}

		/********************************* 条件结束 ***************************************************/
		List<BusinessBillVO> businessBillVOs = criteria.list();
		int sum = 0;
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			sum++;
			System.out.println(businessBillVO);
		}

		System.out.println("数据：" + sum);
		System.out.println(se.getOrderDateEnd());
		return businessBillVOs;
	}

	public List<Long> getBBEIdsForgetBusinessBillVOsByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillExtVO.class);
		// 设置账套
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("examined", "Y"));
		criteria.add(Restrictions.in("completed", "N"));
		List<BusinessBillExtVO> businessBillExtVOs = criteria.list();
		List<Long> ids = new ArrayList<Long>();
		for (BusinessBillExtVO businessBillExtVO : businessBillExtVOs) {
			ids.add(businessBillExtVO.getId());
		}
		return ids;
	}

	// 要制作的业务单 首界面 加限制条件 自定义的
	public List<BusinessBillVO> getBusinessBillVOsByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		SQLQuery query = session
				.createSQLQuery("select  bb.* from	business_bill as bb,business_bill_ext as bbe where	bb.id = bbe.id and bb.tally_set_id = 2 and bbe.examined = 'y' and "
						+ "bbe.enabled = 'y' and bbe.completed = 'n' and bbe.closed = 'n'");
		query.addEntity(BusinessBillVO.class);
		return query.list();
	}

	/*
	 * @Test public void test2() throws Exception {
	 * 
	 * Session session = HibernateUtils.getSession();
	 * session.beginTransaction();
	 * 
	 * @SuppressWarnings("deprecation") SQLQuery query =
	 * session.createSQLQuery("select  * from	business_bill "); //
	 * query.addEntity(BusinessBillVO.class); List ss = query.list(); for
	 * (Object object : ss) { System.out.println(o); } }
	 */

	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		// 设置账套
		criteria.add(Restrictions.in("tallySetId", 2l));

		// 由BB.id=BBE.id ==>BBE BBE.enabled=Y BBE.examined=Y BBE.copmleted=N
		// 才符合条件
		// 此时 得到不饱含BBE.enabled=N 且 BBE.examined=N BBE.copmleted=Y的ids 就行了

		List<Long> ids = getBBEIdsForgetBusinessBillVOsByLimits();

		criteria.add(Restrictions.not(Restrictions.in("id", ids)));
		System.out.println(criteria.list().size());

	}

	@Test
	public void testNamae() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillExtVO.class);
		// 设置账套
		criteria.add(Restrictions.in("enabled", "N"));
		criteria.add(Restrictions.in("examined", "N"));
		criteria.add(Restrictions.in("completed", "Y"));
		List<BusinessBillExtVO> businessBillExtVOs = criteria.list();
		List<Long> ids = new ArrayList<Long>();
		int i = 0;
		for (BusinessBillExtVO businessBillExtVO : businessBillExtVOs) {
			i++;
			System.out.println(businessBillExtVO.getId());

		}
		System.out.println(i);
	}

	/**
	 * @说明： 产量登记： 这个 需要登陆模块 提供 当前登陆的账套 这里显示指定特定的账套
	 */
	// 获得BBE中enabled 状态为未激活的
	public List<Long> getIds() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillExtVO.class);
		// 手动设置账套
		criteria.add(Restrictions.in("enabled", "N"));

		List<BusinessBillExtVO> b = criteria.list();
		List<Long> ids = new ArrayList<Long>();
		for (BusinessBillExtVO businessBillExtVO : b) {
			ids.add(businessBillExtVO.getId());
		}
		return ids;
	}

	@Test
	public void testbb() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		// 设置账套
		criteria.add(Restrictions.in("tallySetId", 2l));
		List<Long> ids = getBBEIds();
		criteria.add(Restrictions.in("id", ids));
		List<BusinessBillVO> c = criteria.list();
		for (BusinessBillVO businessBillVO : c) {
			System.out.println(businessBillVO);
		}
		System.out.println(criteria.list().size());

	}

	// 产量计件明细表 过滤 信息的
	public List<Long> getBBEIds() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillExtVO.class);
		// 设置账套
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.in("examined", "Y"));
		List<BusinessBillExtVO> businessBillExtVOs = criteria.list();
		List<Long> ids = new ArrayList<Long>();
		for (BusinessBillExtVO businessBillExtVO : businessBillExtVOs) {
			ids.add(businessBillExtVO.getId());
		}
		return ids;
	}

	/**
	 * @说明：产量计件明细 首次打开
	 */
	public List<BusinessBillVO> getListAllBBByLImits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		// 设置账套
		criteria.add(Restrictions.in("tallySetId", 2l));

		List<Long> ids = getBBEIds();
		criteria.add(Restrictions.in("id", ids));
		System.out.println(criteria.list().size());

		return criteria.list();
	}

	/**
	 * 产量登记首次打开
	 */
	public List<BusinessBillVO> getListAllBBByLImitsAndTime() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
		ca.add(Calendar.DATE, -60);// 日期减60
		java.util.Date resultDate = ca.getTime();// 结果
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String start = sdf.format(resultDate);
		String end = sdf.format(new java.util.Date());

		Criteria criteria = session.createCriteria(BusinessBillVO.class);
		// 设置账套
		criteria.add(Restrictions.in("tallySetId", 2l));

		List<Long> ids = getBBEIds();
		criteria.add(Restrictions.in("id", ids));

		criteria.add(Restrictions.ge("orderDate", Date.valueOf(start)));
		criteria.add(Restrictions.le("orderDate", Date.valueOf(end)));

		System.out.println(criteria.list().size());

		return criteria.list();
	}

	/**
	 * @param bbiBillIds
	 * @return
	 */
	public List<List<BusinessBillItemVO>> getbbiSS(List<Long> bbiBillIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<Long>> bbiIds = new ArrayList<>();
		for (Long long1 : bbiBillIds) {
			bbiIds.add(session.createQuery(
					"select id from BusinessBillItemVO where billId='" + long1 + "' ").list());
		}
		List<List<BusinessBillItemVO>> businessBillItemVOss = new ArrayList<>();
		for (List<Long> list : bbiIds) {
			for (Long long2 : list) {
				businessBillItemVOss.add(session.createQuery(
						"from BusinessBillItemVO where id='" + long2 + "'").list());

			}

		}
		return businessBillItemVOss;
	}

	@Test
	public void testName1() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String thisTime = sdf.format(new java.util.Date());
		System.out.println(thisTime);
	}

	/**
	 * @param businessBillItemVOs
	 * @return
	 */
	public List<BusinessBillVO> getBBs(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> bbIds = new ArrayList<>();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {

			bbIds.add(businessBillItemVO.getBillId());
		}
		List<BusinessBillVO> billVOs = new ArrayList<>();
		for (Long long1 : bbIds) {
			billVOs.add((BusinessBillVO) session.createQuery(
					"from BusinessBillVO where id='" + long1 + "'").uniqueResult());

		}
		return billVOs;
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillVO> getAllBBByIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillVO> BusinessBillVOs = new ArrayList<BusinessBillVO>();
		for (Long long1 : ids) {
			BusinessBillVOs.add(session.get(BusinessBillVO.class, long1));
		}
		return BusinessBillVOs;
	}

	/**
	 * @param ids
	 * @return
	 */
	public List<BusinessBillVO> getSonghuodanzuofeiByid(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillVO> dd = new ArrayList<>();

		for (Long long1 : ids) {
			dd.add(session.get(BusinessBillVO.class, long1));
		}
		return dd;
	}

}
