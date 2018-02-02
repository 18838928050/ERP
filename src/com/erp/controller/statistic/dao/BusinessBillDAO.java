package com.erp.controller.statistic.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.controller.statistic.vo.BusinessProfitVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillVO;

/**
 * 业务单 dao
 * @author guo
 *
 */
public class BusinessBillDAO extends BaseDAO<BusinessBillVO>{
	//获得当年每月份的业务单的总计
	//	月份	+合同金额	+调账金额	-已收金额	=当月应收款	有五个数据组成
	public List<BusinessBillVO> findYearBill() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
//			获得当年的年份
			Calendar date = Calendar.getInstance();
			String year = String.valueOf(date.get(Calendar.YEAR));
			List<Object[]> list = session.createSQLQuery("select substr(b.deliver_date,1,7), sum(b.cost),sum(bb.adjust_cost),sum(bb.receive_cost) from business_bill b , business_bill_ext bb where b.deliver_date like '2017%' group by substr(b.deliver_date,1,7)").list();
			System.out.println(list.size()+"---------------------------");
			List<BusinessBillVO> businessBills = new ArrayList<BusinessBillVO>(12);
			for (Object[] objects : list) {
				BusinessBillVO businessBill = new BusinessBillVO();
//				这五个数据都是借businessBill存值，发送到前台
				BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(objects[1]));//合同金额
				BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(objects[2]));//调账金额
				BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(objects[3]));//已收金额
				BigDecimal bigDecimal4 = bigDecimal1.add(bigDecimal1).add(bigDecimal2).subtract(bigDecimal3);//当月应收款=合同金额+调账金额-已收金额;
				businessBill.setBillCode(String.valueOf(objects[0]));//月份
				businessBill.setAmount(bigDecimal1);//合同金额
				businessBill.setCost(bigDecimal2);//调账金额
				businessBill.setSquare(bigDecimal3);//已收金额
				businessBill.setLengM(bigDecimal4);//当月应收款
				businessBills.add(businessBill);
				System.out.println("---------------------"+businessBill.getBillCode());
			}
			session.close();
			return businessBills;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}	
	
//	查询所有送货单
	public List<BusinessBillVO> findBusinessBills() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<BusinessBillVO> businessBills = session.createQuery("from BusinessBillVO").list();
			session.close();
			return businessBills;
		}catch (Exception e) {
			return null;
		}	
			
	}	
	
	
}
