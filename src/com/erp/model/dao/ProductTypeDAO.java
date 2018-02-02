package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.ProductVO;
/**
 * 材料类型 dao
 * @author WE
 *
 */

public class ProductTypeDAO extends BaseDAO<ProductType>{
	
	public List<ProductType> findAllCanUse(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<ProductType> list= session.createQuery(
				"FROM  ProductType where enabled = 'Y'")
				.list();
		session.close();
		return list;
		
	}
	
}
