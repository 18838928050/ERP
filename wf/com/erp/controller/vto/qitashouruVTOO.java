/**
 * 
 */
package com.erp.controller.vto;

import com.erp.model.vo.iBean;
import com.erp.model.vo.qitashourufangshenheBean;

/**
 * @author：fu
 * @date 2017年12月21日 下午12:46:03 一份耕耘，一份收获*****
 */
public class qitashouruVTOO {
	private iBean iBean;
	private qitashourufangshenheBean qitashourufangshenheBean;

	public qitashourufangshenheBean getQitashourufangshenheBean() {
		return qitashourufangshenheBean;
	}

	public void setQitashourufangshenheBean(qitashourufangshenheBean qitashourufangshenheBean) {
		this.qitashourufangshenheBean = qitashourufangshenheBean;
	}

	public iBean getiBean() {
		return iBean;
	}

	public void setiBean(iBean iBean) {
		this.iBean = iBean;
	}
}
