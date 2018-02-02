package com.erp.controller.vto;

import java.util.List;

import com.erp.controller.customerBusiness.vo.EstablishmentContactVO;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;

public class WaixieshangdengjiVTO {
	
	
	
	
	
//	客户
	private EstablishmentVO establishment ;
	private List<EstablishmentVO> establishmentVOs;
	private List<CooperBillVO> cooperBillVOs;
	private List<MakeTypeVO> makeTypeVOs;
	private List<List<CooperBillItemVO>> cList;
//	联系人
	private List<EstablishmentContactVO> establishmentContact;

	


	public List<List<CooperBillItemVO>> getcList() {
		return cList;
	}

	public void setcList(List<List<CooperBillItemVO>> cList) {
		this.cList = cList;
	}

	public List<CooperBillVO> getCooperBillVOs() {
		return cooperBillVOs;
	}

	public void setCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		this.cooperBillVOs = cooperBillVOs;
	}


	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}

	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public EstablishmentVO getEstablishment() {
		return establishment;
	}
	
	public void setEstablishment(EstablishmentVO establishment) {
		this.establishment = establishment;
	}

	public List<EstablishmentContactVO> getEstablishmentContact() {
		return establishmentContact;
	}

	public void setEstablishmentContact(List<EstablishmentContactVO> establishmentContact) {
		this.establishmentContact = establishmentContact;
	}
}
