package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.caigoudanrukuMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class caigoudanfanrukuAction  extends BaseAction<PurchaseBillVTOw> {
	caigoudanrukuMgr caigoudanrukuMgr=new caigoudanrukuMgr();
	public String fanruku() {
		model.setPurchaseBillVO(caigoudanrukuMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(caigoudanrukuMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(caigoudanrukuMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(caigoudanrukuMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(caigoudanrukuMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(caigoudanrukuMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(caigoudanrukuMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(caigoudanrukuMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toFanRuku";
	}
	public String caigoudanfanruku() {
      	caigoudanrukuMgr.setcaigoudanfanruku(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	public String tuichu() {
		return "tuichu";
	}
}
