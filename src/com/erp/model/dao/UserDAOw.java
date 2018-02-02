package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.UserVO;

/**
 * 用户表  dao
 * @author JiaQi
 *
 */
public class UserDAOw extends BaseDAOw<UserVO>{
	/**
	 * 通过 userName查找信息
	 */
	public List<UserVO> findByUserName(String userName) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<UserVO> list= session.createQuery("from UserVO where userName = ?").setString(0, userName).list();
		session.close();
		return list;
	}
	
	/**
	 * 通过账号查找
	 */
	public UserVO findByUserNameToVO(String userName) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		UserVO user = (UserVO)session.createQuery("from UserVO where userName = ?").setString(0, userName).uniqueResult();
		session.close();
		return user;
	}

	/**
	 * @说明：
	 */
	public List<UserVO> getAllUserEnabledY() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
	   return	session.createQuery("from UserVO where enabled='Y'").list();
	}

}
