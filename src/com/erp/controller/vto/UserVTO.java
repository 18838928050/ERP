package com.erp.controller.vto;


import java.util.Date;
import java.util.List;

import com.erp.model.vo.StafferVO;
import com.erp.model.vo.UserVO;

public class UserVTO {

	private UserVO userVO;
	private StafferVO stafferVO;
	private String stafferName;
	private String currentPassword;
	private String oldPassword;
	private List tallySets;
	private List workCenters;
	private String validityStr;
	private String overdue = "N";
	private String dfTsName;
	private String needTsSelect = "Y";
	private String depName;
	private String confirmPassword;
	private Date preLogin = null;
	private String privs;
	private String tsPrivs;
	private String wcPrivs;
	private String baPrivs;

	public String getPrivs() {
		return this.privs;
	}

	public void setPrivs(String privs) {
		this.privs = privs;
	}

	public String getTsPrivs() {
		return this.tsPrivs;
	}

	public void setTsPrivs(String tsPrivs) {
		this.tsPrivs = tsPrivs;
	}

	public String getWcPrivs() {
		return this.wcPrivs;
	}

	public void setWcPrivs(String wcPrivs) {
		this.wcPrivs = wcPrivs;
	}

	public String getBaPrivs() {
		return this.baPrivs;
	}

	public void setBaPrivs(String baPrivs) {
		this.baPrivs = baPrivs;
	}

	public Date getPreLogin() {
		return this.preLogin;
	}

	public void setPreLogin(Date preLogin) {
		this.preLogin = preLogin;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public UserVO getUserVO() {
		return this.userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public StafferVO getStafferVO() {
		return this.stafferVO;
	}

	public void setStafferVO(StafferVO stafferVO) {
		this.stafferVO = stafferVO;
	}

	public String getStafferName() {
		return this.stafferName;
	}

	public void setStafferName(String stafferName) {
		this.stafferName = stafferName;
	}

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getOldPassword() {
		return this.oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getValidityStr() {
		return this.validityStr;
	}

	public void setValidityStr(String validityStr) {
		this.validityStr = validityStr;
	}

	public String getOverdue() {
		return this.overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}

	public List getTallySets() {
		return this.tallySets;
	}

	public void setTallySets(List tallySets) {
		this.tallySets = tallySets;
	}

	public String getDfTsName() {
		return this.dfTsName;
	}

	public void setDfTsName(String dfTsName) {
		this.dfTsName = dfTsName;
	}

	public String getNeedTsSelect() {
		return this.needTsSelect;
	}

	public void setNeedTsSelect(String needTsSelect) {
		this.needTsSelect = needTsSelect;
	}

	public List getWorkCenters() {
		return this.workCenters;
	}

	public void setWorkCenters(List workCenters) {
		this.workCenters = workCenters;
	}
}