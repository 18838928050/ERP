package com.erp.controller.business.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.business.mgr.BusinessBillVTOMgr;
import com.erp.controller.vto.BusinessBillVTO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.vo.BusinessBillExt;
import com.erp.model.vo.BusinessBillItem;
import com.erp.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
/**
 * 客户账单
 * @author JiaQi
 */
public class BusinessBillVTOAction extends BaseAction<BusinessBillVTO>{
	private BusinessBillVTOMgr businessBillVTOMgr = new BusinessBillVTOMgr();
	public List<BusinessBillItem> length = null;//cd
	public List<BusinessBillItem> amount = null;//chengp
	public List<BusinessBillItem> area = null;//pingfang
	public long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<BusinessBillItem> getLength() {
		return length;
	}

	public void setLength(List<BusinessBillItem> length) {
		this.length = length;
	}

	public List<BusinessBillItem> getAmount() {
		return amount;
	}

	public void setAmount(List<BusinessBillItem> amount) {
		this.amount = amount;
	}

	public List<BusinessBillItem> getArea() {
		return area;
	}

	public void setArea(List<BusinessBillItem> area) {
		this.area = area;
	}

	/**
	 * 跳转至主界面
	 */
	public String toBusinessBillSearchResult(){
		return "toBusinessBillSearchResult";
	}
	
	/**
	 * 跳转到审核界面BusinessBillVTO_toBusinessBillListForExamine
	 */
	public String toBusinessBillListForExamine(){
		ActionContext.getContext().getValueStack().set("businessBillVTOs", businessBillVTOMgr.findNoExaminer());
		return "toBusinessBillListForExamine";
	}
	/**
	 * 审核
	 * @return
	 */
	public String examine(){
		BusinessBillExt businessBillExt = businessBillVTOMgr.findBusinessBillExt(id);
		businessBillExt.setExamined("Y");
		businessBillVTOMgr.updateBusinessBillExt(businessBillExt);
		return toBusinessBillListForExamine();
	}
	
	/**
	 * 反审核
	 * @return
	 */
	public String noExamine(){
		BusinessBillExt businessBillExt = businessBillVTOMgr.findBusinessBillExt(id);
		businessBillExt.setExamined("N");
		businessBillVTOMgr.updateBusinessBillExt(businessBillExt);
		return toBusinessBillListForUnExamine();
	}
	
	/**
	 * 跳转到反审核界面
	 */
	public String toBusinessBillListForUnExamine(){
		ActionContext.getContext().getValueStack().set("businessBillVTOs", businessBillVTOMgr.findExaminer());
		return "toBusinessBillListForUnExamine";
	}
	
	/**
	 * 保存开单信息
	 */
	public String saveBusiness(){
		getModel().getBusinessBill().setId(IDTools.GetUUID());
		BusinessBillExt businessBillExt = new BusinessBillExt();
		businessBillExt.setId(getModel().getBusinessBill().getId());
		businessBillVTOMgr.save(getModel());
		if(length != null){
			for (int i = 0; i < length.size(); i++) {
				length.get(i).setBillId(getModel().getBusinessBill().getId());
				length.get(i).setPriceType("LENGTH");
				length.get(i).setId(IDTools.GetUUID()+i+10);
				System.out.println(length.get(i));
			}
			businessBillVTOMgr.saveLength(length);
		}
		
		if(amount != null){
			for (int i = 0; i < amount.size(); i++) {
				amount.get(i).setBillId(getModel().getBusinessBill().getId());
				amount.get(i).setPriceType("AMOUNT");
				amount.get(i).setId(IDTools.GetUUID()+i+101);
				System.out.println(amount.get(i));
			}
			businessBillVTOMgr.saveLength(amount);
		}
		
		if(area != null){
			for (int i = 0; i < area.size(); i++) {
				area.get(i).setBillId(getModel().getBusinessBill().getId());
				area.get(i).setPriceType("AREA");
				area.get(i).setId(IDTools.GetUUID()+i+1);
				System.out.println(area.get(i));
			}
			businessBillVTOMgr.saveLength(area);
		}
		businessBillVTOMgr.saveBusinessBillExt(businessBillExt);
		return toBusinessBillSearchResult();
	}
}
