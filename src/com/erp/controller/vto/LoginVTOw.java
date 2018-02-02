package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.TallySetVO;

public class LoginVTOw {
	
/*	private String userName;
	private String passWord;
	private int tryNum;*/
	
	//user表中编辑身份人员的id:staffer_id
	private Long stafferID;
	
	private String userName;
	private String passWord;
	
	//private String returValueString;
	
	//权限id
	private Long privilegesID;
	//权限代码
	private String privilegeCode;
	//用户id
	private Long userID;
	//用户拥有的权限集合
	private List<String> privileges;
	//用户登录次数	
	private int tryNum;
	//用户默认帐套,为0则无默认，否则为帐套id
	private Long tallySetID;
	
	private String tallyTitle;
	private List<TallySetVO> tallySetList;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Long getPrivilegesID() {
		return privilegesID;
	}
	public void setPrivilegesID(Long privilegesID) {
		this.privilegesID = privilegesID;
	}
	public String getPrivilegeCode() {
		return privilegeCode;
	}
	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public List<String> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}
	public int getTryNum() {
		return tryNum;
	}
	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}
	public Long getTallySetID() {
		return tallySetID;
	}
	public void setTallySetID(Long tallySetID) {
		this.tallySetID = tallySetID;
	}
	public String getTallyTitle() {
		return tallyTitle;
	}
	public void setTallyTitle(String tallyTitle) {
		this.tallyTitle = tallyTitle;
	}
	public List<TallySetVO> getTallySetList() {
		return tallySetList;
	}
	public void setTallySetList(List<TallySetVO> tallySetList) {
		this.tallySetList = tallySetList;
	}
	public Long getStafferID() {
		return stafferID;
	}
	public void setStafferID(Long stafferID) {
		this.stafferID = stafferID;
	}
	@Override
	public String toString() {
		return "LoginVTO [stafferID=" + stafferID + ", userName=" + userName
				+ ", passWord=" + passWord + ", privilegesID=" + privilegesID
				+ ", privilegeCode=" + privilegeCode + ", userID=" + userID
				+ ", privileges=" + privileges + ", tryNum=" + tryNum
				+ ", tallySetID=" + tallySetID + ", tallyTitle=" + tallyTitle
				+ ", tallySetList=" + tallySetList + "]";
	}
	
	 

}
