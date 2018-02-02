package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.MoneyMgr;
import com.erp.controller.vto.MoneyVTOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FenyeMode;

/**
 * 这里是账务模块
 * 
 * @author fu
 *
 */
public class MoneyBillAction extends BaseAction<MoneyVTOw> {

	private MoneyMgr moneyMgr = new MoneyMgr();
	private Integer CurrentPageNum;
	private Integer MaxNumEveryPage;
	FenyeMode fenyeMode = new FenyeMode();

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return MaxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		MaxNumEveryPage = maxNumEveryPage;
	}

	public FenyeMode getFenyeMode() {
		return fenyeMode;
	}

	public void setFenyeMode(FenyeMode fenyeMode) {
		this.fenyeMode = fenyeMode;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	/**
	 * 
	 * @说明：获得银行账户列表
	 */

	public String BankAccountUI() throws Exception {
		MaxNumEveryPage = (MaxNumEveryPage == null || MaxNumEveryPage.equals("")) ? 10
				: MaxNumEveryPage;
		fenyeMode = moneyMgr.fenyeService(MaxNumEveryPage, CurrentPageNum);
		List<BankAccountVO> bankAccountVOs = fenyeMode.getBankAccountList();
		model.setBankAccountVOs(bankAccountVOs);
		return "toListUI";
	}

	/**
	 * 
	 * @说明：编辑账户 回显功能
	 */
	public String edtiBankAccountUI() throws Exception {
		model.setBankAccount(moneyMgr.getBankAccountById(model.getBankAccount().getId()));
		return "toEditAndUI";
	}

	/**
	 * 
	 * @说明：编辑银行账户
	 */
	public String edtiBankAccount() throws Exception {
		System.out.println(model.getBankAccount().getId());
		moneyMgr.updateBankAccount(model.getBankAccount());
		return "toList";
	}

	/**
	 * 
	 * @说明：停用账户
	 */
	public String StopBankAccount() throws Exception {
		moneyMgr.stopBankAccountById(model.getBankAccount().getId(), model.getBankAccount()
				.getStr());
		return "toList";
	}

	/**
	 * 
	 * @说明：删除账户
	 */
	public String DeleteBankAccount() throws Exception {
		moneyMgr.deleteBankAccountById(model.getBankAccount().getId());
		return "toList";
	}

	/**
	 * 
	 * @说明：添加银行账户回显增加页面
	 */
	public String addBankAccountUI() throws Exception {
		BankAccountVO bankAccountVO = new BankAccountVO();
		bankAccountVO.setSequenceCode(moneyMgr.getBankAccountSequenceCodeMax() + 1);
		model.setBankAccount(bankAccountVO);
		return "toEditAndUI";
	}

	/**
	 * 
	 * @说明：增加银行账户
	 */
	public String addBankAccount() throws Exception {
		moneyMgr.save(model.getBankAccount());
		return "toList";
	}

}
