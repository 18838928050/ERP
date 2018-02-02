package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.TallySetVO;

/**
 @author：半缘修道半缘君    @time：2017年8月28日 下午3:25:19 
 **************************************************************************************************************************************
 @说明： 
 **************************************************************************************************************************************/
public class TallySetDAO extends BaseDAO<TallySetVO>{
	
	public List<TallySetVO> getTallySetList() {
		List<TallySetVO> tallySetList;
		try {
			Session session = HibernateUtils.getSession();
			session.beginTransaction();
			String hql = "from TallySetVO";
			tallySetList = session.createQuery(hql)
					.list();
			session.close();
			
			} catch (Exception e) {
				e.printStackTrace();
				tallySetList = null;
			}		
		return tallySetList;
	}
	

	public TallySetVO getTallySetVO(Long userID) {
	try {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select t from TallySetVO as t,UserVO as u where u.id=:myID and u.dfTsId = t.id";
		TallySetVO tallySetVO = (TallySetVO) session.createQuery(hql)
				.setLong("myID", userID).uniqueResult();
		
		System.out.println("123");
		
		System.out.println("com.erp.model.dao.TallySetDAO.getTallySet().tallySetVO :"
				+ tallySetVO.toString());
		session.close();
		return tallySetVO;
		} catch (Exception e) {
			//如果User中dfTsId为0的话 查询出的必定是空指针异常
			//e.printStackTrace();
			return null;
		}		
	}
	  
	
	
		
	

}
