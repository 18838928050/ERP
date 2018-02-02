package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ProductTypeVO;

public class ProductTypeDAOw extends BaseDAOw<ProductTypeVO>{

	public List<ProductTypeVO> findPsByProIds(List<Long> productTypeIds) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		ProductTypeVO productTypeVO=new ProductTypeVO();
		List<ProductTypeVO> productTypeVOs=new ArrayList<ProductTypeVO>();
		for (Long long1 : productTypeIds) {
			productTypeVO=(ProductTypeVO) session.createQuery("from ProductTypeVO where id='"+long1+"'").uniqueResult();
			productTypeVOs.add(productTypeVO);
		}
		return productTypeVOs;
	}
}
