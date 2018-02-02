/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBill;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.YwduizhangVOOO;

/**
 * @author：fu
 * @date 2017年12月20日 下午6:43:59 一份耕耘，一份收获*****
 */
public class YewuduizhangVTO {
	private YwduizhangVOOO ywduizhangVOOO;

	private EstablishmentVO establishmentVO;
	private BusinessBill businessBill;
	private List<EstablishmentVO> establishmentVOs;
	private List<BusinessBill> businessBills;

	public BusinessBill getBusinessBill() {
		return businessBill;
	}

	public void setBusinessBill(BusinessBill businessBill) {
		this.businessBill = businessBill;
	}

	public List<BusinessBill> getBusinessBills() {
		return businessBills;
	}

	public void setBusinessBills(List<BusinessBill> businessBills) {
		this.businessBills = businessBills;
	}

	public YwduizhangVOOO getYwduizhangVOOO() {
		return ywduizhangVOOO;
	}

	public void setYwduizhangVOOO(YwduizhangVOOO ywduizhangVOOO) {
		this.ywduizhangVOOO = ywduizhangVOOO;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	@Override
	public String toString() {
		return "YewuduizhangVTO [establishmentVO=" + establishmentVO + "]";
	}

}
