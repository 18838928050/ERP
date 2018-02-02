/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.OuputDetailMgr;
import com.erp.controller.vto.OuputDetailVTOw;

/**
 * @author： 如约而至 @time：2017年10月12日 下午9:08:19
 *******************************************************************
 @说明：
 *******************************************************************/
public class OuputDetailAction extends BaseAction<OuputDetailVTOw> {
	OuputDetailMgr ouputDetailMgr = new OuputDetailMgr();

	/**
	 * 
	 * @说明：首次打开产量计件明细表的展示
	 */
	public String listUI() throws Exception {
		// 为下面提供条件
		model.setBusinessBillVOs(ouputDetailMgr.getListAllBBByLImits());
		// 为下面提供条件
		model.setBusinessBillItemVOss(ouputDetailMgr.getbbiSS(model.getBusinessBillVOs()));
		// 前面用的到(op)
		model.setOutputVOs(ouputDetailMgr.getOp(model.getBusinessBillItemVOss()));
		// 页面用的到（bbi)
		model.setBusinessBillItemVOs(ouputDetailMgr.getbbis(model.getOutputVOs()));
		// 页面用的到（bb)

		model.setBusinessBillVO2(ouputDetailMgr.getBBs(model.getBusinessBillItemVOs()));
		// 页面用的到（mt)
		model.setMakeTypeVOs(ouputDetailMgr.getMT(model.getBusinessBillItemVOs()));
		model.setWorkProcessVOs(ouputDetailMgr.getWPs(model.getOutputVOs()));
		model.setWorkCenterVOs(ouputDetailMgr.getWCs(model.getBusinessBillItemVOs()));
		model.setEstablishmentVOs(ouputDetailMgr.getEs(model.getBusinessBillVO2()));

		return "listUI";
	}

	public String delete() throws Exception {
		ouputDetailMgr.deleteOP(model.getOutputVOs());
		return "toListUI";

	}
}
