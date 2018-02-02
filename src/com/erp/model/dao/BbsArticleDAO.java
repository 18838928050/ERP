package com.erp.model.dao;

import java.util.List;


import org.hibernate.Session;

import com.erp.model.vo.BbsArticle;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.StafferVO;

/**
 * 
 * @author WangEn
 *
 */
public class BbsArticleDAO extends BaseDAO<BbsArticle>{
	public List<BbsArticle> findByBbsColumnId(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<BbsArticle> list= session.createQuery("from BbsArticle where columnId = ? order by sequenceCode desc").setLong(0, id).list();
		session.close();
		return list;
	}

}
