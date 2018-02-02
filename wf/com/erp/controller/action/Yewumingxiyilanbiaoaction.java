package com.erp.controller.action;

import com.erp.controller.system.mgr.YewumingxiyilanbiaoMGR;
import com.erp.controller.vto.LoginVTOw;
import com.erp.controller.vto.YewumingxiyilanbiaoVTO;

public class Yewumingxiyilanbiaoaction extends BaseAction<YewumingxiyilanbiaoVTO>{
	YewumingxiyilanbiaoMGR yewumingxiyilanbiaoMGR=new YewumingxiyilanbiaoMGR();
	
	//首次打开业务明细一览表时
	public String listall(){
		model.setBusinessBillVOs(yewumingxiyilanbiaoMGR.getAllBusinessBill());
		
		
		
		model.setBusinessBillItemVOs(yewumingxiyilanbiaoMGR.getBBIByBBBillid(model.getBusinessBillVOs()));
		model.setEstablishmentVOs(yewumingxiyilanbiaoMGR.getE(model.getBusinessBillVOs()));
		return "list";
	}

}
