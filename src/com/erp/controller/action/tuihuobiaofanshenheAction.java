package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.TuihuobiaofanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class tuihuobiaofanshenheAction extends BaseAction<PurchaseBillVTOw> {
	TuihuobiaofanshenheMgr tuihuobiaofanshenheMgr=new TuihuobiaofanshenheMgr();
	public String shenhebutongguo() {
		tuihuobiaofanshenheMgr.shenhebutongguo(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	public String chakan() {
		model.setPurchaseBillVO(tuihuobiaofanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(tuihuobiaofanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(tuihuobiaofanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(tuihuobiaofanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(tuihuobiaofanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(tuihuobiaofanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(tuihuobiaofanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(tuihuobiaofanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
