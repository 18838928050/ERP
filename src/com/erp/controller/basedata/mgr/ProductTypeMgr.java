package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.ProductDAO;
import com.erp.model.dao.ProductTypeDAO;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.Unit;
/**
 * 材料类型  逻辑处理
 * @author WE
 *
 */
public class ProductTypeMgr {
	private ProductTypeDAO productTypeDao = new ProductTypeDAO();

	/**
	 * 查询product_type表
	 */
	public List<ProductType> findAll() {
		List<ProductType> productTypes = null;
		try {
			productTypes = productTypeDao.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}	
		return productTypes;
	}

   /**
	 * 增加 product_type表中的记录，保存到数据库中
	 * @param productType
	 */
	public void saveProductType(ProductType productType) {
		try {
			productTypeDao.save(productType);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id查询获得unit表某个记录
	 * @param id
	 * @return
	 */
	public ProductType getById(long id) {
		ProductType productType = null;
		try {
			productType = productTypeDao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productType;
	}
	
	/**
	 * 更新product_type表
	 * @param productType
	 */
	public void updateProductType(ProductType productType) {
		try {
			productTypeDao.update(productType);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}

	/**
	 * 根据id删除product_type表中的某条记录
	 * @param id
	 */
	public void deleteProductType(long id) {
		try {
			productTypeDao.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}
	
	
	
	

}
