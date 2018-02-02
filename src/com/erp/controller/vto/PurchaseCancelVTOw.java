/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.StorehouseVO;
import com.erp.model.vo.TallySetVO;

/**
 @author： 如约而至    @time：2017年10月10日 下午3:47:54 
 *******************************************************************
 @说明：采购单作废  和退款单
 *******************************************************************/
public class PurchaseCancelVTOw {
	
	
	
	
	
	
	
	
	
	
	/***********************************************************/
	private BankAccountVO bankAccountVO;
	private EstablishmentVO establishmentVO;
	private List<PurchaseBillItemVO> purchaseBillItemVOs;
	private List<ProductVO> productVOs;
	private StorehouseVO storehouseVO;
	private PurchaseBillVO purchaseBillVO;
	private List<PurchaseBillVO> purchaseBillVOs;
	private List<PurchaseBillExtVO> purchaseBillExtVOs;
	private List<StorehouseVO> storehouseVOs;
	private List<EstablishmentVO> establishmentVOs;
	private TallySetVO tallySetVO;
	private PurchaseBillExtVO purchaseBillExtVO;
	private List<PayBillVO> payBillVOs;
	private List<AdjustBillVO> adjustBillVOs;
	
	
	
	
	
	
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
	 * @return the purchaseBillExtVO
	 */
	public PurchaseBillExtVO getPurchaseBillExtVO() {
		return purchaseBillExtVO;
	}
	/**
	 * @param purchaseBillExtVO the purchaseBillExtVO to set
	 */
	public void setPurchaseBillExtVO(PurchaseBillExtVO purchaseBillExtVO) {
		this.purchaseBillExtVO = purchaseBillExtVO;
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
	 * @return the bankAccountVO
	 */
	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}
	/**
	 * @param bankAccountVO the bankAccountVO to set
	 */
	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
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
	/**
	 * @return the purchaseBillItemVOs
	 */
	public List<PurchaseBillItemVO> getPurchaseBillItemVOs() {
		return purchaseBillItemVOs;
	}
	/**
	 * @param purchaseBillItemVOs the purchaseBillItemVOs to set
	 */
	public void setPurchaseBillItemVOs(List<PurchaseBillItemVO> purchaseBillItemVOs) {
		this.purchaseBillItemVOs = purchaseBillItemVOs;
	}
	/**
	 * @return the productVOs
	 */
	public List<ProductVO> getProductVOs() {
		return productVOs;
	}
	/**
	 * @param productVOs the productVOs to set
	 */
	public void setProductVOs(List<ProductVO> productVOs) {
		this.productVOs = productVOs;
	}
	/**
	 * @return the storehouseVO
	 */
	public StorehouseVO getStorehouseVO() {
		return storehouseVO;
	}
	/**
	 * @param storehouseVO the storehouseVO to set
	 */
	public void setStorehouseVO(StorehouseVO storehouseVO) {
		this.storehouseVO = storehouseVO;
	}
	/**
	 * @return the purchaseBillVO
	 */
	public PurchaseBillVO getPurchaseBillVO() {
		return purchaseBillVO;
	}
	/**
	 * @param purchaseBillVO the purchaseBillVO to set
	 */
	public void setPurchaseBillVO(PurchaseBillVO purchaseBillVO) {
		this.purchaseBillVO = purchaseBillVO;
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
	 * @return the purchaseBillExtVOs
	 */
	public List<PurchaseBillExtVO> getPurchaseBillExtVOs() {
		return purchaseBillExtVOs;
	}
	/**
	 * @param purchaseBillExtVOs the purchaseBillExtVOs to set
	 */
	public void setPurchaseBillExtVOs(List<PurchaseBillExtVO> purchaseBillExtVOs) {
		this.purchaseBillExtVOs = purchaseBillExtVOs;
	}
	/**
	 * @return the storehouseVOs
	 */
	public List<StorehouseVO> getStorehouseVOs() {
		return storehouseVOs;
	}
	/**
	 * @param storehouseVOs the storehouseVOs to set
	 */
	public void setStorehouseVOs(List<StorehouseVO> storehouseVOs) {
		this.storehouseVOs = storehouseVOs;
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
	
	
	
	
	
	
	
	
	
	

}
