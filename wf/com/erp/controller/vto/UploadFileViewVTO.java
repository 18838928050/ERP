/**
 * 
 */
package com.erp.controller.vto;


import java.util.List;

import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.WorkCenter;
import com.erp.model.vo.WorkCenterVO;

/**
 @author： 如约而至    @time：2017年12月3日 下午7:01:27 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class UploadFileViewVTO {
	private List<EstablishmentVO> establishmentVOs;
	private List<AccessoryVO> accessoryVOs;
	private List<WorkCenterVO> workCenterVOs;
	private List<BusinessBillVO> businessBillVOs;
	
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	public List<AccessoryVO> getAccessoryVOs() {
		return accessoryVOs;
	}
	public void setAccessoryVOs(List<AccessoryVO> accessoryVOs) {
		this.accessoryVOs = accessoryVOs;
	}
	public List<WorkCenterVO> getWorkCenterVOs() {
		return workCenterVOs;
	}
	public void setWorkCenterVOs(List<WorkCenterVO> workCenterVOs) {
		this.workCenterVOs = workCenterVOs;
	}
	public List<BusinessBillVO> getBusinessBillVOs() {
		return businessBillVOs;
	}
	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}
	
}
