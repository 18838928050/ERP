package com.erp.controller.accounts.dao;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.erp.controller.accounts.vo.ReceiveBillVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 收款单	 dao
 * @author guo
 *
 */
public class ReceiveBillDAO extends BaseDAO<ReceiveBillVO>{

	ReceiveBillVO receiveBill = new ReceiveBillVO();

	//	作废单个收款单
	public void updeateEnabled(Long id) {
		
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		
		
		
		
		receiveBill.setId(id);
		receiveBill.setEnabled("Y");
		session.update(receiveBill);
		
	}

	//	作废全部收款单
	

	//	获得所有的激活的数据
	public List<ReceiveBillVO> findAllEnableds(){
		
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		//		查询到的收款单数据
		List<ReceiveBillVO> receiveBills = session.createQuery("from ReceiveBillVO r where r.enabled = 'Y' ").list();
		
		return receiveBills;
	
	}

	//	根据条件进行 付款单位 and 单号 and 公司类型
	public List<ReceiveBillVO> selectReceive(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<Object[]> list =session.createQuery("select r.billCode , r.receiveDate, b.mark,r.cost ,r.description, r.managerName,r.examined  from BankAccountDetailVO b,ReceiveBillVO r where r.billCode=b.billCode  and r.billCode like '%1%' or b.mark like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' ").list();
			//			将时间进行一个转化为date
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;                                      
			List<ReceiveBillVO> receiveBills = new ArrayList<ReceiveBillVO>();

			//			对得到的数据进行封装
			for (Object[] objects : list) {
				try {  
					//将字符串转换成日期格式   
					date = df.parse(String.valueOf(objects[1]));  
				} catch (Exception e) {  
					e.printStackTrace();  
				} 
				receiveBill.setBillCode(String.valueOf(objects[0]));//单号
				receiveBill.setReceiveDate(date);//收款日期
				receiveBill.setMark(String.valueOf(objects[2]));//付款单位，替用
				receiveBill.setCost(new BigDecimal(String.valueOf(objects[3])));//金额
				receiveBill.setDescription(String.valueOf(objects[4]));//摘要
				receiveBill.setManagerName(String.valueOf(objects[5]));//经办人
				receiveBill.setExamined(String.valueOf(objects[6]));//经办人
				receiveBills.add(receiveBill);
			}
			return receiveBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}