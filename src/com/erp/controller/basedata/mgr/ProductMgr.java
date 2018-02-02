package com.erp.controller.basedata.mgr;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.ProductDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.Product;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.ProductVO;
/**
 * 材料列表  逻辑处理
 * @author WE
 *
 */
public class ProductMgr {
	private ProductDAO productDao = new ProductDAO();
	

	/**
	 * 通过product_codec查询材料 JiaQi
	 */
	public Product findByProductTypeId(String product_code){
		return productDao.findByProductTypeId(product_code);
	}
	
	/**
	 * 查询product表
	 */
	public List<ProductVO> findByProductTypeId(Long productTypeId) {
		List<ProductVO> products = null;
		try {
			products = productDao.findByProductTypeId(productTypeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	
	/**
	 * 查询product表 全部数据
	 */
	public List<ProductVO> findAll() {
		List<ProductVO> products = null;
		try {
			products = productDao.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}	
		return products;
	}
	
	
	/**
	 * 查询product表
	 */
	public List<ProductVO> findByProductTypeId(long id) {
		List<ProductVO> products = null;
		try {
			products = productDao.findByProductTypeId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	
	   /**
		 * 增加 product表中的记录，保存到数据库中
		 * @param product
		 */
		public void saveProduct(ProductVO product) {
			try {
				productDao.save(product);
			} catch (Exception e) {
				System.out.println("保存失败！");
				e.printStackTrace();
			}
		}
		
		/**
		 * 为了下面那个傻逼重写我的方法getById的方法而写的方法
		 * By JiaQi
		 * QQ:562419855 微信同号
		 * TEL:15937496103  
		 * 不服来找我
		 * 奶奶的  傻逼
		 * @return
		 */
		public Product findById(long id){
			Product product = null;
				Session session=HibernateUtils.getSession();
				session.beginTransaction();
				product =  session.get(Product.class, id);
				session.close();
			return product;
		}

		/**
		 * 通过id查询获得product表某个记录
		 * @param id
		 * @return
		 */
		public ProductVO getById(long id) {
			ProductVO product = null;
			try {
				product = productDao.getById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return product;
		}
		
		/**
		 * 更新product表
		 * @param product
		 */
		public void updateProduct(ProductVO product) {
			try {
				productDao.update(product);
			} catch (Exception e) {
				System.out.println("更新失败！");
				e.printStackTrace();
			}
			
		}


		/**
		 * 根据id删除product表中的某条记录
		 * @param id
		 */
		public void deleteProduct(long id) {
			try {
				productDao.delete(id);
			} catch (Exception e) {
				System.out.println("删除失败！");
				e.printStackTrace();
			}
		}
	

}
