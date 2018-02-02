package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.WorkCenterVO;

public class MakeBillVTOw {
	
	
	private List<BusinessBillItemVO> businessBillItemVOs;
	
	private  List<BusinessBillVO> businessBillVOs;
	private List<EstablishmentVO> establishmentVOs;
	private List<BusinessBillExtVO> businessBillExtVOs;
	private List<WorkCenterVO> workCenterVOs;
	private List<BusinessBillItemExtVO> businessBillItemExtVOs;
	
	
	
	
	public List<BusinessBillItemVO> getBusinessBillItemVOs() {
		return businessBillItemVOs;
	}
	public void setBusinessBillItemVOs(List<BusinessBillItemVO> businessBillItemVOs) {
		this.businessBillItemVOs = businessBillItemVOs;
	}
	public List<BusinessBillVO> getBusinessBillVOs() {
		
		
		return businessBillVOs;
	}
	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	public List<BusinessBillExtVO> getBusinessBillExtVOs() {
		return businessBillExtVOs;
	}
	public void setBusinessBillExtVOs(List<BusinessBillExtVO> businessBillExtVOs) {
		this.businessBillExtVOs = businessBillExtVOs;
	}
	public List<WorkCenterVO> getWorkCenterVOs() {
		return workCenterVOs;
	}
	public void setWorkCenterVOs(List<WorkCenterVO> workCenterVOs) {
		this.workCenterVOs = workCenterVOs;
	}
	public List<BusinessBillItemExtVO> getBusinessBillItemExtVOs() {
		return businessBillItemExtVOs;
	}
	public void setBusinessBillItemExtVOs(List<BusinessBillItemExtVO> businessBillItemExtVOs) {
		this.businessBillItemExtVOs = businessBillItemExtVOs;
	}
	
	
	

}
