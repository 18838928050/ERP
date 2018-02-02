package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;

public class YewumingxiyilanbiaoVTO {
	private List<BusinessBillVO> businessBillVOs;
	private List<BusinessBillItemVO> businessBillItemVOs;
	private List<BusinessBillItemExtVO> businessBillItemExtVOs;
	private List<EstablishmentVO> establishmentVOs;
	public List<BusinessBillVO> getBusinessBillVOs() {
		return businessBillVOs;
	}
	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}
	public List<BusinessBillItemVO> getBusinessBillItemVOs() {
		return businessBillItemVOs;
	}
	public void setBusinessBillItemVOs(List<BusinessBillItemVO> businessBillItemVOs) {
		this.businessBillItemVOs = businessBillItemVOs;
	}
	public List<BusinessBillItemExtVO> getBusinessBillItemExtVOs() {
		return businessBillItemExtVOs;
	}
	public void setBusinessBillItemExtVOs(List<BusinessBillItemExtVO> businessBillItemExtVOs) {
		this.businessBillItemExtVOs = businessBillItemExtVOs;
	}
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	

}
