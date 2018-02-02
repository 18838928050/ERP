package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.TuihuodanyilanbiaoMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class tuihuodanyilanbiaoAction extends BaseAction<PurchaseBillVTOw> {
	TuihuodanyilanbiaoMgr tuihuodanyilanbiaoMgr = new TuihuodanyilanbiaoMgr();

	public String findAll() {
		long tallySetId = 2l;
		model.setPurchaseBillVOs(tuihuodanyilanbiaoMgr.findAll(tallySetId));
		model.setPurchaseBillExtVOs(tuihuodanyilanbiaoMgr.findPbesByPbIds(model
				.getPurchaseBillVOs()));
		model.setStorehouseVOs(tuihuodanyilanbiaoMgr.findStoresByPbIds(model.getPurchaseBillVOs()));
		model.setEstablishmentSS(tuihuodanyilanbiaoMgr.findEstsByPbIds(model.getPurchaseBillVOs()));
		return "toTuihuodanyilanbiao";
	}
}
