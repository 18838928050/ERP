package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.TuihuodanfanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class tuihuodanfanshenheAction extends BaseAction<PurchaseBillVTOw> {
	TuihuodanfanshenheMgr tuihuodanfanshenheMgr = new TuihuodanfanshenheMgr();

	public String findAll() {
		long tallySetId = 2l;
		model.setPurchaseBillVOs(tuihuodanfanshenheMgr.findIsYPbsfan(tallySetId));
		model.setEstablishmentSS(tuihuodanfanshenheMgr.findEsts(model.getPurchaseBillVOs()));
		model.setStoreHouseVOSS(tuihuodanfanshenheMgr.findStores(model.getPurchaseBillVOs()));
		return "toTuihuodanfanshenhe";
	}
	public String shenhebutongguo() {
		tuihuodanfanshenheMgr.shenhebutongguo(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	public String chakan() {
		model.setPurchaseBillVO(tuihuodanfanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(tuihuodanfanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(tuihuodanfanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(tuihuodanfanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(tuihuodanfanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(tuihuodanfanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(tuihuodanfanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(tuihuodanfanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
