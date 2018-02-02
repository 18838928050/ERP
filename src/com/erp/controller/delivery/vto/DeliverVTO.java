package com.erp.controller.delivery.vto;



import com.erp.model.vo.BusinessBillItem;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.DeliverBill;
import com.erp.model.vo.PayMode;

/**
 * 送货业务
 * @author guo
 *
 */
public class DeliverVTO {
	
	private BusinessBillVO businessBill;
	private DeliverBill deliverBill;
	private BusinessBillItem businessBillItem;
	private PayMode payMode;
	
	public DeliverBill getDeliverBill() {
		return deliverBill;
	}

	public void setDeliverBill(DeliverBill deliverBill) {
		this.deliverBill = deliverBill;
	}

	public BusinessBillItem getBusinessBillItem() {
		return businessBillItem;
	}

	public void setBusinessBillItem(BusinessBillItem businessBillItem) {
		this.businessBillItem = businessBillItem;
	}

	public PayMode getPayMode() {
		return payMode;
	}

	public void setPayMode(PayMode payMode) {
		this.payMode = payMode;
	}

	public BusinessBillVO getBusinessBill() {
		return businessBill;
	}

	public void setBusinessBill(BusinessBillVO businessBill) {
		this.businessBill = businessBill;
	}
	
}