package com.erp.controller.delivery.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.controller.delivery.vto.DeliverVTO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
/**
 * 送货vto dao
 * @author guo
 *
 */
public class DeliverVtoDAO extends BaseDAO<DeliverVTO>{
	
	public List<Object> findAllDeliverVTO() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<Object> lists = session.createQuery
					("select d.deliverDate,d.billCode,d.content,mt.typeName,b.finishedContent,b.proName,b.specification,b.unit,b.amount,b.unitPrice,bu.cost,d.address,p.modeName,bu.createrName,bu.billCode "
					+ "from DeliverBill d, BusinessBillItem b, PayMode p, BusinessBill  bu,MakeType mt "
					+ "where d.businessBillId=b.id and b.makeTypeId = mt.id and  d.businessBillId=bu.id and d.payModeId = p.id").list();
			session.close();
			return lists;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
