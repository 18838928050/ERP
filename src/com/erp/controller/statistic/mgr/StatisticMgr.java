package com.erp.controller.statistic.mgr;

import java.util.List;

import com.erp.controller.accounts.dao.PayBillDAO;
import com.erp.controller.customerBusiness.dao.EstablishmentDAO;
import com.erp.controller.statistic.dao.BankAccountDAO;
import com.erp.controller.statistic.dao.BusinessBillDAO;
import com.erp.controller.statistic.dao.BusinessBillExtDAO;
import com.erp.controller.statistic.dao.BusinessBillProfitDAO;
import com.erp.controller.statistic.dao.PurchaseBillDAO;
import com.erp.controller.statistic.vo.BusinessProfitVO;
import com.erp.controller.subcontractCancel.dao.CooperBillDAO;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.PurchaseBillVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 账务	作废模块
 * @author guo
 *
 */
public class StatisticMgr {
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	private BusinessBillDAO businessBillDAO = new BusinessBillDAO();
	private BusinessBillExtDAO businessBillExtDAO = new BusinessBillExtDAO();
	private BusinessBillProfitDAO businessBillProfitDAO = new BusinessBillProfitDAO();
	private PurchaseBillDAO purchaseBillDAO = new PurchaseBillDAO();
	private BankAccountDAO bankAccountDAO = new BankAccountDAO();
	private PayBillDAO payBillDAO = new PayBillDAO();
	private CooperBillDAO cooperBillDAO = new CooperBillDAO();

	//	获得所有的客户
	public void findAllEstablishment() {
		try {
			List<EstablishmentVO> establishments = establishmentDAO.findAll();
			ActionContext.getContext().getValueStack().set("establishments", establishments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	获得所有的业务单
	public void findAllBusinessBill() {
		try {
			List<BusinessBillVO> businessBills= businessBillDAO.findAll();
			//			根据业务单号查询
			for (BusinessBillVO businessBillVO : businessBills) {
				//通过id获得BusinessBillExtVO中的 已收款和调账
				long id = businessBillVO.getId();
				BusinessBillExtVO byId = businessBillExtDAO.getById(id);
				//通过billcode获得BusinessProfitVO	欠款
				String billCode = businessBillVO.getBillCode();
				BusinessProfitVO findByBillCode = businessBillProfitDAO.findByBillCode(billCode);
				//借用此businessBillVO存放一些值，前台遍历时需要注意
				businessBillVO.setSquare(byId.getReceiveCost());//已收
				businessBillVO.setLengM(byId.getAdjustCost());//调账
				if(findByBillCode != null ){
					businessBillVO.setLengCm(findByBillCode.getProfitCost());//欠款
				}
			}
			ActionContext.getContext().getValueStack().set("businessBills", businessBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//应收汇总表	获得当年的业务单	
	public void findYearBusinessBill() {
		try {
			List<BusinessBillVO> businessBills= businessBillDAO.findYearBill();
			ActionContext.getContext().getValueStack().set("businessBills", businessBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//应收款账龄分布表	
	public void findMonthProfitCost() {
		try {
			List<BusinessBillExtVO> businessBills= businessBillProfitDAO.findMonthProfitCost();
			ActionContext.getContext().getValueStack().set("businessBills", businessBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//采购付款一览表	
	public void findPurPayCostList() {
//		采购
		try {
			List<PurchaseBillVO> purchaseBills = purchaseBillDAO.findAll();
			for (PurchaseBillVO purchaseBillVO : purchaseBills) {
				long providerId = purchaseBillVO.getProviderId();//供应商
				EstablishmentVO establishment = establishmentDAO.getById(providerId);
				purchaseBillVO.setContractCode(establishment.getEstName());//借这个放供应商的值
				long bankAccountId = purchaseBillVO.getBankAccountId();//银行账户
				BankAccountVO bankAccount = bankAccountDAO.getById(bankAccountId);
				try {//空指针
				purchaseBillVO.setAttachFile(bankAccount.getBankName());//借这个存放银行账号
				} catch (Exception e) {
				}
			}
			ActionContext.getContext().getValueStack().set("purchaseBills", purchaseBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		付款
		try {
			List<PayBillVO> payBills = payBillDAO.findAll();
			for (PayBillVO payBill : payBills) {
				long departmentId = payBill.getDepartmentId();//供应商
				EstablishmentVO establishment = establishmentDAO.getById(departmentId);
				payBill.setPayType(establishment.getEstName());//借这个放供应商的值
				long bankAccountId = payBill.getBankAccountId();//银行账户
				BankAccountVO bankAccount = bankAccountDAO.getById(bankAccountId);
				payBill.setAttachFile(bankAccount.getBankName());//借这个存放银行账号
			}
			ActionContext.getContext().getValueStack().set("payBills", payBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	外协付款一览表	
	public void findCooPayCostList() {
//		外协
		try {
			List<CooperBillVO> cooperBills = cooperBillDAO.findAll();
			for (CooperBillVO cooperBill : cooperBills) {
				long cooperatorId = cooperBill.getCooperatorId();//供应商
				EstablishmentVO establishment = establishmentDAO.getById(cooperatorId);
				cooperBill.setAddress(establishment.getEstName());//借这个放供应商的值
				long bankAccountId = cooperBill.getBankAccountId();//银行账户
				BankAccountVO bankAccount = bankAccountDAO.getById(bankAccountId);
				cooperBill.setGatherRequire(bankAccount.getBankName());//借这个存放银行账号
			}
			ActionContext.getContext().getValueStack().set("cooperBills", cooperBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		付款
		try {
			List<PayBillVO> payBills = payBillDAO.findAll();
			for (PayBillVO payBill : payBills) {
				long departmentId = payBill.getDepartmentId();//供应商
				EstablishmentVO establishment = establishmentDAO.getById(departmentId);
				payBill.setPayType(establishment.getEstName());//借这个放供应商的值
				long bankAccountId = payBill.getBankAccountId();//银行账户
				BankAccountVO bankAccount = bankAccountDAO.getById(bankAccountId);
				payBill.setAttachFile(bankAccount.getBankName());//借这个存放银行账号
			}
			ActionContext.getContext().getValueStack().set("payBills", payBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}