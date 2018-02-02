package com.erp.controller.accounts.dao;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.erp.controller.accounts.vo.AdjustBillVO;
import com.erp.controller.accounts.vo.IncomeBillVO;
import com.erp.controller.accounts.vo.ReceiveBillVO;
import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.phone.vo.PhoneBookVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 其它收入单	 dao
 * @author guo
 *
 */
public class IncomeBillDAO extends BaseDAO<IncomeBillVO>{

	IncomeBillVO incomeBill = new IncomeBillVO();
	
	//	作废单个其它收入单
	public void updeateEnabled(Long id) {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			incomeBill.setId(id);
			incomeBill.setEnabled("Y");
			session.update(incomeBill);
	}
//	作废全部其它收入单
	public void updeateEnableds() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		session.update("update IncomeBillVO set enabled = 'N' ");
	}
//	获得所有的激活的数据
	public List<IncomeBillVO> findAllEnableds(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<IncomeBillVO> incomeBills = session.createQuery("from IncomeBillVO where enabled = 'Y' ").list();
		return incomeBills;
	}
	
//	根据条件进行 付款单位 and 单号 and 付款单位
	public List<IncomeBillVO> selectIncomeBill(String select,String stallyId) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<IncomeBillVO> incomeBills =session.createQuery("from IncomeBillVO where billCode like '%1%' or payerName like '%格力%' and r.tallySetId= 2  and r.enabled = 'Y' ").list();
			return incomeBills;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}