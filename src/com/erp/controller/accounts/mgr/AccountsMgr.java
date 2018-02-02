package com.erp.controller.accounts.mgr;

import java.util.HashMap;
import java.util.List;

import com.erp.controller.accounts.dao.AdjustBillDAO;
import com.erp.controller.accounts.dao.FeeBillDAO;
import com.erp.controller.accounts.dao.IncomeBillDAO;
import com.erp.controller.accounts.dao.LoanBillDAO;
import com.erp.controller.accounts.dao.PayBillDAO;
import com.erp.controller.accounts.dao.ReceiveBillDAO;
import com.erp.controller.accounts.dao.TransferBillDAO;
import com.erp.controller.accounts.vo.IncomeBillVO;
import com.erp.controller.accounts.vo.LoanBillVO;
import com.erp.controller.accounts.vo.ReceiveBillVO;
import com.erp.controller.accounts.vo.TransferBillVO;
import com.erp.controller.accounts.vto.AccountsVTO;
import com.erp.controller.customerBusiness.dao.EstablishmentDAO;
import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FeeBillVO;
import com.erp.model.vo.PayBillVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 账务	作废模块
 * @author guo
 *
 */
public class AccountsMgr {
	AdjustBillDAO adjustBillDAO = new AdjustBillDAO();
	FeeBillDAO feeBillDAO = new FeeBillDAO();
	IncomeBillDAO incomeBillDAO = new IncomeBillDAO();
	LoanBillDAO loanBillDAO = new LoanBillDAO();
	PayBillDAO payBillDAO = new PayBillDAO();
	ReceiveBillDAO receiveBillDAO = new ReceiveBillDAO();
	TransferBillDAO transferBillDAO = new TransferBillDAO();
	EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	
//	进入作废收款单页面需要的数据
	public void toReceiveBills() {
		List<ReceiveBillVO> receiveBills = receiveBillDAO.findAllEnableds();
		try {
			List<EstablishmentVO> findAll = establishmentDAO.findAll();
			
			HashMap<Long, String> IdAndName = new HashMap<>();
			for (EstablishmentVO establishmentVO : findAll) {
				IdAndName.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
			for (ReceiveBillVO receiveBillVO : receiveBills) {
				long clientId = receiveBillVO.getClientId();
				String value = IdAndName.get(clientId);
				receiveBillVO.setMark(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		封装客户信息
//		HashMap<Long, String> IdAndName = establishmentDAO.findIdAndName();
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBills);
	}
	//	进入作废收款单页面需要的数据（带搜索条件）
	public void selectReceiveBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<ReceiveBillVO> receiveBills = receiveBillDAO.selectReceive("格力空调","1");
		ActionContext.getContext().getValueStack().set("receiveBills", receiveBills);
	}
//	作废单个收款单
	public void enabledReceiveBill(AccountsVTO account) {
//		根据id作废
		ReceiveBillVO byId;
		try {
			byId = receiveBillDAO.getById(account.getId());
			byId.setEnabled("N");
			receiveBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	获得单个收款单
	public void getReceiveBill(AccountsVTO account) {
		try {
			ReceiveBillVO receiveBill = receiveBillDAO.getById(account.getId());
			List<EstablishmentVO> findAll = establishmentDAO.findAll();
			HashMap<Long, String> idAndName = new HashMap<>();
			for (EstablishmentVO establishmentVO : findAll) {
				idAndName.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
			long clientId = receiveBill.getClientId();
			String name = idAndName.get(clientId);
			receiveBill.setAttachFile(name);//付款单位
			ActionContext.getContext().getValueStack().set("receiveBill", receiveBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	进入其它收入单页面需要的数据
	public void toIncomeBills() {
		List<IncomeBillVO> incomeBills = incomeBillDAO.findAllEnableds();
		ActionContext.getContext().getValueStack().set("incomeBills", incomeBills);
	}
//	进入其它收入单页面需要的数据（带搜索条件）
	public void selectIncomeBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<IncomeBillVO> incomeBills = incomeBillDAO.selectIncomeBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("incomeBills", incomeBills);
	}
//	进入其它收入单作废页面  模态框未找到
	public void toEnabledIncomeBill(AccountsVTO account) {
		try {
//			根据id进行查找
			IncomeBillVO incomeBill = incomeBillDAO.getById(account.getId());
			ActionContext.getContext().getValueStack().set("incomeBill", incomeBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
//	作废单个其它收入单
	public void enabledIncomeBill(AccountsVTO account) {
//		根据id作废
		IncomeBillVO byId;
		try {
			byId = incomeBillDAO.getById(account.getId());
			System.out.println(account.getId()+"-------------------------");
			byId.setEnabled("N");
			incomeBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toIncomeBill(AccountsVTO account) {
		IncomeBillVO incomeBill = null;
		try {
			incomeBill = incomeBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("incomeBill", incomeBill);
	}
	
	
//	进入付款单页面需要的数据
	public void toPaycomeBills() {
		List<PayBillVO> payBills = payBillDAO.findAllEnableds();
		ActionContext.getContext().getValueStack().set("payBills", payBills);
	}
//	进入付款单页面需要的数据（带搜索条件）
	public void selectPayBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<PayBillVO> payBills = payBillDAO.selectPayBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("payBills", payBills);
	}
	
//	进入付款单作废页面  模态框未找到
	public void toEnabledPayBill(AccountsVTO account) {
		try {
//			根据id进行查找
			PayBillVO payBills = payBillDAO.getById(account.getPayBill().getId());
			ActionContext.getContext().getValueStack().set("payBills", payBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	作废单个付款单
	public void enabledPayBill(AccountsVTO account) {
//		根据id作废
		PayBillVO byId;
		try {
			byId = payBillDAO.getById(account.getId());
			byId.setEnabled("N");
			payBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toPayBill(AccountsVTO account) {
		PayBillVO payBill=null;
		try {
			payBill = payBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("payBill", payBill);
	}
	
	
//	进入费用单页面需要的数据
	public void toFeeBills() {
		List<FeeBillVO> feeBills = feeBillDAO.findAllEnableds();
		ActionContext.getContext().getValueStack().set("feeBills", feeBills);
	}
//	进入费用单页面需要的数据（带搜索条件）
	public void selectFeeBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<FeeBillVO> feeBills = feeBillDAO.selectFeeBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("feeBills", feeBills);
	}
//	进入费用单作废页面  模态框未找到
	public void toEnabledFeeBill(AccountsVTO account) {
		try {
//			根据id进行查找
			FeeBillVO feeBills = feeBillDAO.getById(account.getFeeBill().getId());
			ActionContext.getContext().getValueStack().set("feeBills", feeBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
//	作废单个费用单
	public void enabledFeeBill(AccountsVTO account) {
//		根据id作废
		FeeBillVO byId;
		try {
			byId = feeBillDAO.getById(account.getId());
			byId.setEnabled("N");
			feeBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void toFeeBill(AccountsVTO account) {
		FeeBillVO feeBill = null;
		try {
			feeBill = feeBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("feeBill", feeBill);
	}
	
	
//	进入调账单页面需要的数据
	public void toAdjustBills() {
		List<AdjustBillVO> adjustBills = adjustBillDAO.findAllEnableds();
		try {
			List<EstablishmentVO> findAll = establishmentDAO.findAll();
			
			HashMap<Long, String> IdAndName = new HashMap<>();
			for (EstablishmentVO establishmentVO : findAll) {
				IdAndName.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
			for (AdjustBillVO adjustBill : adjustBills) {
				long clientId = adjustBill.getClientId();
				String value = IdAndName.get(clientId);
				adjustBill.setMark(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("adjustBills", adjustBills);
	}
//	进入调账单页面需要的数据（带搜索条件）
	public void selectAdjustBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<AdjustBillVO> adjustBills = adjustBillDAO.selectAdjustBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("adjustBills", adjustBills);
	}
//	进入调账单作废页面
	public void toEnabledAdjustBill(AccountsVTO account) {
		try {
//			根据id进行查找
			AdjustBillVO adjustBill = adjustBillDAO.getById(account.getId());
			List<EstablishmentVO> findAll = establishmentDAO.findAll();
			HashMap<Long, String> idAndName = new HashMap<>();
			for (EstablishmentVO establishmentVO : findAll) {
				idAndName.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
			long clientId = adjustBill.getClientId();
			String name = idAndName.get(clientId);
			adjustBill.setExamSms(name);//付款单位
			ActionContext.getContext().getValueStack().set("adjustBill", adjustBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
//	作废单个调账单
	public void enabledAdjustBill(AccountsVTO account) {
//		根据id作废
		AdjustBillVO byId;
		try {
			byId = adjustBillDAO.getById(account.getId());
			byId.setEnabled("N");
			adjustBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
	public void toAdjustBill(AccountsVTO account) {
		AdjustBillVO adjustBill =null;
		try {
			adjustBill = adjustBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("adjustBill", adjustBill);
	}
	
	
	
//	进入转账取款页面需要的数据
	public void toTransferBills() {
		List<TransferBillVO> transferBills = transferBillDAO.findAllEnableds();
		ActionContext.getContext().getValueStack().set("transferBills", transferBills);
	}
//	进入转账取款页面需要的数据（带搜索条件）
	public void selectTransferBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<TransferBillVO> transferBills = transferBillDAO.selectTransferBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("transferBills", transferBills);
	}
//	进入转账取款作废页面  模态框未找到
	public void toEnabledTransferBill(AccountsVTO account) {

	}	
//	作废单个转账取款
	public void enabledTransferBill(AccountsVTO account) {
//		根据id作废
		TransferBillVO byId;
		try {
			byId = transferBillDAO.getById(account.getId());
			byId.setEnabled("N");
			transferBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toTransferBill(AccountsVTO account) {
		TransferBillVO transferBill = null;
		try {
			transferBill = transferBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("transferBill", transferBill);
	}
	
	
//	进入资金借入页面需要的数据
	public void toInLoanBills() {
		List<LoanBillVO> loanBills = loanBillDAO.findAllInEnableds();
		ActionContext.getContext().getValueStack().set("loanBills", loanBills);
	}
//	进入资金借入页面需要的数据（带搜索条件）
	public void selectInLoanBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<LoanBillVO> loanBills = loanBillDAO.selectInLoanBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("loanBills", loanBills);
	}
//	进入资金借入作废页面  模态框未找到
	public void toEnabledInLoanBill(AccountsVTO account) {
		try {
//			根据id进行查找
			LoanBillVO loanBills = loanBillDAO.getById(account.getLoanBill().getId());
			ActionContext.getContext().getValueStack().set("loanBills", loanBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
//	作废单个资金借入
	public void enabledInLoanBill(AccountsVTO account) {
//		根据id作废
		LoanBillVO byId;
		try {
			byId = loanBillDAO.getById(account.getId());
			byId.setEnabled("N");
			loanBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toInLoanBill(AccountsVTO account) {
		LoanBillVO loanBill=null;
		try {
			loanBill = loanBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("loanBill", loanBill);
	}
	
	
	
//	进入资金借出页面需要的数据
	public void toOutLoanBills() {
		List<LoanBillVO> loanBills = loanBillDAO.findAllOutEnableds();
		ActionContext.getContext().getValueStack().set("loanBills", loanBills);
	}
//	进入资金借出页面需要的数据（带搜索条件）
	public void selectOutLoanBill(AccountsVTO account) {
//		搜索条件  付款公司	单号
		List<LoanBillVO> loanBills = loanBillDAO.selectOutLoanBill("格力空调","1");
		ActionContext.getContext().getValueStack().set("loanBills", loanBills);
	}
//	进入资金借出作废页面  模态框未找到
	public void toEnabledOutLoanBill(AccountsVTO account) {
		try {
//			根据id进行查找
			LoanBillVO loanBill = loanBillDAO.getById(account.getLoanBill().getId());
			ActionContext.getContext().getValueStack().set("loanBill", loanBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
//	作废单个资金借出
	public void enabledOutLoanBill(AccountsVTO account) {
//		根据id作废
		LoanBillVO byId;
		try {
			byId = loanBillDAO.getById(account.getId());
			byId.setEnabled("N");
			loanBillDAO.update(byId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void toOutLoanBill(AccountsVTO account) {
		LoanBillVO loanBill=null;
		try {
			loanBill = loanBillDAO.getById(account.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("loanBill", loanBill);
	}
}