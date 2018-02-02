/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import com.erp.controller.system.mgr.MoneyMgr;
import com.erp.controller.vto.MoneyVTOw;
import com.erp.model.vo.IncomeTypeVO;

/**
 @author： 如约而至    @time：2017年9月1日 下午5:07:29 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class incomeTypeAction  extends BaseAction<MoneyVTOw>{
	private MoneyMgr moneyMgr=new MoneyMgr();
	
	MoneyVTOw moneyVTO=new MoneyVTOw();
	/**
	 * 
	 * @说明：获得账户类型列表
	 */
	
	public String IncomeTypeUI() throws Exception {
		List<IncomeTypeVO> IncomeTypeVOs=moneyMgr.getIncomeTypeList();
		model.setIncomeTypeVOs(IncomeTypeVOs);
		
		return "toListUI";
	}
	/**
	 * 增加收入类型回显增加页面
	 */
	
	public String addIncomeTypeUI() throws Exception {
		IncomeTypeVO incomeTypeVO=new IncomeTypeVO();
		incomeTypeVO.setSequenceCode(moneyMgr.getIncomeTypeSequenceCodeMax()+1);
		model.setIncomeType(incomeTypeVO);
		return "toEditAndUI";
	}
	/**
	 * 
	 * @说明：增加收入类型
	 */
	public String addIncomeType() throws Exception {
		System.out.println(model.getIncomeType());
		moneyMgr.save(model.getIncomeType());
		return "toList";
	}

	/**
	 * 
	 * @说明：编辑收入类型回显功能
	 */
	public String editIncomeTypeUI() throws Exception {
		model.setIncomeType(moneyMgr.getIncomeTypeById(model.getIncomeType().getId()));
		System.out.println(model.getIncomeType().getId()+".....");
		return "toEditAndUI";
	}
	
	/**
	 * 
	 * @说明：编辑收入类型
	 */
	public String editIncomeType() throws Exception {
		System.out.println(model.getIncomeType().getId());
		moneyMgr.updateIncomeType(model.getIncomeType());
		return "toList";
	}
	
	
	
	/**
	 * 
	 * @说明：删除收入类型
	 */
	public String DeleteIncomeType() throws Exception {
		System.out.println(model.getIncomeType().getId());
		moneyMgr.deleteIncomeTypeById(model.getIncomeType().getId());
		return "toList";
	}
	

	
	
	
	
}
