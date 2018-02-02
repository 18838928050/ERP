package com.erp.controller.stock.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.stock.vo.InBillVO;
import com.erp.controller.stock.vo.OutBillVO;
import com.erp.controller.stock.vo.ProductVO;
import com.erp.controller.subcontractCancel.vo.GatherBillVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 库存 dao
 * @author guo
 *
 */
public class ProductDAO extends BaseDAO<ProductVO>{
	private ProductVO product=null;
	
	//	根据条件进行搜索
	public List<OutBillVO> findByBillCode(String billCode) {
		try {
			/**
			 * 货物单号	billCode（待确定）	
			 */
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<OutBillVO> products =session.createQuery
					("from ProductVO where billCode like ? ").setString(0, "%"+billCode+"%").list();
			session.close();
			return products;
		}catch (Exception e) {
			return null;
		}	
	}

	
}