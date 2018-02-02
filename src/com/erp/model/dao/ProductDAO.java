package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Product;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.UserVO;
/**
 * 材料 dao
 * @author WE
 *
 */
public class ProductDAO extends BaseDAO<ProductVO>{
	public List<ProductVO> findByProductTypeId(Long productTypeId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<ProductVO> list= session.createQuery("from ProductVO where productTypeId = ? order by id desc").setLong(0, productTypeId).list();
		session.close();
		return list;
	}
	
	public List<Product> findByProductType(Long productTypeId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<Product> list= session.createQuery("from Product where productTypeId = ? and enabled = 'Y'").setLong(0, productTypeId).list();
		session.close();
		return list;
	}
	
	/**
	 * 获取全部可用的材料
	 */
	public List<Product> fingAllCanUseProduct(){
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Product> products = session.createQuery("from Product where enabled = ?").setString(0, "Y").list();
		session.close();
		return products;
	}
	
	/**
	 * 
	 */
	public Product findByProductTypeId(String product_code) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Product product = (Product) session.createQuery("from Product where enabled = 'Y' and productCode = ?").setString(0, product_code).uniqueResult();
		session.close();
		System.out.println(product);
		return product;
	}
}
