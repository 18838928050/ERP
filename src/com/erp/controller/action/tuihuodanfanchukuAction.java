package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.tuihuodanchukuMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class tuihuodanfanchukuAction  extends BaseAction<PurchaseBillVTOw> {
	tuihuodanchukuMgr tuihuodanchukuMgr=new tuihuodanchukuMgr();
	public String fanchuku() {
		model.setPurchaseBillVO(tuihuodanchukuMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(tuihuodanchukuMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(tuihuodanchukuMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(tuihuodanchukuMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(tuihuodanchukuMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(tuihuodanchukuMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(tuihuodanchukuMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(tuihuodanchukuMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toFanchuku";
	}
	public String tuihuodanfanchuku() {
      	tuihuodanchukuMgr.tuihuodanfanchuku(model.getPurchaseBillVO().getId());
		return "toFindAll";
		
		
	}
	public String tuichu() {
		return "tuichu";
	}
}
