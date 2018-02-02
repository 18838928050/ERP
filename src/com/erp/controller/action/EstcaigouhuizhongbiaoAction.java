/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.GYScaigouhuizongMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

/**
 * 供应商采购汇总表
 * 
 * @author： 如约而至 @time：2017年10月10日 下午6:44:34
 *******************************************************************
 @说明：
 *******************************************************************/
public class EstcaigouhuizhongbiaoAction extends BaseAction<PurchaseBillVTOw> {
	GYScaigouhuizongMgr gyScaigouhuizongMgr = new GYScaigouhuizongMgr();

	public String findAll() {
		long tallySetId = 2l;
		// 为下面查询提供条件，不显示在页面上
		model.setPurchaseBillVOs(gyScaigouhuizongMgr.getPurchaseBillVOS(tallySetId));
		// 为下面查询提供条件，不显示在页面上
		model.setPurchaseBillItemVOSS(gyScaigouhuizongMgr.findPBIss(model.getPurchaseBillVOs()));

		// 页面上需要的数据
		model.setPurhchaseBillItemVOSS2(gyScaigouhuizongMgr.findPBIss2(model.getPurchaseBillVOs()));
		// 页面上需要的数据
		model.setProductVOSS(gyScaigouhuizongMgr.findProductVOssByPbIIds(model.getPurchaseBillVOs()));
		// 页面上需要的数据
		model.setPurchaseBillVOs2(gyScaigouhuizongMgr.findPurchaseBillVOs2(model
				.getPurchaseBillItemVOSS()));
		// 页面上需要的数据
		model.setEstablishmentVOs(gyScaigouhuizongMgr.findEstsByPbIds(model.getPurchaseBillVOs2()));
		return "toList";
	}

}
