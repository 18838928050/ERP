package com.erp.controller.action;

import java.util.List;

import com.erp.controller.system.mgr.FukuandanshenheMgr;
import com.erp.controller.vto.FukuandanshenheVTOw;
import com.erp.model.vo.PayBillItemVO;
import com.erp.model.vo.PayBillVO;

public class FukuandanshenheAction extends BaseAction<FukuandanshenheVTOw> {
	private FukuandanshenheMgr fukuandanshenheMgr = new FukuandanshenheMgr();

	/**
	 * @author fu 通过tallyset=2,examined=N,enabled=Y三个条件进行筛选后的全部查询
	 * @return
	 * @throws Exception
	 */
	// 查找全部
	public String findAll() throws Exception {
		Long tallyset = 2l;
		List<PayBillVO> payBillVOs = FukuandanshenheMgr.findAllByTEN(tallyset);
		model.setPayBillVOs(payBillVOs);
		model.setEstablishmentVOs(fukuandanshenheMgr.getEstblishmentSS(model.getPayBillVOs()));
		return "toListUI";
	}

	// 审核通过
	public String ExaminedTongGuo() {
		fukuandanshenheMgr.ExaminedTongGuo(model.getPayBillVO().getId());
		return "toFindAll";
	}

	// 查看
	public String ChaZhaoByPayBillId() {
		model.setPayBillVO(fukuandanshenheMgr.ChaZhaoByPayBillId(model.getPayBillVO().getId()));
		// fB.ID=FBI.billId
		model.setPayBillItemVOs(fukuandanshenheMgr.getPayBillItemById(model.getPayBillVO().getId()));
		for (PayBillItemVO payBillItemVO : model.getPayBillItemVOs()) {
			System.out.println(payBillItemVO);
		}
		model.setEstablishmentVO(fukuandanshenheMgr.getEstblishment(model.getPayBillVO()
				.getReceiverId()));
		model.setDepartmentVO(fukuandanshenheMgr.getDepartmentsByDepatementId(model.getPayBillVO()
				.getDepartmentId()));
		System.out.println(model.getDepartmentVO());
		model.setTallySetVO(fukuandanshenheMgr.getTallySetByPayBillId(model.getPayBillVO()
				.getTallySetId()));
		System.out.println(model.getTallySetVO());
		model.setBankAccountVO(fukuandanshenheMgr.getBankAccountByFbBankAccId(model.getPayBillVO()
				.getBankAccountId()));
		System.out.println(model.getBankAccountVO());
		return "toChaZhao";
	}
	public String tuichu() {
		return "toBack";
		
	}

}
