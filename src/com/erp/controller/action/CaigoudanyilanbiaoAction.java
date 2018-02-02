package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CaigoudanyilanbiaoMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class CaigoudanyilanbiaoAction extends BaseAction<PurchaseBillVTOw> {
	CaigoudanyilanbiaoMgr caigoudanyilanbiaoMgr = new CaigoudanyilanbiaoMgr();

	public String findAll() {
		long tallySetId = 2l;
		model.setPurchaseBillVOs(caigoudanyilanbiaoMgr.findAll(tallySetId));
		model.setPurchaseBillExtVOs(caigoudanyilanbiaoMgr.findPbesByPbIds(model
				.getPurchaseBillVOs()));
		model.setStorehouseVOs(caigoudanyilanbiaoMgr.findStoresByPbIds(model.getPurchaseBillVOs()));
		model.setEstablishmentSS(caigoudanyilanbiaoMgr.findEstsByPbIds(model.getPurchaseBillVOs()));
		return "toCaigoudanyilanbiao";
	}
}
