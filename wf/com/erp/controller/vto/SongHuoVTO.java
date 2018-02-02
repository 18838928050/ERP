/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.DeliverBillVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.TallySetVO;

/**
 * @author： 如约而至 @time：2017年12月15日 上午9:48:49
 *******************************************************************
 @说明：
 *******************************************************************/
public class SongHuoVTO {
	private List<EstablishmentVO> establishmentVOs;
	private List<BusinessBillVO> businessBillVOs;
	private List<DeliverBillVO> deliverBillVOs;
	private DeliverBillVO deliverBillVO;

	private EstablishmentVO establishmentVO;
	private PayModeVO payModeVO;
	private TallySetVO tallySetVO;
	private DepartmentVO departmentVO;
	private BusinessBillVO businessBillVO;

	private List<BusinessBillItemVO> businessBillItemVOs;
	private List<BusinessBillItemExtVO> billItemExtVOs;
	private List<MakeTypeVO> makeTypeVOs;

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public List<BusinessBillVO> getBusinessBillVOs() {
		return businessBillVOs;
	}

	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}

	public List<DeliverBillVO> getDeliverBillVOs() {
		return deliverBillVOs;
	}

	public void setDeliverBillVOs(List<DeliverBillVO> deliverBillVOs) {
		this.deliverBillVOs = deliverBillVOs;
	}

	public DeliverBillVO getDeliverBillVO() {
		return deliverBillVO;
	}

	public void setDeliverBillVO(DeliverBillVO deliverBillVO) {
		this.deliverBillVO = deliverBillVO;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public PayModeVO getPayModeVO() {
		return payModeVO;
	}

	public void setPayModeVO(PayModeVO payModeVO) {
		this.payModeVO = payModeVO;
	}

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public BusinessBillVO getBusinessBillVO() {
		return businessBillVO;
	}

	public void setBusinessBillVO(BusinessBillVO businessBillVO) {
		this.businessBillVO = businessBillVO;
	}

	public List<BusinessBillItemVO> getBusinessBillItemVOs() {
		return businessBillItemVOs;
	}

	public void setBusinessBillItemVOs(List<BusinessBillItemVO> businessBillItemVOs) {
		this.businessBillItemVOs = businessBillItemVOs;
	}

	public List<BusinessBillItemExtVO> getBillItemExtVOs() {
		return billItemExtVOs;
	}

	public void setBillItemExtVOs(List<BusinessBillItemExtVO> billItemExtVOs) {
		this.billItemExtVOs = billItemExtVOs;
	}

	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}

	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}

}