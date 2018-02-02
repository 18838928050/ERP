package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.FeeBillItemVO;
import com.erp.model.vo.FeeBillVO;
import com.erp.model.vo.FeeTypeVO;
import com.erp.model.vo.TallySetVO;

/**
 * 费用单审核
 * 
 * @author fu
 *
 */
public class FeeBillVTOw {
	private FeeBillVO feeBillVO;
	private List<FeeBillItemVO> feeBillItemVOs;
	private List<FeeBillVO> feeBillVOs;
	private TallySetVO tallySetVO;
	private BankAccountVO bankAccountVO;
	private DepartmentVO departmentVO;
	private List<FeeTypeVO> feeTypeVOs;

	public List<FeeTypeVO> getFeeTypeVOs() {
		return feeTypeVOs;
	}

	public void setFeeTypeVOs(List<FeeTypeVO> feeTypeVOs) {
		this.feeTypeVOs = feeTypeVOs;
	}

	public FeeBillVO getFeeBillVO() {
		return feeBillVO;
	}

	public void setFeeBillVO(FeeBillVO feeBillVO) {
		this.feeBillVO = feeBillVO;
	}

	public List<FeeBillItemVO> getFeeBillItemVOs() {
		return feeBillItemVOs;
	}

	public void setFeeBillItemVOs(List<FeeBillItemVO> feeBillItemVOs) {
		this.feeBillItemVOs = feeBillItemVOs;
	}

	public List<FeeBillVO> getFeeBillVOs() {
		return feeBillVOs;
	}

	public void setFeeBillVOs(List<FeeBillVO> feeBillVOs) {
		this.feeBillVOs = feeBillVOs;
	}

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

}
