/**
 * 
 */
package com.erp.model.dao;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Product;

/**
 @author： fu    @time：2017年12月3日 下午4:42:01 
 @说明： 一份耕耘，一份收获
 **/
public class ProductDAOByfu {

	/**
	 * @说明：
	 */
	public Product getProduct(String productCode) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Product product=new Product();
		product=(Product) session.createQuery("from Product where productCode='"+productCode+"'").uniqueResult();
		return product ;
	}

}
