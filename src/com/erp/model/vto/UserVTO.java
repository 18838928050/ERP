package com.erp.model.vto;
/**
 * 用户  
 * 里面包含着   user  和  staffer
 * @author JiaQi
 *
 */

import com.erp.model.vo.StafferVO;
import com.erp.model.vo.UserVO;

public class UserVTO {
	private UserVO user;
	private StafferVO staffer;
	
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public StafferVO getStaffer() {
		return staffer;
	}
	public void setStaffer(StafferVO staffer) {
		this.staffer = staffer;
	}
}
