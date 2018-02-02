package com.erp.controller.accounts.dao;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AdjustBillVO;

/**
 * 调账单	 dao
 * @author guo
 *
 */
public class AdjustBillDAO extends BaseDAO<AdjustBillVO>{

	AdjustBillVO adjustBill = new AdjustBillVO();
	
	//	作废单个调帐单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			adjustBill.setId(id);
			adjustBill.setEnabled("Y");
			session.update(adjustBill);
	}
	
	
//	作废全部调帐单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update AdjustBillVO set enabled = 'N' ");
	}
	
//	获得所有的激活的数据
	public List<AdjustBillVO> findAllEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<AdjustBillVO> adjustBills = session.createQuery("from AdjustBillVO where enabled = 'Y' ").list();
		return adjustBills;
	}
	
	
//	根据条件进行 付款单位 or 单号 	and 	公司类型(默认条件是激活状态)
//付款单位在BankAccountDetail表中
	public List<AdjustBillVO> selectAdjustBill(String select,String tallyId) {
		try {
			/**
			 * 货物单号	billCode（待确定）	
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<Object[]> list =session.createQuery
					("select a.billCode,a.adjustDate,a.mark,a.cost,a.description,a.managerName,a.examined from BankAccountDetailVO b,AdjustBillVO a where a.billCode=a.billCode and  a.billCode like ? or b.mark like ?  ").setString(0, "%"+select+"%").setString(1, "%"+select+"%").list();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;                                      
			List<AdjustBillVO> adjustBills = new ArrayList<AdjustBillVO>();
			//			对得到的数据进行封装
			for (Object[] objects : list) {
				try {  
		            //将字符串转换成日期格式   
		            date = df.parse(String.valueOf(objects[1]));  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } 
				adjustBill.setBillCode(String.valueOf(objects[0]));//单号
				adjustBill.setAdjustDate(date);//收款日期
				adjustBill.setMark(String.valueOf(objects[2]));//付款单位，替用
				adjustBill.setCost(new BigDecimal(String.valueOf(objects[3])));//金额
				adjustBill.setDescription(String.valueOf(objects[4]));//摘要
				adjustBill.setManagerName(String.valueOf(objects[5]));//经办人
				adjustBill.setExamined(String.valueOf(objects[6]));//经办人
				adjustBills.add(adjustBill);
			}
			session.close();
			return adjustBills;
		}catch (Exception e) {
			return null;
		}	
	}
	
	
	
}