package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.StorehouseVO;

public class StoreHouseDAOw extends BaseDAOw<StorehouseVO> {

	public List<StorehouseVO> findStoresByPbIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<StorehouseVO> storehouseVOs = new ArrayList<StorehouseVO>();
		for (long long2 : ids) {
			storehouseVOs.add(session.get(StorehouseVO.class, long2));
		}
		return storehouseVOs;
	}
	public List<List<StorehouseVO>> getStoreHousesByBillIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<StorehouseVO>> sLists = new ArrayList<List<StorehouseVO>>();
		List<StorehouseVO> storehouseVOs = new ArrayList<StorehouseVO>();
		for (Long long1 : ids) {
			storehouseVOs = session.createQuery("from StorehouseVO where id='" + long1 + "'")
					.list();
			sLists.add(storehouseVOs);
		}
		return sLists;
	}

	public StorehouseVO getStoreHouseByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		long id2 = (long) session.createQuery(
				"select storehouseId from PurchaseBillVO where id='" + id + "' ").uniqueResult();
		Criteria criteria = session.createCriteria(StorehouseVO.class);
		criteria.add(Restrictions.in("id", id2));
		return (StorehouseVO) criteria.uniqueResult();
	}

}
