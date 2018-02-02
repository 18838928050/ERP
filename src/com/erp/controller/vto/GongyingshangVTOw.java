/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.EstablishmentContactVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.TallySetVO;

/**
 @author： 如约而至    @time：2017年10月6日 下午3:10:12 
 *******************************************************************
 @说明： 供应商
 *******************************************************************/
public class GongyingshangVTOw {
	private EstablishmentVO establishmentVO;
	private List<EstablishmentVO> establishmentVOs;
	private List<TallySetVO> tSetVOs;
	private List<PurchaseBillVO> purchaseBillVOs;
	private List<List<PurchaseBillItemVO>> pLists;
	private List<List<ProductVO>> productVOss;
	private List<PayBillVO> payBillVOs;
	private List<AdjustBillVO> adjustBillVOs;
	private List<EstablishmentContactVO> establishmentContactVOs;
	private TallySetVO tallySetVO;
	private List<AccessoryVO> accessoryVOs;
	private AccessoryVO accessoryVO;
	
	
	
	
	
	/**
	 * @return the accessoryVO
	 */
	public AccessoryVO getAccessoryVO() {
		return accessoryVO;
	}
	/**
	 * @param accessoryVO the accessoryVO to set
	 */
	public void setAccessoryVO(AccessoryVO accessoryVO) {
		this.accessoryVO = accessoryVO;
	}
	/**
	 * @return the accessoryVOs
	 */
	public List<AccessoryVO> getAccessoryVOs() {
		return accessoryVOs;
	}
	/**
	 * @param accessoryVOs the accessoryVOs to set
	 */
	public void setAccessoryVOs(List<AccessoryVO> accessoryVOs) {
		this.accessoryVOs = accessoryVOs;
	}
	/**
	 * @return the tallySetVO
	 */
	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}
	/**
	 * @param tallySetVO the tallySetVO to set
	 */
	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}
	/**
	 * @return the establishmentContactVOs
	 */
	public List<EstablishmentContactVO> getEstablishmentContactVOs() {
		return establishmentContactVOs;
	}
	/**
	 * @param establishmentContactVOs the establishmentContactVOs to set
	 */
	public void setEstablishmentContactVOs(
			List<EstablishmentContactVO> establishmentContactVOs) {
		this.establishmentContactVOs = establishmentContactVOs;
	}
	/**
	 * @return the adjustBillVOs
	 */
	public List<AdjustBillVO> getAdjustBillVOs() {
		return adjustBillVOs;
	}
	/**
	 * @param adjustBillVOs the adjustBillVOs to set
	 */
	public void setAdjustBillVOs(List<AdjustBillVO> adjustBillVOs) {
		this.adjustBillVOs = adjustBillVOs;
	}
	/**
	/**
	 * @return the productVOss
	 */
	public List<List<ProductVO>> getProductVOss() {
		return productVOss;
	}
	/**
	 * @param productVOss the productVOss to set
	 */
	public void setProductVOss(List<List<ProductVO>> productVOss) {
		this.productVOss = productVOss;
	}
	/**
	 * @return the pLists
	 */
	public List<List<PurchaseBillItemVO>> getpLists() {
		return pLists;
	}
	/**
	 * @param pLists the pLists to set
	 */
	public void setpLists(List<List<PurchaseBillItemVO>> pLists) {
		this.pLists = pLists;
	}
	/**
	 * @return the payBillVOs
	 */
	public List<PayBillVO> getPayBillVOs() {
		return payBillVOs;
	}
	/**
	 * @param payBillVOs the payBillVOs to set
	 */
	public void setPayBillVOs(List<PayBillVO> payBillVOs) {
		this.payBillVOs = payBillVOs;
	}
	/**
	 * @return the purchaseBillVOs
	 */
	public List<PurchaseBillVO> getPurchaseBillVOs() {
		return purchaseBillVOs;
	}
	/**
	 * @param purchaseBillVOs the purchaseBillVOs to set
	 */
	public void setPurchaseBillVOs(List<PurchaseBillVO> purchaseBillVOs) {
		this.purchaseBillVOs = purchaseBillVOs;
	}
	
	/**
	 * @return the establishmentVOs
	 */
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	/**
	 * @param establishmentVOs the establishmentVOs to set
	 */
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	/**
	 * @return the tSetVOs
	 */
	public List<TallySetVO> gettSetVOs() {
		return tSetVOs;
	}
	/**
	 * @param tSetVOs the tSetVOs to set
	 */
	public void settSetVOs(List<TallySetVO> tSetVOs) {
		this.tSetVOs = tSetVOs;
	}
	/**
	 * @return the establishmentVO
	 */
	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}
	/**
	 * @param establishmentVO the establishmentVO to set
	 */
	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}
	
	
	

}
