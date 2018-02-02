package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.TuihuodanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class TuihuobiaoshenheAction extends BaseAction<PurchaseBillVTOw> {
	TuihuodanshenheMgr tuihuodanshenheMgr = new TuihuodanshenheMgr();

	public String findAll(){
		long tallySetId = 2l;
		model.setPurchaseBillVOs(tuihuodanshenheMgr.findPbs2(tallySetId));
		model.setEstablishmentSS(tuihuodanshenheMgr.findEsts(model.getPurchaseBillVOs()));
		model.setStoreHouseVOSS(tuihuodanshenheMgr.findStores(model.getPurchaseBillVOs()));
		return "toTuihuobiaoshenhe";
	}
	public String shenhetongguo() {
		tuihuodanshenheMgr.shenhetongguo(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	public String chakan() {
		model.setPurchaseBillVO(tuihuodanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(tuihuodanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(tuihuodanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(tuihuodanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(tuihuodanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(tuihuodanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(tuihuodanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(tuihuodanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
