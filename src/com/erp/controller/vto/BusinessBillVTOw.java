/**
 * 
 */
package com.erp.controller.vto;

import java.math.BigDecimal;
import java.util.List;

import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.AdjustBillItemVO;
import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.CodeRuleVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EnterpriseInfoVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.PublicVO;
import com.erp.model.vo.SerarchBeans;
import com.erp.model.vo.TallySetVO;
import com.erp.model.vo.WorkCenterVO;

/**
 @author： 如约而至    @time：2017年9月12日 下午8:05:21 
 *******************************************************************
 @说明： 业务单一览表
 *******************************************************************/
public class BusinessBillVTOw {
	
	//查询条件bean 
	private SerarchBeans serarchBeans;
	
	
	//用于修改业务改单时 提交的三个table 每个table 用一个数组将值传到后台（如果用一个的话 重复了！）
	private List<BusinessBillItemVO> businessBillItemVOsOne;
	private List<BusinessBillItemVO> businessBillItemVOsTwo;
	private List<BusinessBillItemVO> businessBillItemVOsThree;
	
	//已收金额
	private List<BigDecimal> yishous;
	//欠款
	private List<BigDecimal> qianMoneys;
	//调账数据
	private List<BigDecimal> zhangtaos;
	private BankAccountVO bankAccountVO;
	private AccessoryVO accessoryVO;
	private List<AccessoryVO> accessoryVOs;
	private TallySetVO tallySetVO;
	private BusinessBillExtVO businessBillExtVO;
	private BusinessBillVO businessBillVO;
	private EstablishmentVO establishmentVO;
	private BusinessBillItemVO businessBillItemVO;
	private WorkCenterVO workCenterVO;
	private MakeTypeVO makeTypeVO;
	private PayModeVO payModeVO;
	private List<MakeTypeVO> makeTypeVOs;
	private List<List<MakeTypeVO>> maketypeListList;
	private List<WorkCenterVO> workCenterVOs;
	private List<List<WorkCenterVO>> workCenterListList;
	private List<BusinessBillItemVO> businessBillItemVOs;
	
	private List<BusinessBillVO> businessBillVOs;
	private List<EstablishmentVO> establishmentVOs;
	private List<BusinessBillExtVO> businessBillExtVOs;
	
	private List<PayModeVO> payModeVOs;
	
	private List<List<BusinessBillItemVO>> businessBillItemListsList;
	private DepartmentVO departmentVO;
	private List<DepartmentVO> departmentVOs;
	private CodeRuleVO codeRuleVO;
	private List<AdjustBillItemVO> adjustBillItemVOs;
	private EnterpriseInfoVO enterpriseInfoVO;
	private List<AdjustBillVO> adjustBillVOs;
	private List<List<AdjustBillItemVO>> adjustBillItemss;
	
	
	
	
	
	
	
	
	
	public SerarchBeans getSerarchBeans() {
		return serarchBeans;
	}
	public void setSerarchBeans(SerarchBeans serarchBeans) {
		this.serarchBeans = serarchBeans;
	}
	public List<BusinessBillItemVO> getBusinessBillItemVOsOne() {
		return businessBillItemVOsOne;
	}
	public void setBusinessBillItemVOsOne(
			List<BusinessBillItemVO> businessBillItemVOsOne) {
		this.businessBillItemVOsOne = businessBillItemVOsOne;
	}
	public List<BusinessBillItemVO> getBusinessBillItemVOsTwo() {
		return businessBillItemVOsTwo;
	}
	public void setBusinessBillItemVOsTwo(
			List<BusinessBillItemVO> businessBillItemVOsTwo) {
		this.businessBillItemVOsTwo = businessBillItemVOsTwo;
	}
	public List<BusinessBillItemVO> getBusinessBillItemVOsThree() {
		return businessBillItemVOsThree;
	}
	public void setBusinessBillItemVOsThree(
			List<BusinessBillItemVO> businessBillItemVOsThree) {
		this.businessBillItemVOsThree = businessBillItemVOsThree;
	}
	public List<BigDecimal> getYishous() {
		return yishous;
	}
	public void setYishous(List<BigDecimal> yishous) {
		this.yishous = yishous;
	}
	public List<BigDecimal> getQianMoneys() {
		return qianMoneys;
	}
	public void setQianMoneys(List<BigDecimal> qianMoneys) {
		this.qianMoneys = qianMoneys;
	}
	public List<BigDecimal> getZhangtaos() {
		return zhangtaos;
	}
	public void setZhangtaos(List<BigDecimal> zhangtaos) {
		this.zhangtaos = zhangtaos;
	}
	public List<List<AdjustBillItemVO>> getAdjustBillItemss() {
		return adjustBillItemss;
	}
	public void setAdjustBillItemss(List<List<AdjustBillItemVO>> adjustBillItemss) {
		this.adjustBillItemss = adjustBillItemss;
	}
	public List<AdjustBillVO> getAdjustBillVOs() {
		return adjustBillVOs;
	}
	public void setAdjustBillVOs(List<AdjustBillVO> adjustBillVOs) {
		this.adjustBillVOs = adjustBillVOs;
	}
	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}
	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}
	
	public EnterpriseInfoVO getEnterpriseInfoVO() {
		return enterpriseInfoVO;
	}
	public void setEnterpriseInfoVO(EnterpriseInfoVO enterpriseInfoVO) {
		this.enterpriseInfoVO = enterpriseInfoVO;
	}
	public List<List<WorkCenterVO>> getWorkCenterListList() {
		return workCenterListList;
	}
	public void setWorkCenterListList(List<List<WorkCenterVO>> workCenterListList) {
		this.workCenterListList = workCenterListList;
	}
	public List<List<MakeTypeVO>> getMaketypeListList() {
		return maketypeListList;
	}
	public void setMaketypeListList(List<List<MakeTypeVO>> maketypeListList) {
		this.maketypeListList = maketypeListList;
	}
	
	public CodeRuleVO getCodeRuleVO() {
		return codeRuleVO;
	}
	public void setCodeRuleVO(CodeRuleVO codeRuleVO) {
		this.codeRuleVO = codeRuleVO;
	}
	public List<List<BusinessBillItemVO>> getBusinessBillItemListsList() {
		return businessBillItemListsList;
	}
	public void setBusinessBillItemListsList(
			List<List<BusinessBillItemVO>> businessBillItemListsList) {
		this.businessBillItemListsList = businessBillItemListsList;
	}
	public PayModeVO getPayModeVO() {
		return payModeVO;
	}
	
	
	public List<AdjustBillItemVO> getAdjustBillItemVOs() {
		return adjustBillItemVOs;
	}
	public void setAdjustBillItemVOs(List<AdjustBillItemVO> adjustBillItemVOs) {
		this.adjustBillItemVOs = adjustBillItemVOs;
	}
	public void setPayModeVO(PayModeVO payModeVO) {
		this.payModeVO = payModeVO;
	}
	public List<DepartmentVO> getDepartmentVOs() {
		return departmentVOs;
	}
	public void setDepartmentVOs(List<DepartmentVO> departmentVOs) {
		this.departmentVOs = departmentVOs;
	}
	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}
	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
	public List<AccessoryVO> getAccessoryVOs() {
		return accessoryVOs;
	}
	public void setAccessoryVOs(List<AccessoryVO> accessoryVOs) {
		this.accessoryVOs = accessoryVOs;
	}
	public AccessoryVO getAccessoryVO() {
		return accessoryVO;
	}
	public void setAccessoryVO(AccessoryVO accessoryVO) {
		this.accessoryVO = accessoryVO;
	}
	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}
	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}
	public BusinessBillExtVO getBusinessBillExtVO() {
		return businessBillExtVO;
	}
	public void setBusinessBillExtVO(BusinessBillExtVO businessBillExtVO) {
		this.businessBillExtVO = businessBillExtVO;
	}
	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}
	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}
	public List<WorkCenterVO> getWorkCenterVOs() {
		return workCenterVOs;
	}
	public void setWorkCenterVOs(List<WorkCenterVO> workCenterVOs) {
		this.workCenterVOs = workCenterVOs;
	}
	public List<BusinessBillItemVO> getBusinessBillItemVOs() {
		return businessBillItemVOs;
	}
	public void setBusinessBillItemVOs(List<BusinessBillItemVO> businessBillItemVOs) {
		this.businessBillItemVOs = businessBillItemVOs;
	}
	public WorkCenterVO getWorkCenterVO() {
		return workCenterVO;
	}
	public void setWorkCenterVO(WorkCenterVO workCenterVO) {
		this.workCenterVO = workCenterVO;
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
	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}
	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}
	public BusinessBillVO getBusinessBillVO() {
		return businessBillVO;
	}
	public void setBusinessBillVO(BusinessBillVO businessBillVO) {
		this.businessBillVO = businessBillVO;
	}
	public List<BusinessBillVO> getBusinessBillVOs() {
		return businessBillVOs;
	}
	public void setBusinessBillVOs(List<BusinessBillVO> businessBillVOs) {
		this.businessBillVOs = businessBillVOs;
	}
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	public List<BusinessBillExtVO> getBusinessBillExtVOs() {
		return businessBillExtVOs;
	}
	public void setBusinessBillExtVOs(List<BusinessBillExtVO> businessBillExtVOs) {
		this.businessBillExtVOs = businessBillExtVOs;
	}
	public List<PayModeVO> getPayModeVOs() {
		return payModeVOs;
	}
	public void setPayModeVOs(List<PayModeVO> payModeVOs) {
		this.payModeVOs = payModeVOs;
	}
	
	
	

}
