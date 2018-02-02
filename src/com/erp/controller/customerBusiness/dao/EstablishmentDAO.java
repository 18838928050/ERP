package com.erp.controller.customerBusiness.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.EstablishmentVO;
/**
 * 客户表 dao
 * @author guo
 */
public class EstablishmentDAO extends BaseDAO<EstablishmentVO>{
	/**
	 * 判断客户是否存在
	 * @param stafferName
	 * @return
	 */
	public List<EstablishmentVO> findByEstName(String estName) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<EstablishmentVO> establishments =session.createQuery("from EstablishmentVO where estName like ?").setString(0, "%"+estName+"%").list();
			session.close();
			return establishments;
		}catch (Exception e) {
			return null;
		}	
	}
	
//	客户表中的客户	客户中有其它type
	public List<EstablishmentVO> findAllProvider(String estName) {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<EstablishmentVO> establishments =session.createQuery("from EstablishmentVO where estType = ?").setString(0, "PROVIDER").list();
			session.close();
			return establishments;
		}catch (Exception e) {
			return null;
		}	
	}
//	最大的id
	public Integer findMaxId() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			Object uniqueResult = session.createQuery("select max(id) from EstablishmentVO").uniqueResult();
			session.close();
			return Integer.valueOf(String.valueOf(uniqueResult));
		}catch (Exception e) {
			return 0;
		}	
	}
	
//	id and name
	public HashMap<Long, String> findIdAndName() {
		HashMap<Long, String> establishments2 = null;
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<EstablishmentVO> establishments = session.createQuery("from EstablishmentVO ").list();
			for (EstablishmentVO establishmentVO : establishments) {
				establishments2.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
			return establishments2;
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return establishments2;	
	}

	public List<EstablishmentVO> getAllEsByT() {
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<EstablishmentVO> establishments =session.createQuery("from EstablishmentVO where estCode like ? and enabled=?").setString(0, "T%").setString(1, "Y").list();
			session.close();
			return establishments;
		}catch (Exception e) {
			return null;
		}	
	}

	public void start(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String sql="update EstablishmentVO set status ='Y' where id='"+id+"'";
		session.createQuery(sql).executeUpdate();
		session.getTransaction().commit();
		
	}

	public void stop(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		String sql="update EstablishmentVO set status ='N' where id='"+id+"'";
		session.createQuery(sql).executeUpdate();
		session.getTransaction().commit();
		
	}
	
	
}