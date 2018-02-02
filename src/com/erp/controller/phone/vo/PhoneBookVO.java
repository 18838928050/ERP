package com.erp.controller.phone.vo;

//通讯录	联系人
public class PhoneBookVO {
	private long id;
	private long stafferId = 0L;//归属用户的id
	private String perName;//姓名
	private String pnSpell;
	private String mobile;//手机号
	private String companyName;//公司
	private String possie;//职位
	private String qq;//qq
	private String email;
	private String phone;
	private String fax;
	private String mark;

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPossie() {
		return this.possie;
	}

	public void setPossie(String possie) {
		this.possie = possie;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public long getStafferId() {
		return this.stafferId;
	}

	public void setStafferId(long stafferId) {
		this.stafferId = stafferId;
	}

	public String getPnSpell() {
		return this.pnSpell;
	}

	public void setPnSpell(String pnSpell) {
		this.pnSpell = pnSpell;
	}

	@Override
	public String toString() {
		return "PhoneBookVO [id=" + id + ", stafferId=" + stafferId + ", perName=" + perName + ", pnSpell=" + pnSpell
				+ ", mobile=" + mobile + ", companyName=" + companyName + ", possie=" + possie + ", qq=" + qq
				+ ", email=" + email + ", phone=" + phone + ", fax=" + fax + ", mark=" + mark + "]";
	}
	
}