/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

public class EstablishmentContactVO {
	public static final String EST_TYPE_CLIENT = "CLIENT";
	public static final String EST_TYPE_PROVIDER = "PROVIDER";
	public static final String EST_TYPE_COOPERATOR = "COOPERATOR";
	private long id;
	private long estId = 0L;
	private String contactName;
	private String sex;
	private String possie;
	private String mobile;
	private String phone;
	private String email;
	private String im;
	private String mark;
	private String isMain = "N";
	private String tmpCode;

	public String getTmpCode() {
		return this.tmpCode;
	}

	public void setTmpCode(String tmpCode) {
		this.tmpCode = tmpCode;
	}

	public String getIsMain() {
		return this.isMain;
	}

	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getEstId() {
		return this.estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIm() {
		return this.im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPossie() {
		return this.possie;
	}

	public void setPossie(String possie) {
		this.possie = possie;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EstablishmentContactVO [id=" + id + ", estId=" + estId
				+ ", contactName=" + contactName + ", sex=" + sex + ", possie="
				+ possie + ", mobile=" + mobile + ", phone=" + phone
				+ ", email=" + email + ", im=" + im + ", mark=" + mark
				+ ", isMain=" + isMain + ", tmpCode=" + tmpCode + "]";
	}
	
}