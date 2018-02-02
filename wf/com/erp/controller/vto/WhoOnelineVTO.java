/**
 * 
 */
package com.erp.controller.vto;

import antlr.collections.List;

import com.erp.model.vo.SystemLog;

/**
 @author： 如约而至    @time：2017年12月3日 上午11:57:24 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class WhoOnelineVTO {
	private SystemLog systemLog;
	private java.util.List<SystemLog> systemLogs;
	

	public java.util.List<SystemLog> getSystemLogs() {
		return systemLogs;
	}

	public void setSystemLogs(java.util.List<SystemLog> systemLogs) {
		this.systemLogs = systemLogs;
	}

	public SystemLog getSystemLog() {
		return systemLog;
	}

	public void setSystemLog(SystemLog systemLog) {
		this.systemLog = systemLog;
	}

}
