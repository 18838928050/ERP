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
public class UserDAO extends BaseDAO<UserVO>{
	/**
	 * 通过 userName查找信息 模糊查询
	 */
	public List<UserVO> findByUserName(String userName) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<UserVO> list= session.createQuery("from UserVO where userName like ?").setString(0, "%"+userName+"%").list();
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
	 * 通过  stafferid 查询
	 */
	public UserVO findByStafferId(Long stafferId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		UserVO user = (UserVO)session.createQuery("from UserVO where stafferId = ?").setLong(0, stafferId).uniqueResult();
		session.close();
		return user;
	}

}
