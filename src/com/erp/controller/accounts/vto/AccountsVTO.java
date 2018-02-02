package com.erp.controller.accounts.vto;

import com.erp.controller.accounts.vo.AdjustBillVO;
import com.erp.controller.accounts.vo.BankAccountDetailVO;
import com.erp.controller.accounts.vo.FeeBillVO;
import com.erp.controller.accounts.vo.IncomeBillVO;
import com.erp.controller.accounts.vo.LoanBillVO;
import com.erp.controller.accounts.vo.PayBillVO;
import com.erp.controller.accounts.vo.ReceiveBillVO;
import com.erp.controller.accounts.vo.TransferBillVO;

public class AccountsVTO {

	private ReceiveBillVO receiveBill;
	private AdjustBillVO adjustBill;
	private BankAccountDetailVO bankAccountDetail;
	private FeeBillVO feeBill;
	private IncomeBillVO incomeBill;
	private LoanBillVO loanBill;
	private PayBillVO payBill;
	private TransferBillVO transferBill;
	
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public ReceiveBillVO getReceiveBill() {
		return receiveBill;
	}
	public void setReceiveBill(ReceiveBillVO receiveBill) {
		this.receiveBill = receiveBill;
	}
	public BankAccountDetailVO getBankAccountDetail() {
		return bankAccountDetail;
	}
	public void setBankAccountDetail(BankAccountDetailVO bankAccountDetail) {
		this.bankAccountDetail = bankAccountDetail;
	}
	public AdjustBillVO getAdjustBill() {
		return adjustBill;
	}
	public void setAdjustBill(AdjustBillVO adjustBill) {
		this.adjustBill = adjustBill;
	}
	public FeeBillVO getFeeBill() {
		return feeBill;
	}
	public void setFeeBill(FeeBillVO feeBill) {
		this.feeBill = feeBill;
	}
	public IncomeBillVO getIncomeBill() {
		return incomeBill;
	}
	public void setIncomeBill(IncomeBillVO incomeBill) {
		this.incomeBill = incomeBill;
	}
	public LoanBillVO getLoanBill() {
		return loanBill;
	}
	public void setLoanBill(LoanBillVO loanBill) {
		this.loanBill = loanBill;
	}
	public PayBillVO getPayBill() {
		return payBill;
	}
	public void setPayBill(PayBillVO payBill) {
		this.payBill = payBill;
	}
	public TransferBillVO getTransferBill() {
		return transferBill;
	}
	public void setTransferBill(TransferBillVO transferBill) {
		this.transferBill = transferBill;
	}

}
