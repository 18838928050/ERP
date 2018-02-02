/**
 * 
 */
package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillItemVO;

/**
 @author： fu    @time：2017年12月3日 下午5:11:06 
 @说明： 一份耕耘，一份收获
 **/
public class PurchaseBillItemDAOByfu {

	/**
	 * @说明：
	 */
	public List<PurchaseBillItemVO> getPBIs(String productCode) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		long productId=(long) session.createQuery("select id from Product where productCode='"+productCode+"' ").uniqueResult();
		List<PurchaseBillItemVO> purchaseBillItemVOs=session.createQuery("from PurchaseBillItemVO where productId='"+productId+"'").list();
		return purchaseBillItemVOs;
	}

}
