package com.erp.model.vo;

import java.util.Date;

public class UserVO {
		public static final int SUPER_MANAGER = 1;
		public static final int GENERAL_STAFFER = 0;
		private long id;
		private String userName;
		private String password;
		private long stafferId = 0L;
		private int userType = 0;
		private String enabled = "Y";
		private int tryNum = 0;
		private String locked = "N";
		private Date lockTime;
		private String useValidity = "N";
		private Date validity;
		private long dfTsId = 0L;
		private long dfBaId = 0L;
		private String timeLimit = "N";
		private int tlStartHour = 8;
		private int tlStartMinute = 0;
		private int tlEndHour = 19;
		private int tlEndMinute = 0;
		private String allowInternet = "Y";
		private Date lastLogin;
		private String useApp = "Y";

		public long getDfBaId() {
			return this.dfBaId;
		}

		public void setDfBaId(long dfBaId) {
			this.dfBaId = dfBaId;
		}

		public String getUseApp() {
			return this.useApp;
		}

		public void setUseApp(String useApp) {
			this.useApp = useApp;
		}

		public Date getLastLogin() {
			return this.lastLogin;
		}

		public void setLastLogin(Date lastLogin) {
			this.lastLogin = lastLogin;
		}

		public String getEnabled() {
			return this.enabled;
		}

		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}

		public long getId() {
			return this.id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public long getStafferId() {
			return this.stafferId;
		}

		public void setStafferId(long stafferId) {
			this.stafferId = stafferId;
		}

		public String getUserName() {
			return this.userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getUserType() {
			return this.userType;
		}

		public void setUserType(int userType) {
			this.userType = userType;
		}

		public String getLocked() {
			return this.locked;
		}

		public void setLocked(String locked) {
			this.locked = locked;
		}

		public Date getLockTime() {
			return this.lockTime;
		}

		public void setLockTime(Date lockTime) {
			this.lockTime = lockTime;
		}

		public int getTryNum() {
			return this.tryNum;
		}

		public void setTryNum(int tryNum) {
			this.tryNum = tryNum;
		}

		public String getUseValidity() {
			return this.useValidity;
		}

		public void setUseValidity(String useValidity) {
			this.useValidity = useValidity;
		}

		public Date getValidity() {
			return this.validity;
		}

		public void setValidity(Date validity) {
			this.validity = validity;
		}

		public long getDfTsId() {
			return this.dfTsId;
		}

		public void setDfTsId(long dfTsId) {
			this.dfTsId = dfTsId;
		}

		public String getAllowInternet() {
			return this.allowInternet;
		}

		public void setAllowInternet(String allowInternet) {
			this.allowInternet = allowInternet;
		}

		public String getTimeLimit() {
			return this.timeLimit;
		}

		public void setTimeLimit(String timeLimit) {
			this.timeLimit = timeLimit;
		}

		public int getTlEndHour() {
			return this.tlEndHour;
		}

		public void setTlEndHour(int tlEndHour) {
			this.tlEndHour = tlEndHour;
		}

		public int getTlEndMinute() {
			return this.tlEndMinute;
		}

		public void setTlEndMinute(int tlEndMinute) {
			this.tlEndMinute = tlEndMinute;
		}

		public int getTlStartHour() {
			return this.tlStartHour;
		}

		public void setTlStartHour(int tlStartHour) {
			this.tlStartHour = tlStartHour;
		}

		public int getTlStartMinute() {
			return this.tlStartMinute;
		}

		public void setTlStartMinute(int tlStartMinute) {
			this.tlStartMinute = tlStartMinute;
		}

		@Override
		public String toString() {
			return "UserVO [id=" + id + ", userName=" + userName
					+ ", password=" + password + ", stafferId=" + stafferId
					+ ", userType=" + userType + ", enabled=" + enabled
					+ ", tryNum=" + tryNum + ", locked=" + locked
					+ ", lockTime=" + lockTime + ", useValidity=" + useValidity
					+ ", validity=" + validity + ", dfTsId=" + dfTsId
					+ ", dfBaId=" + dfBaId + ", timeLimit=" + timeLimit
					+ ", tlStartHour=" + tlStartHour + ", tlStartMinute="
					+ tlStartMinute + ", tlEndHour=" + tlEndHour
					+ ", tlEndMinute=" + tlEndMinute + ", allowInternet="
					+ allowInternet + ", lastLogin=" + lastLogin + ", useApp="
					+ useApp + "]";
		}
		
		
	}