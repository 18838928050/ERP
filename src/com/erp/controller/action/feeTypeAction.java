/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.MoneyMgr;
import com.erp.controller.vto.MoneyVTOw;
import com.erp.model.vo.FeeTypeVO;

/**
 * @author： 如约而至 @time：2017年9月1日 下午5:07:29
 *******************************************************************
 @说明：
 *******************************************************************/
public class feeTypeAction extends BaseAction<MoneyVTOw> {
	private MoneyMgr moneyMgr = new MoneyMgr();

	MoneyVTOw moneyVTO = new MoneyVTOw();

	/**
	 * 
	 * @说明：获得费用类型列表
	 */

	public String FeeTypeUI() throws Exception {
		List<FeeTypeVO> FeeTypeVOs = moneyMgr.getFeeTypeList();
		model.setFeeTypeVOs(FeeTypeVOs);
		return "toListUI";
	}
	/**
	 * 增加费用类型回显增加页面
	 */
	
	public String addFeeTypeUI() throws Exception {
		FeeTypeVO feeTypeVO=new FeeTypeVO();
		feeTypeVO.setSequenceCode(moneyMgr.getFeeTypeSequenceCodeMax()+1);
		model.setFeeType(feeTypeVO);
		return "toEditAndUI";
	}
	/**
	 * 
	 * @说明：增加费用类型
	 */
	public String addFeeType() throws Exception {
		System.out.println(model.getFeeType());
		moneyMgr.save(model.getFeeType());
		return "toList";
	}

	/**
	 * 
	 * @说明：编辑费用类型回显功能
	 */
	public String editFeeTypeUI() throws Exception {
		model.setFeeType(moneyMgr.getFeeTypeById(model.getFeeType().getId()));
		System.out.println(model.getFeeType().getId()+".....");
		return "toEditAndUI";
	}
	/**
	 * 编辑费用类型（修改费用类型）
	 * @说明：
	 */
	public String editFeeType() throws Exception {
		moneyMgr.updateFeeType(model.getFeeType());
		return "toList";
	}
	/**
	 * 删除费用类型
	 * @说明：
	 */
	public String deleteFeeType() throws Exception {
		System.out.println(model.getFeeType().getId());
		moneyMgr.deleteFeeTypeById(model.getFeeType().getId());
		return "toList";
	}

}
