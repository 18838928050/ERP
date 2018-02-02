package com.erp.controller.statistic.dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.erp.controller.statistic.vo.BusinessProfitVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExtVO;

/**
 * 业务单 dao
 * @author guo
 *
 */
public class BusinessBillProfitDAO extends BaseDAO<BusinessProfitVO>{
	//根据编号查询
		public BusinessProfitVO findByBillCode(String billCode) {
			try {
				Session session=HibernateUtils.getSession();
				session.beginTransaction();
				BusinessProfitVO businessProfit = (BusinessProfitVO) session.createQuery("from BusinessProfitVO where bbCode = ? ").setParameter(0, billCode).uniqueResult();
				session.close();
				return businessProfit;
			}catch (Exception e) {
				return null;
			}	
		}	
		
//		账单未完结中	按月份和客户名称统计欠款
		public List<BusinessBillExtVO> findMonthProfitCost() {
			try {
				Session session=HibernateUtils.getSession();
				session.beginTransaction();
				//			获得当年的年份
				Calendar date = Calendar.getInstance();
				String year = String.valueOf(date.get(Calendar.YEAR));
				String sql="select b.client_id , "
						+ "sum(case when (b.deliver_date < '2017-02-01') and (b.deliver_date > '2017-01-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-03-01') and (b.deliver_date > '2017-02-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-04-01') and (b.deliver_date > '2017-03-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-05-01') and (b.deliver_date > '2017-04-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-06-01') and (b.deliver_date > '2017-05-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-07-01') and (b.deliver_date > '2017-06-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-08-01') and (b.deliver_date > '2017-07-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-09-01') and (b.deliver_date > '2017-08-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-10-01') and (b.deliver_date > '2017-09-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-11-01') and (b.deliver_date > '2017-10-01') then 'no' end),"
						+ "sum(case when (b.deliver_date < '2017-12-01') and (b.deliver_date > '2017-11-01') then 'no' end), "
						+ "sum(case when (b.deliver_date < '2017-12-31') and (b.deliver_date > '2017-12-01') then 'no' end) "
						+ "from business_bill b , business_bill_ext bb "
						+ "where bb.completed='N' and bb.has_receive='N' and b.id=bb.id "
						+ "group by b.client_id";
				System.out.println(sql);
				List<Object[]> list = session.createSQLQuery(sql).list();
				List<BusinessBillExtVO> businessBills = new ArrayList<BusinessBillExtVO>(12);
				session.close();
				return businessBills;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;	
		}
}
