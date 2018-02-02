package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.mysql.fabric.xmlrpc.base.Array;

public class YewumingxiyilanbiaoMGR {
	BusinessBillDAOw businessBillDAOw=new BusinessBillDAOw();
	BusinessBillItemDAOw businessBillItemDAOw=new BusinessBillItemDAOw();
	EstablishmentDAOw establishmentDAOw=new EstablishmentDAOw();

	public List<BusinessBillVO> getAllBusinessBill() {
		return businessBillDAOw.getBusinessBillsByLimit();
	}

	public List<BusinessBillItemVO> getBBIByBBBillid(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			ids.add(businessBillVO.getId());
		}
		
		return businessBillItemDAOw.getbbis(ids);
	}

	public List<EstablishmentVO> getE(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			ids.add(businessBillVO.getClientId());
		}
		return establishmentDAOw.findEsts(ids);
	}

}
