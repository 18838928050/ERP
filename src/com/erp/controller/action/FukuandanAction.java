package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.FukuanDanMgr;
import com.erp.controller.vto.FukuandanVTOw;

public class FukuandanAction extends BaseAction<FukuandanVTOw> {
	FukuanDanMgr fukuanDanMgr = new FukuanDanMgr();
	private long estId;
	private long bankId;

	public long getEstId() {
		return estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	private String PayType;

	public String getPayType() {
		return PayType;
	}

	public void setPayType(String payType) {
		PayType = payType;
	}

	public String waixiefindAll() throws Exception {

		long tallySet = 2l;
		// 收款单位
		// model.setEstName(fukuanDanMgr.getEstNameByEstId(estId));
		model.setEstablishmentVOs(fukuanDanMgr.getEstsByLimits(tallySet));

		model.setCooperBillVOs(fukuanDanMgr.getCooperBillsByLimits(bankId, estId, tallySet));

		model.setBankAccountVOs(fukuanDanMgr.getBankAccounts());
		return "towaixiefukuandan";
	}

	public String caigouFindAll() throws Exception {
		long tallyset = 2l;
		long prividerId = 760l;
		model.setEstablishmentVOs(fukuanDanMgr.getEstsByLimits(tallyset));
		model.setPurchaseBillVOs(fukuanDanMgr.getPurchaseBillVOsByLimits(prividerId, tallyset));
		model.setBankAccountVOs(fukuanDanMgr.getBankAccounts());
		return "toCaigoufukuan";
	}

	public String Select() {
		return "toSelectUI";
	}

	public String SelectPayType() throws Exception {
		long tallySet = 2l;
		model.setEstablishmentVOs(fukuanDanMgr.getEstsByLimits(tallySet));
		model.setBankAccountVOs(fukuanDanMgr.getBankAccounts());
		if (PayType.equals("采购付款")) {
			return "toCaigou";
		} else {
			return "toWaixie";
		}
	}
}
