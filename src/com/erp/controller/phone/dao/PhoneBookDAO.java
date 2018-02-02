package com.erp.controller.phone.dao;


import java.util.List;

import org.hibernate.Session;

import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.phone.vo.PhoneBookVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;

/**
 * 通讯录 联系人 dao
 * @author guo
 *
 */
public class PhoneBookDAO extends BaseDAO<PhoneBookVO>{
	//查询登录用户下的联系人
	public List<PhoneBookVO> findByStafferId(long stafferId){
		try {
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<PhoneBookVO> phoneBooks =session.createQuery("from PhoneBookVO where stafferId = ?").setLong(0, stafferId).list();
			session.close();
			return phoneBooks;
		}catch (Exception e) {
			return null;
		}
	}
}
