package com.erp.model.dao;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.UserVO;

public class LoginDAO extends BaseDAO<UserVO> {
	
	
	public void saveUserVO(UserVO userVO) {
//		save(userVO);
	}
	
	
	 /**
	  * 通过name,password获得  对应的实体类id值
	  * 如果未查询到  返回 null
	  * @param name
	  * @param password
	  * @return userID
	  */
	 public Long getIdByLogin(String userName,String password) throws Exception {
		if (userName == null || "".equals(userName) || password == null || "".equals(password)) {
			 return null;
			 }else {
			 
				 Session session=HibernateUtils.getSession();
				 session.beginTransaction();
				 Long id =  (Long) session.getNamedQuery("selectIDByLogin")
						 .setString("loginName",userName)
						 .setString("loginPassword", password)
						 .uniqueResult();
				 System.out.println("id is " + id);
				 session.close();
				return id;
				}
			}

	
	
	
	 /**
	  * 通过name,password获得  对应的实体类id值
	  * 如果未查询到  返回 null
	  * @param name
	  * @param password
	  * @return userID
	  */
	 public UserVO getVOByLogin(String userName,String password) throws Exception {
		if (userName == null || "".equals(userName) || password == null || "".equals(password)) {
			 return null;
			 }else {
				 Session session=HibernateUtils.getSession();
				 session.beginTransaction();
				 UserVO userVO =  (UserVO) session.getNamedQuery("selectVOByLogin")
						 .setString("loginName",userName)
						 .setString("loginPassword", password)
						 .uniqueResult();
				 System.out.println(" UserVO getVOByLogin(========================");
				 session.close();
				 return userVO;
				}
			}	 
}
