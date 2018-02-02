package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CaigoudanfanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class caigoudanfanshenheAction extends BaseAction<PurchaseBillVTOw> {
	CaigoudanfanshenheMgr caigoudanfanshenheMgr = new CaigoudanfanshenheMgr();

	public String findAll() {
		long tallySetId = 2l;
		model.setPurchaseBillVOs(caigoudanfanshenheMgr.findIsYPbs(tallySetId));
		model.setEstablishmentSS(caigoudanfanshenheMgr.findEsts(model.getPurchaseBillVOs()));
		model.setStoreHouseVOSS(caigoudanfanshenheMgr.findStores(model.getPurchaseBillVOs()));
		return "toCaigoudanshenhe";
	}
	public String shenhebutongguo() {
		caigoudanfanshenheMgr.shenhebutongguo(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	public String chakan() {
		model.setPurchaseBillVO(caigoudanfanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(caigoudanfanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(caigoudanfanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(caigoudanfanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(caigoudanfanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(caigoudanfanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(caigoudanfanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(caigoudanfanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
