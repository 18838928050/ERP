package com.erp.model.vo;

import java.util.Date;

public class StafferVO {

		public static final String CODE_RULE = "STAFFER";
		public static final String MAN = "MAN";
		public static final String FEMALE = "FEMALE";
		private long id;
		private String stafferCode;
		private String stafferName;
		private String sex = "MAN";
		private Date birthday;
		private String origin;
		private String household;
		private String mobile;
		private String phone;
		private String address;
		private long departmentId = 0L;
		private String possie;
		private long superiorId = 0L;
		private String superiorIdStr;
		private Date inDate;
		private String enabled = "Y";
		private String accessory;
		private String mark;
		private String nameSpell;
		private Date leaveDate;
		private String certName;
		private String certCode;
		private String image;
		private String subPhone;
		private String subMobile;
		private String qq;
		private String email;
		private String headImage;

		public String getHeadImage() {
			return this.headImage;
		}

		public void setHeadImage(String headImage) {
			this.headImage = headImage;
		}

		public String getSubPhone() {
			return this.subPhone;
		}

		public void setSubPhone(String subPhone) {
			this.subPhone = subPhone;
		}

		public String getSubMobile() {
			return this.subMobile;
		}

		public void setSubMobile(String subMobile) {
			this.subMobile = subMobile;
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

		public void setImage(String image) {
			this.image = image;
		}

		public String getImage() {
			return this.image;
		}

		public String getCertCode() {
			return this.certCode;
		}

		public void setCertCode(String certCode) {
			this.certCode = certCode;
		}

		public String getCertName() {
			return this.certName;
		}

		public void setCertName(String certName) {
			this.certName = certName;
		}

		public Date getLeaveDate() {
			return this.leaveDate;
		}

		public void setLeaveDate(Date leaveDate) {
			this.leaveDate = leaveDate;
		}

		public String getNameSpell() {
			return this.nameSpell;
		}

		public void setNameSpell(String nameSpell) {
			this.nameSpell = nameSpell;
		}

		public String getAccessory() {
			return this.accessory;
		}

		public void setAccessory(String accessory) {
			this.accessory = accessory;
		}

		public String getAddress() {
			return this.address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Date getBirthday() {
			return this.birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getEnabled() {
			return this.enabled;
		}

		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}

		public String getHousehold() {
			return this.household;
		}

		public void setHousehold(String household) {
			this.household = household;
		}

		public long getId() {
			return this.id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Date getInDate() {
			return this.inDate;
		}

		public void setInDate(Date inDate) {
			this.inDate = inDate;
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

		public String getOrigin() {
			return this.origin;
		}

		public void setOrigin(String origin) {
			this.origin = origin;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPossie() {
			return this.possie;
		}

		public void setPossie(String possie) {
			this.possie = possie;
		}

		public String getSex() {
			return this.sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getStafferCode() {
			return this.stafferCode;
		}

		public void setStafferCode(String stafferCode) {
			this.stafferCode = stafferCode;
		}

		public String getStafferName() {
			return this.stafferName;
		}

		public void setStafferName(String stafferName) {
			this.stafferName = stafferName;
		}

		public long getDepartmentId() {
			return this.departmentId;
		}

		public void setDepartmentId(long departmentId) {
			this.departmentId = departmentId;
		}

		public long getSuperiorId() {
			return this.superiorId;
		}

		public void setSuperiorId(long superiorId) {
			this.superiorId = superiorId;
		}

		public String getSuperiorIdStr() {
			return this.superiorIdStr;
		}

		public void setSuperiorIdStr(String superiorIdStr) {
			this.superiorIdStr = superiorIdStr;
		}
	}