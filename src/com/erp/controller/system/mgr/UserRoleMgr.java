package com.erp.controller.system.mgr;

import java.util.List;

import com.erp.model.dao.UserDAOw;
import com.erp.model.vo.UserVO;

/**
 *用户权限 逻辑处理
 * @author JiaQi
 *
 */
public class UserRoleMgr {
//	创建dao层对象
	private UserDAOw userDAO = new UserDAOw();
	
	/**
	 * 获取全部用户
	 */
	public List<UserVO> findAll(){
		try{
			return userDAO.findAll();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("获取用户列表错误！");
			return null;
		}
	}
	
	/**
	 * 通过id删除用户
	 */
	public void delById(Long id){
		try {
			userDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("用户删除错误！"+id);
		}
	}
	
	/**
	 * 通过id查找用户
	 */
	public UserVO findById(Long id){
		try {
			UserVO user = userDAO.getById(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查找用户错误！"+id);
			return null;
		}
	}
	
	/**
	 * 通过id  停用账户
	 * @param id
	 */
	public void setAbled(long id,String abled) {
		try{
			UserVO userVO = new UserVO();
			userVO = userDAO.getById(id);
			userVO.setEnabled(abled);
			userDAO.update(userVO);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("设置用户状态失败！");
		}
	}
	
	/**
	 * 用户搜索
	 * @param userName 
	 */
	public List<UserVO> findUser(String userName){
		return userDAO.findByUserName(userName);
	}
	
	/**
	 * 更新
	 */
	public void save(UserVO userVO){
		try {
			userDAO.save(userVO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存失败！");
		}
	}
	
	/**
	 * 通过 用户名查找
	 */
	public UserVO findByUserNameToVO(String userName){
		return userDAO.findByUserNameToVO(userName);
	}

//	更新用户
	public void update(UserVO userVO) {
		try {
			userDAO.update(userVO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存失败！");
		}
	}
}
