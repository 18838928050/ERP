package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.TallySetVO;

/**
 * @author：半缘修道半缘君 @time：2017年8月28日 下午3:25:19
 **************************************************************************************************************************************
 @说明：
 **************************************************************************************************************************************/
public class TallySetDAOw extends BaseDAOw<TallySetVO> {
	
	public List<TallySetVO> getSetVOsByIds(List<Long> ids) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<TallySetVO>dd=new ArrayList<TallySetVO>();
		for (Long long1 : ids) {
			 dd.add( session.get(TallySetVO.class, long1));
		}
		return dd;
	}

	public List<TallySetVO> getTallySetList() {
		List<TallySetVO> tallySetList;
		try {
			Session session = HibernateUtils.getSession();
			session.beginTransaction();
			String hql = "from TallySetVO";
			tallySetList = session.createQuery(hql).list();
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
			TallySetVO tallySetVO = (TallySetVO) session.createQuery(hql).setLong("myID", userID)
					.uniqueResult();

			System.out.println("123");

			System.out.println("com.erp.model.dao.TallySetDAO.getTallySet().tallySetVO :"
					+ tallySetVO.toString());
			session.close();
			return tallySetVO;
		} catch (Exception e) {
			// 如果User中dfTsId为0的话 查询出的必定是空指针异常
			// e.printStackTrace();
			return null;
		}
	}

	public TallySetVO getTallySetByFeeBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(TallySetVO.class);
		criteria.add(Restrictions.in("id", id));
		return (TallySetVO) criteria.uniqueResult();
	}

	public TallySetVO findTallySetByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		long tallySetId=(long) session.createQuery("select tallySetId from PurchaseBillVO where id='"+id+"'").uniqueResult();
		Criteria criteria = session.createCriteria(TallySetVO.class);
		criteria.add(Restrictions.in("id", tallySetId));
		return (TallySetVO) criteria.uniqueResult();
	}

}
