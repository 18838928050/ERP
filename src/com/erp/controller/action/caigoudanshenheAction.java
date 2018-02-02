package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CaigoudanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class caigoudanshenheAction extends BaseAction<PurchaseBillVTOw> {
	CaigoudanshenheMgr caigoudanshenheMgr = new CaigoudanshenheMgr();

	public String findAll(){
		long tallySetId = 2l;
		model.setPurchaseBillVOs(caigoudanshenheMgr.findPbs(tallySetId));
		model.setEstablishmentSS(caigoudanshenheMgr.findEsts(model.getPurchaseBillVOs()));
		model.setStoreHouseVOSS(caigoudanshenheMgr.findStores(model.getPurchaseBillVOs()));
		return "toCaigoudanshenhe";
	}
	public String shenhetongguo() {
		caigoudanshenheMgr.shenhetongguo(model.getPurchaseBillVO().getId());
		return "toFindAlll";
	}
	public String chakan() {
		model.setPurchaseBillVO(caigoudanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(caigoudanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(caigoudanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(caigoudanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(caigoudanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(caigoudanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(caigoudanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(caigoudanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
