/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.OutputVO;
import com.erp.model.vo.WorkCenterVO;
import com.erp.model.vo.WorkProcessVO;

/**
 * @author： 如约而至 @time：2017年10月12日 下午9:11:09
 *******************************************************************
 @说明： 产量计件明细表
 *******************************************************************/
public class OuputDetailVTOw {
	private List<BusinessBillVO> businessBillVO2;
	private BusinessBillVO businessBillVO;
	private OutputVO outputVO;
	private BusinessBillItemVO businessBillItemVO;
	private EstablishmentVO establishmentVO;
	private WorkCenterVO workCenterVO;
	private WorkProcessVO workProcessVO;
	private MakeTypeVO makeTypeVO;
	private String time;

	private List<EstablishmentVO> establishmentVOs;
	private List<BusinessBillItemVO> businessBillItemVOs;
	private List<MakeTypeVO> makeTypeVOs;
	private List<WorkCenterVO> workCenterVOs;
	private List<BusinessBillItemExtVO> businessBillItemExtVOs;

	public OutputVO getOutputVO() {
		return outputVO;
	}

	public void setOutputVO(OutputVO outputVO) {
		this.outputVO = outputVO;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public WorkCenterVO getWorkCenterVO() {
		return workCenterVO;
	}

	public void setWorkCenterVO(WorkCenterVO workCenterVO) {
		this.workCenterVO = workCenterVO;
	}

	public WorkProcessVO getWorkProcessVO() {
		return workProcessVO;
	}

	public void setWorkProcessVO(WorkProcessVO workProcessVO) {
		this.workProcessVO = workProcessVO;
	}

	public MakeTypeVO getMakeTypeVO() {
		return makeTypeVO;
	}

	public void setMakeTypeVO(MakeTypeVO makeTypeVO) {
		this.makeTypeVO = makeTypeVO;
	}

	public BusinessBillItemVO getBusinessBillItemVO() {
		return businessBillItemVO;
	}

	public void setBusinessBillItemVO(BusinessBillItemVO businessBillItemVO) {
		this.businessBillItemVO = businessBillItemVO;
	}

	public List<BusinessBillVO> getBusinessBillVO2() {
		return businessBillVO2;
	}

	public void setBusinessBillVO2(List<BusinessBillVO> businessBillVO2) {
		this.businessBillVO2 = businessBillVO2;
	}

	public List<WorkProcessVO> getWorkProcessVOs() {
		return workProcessVOs;
	}

	public void setWorkProcessVOs(List<WorkProcessVO> workProcessVOs) {
		this.workProcessVOs = workProcessVOs;
	}

	private List<OutputVO> outputVOs;
	private List<BusinessBillVO> businessBillVOs;
	private List<List<OutputVO>> outPutVoss;
	private List<List<BusinessBillItemVO>> businessBillItemVOss;
	private List<WorkProcessVO> workProcessVOs;

	public List<List<BusinessBillItemVO>> getBusinessBillItemVOss() {
		return businessBillItemVOss;
	}

	public void setBusinessBillItemVOss(List<List<BusinessBillItemVO>> businessBillItemVOss) {
		this.businessBillItemVOss = businessBillItemVOss;
	}

	public List<List<OutputVO>> getOutPutVoss() {
		return outPutVoss;
	}

	public void setOutPutVoss(List<List<OutputVO>> outPutVoss) {
		this.outPutVoss = outPutVoss;
	}

	/**
	 * @return the businessBillVO
	 */
	public BusinessBillVO getBusinessBillVO() {
		return businessBillVO;
	}

	/**
	 * @param businessBillVO
	 *            the businessBillVO to set
	 */
	public void setBusinessBillVO(BusinessBillVO businessBillVO) {
		this.businessBillVO = businessBillVO;
	}

	/**
	 * @return the establishmentVOs
	 */
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	/**
	 * @param establishmentVOs
	 *            the establishmentVOs to set
	 */
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	/**
	 * @return the businessBillItemVOs
	 */
	public List<BusinessBillItemVO> getBusinessBillItemVOs() {
		return businessBillItemVOs;
	}

	/**
	 * @param businessBillItemVOs
	 *            the businessBillItemVOs to set
	 */
	public void setBusinessBillItemVOs(List<BusinessBillItemVO> businessBillItemVOs) {
		this.businessBillItemVOs = businessBillItemVOs;
	}

	/**
	 * @return the makeTypeVOs
	 */
	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}

	/**
	 * @param makeTypeVOs
	 *            the makeTypeVOs to set
	 */
	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}

	/**
	 * @return the workCenterVOs
	 */
	public List<WorkCenterVO> getWorkCenterVOs() {
		return workCenterVOs;
	}

	/**
	 * @param workCenterVOs
	 *            the workCenterVOs to set
	 */
	public void setWorkCenterVOs(List<WorkCenterVO> workCenterVOs) {
		this.workCenterVOs = workCenterVOs;
	}

	/**
	 * @return the businessBillItemExtVOs
	 */
	public List<BusinessBillItemExtVO> getBusinessBillItemExtVOs() {
		return businessBillItemExtVOs;
	}

	/**
	 * @param businessBillItemExtVOs
	 *            the businessBillItemExtVOs to set
	 */
	public void setBusinessBillItemExtVOs(List<BusinessBillItemExtVO> businessBillItemExtVOs) {
		this.businessBillItemExtVOs = businessBillItemExtVOs;
	}

	/**
	 * @return the outputVOs
	 */
	public List<OutputVO> getOutputVOs() {
		return outputVOs;
	}

	/**
	 * @param outputVOs
	 *            the outputVOs to set
	 */
	public void setOutputVOs(List<OutputVO> outputVOs) {
		this.outputVOs = outputVOs;
	}

	/**
	 * @return the businessBillVOs
	 */
	public List<BusinessBillVO> getBusinessBillVOs() {
		return businessBillVOs;
	}

	/**
	 * @param businessBillVOs
	 *            the businessBillVOs to set
	 */
	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}

}
