package com.erp.controller.customerBusiness.vto;

import java.util.List;

import com.erp.controller.customerBusiness.vo.EstablishmentContactVO;
import com.erp.model.vo.EstablishmentVO;

/**
 * 客户业务 逻辑处理
 * @author guo
 *
 */
public class CustomerVTO {
	
//	客户
	private EstablishmentVO establishment ;
//	联系人
	private List<EstablishmentContactVO> establishmentContact;

	


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