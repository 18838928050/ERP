package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.MakeBillMgr;
import com.erp.controller.vto.MakeBillVTOw;

public class MakeBillAction extends BaseAction<MakeBillVTOw> {
	MakeBillMgr makeBillMgr=new MakeBillMgr();
	
	
	public String listUI() throws Exception{
		//BB  自定义几个条件 都用 sql
		model.setBusinessBillVOs(makeBillMgr.getBusinessBillVOsByLimits());
		
	
		//bb.client_id=E.id
//		model.setEstablishmentVOs(makeBillMgr.getEstablistmentbyid(model.getBusinessBillVOs()));
		
		
		//得到bbe  都用sql
//		model.setBusinessBillExtVOs(makeBillMgr.getBusinessBillExtByIds(model.getBusinessBillVOs()));
		
		
		
		//bb.id=bbi.bill_id
//		model.setBusinessBillItemVOs(makeBillMgr.getBusinessBillItemByBillIds(model.getBusinessBillVOs()));
		
		
		
		//bbie.id=bbi.id
//		model.setBusinessBillItemExtVOs(makeBillMgr.getBBIEById(model.getBusinessBillItemVOs()));
		//bbi.wc_id =wc.id
//		model.setWorkCenterVOs(makeBillMgr.getWorkCentersVo(model.getBusinessBillItemVOs()));
		
		return "listUI";
	}

}
