/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CooperBillActionMgr;
import com.erp.controller.vto.CooperBillActionVTOw;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.PageVO;
import com.opensymphony.xwork2.ActionContext;

/**
 @author： 如约而至    @time：2017年9月4日 上午10:35:19 
 *******************************************************************
 @说明： 
 *******************************************************************/
@SuppressWarnings({"serial","unused"})
public class CooperBillAction extends BaseAction<CooperBillActionVTOw>{
	private CooperBillActionMgr cooperBillActionMgr=new CooperBillActionMgr();
	private Integer maxNumEvePage;
	private Integer CurrentPageNum;
	//由于 审核与反审核 仅仅是通过判断一个值而决定的，所以 共同action。isCheck=1 审核单；
	private Integer isCheck;
	
	
	
	/**
	 * 查看来源  到制作单部分。前台传值：
	 * @throws Exception 
	 */
	public String Source() throws Exception{
		//BusinessBillVO.billCode=cooperBillItemVO.bbCode,所以前台传值时：直接：&businessBillVO.billCode=%{bbCode}
		//BB:BusinessBillVO.billCode ：由BillCode 得到BusinessBillVO 
		model.setBusinessBillVO(cooperBillActionMgr.getBusinessBillByBillCode(model.getBusinessBillVO().getBillCode()));
		//CBI:CooperBillItemVO.BbCode  由BbCode得到了CooperBillItemVO。
		model.setCooperBillItemVOs(cooperBillActionMgr.getCooperBillItemByBbCode(model.getCooperBillItemVO().getBbCode()));
		//E:由BusinessBillVO.client_id=establishment.id 得到establishment，从而establishment.est_name是来源
		model.setEstablishmentVO(cooperBillActionMgr.getEstablishmentById(model.getBusinessBillVO().getClientId()));
		//MK:CooperBillItemVO.make_type_id=make_type.id  从而得到makeTypeVO
		model.setMakeTypeVO(cooperBillActionMgr.getMakeTypeById(model.getCooperBillItemVO().getMakeTypeId()));
		
		return "toDetailUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * index查看所有 分页
	 */
	public String listUI() throws Exception {
		ActionContext.getContext().getSession().put("isCheck", isCheck);
		//获得分页
		model.setPageVO(cooperBillActionMgr.getPageVO(maxNumEvePage,CurrentPageNum));
		return "toListUI";
	}
	
	
	/**
	 * 
	 * @说明：审核与反审核的按钮实现  isCheck=1 需要审核，还没审核.
	 */
	public String isCheckOrNo(){
		//这个isCheck  代表当前是查询未审核的 N  isCheck=1 ;  同时放在Struts里面将这个值传给listUi 
		isCheck=  (Integer) ActionContext.getContext().getSession().get("isCheck");
		//将cooper_bill中id传给下面，cooper_bill.id=cooper_bill_ext.id 从而cooper_bill_ext.examined
		 cooperBillActionMgr.isCheckOrNo(isCheck,model.getCooperBillVO().getId());
		  return "toList";
	}
	
	
	
	/**
	 * 查看具体反审核单
	 * @throws Exception 
	 */
	public String listUIDetailByBillCode() throws Exception{
		//由前台/ERP/WebContent/WEB-INF/view/waixie/listUI.jsp查看：传来的CooperBill中的billcode 查询Cooperbill中此条详细信息。
		model.setCooperBillVO(cooperBillActionMgr.getCooperBillByBillCode(model.getCooperBillVO().getBillCode()));
		//由上条查出并且压入值栈的整条cooperbill记录中的department_id;利用CooperBill.department_id=MakeType.id查询此条信息
		model.setMakeTypeVO(cooperBillActionMgr.getMakeTypeById(model.getCooperBillVO().getDepartmentId()));
		//这是数组结果。。。由前台/ERP/WebContent/WEB-INF/view/waixie/listUI.jsp查看：传来的id，查询CooperBillItem整条信息。
		model.setCooperBillItemVOs(cooperBillActionMgr.getCooperBillItemByCooperBillId(model.getCooperBillVO().getId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的bank_account_id;由CooperBill.bank_account_id=BankAccount.id 
		model.setBankAccountVO(cooperBillActionMgr.getBankAccountByAccountId(model.getCooperBillVO().getBankAccountId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的pay_mode_id;由CooperBill.pay_mode_id=pay_mode.id 
		model.setPayModeVO(cooperBillActionMgr.getPayModeByPayModeId(model.getCooperBillVO().getPayModeId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的tally_set_id;由CooperBill.tally_set_id=tally_set.id 
		model.setTallySetVO(cooperBillActionMgr.getTallySetByTallSetId(model.getCooperBillVO().getTallySetId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的department_id=department.id从而 department_name; 
		model.setDepartmentVO(cooperBillActionMgr.getDepartmentNameById(model.getCooperBillVO().getDepartmentId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的cooperator_id=establishment.id  从而得到establishment中的est_name外协单位：
		model.setEstablishmentVO(cooperBillActionMgr.getEstablishmentById(model.getCooperBillVO().getCooperatorId()));
		//由上条查出并且压入值栈的整条cooperbill记录中的id =CooperBillExtVO.id 从而得到审核人 审核时间 examiner_name 和 examine_time
		model.setCooperBillExtVO(cooperBillActionMgr.getCooperBillExtById(model.getCooperBillVO().getId()));
		return "toListUIDetail";
	}
	
	
	
	/**
	 * 
	 * @说明：增加之前的数据准备
	 */
	public String addUI() throws Exception {
		return "toEditAddUI";
	}
	
	/**
	 * 
	 * @说明：增加
	 */
	public String add() throws Exception {
		return "toList";
	}
	
	/**
	 * 
	 * @说明：修改之前的数据准备
	 */
	public String updateUI() throws Exception {
		return "toEditAddUI";
	}
	
	/**
	 * 
	 * @说明：修改数据
	 */
	public String update() throws Exception {
		return "toList";
	}
	
	/**
	 * 
	 * @说明：删除数据
	 */
	public String delete() throws Exception {
		return "toList";
	}

	public Integer getMaxNumEvePage() {
		return maxNumEvePage;
	}

	public void setMaxNumEvePage(Integer maxNumEvePage) {
		this.maxNumEvePage = maxNumEvePage;
	}

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
	

	
	

}
