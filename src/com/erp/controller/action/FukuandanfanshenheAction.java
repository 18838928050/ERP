package com.erp.controller.action;

import java.util.List;

import com.erp.controller.system.mgr.FukuandanfanshenheMgr;
import com.erp.controller.vto.FukuandanshenheVTOw;
import com.erp.model.vo.PayBillItemVO;
import com.erp.model.vo.PayBillVO;

public class FukuandanfanshenheAction extends BaseAction<FukuandanshenheVTOw> {
	private FukuandanfanshenheMgr fukuandanfanshenheMgr = new FukuandanfanshenheMgr();

	/**
	 * @author fu 通过tallyset=2,examined=N,enabled=Y三个条件进行筛选后的全部查询
	 * @return
	 * @throws Exception
	 */
	// 查找全部
	public String findAll() throws Exception {
		Long tallyset = 2l;
		List<PayBillVO> payBillVOs = fukuandanfanshenheMgr.findAllByTEN(tallyset);
		model.setPayBillVOs(payBillVOs);
		model.setEstablishmentVOs(fukuandanfanshenheMgr.getEstblishmentSS(model.getPayBillVOs()));
		return "toListUI";
	}

	// 审核不通过
	public String ExaminedNotTongGuo() {
		fukuandanfanshenheMgr.ExaminedTongGuo(model.getPayBillVO().getId());
		return "toFindAll";
	}

	// 查看
	public String ChaZhaoByPayBillId() {
		model.setPayBillVO(fukuandanfanshenheMgr.ChaZhaoByPayBillId(model.getPayBillVO().getId()));
		// fB.ID=FBI.billId
		model.setPayBillItemVOs(fukuandanfanshenheMgr.getPayBillItemById(model.getPayBillVO()
				.getId()));
		for (PayBillItemVO payBillItemVO : model.getPayBillItemVOs()) {
			System.out.println(payBillItemVO);

		}
		model.setEstablishmentVO(fukuandanfanshenheMgr.getEstblishment(model.getPayBillVO()
				.getReceiverId()));
		model.setDepartmentVO(fukuandanfanshenheMgr.getDepartmentsByDepatementId(model
				.getPayBillVO().getDepartmentId()));
		System.out.println(model.getDepartmentVO());
		model.setTallySetVO(fukuandanfanshenheMgr.getTallySetByPayBillId(model.getPayBillVO()
				.getTallySetId()));
		System.out.println(model.getTallySetVO());
		model.setBankAccountVO(fukuandanfanshenheMgr.getBankAccountByFbBankAccId(model
				.getPayBillVO().getBankAccountId()));
		System.out.println(model.getBankAccountVO());
		return "toChaZhao";
	}
	public String tuichu() {
		return "toBack";
		
	}
}
