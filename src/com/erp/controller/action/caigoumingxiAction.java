package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CaigoumingxiMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class caigoumingxiAction extends BaseAction<PurchaseBillVTOw> {
	CaigoumingxiMgr caigoumingxiMgr = new CaigoumingxiMgr();

	public String findAll() {
		//	model.setEstablishmentVOs(caigoumingxiMgr.findEstsByPbIds(model.getPurchaseBillVOs()));
		long tallySetId = 2l;
		//为下面查询提供条件，不显示在页面上
		model.setPurchaseBillVOs(caigoumingxiMgr.findPurchaseBillsByLimit(tallySetId));
		//为下面查询提供条件，不显示在页面上
		model.setPurchaseBillItemVOSS(caigoumingxiMgr.findPBIss(model.getPurchaseBillVOs()));
		//为了找PBIS显示在jsp上的数据，首先找所有的PBI的id或者bill_id,bill_id有重复的
		 //页面上需要的数据
		model.setPurhchaseBillItemVOSS2(caigoumingxiMgr.findPBIss2(model.getPurchaseBillVOs()));
		 //页面上需要的数据
		model.setProductVOSS(caigoumingxiMgr.findProductVOssByPbIIds(model
				.getPurchaseBillVOs()));
		 //页面上需要的数据
		 model.setProductTypeVOs(caigoumingxiMgr.findPsByProIds(model.getProductVOSS()));
		 //页面上需要的数据
		 model.setPurchaseBillVOs2(caigoumingxiMgr.findPurchaseBillVOs2(model.getPurchaseBillItemVOSS()));
		 //页面上需要的数据
		 model.setEstablishmentVOs(caigoumingxiMgr.findEstsByPbIds(model.getPurchaseBillVOs2()));
		return "toList";
	}
}
