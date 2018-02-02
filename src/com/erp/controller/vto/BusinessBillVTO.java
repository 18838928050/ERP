package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBill;
import com.erp.model.vo.BusinessBillExt;
import com.erp.model.vo.BusinessBillItem;
import com.erp.model.vo.Establishment;

/**
 * 业务单中间层
 * @author JiaQi
 *
 */
public class BusinessBillVTO {
	private BusinessBill businessBill;
	private Establishment establishment;
	private BusinessBillExt businessBillExt;
	private List<BusinessBillItem> businessBillItems;
	
	public BusinessBill getBusinessBill() {
		return businessBill;
	}
	public void setBusinessBill(BusinessBill businessBill) {
		this.businessBill = businessBill;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
	public BusinessBillExt getBusinessBillExt() {
		return businessBillExt;
	}
	public void setBusinessBillExt(BusinessBillExt businessBillExt) {
		this.businessBillExt = businessBillExt;
	}
	public List<BusinessBillItem> getBusinessBillItems() {
		return businessBillItems;
	}
	public void setBusinessBillItems(List<BusinessBillItem> businessBillItems) {
		this.businessBillItems = businessBillItems;
	}
	
}
