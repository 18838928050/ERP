package com.erp.controller.mgr;

import java.util.List;

import com.erp.controller.vto.LoginVTOw;
import com.erp.err.PasswordErrorException;
import com.erp.err.UserNotFoundException;
import com.erp.model.dao.LoginDAO;
import com.erp.model.dao.TallySetDAO;
import com.erp.model.dao.UserPrivilegeDAO;
import com.erp.model.vo.TallySetVO;
import com.erp.model.vo.UserVO;

public class LoginMgr {
	
	private LoginDAO loginDAO = new LoginDAO();
	private UserPrivilegeDAO userPrivilegeDAO;
	private TallySetDAO tallySetDAO;
	private TallySetVO tallySetVO;
	private Long userID;
	private UserVO userVO;
	
	//根据用户id，获取当前用户所属帐套，如果没有帐套，弹出选择框，让当前用户选择帐套
		public TallySetVO getTallySetVO(Long userID) {
			
			tallySetDAO = new TallySetDAO();
			tallySetVO = tallySetDAO.getTallySetVO(userID);
			if (tallySetVO != null) {
				return tallySetVO;
			}		
			else {
				return null;
			}
		}
		
		public List<String> getPrivilegeList(Long userID)	{
			userPrivilegeDAO = new UserPrivilegeDAO();
			return userPrivilegeDAO.getPrivileges(userID);		
		}
	
	
	public LoginVTOw login(LoginVTOw loginVTO) {
		try {
			userVO = loginDAO.getVOByLogin(loginVTO.getUserName(), loginVTO.getPassWord());	
			
//			System.out.println("com.erp.controller.vto.LoginVTO获得编辑人员Stafferid:"+userVO.getStafferId());
			
			//如果用户名称或密码错误的话 结果就是没查到
			if(null==userVO){
				loginVTO.setUserID(null);
				return loginVTO;
			}
			
			
			System.out.println("userVO:"+userVO);
			//if userVO == null   return "input" or "error"
			userID = userVO.getId();
			//如果User中dfTsId为0的话 tallySetVO为空
			TallySetVO tallySetVO = this.getTallySetVO(userID);
			
			List<String> privileges = this.getPrivilegeList(userID);
			
			List<TallySetVO> list = tallySetDAO.getTallySetList();
			
			
			
			//获得当前登录用户ID
			loginVTO.setUserID(userID);
			
			//设置当前用户id拥有的权限列表
			loginVTO.setPrivileges(privileges);	
			
			//设置当前所有帐套和默认帐套
			loginVTO.setTallySetList(list);
			
			//user表中编辑身份人员的id:staffer_id
			loginVTO.setStafferID(userVO.getStafferId());
			
			
			//获得当前用户帐套title,如果当前用户数据库中无对应帐套，则帐套ID设为0
			if ((userVO.getDfTsId() == 0) || (tallySetVO == null)) {
				loginVTO.setTallySetID(Long.parseLong("0"));
				loginVTO.setTallyTitle("0");
			}else {
				//获得当前用户帐套id,此时当前用户帐套必属于1:新异;2:网络公司
				loginVTO.setTallySetID(tallySetVO.getId());
				loginVTO.setTallyTitle(tallySetVO.getTitle());
			}	
			
			System.out.println("LoginMgr==========");
			System.out.println(loginVTO);
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return loginVTO;
	}
	
	
	
	
	
	
	
	
	/*public void login(String username, String password) {
		if (!"admin".equals(username)) {
			throw new UserNotFoundException();
		}
		if (!"admin".equals(password)) {
			throw new PasswordErrorException();
		}
	}*/
}
