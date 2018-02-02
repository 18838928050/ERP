/**
 * 
 */
package com.erp.controller.action;

import java.text.SimpleDateFormat;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.ChanliangRegisterMgr;
import com.erp.controller.vto.OuputDetailVTOw;

/**
 * @author： 如约而至 @time：2017年10月12日 下午9:08:19
 *******************************************************************
 @说明：
 *******************************************************************/
public class chanLiangRegisterAction extends BaseAction<OuputDetailVTOw> {
	ChanliangRegisterMgr chanliangRegisterMgr = new ChanliangRegisterMgr();

	/**
	 * 
	 * @说明：首次打开产量登记的展示
	 */
	public String listUI() throws Exception {
		// 为下面提供条件
		model.setBusinessBillVOs(chanliangRegisterMgr.getListAllBBByLImitsAndTime());
		// 前面页面用得到（bbi)
		model.setBusinessBillItemVOss(chanliangRegisterMgr.getbbiSS(model.getBusinessBillVOs()));
		// 前面页面用得到（bb)
		model.setBusinessBillVO2(chanliangRegisterMgr.getBbS(model.getBusinessBillItemVOss()));
		// 前面页面用得到（e)
		model.setEstablishmentVOs(chanliangRegisterMgr.getEs(model.getBusinessBillVO2()));
		// 前面页面用得到（wc)
		model.setWorkCenterVOs(chanliangRegisterMgr.getWCs(model.getBusinessBillItemVOss()));
		// 前面页面用得到（bbie)
		model.setBusinessBillItemExtVOs(chanliangRegisterMgr.getBBIEs(model
				.getBusinessBillItemVOss()));
		// 前面页面用得到（mt)
		model.setMakeTypeVOs(chanliangRegisterMgr.getMts(model.getBusinessBillItemVOss()));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String thisTime = sdf.format(new java.util.Date());
		model.setTime(thisTime);
		return "listUI";
	}

	public String dengji() throws Exception {
		model.setBusinessBillItemVO(chanliangRegisterMgr.getbbiSS(model.getBusinessBillItemVO()
				.getId()));
		model.setBusinessBillVO(chanliangRegisterMgr.getB(model.getBusinessBillItemVO()));
		model.setEstablishmentVO(chanliangRegisterMgr.getE(model.getBusinessBillVO()));
		model.setMakeTypeVO(chanliangRegisterMgr.getMts(model.getBusinessBillItemVO()));
		model.setWorkCenterVO(chanliangRegisterMgr.getWC(model.getBusinessBillItemVO()));
		model.setOutPutVoss(chanliangRegisterMgr.getOp(model.getBusinessBillItemVO()));
		model.setWorkProcessVOs(chanliangRegisterMgr.getWpS(model.getOutPutVoss()));

		long wcId = model.getBusinessBillItemVO().getWcId();
		if (wcId == 7) {
			return "toBiaoShi";
		} else if (wcId == 13) {
			return "toBiaoPaiDengJi";

		} else if (wcId == 14) {
			return "lvCaiJiaGong";

		} else {
			return "xingCaiXiaoShou";
		}
	}

	public String newPe() {
		return "toNew";

	}
}
