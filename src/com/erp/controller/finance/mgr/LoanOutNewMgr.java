package com.erp.controller.finance.mgr;

//import com.erp.controller.finance.dao.BankAccountDAO;
//import com.erp.controller.finance.dao.DepartmentDAO;
import com.erp.model.dao.InFinanceDAO;
import com.erp.model.vo.LoanBill;

/**
 * 资金借出单
 * @author WangEn
 *
 */
public class LoanOutNewMgr {
	private InFinanceDAO inFinanceDao = new InFinanceDAO();
	//private DepartmentDAO departmentDao = new DepartmentDAO();
	//private BankAccountDAO bankAccountDao = new BankAccountDAO();
	/**
	 * 新增资金借出单，保存到loanBill中
	 */
	public void saveLoanBill(LoanBill loanBill){
		try {
			inFinanceDao.save(loanBill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("保存失败！");
			e.printStackTrace();
		}		
	}
	
	
	

}
