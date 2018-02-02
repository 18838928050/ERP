/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import com.erp.controller.system.mgr.CaigouduizhangMgr;
import com.erp.controller.vto.PurchaseBillVTOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillItemVO;

/**
 * @author fu
 *
 */
public class caigouduizhangAction extends BaseAction<PurchaseBillVTOw> {
	CaigouduizhangMgr caigouduizhangMgr = new CaigouduizhangMgr();

	public String findAll() {
		model.setEstablishmentVOs(caigouduizhangMgr.findEsts());
		return "toList";
	}

	public String xuanze() {
		//选择需要三个列表，PB,P,PBI
		//这是PBI，通过Establistment的id找到PBI
		model.setPurchaseBillItemVOSS(caigouduizhangMgr
				.finPBISS(model.getEstablishmentVO().getId()));
		System.out.println(model.getPurchaseBillItemVOSS()+"9999999999999999999999999999999999999999999999");
		/*for (List<PurchaseBillItemVO> iterable_element : model.getPurchaseBillItemVOSS()) {
		for (PurchaseBillItemVO purchaseBillItemVO : iterable_element) {
			System.out.println(purchaseBillItemVO);
			
		}
			
		}*/
		return "xuanze";

	}
}
