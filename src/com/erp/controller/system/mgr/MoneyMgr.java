/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import org.hibernate.SQLQuery;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.FeeTypeDAOw;
import com.erp.model.dao.IncomeTypeDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeTypeVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.IncomeTypeVO;

/**
 * @author： 如约而至 @time：2017年8月31日 下午10:13:35
 *******************************************************************
 @说明：
 *******************************************************************/
public class MoneyMgr {

	private BankAccountDAOw bankAccountDAO = new BankAccountDAOw();
	private IncomeTypeDAOw incomeTypeDAO = new IncomeTypeDAOw();
	private FeeTypeDAOw feeTypeDAO = new FeeTypeDAOw();

	/**
	 * @throws Exception
	 * @说明：获得bankaccount列表
	 */
	/*
	 * public List<BankAccountVO> getBankAccountList() throws Exception { return
	 * bankAccountDAO.findAllOderyBySequenceCode(); }
	 */
	/**
	 * @throws Exception
	 * @说明：停止账户
	 */
	public void stopBankAccountById(long id, Integer str) throws Exception {
		bankAccountDAO.stopBankAccountById(id, str);

	}

	/**
	 * @throws Exception
	 * @说明：删除账户
	 */
	public void deleteBankAccountById(long id) throws Exception {
		bankAccountDAO.delete(id);
	}

	/**
	 * @说明：
	 */
	public int getBankAccountSequenceCodeMax() {
		return bankAccountDAO.getBankAccountSequenceCodeMax();
	}

	public void save(BankAccountVO bankAccount) throws Exception {
		bankAccountDAO.save(bankAccount);
	}

	public void save(IncomeTypeVO incomeType) throws Exception {
		IncomeTypeVO incomeTypeVO = new IncomeTypeVO();
		incomeTypeVO.setId(incomeType.getSequenceCode() + 10l);
		incomeTypeVO.setEnabled(incomeType.getEnabled());
		incomeTypeVO.setSequenceCode(incomeType.getSequenceCode());
		incomeTypeVO.setTypeName(incomeType.getTypeName());
		System.out.println(incomeTypeVO + "..");
		incomeTypeDAO.save(incomeTypeVO);
	}

	/**
	 * @说明：
	 */
	public void save(FeeTypeVO feeType) throws Exception {
		/*
		 * FeeTypeVO feeTypeVO=new FeeTypeVO();
		 * feeTypeVO.setId(feeType.getSequenceCode()+10l);
		 * feeTypeVO.setEnabled(feeType.getEnabled());
		 * feeTypeVO.setSequenceCode(feeType.getSequenceCode());
		 * feeTypeVO.setTypeName(feeType.getTypeName());
		 * System.out.println(feeTypeVO);
		 */
		feeTypeDAO.save(feeType);
	}

	/**
	 * @说明：
	 */
	public int getFeeTypeSequenceCodeMax() {
		return feeTypeDAO.getFeeTypeSequenceCodeMax();
	}

	/**
	 * @throws Exception
	 * @说明：用bank-account中id 获得指定信息
	 */
	public BankAccountVO getBankAccountById(long id) throws Exception {
		return bankAccountDAO.getById(id);
	}

	/**
	 * @throws Exception
	 * @说明：更新银行看
	 */
	public void updateBankAccount(BankAccountVO bankAccount) throws Exception {
		bankAccountDAO.update(bankAccount);
	}

	/**
	 * @说明：
	 */
	public List<IncomeTypeVO> getIncomeTypeList() {
		// TODO Auto-generated method stub
		return incomeTypeDAO.findAllOderyBySequenceCode();
	}

	/**
	 * @说明：
	 */
	public int getIncomeTypeSequenceCodeMax() {
		return incomeTypeDAO.getIncomeTypeSequenceCodeMax();
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public IncomeTypeVO getIncomeTypeById(long id) throws Exception {
		return incomeTypeDAO.getById(id);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public void updateIncomeType(IncomeTypeVO incomeType) throws Exception {
		incomeTypeDAO.update(incomeType);

	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public void deleteIncomeTypeById(long id) throws Exception {
		incomeTypeDAO.delete(id);
	}

	/**
	 * @说明：
	 */
	public List<FeeTypeVO> getFeeTypeList() throws Exception {
		return feeTypeDAO.findAllOderyBySequenceCode();
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public FeeTypeVO getFeeTypeById(long id) throws Exception {
		// TODO Auto-generated method stub
		return feeTypeDAO.getById(id);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public void updateFeeType(FeeTypeVO feeType) throws Exception {
		feeTypeDAO.update(feeType);

	}

	/**
	 * @throws Exception
	 * @说明：
	 */

	public void deleteFeeTypeById(long id) throws Exception {
		feeTypeDAO.delete(id);
	}

	/**
	 * @throws Exception
	 * @说明：获得bankaccount列表
	 */
	public FenyeMode fenyeService(Integer maxNumEveryPage, Integer currentPageNum) {
		FenyeMode fenyeMode = new FenyeMode();
		fenyeMode.setMaxNumEveryPage(maxNumEveryPage);
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;

		SQLQuery query = bankAccountDAO.findAllOderyBySequenceCode();
		Integer allResultNum = query.list().size();
		// 3：设置全部结果数
		fenyeMode.setAllResultNum(allResultNum);

		Integer allPageNum = (allResultNum % maxNumEveryPage == 0) ? allResultNum / maxNumEveryPage
				: allResultNum / maxNumEveryPage + 1;

		// 4:设置一共多少页
		fenyeMode.setAllPageNum(allPageNum);
		// 5：设置如果到了最后一页，那么跳回到第一页
		if (currentPageNum > allPageNum) {
			currentPageNum = allPageNum;
		}
		// 再设置一次当前页currentPageNum
		fenyeMode.setCurrentPageNum(currentPageNum);
		// 设置每页最大数量
		query.setMaxResults(fenyeMode.getMaxNumEveryPage());
		// 设置从第几条数据开始
		query.setFirstResult((currentPageNum - 1) * maxNumEveryPage);
		// 取得结果集
		List<BankAccountVO> bankAccountVOs = query.list();
		// 5：装在结果集
		fenyeMode.setBankAccountList(bankAccountVOs);
		System.out.println(bankAccountVOs + "................bankAccountVOs");
		return fenyeMode;
	}
}
