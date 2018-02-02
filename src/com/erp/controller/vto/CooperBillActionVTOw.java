/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.CooperBillExtVO;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PageVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.TallySetVO;

/**
 * @author： 如约而至 @time：2017年9月4日 上午10:36:18
 *******************************************************************
 @说明：
 *******************************************************************/
public class CooperBillActionVTOw {
	private CooperBillVO cooperBillVO;
	private List<CooperBillVO> cooperBillVOs;
	private CooperBillItemVO cooperBillItemVO;
	
	private List<CooperBillItemVO> cooperBillItemVOs;
	private MakeTypeVO makeTypeVO;
	private TallySetVO tallySetVO;
	private PayModeVO payModeVO;
	private EstablishmentVO establishmentVO;
	private BankAccountVO bankAccountVO;
	private DepartmentVO departmentVO;
	private CooperBillExtVO cooperBillExtVO;
	private BusinessBillVO businessBillVO;
	

	private PageVO pageVO;

	
	public BusinessBillVO getBusinessBillVO() {
		return businessBillVO;
	}

	public void setBusinessBillVO(BusinessBillVO businessBillVO) {
		this.businessBillVO = businessBillVO;
	}

	public CooperBillExtVO getCooperBillExtVO() {
		return cooperBillExtVO;
	}

	public void setCooperBillExtVO(CooperBillExtVO cooperBillExtVO) {
		this.cooperBillExtVO = cooperBillExtVO;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public List<CooperBillItemVO> getCooperBillItemVOs() {
		return cooperBillItemVOs;
	}

	public void setCooperBillItemVOs(List<CooperBillItemVO> cooperBillItemVOs) {
		this.cooperBillItemVOs = cooperBillItemVOs;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public List<CooperBillVO> getCooperBillVOs() {
		return cooperBillVOs;
	}

	public void setCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		this.cooperBillVOs = cooperBillVOs;
	}

	public CooperBillVO getCooperBillVO() {
		return cooperBillVO;
	}

	public void setCooperBillVO(CooperBillVO cooperBillVO) {
		this.cooperBillVO = cooperBillVO;
	}

	public CooperBillItemVO getCooperBillItemVO() {
		return cooperBillItemVO;
	}

	public void setCooperBillItemVO(CooperBillItemVO cooperBillItemVO) {
		this.cooperBillItemVO = cooperBillItemVO;
	}

	public MakeTypeVO getMakeTypeVO() {
		return makeTypeVO;
	}

	public void setMakeTypeVO(MakeTypeVO makeTypeVO) {
		this.makeTypeVO = makeTypeVO;
	}

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public PayModeVO getPayModeVO() {
		return payModeVO;
	}

	public void setPayModeVO(PayModeVO payModeVO) {
		this.payModeVO = payModeVO;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

	@Override
	public String toString() {
		return "CooperBillActionVTO [cooperBillVO=" + cooperBillVO
				+ ", cooperBillItemVO=" + cooperBillItemVO + ", makeTypeVO="
				+ makeTypeVO + ", tallySetVO=" + tallySetVO + ", payModeVO="
				+ payModeVO + ", establishmentVO=" + establishmentVO
				+ ", bankAccountVO=" + bankAccountVO + "]";
	}

}
