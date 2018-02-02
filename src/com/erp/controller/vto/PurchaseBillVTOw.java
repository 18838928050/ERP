package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.ProductTypeVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.StorehouseVO;
import com.erp.model.vo.TallySetVO;

public class PurchaseBillVTOw {
	private PurchaseBillVO purchaseBillVO;
	private BankAccountVO bankAccountVO;
	private List<EstablishmentVO> establishmentVOs2;
	private List<List<ProductVO>> productVOSS;
	private List<ProductVO> productVOs;
	private List<PurchaseBillItemVO> purchaseBillItemVOs;
	private List<PurchaseBillVO> purchaseBillVOs;
	private List<PurchaseBillExtVO> purchaseBillExtVOs;
	private List<EstablishmentVO> establishmentVOs;
	private List<StorehouseVO> storehouseVOs;
	private List<List<EstablishmentVO>> establishmentSS;
	private List<List<StorehouseVO>> storeHouseVOSS;
	private PurchaseBillExtVO purchaseBillExtVO;
	private PurchaseBillItemVO purchaseBillItemVO;
	private EstablishmentVO establishmentVO;
	private ProductVO productVO;
	private TallySetVO tallySetVO;
	private StorehouseVO storehouseVO;
	private List<ProductTypeVO> productTypeVOs;
	private List<List<PurchaseBillItemVO>> purchaseBillItemVOSS;
	private List<PurchaseBillVO> purchaseBillVOs2;
	private List<List<PurchaseBillItemVO>> purhchaseBillItemVOSS2;
	private List<List<ProductVO>> productVOSS2;

	public List<List<ProductVO>> getProductVOSS2() {
		return productVOSS2;
	}

	public void setProductVOSS2(List<List<ProductVO>> productVOSS2) {
		this.productVOSS2 = productVOSS2;
	}

	public List<PurchaseBillVO> getPurchaseBillVOs2() {
		return purchaseBillVOs2;
	}

	public List<List<PurchaseBillItemVO>> getPurhchaseBillItemVOSS2() {
		return purhchaseBillItemVOSS2;
	}

	public void setPurhchaseBillItemVOSS2(List<List<PurchaseBillItemVO>> purhchaseBillItemVOSS2) {
		this.purhchaseBillItemVOSS2 = purhchaseBillItemVOSS2;
	}

	public void setPurchaseBillVOs2(List<PurchaseBillVO> purchaseBillVOs2) {
		this.purchaseBillVOs2 = purchaseBillVOs2;
	}

	public List<List<PurchaseBillItemVO>> getPurchaseBillItemVOSS() {
		return purchaseBillItemVOSS;
	}

	public void setPurchaseBillItemVOSS(List<List<PurchaseBillItemVO>> purchaseBillItemVOSS) {
		this.purchaseBillItemVOSS = purchaseBillItemVOSS;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public List<ProductTypeVO> getProductTypeVOs() {
		return productTypeVOs;
	}

	public void setProductTypeVOs(List<ProductTypeVO> productTypeVOs) {
		this.productTypeVOs = productTypeVOs;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

	public StorehouseVO getStorehouseVO() {
		return storehouseVO;
	}

	public void setStorehouseVO(StorehouseVO storehouseVO) {
		this.storehouseVO = storehouseVO;
	}

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public List<PurchaseBillItemVO> getPurchaseBillItemVOs() {
		return purchaseBillItemVOs;
	}

	public void setPurchaseBillItemVOs(List<PurchaseBillItemVO> purchaseBillItemVOs) {
		this.purchaseBillItemVOs = purchaseBillItemVOs;
	}

	public List<ProductVO> getProductVOs() {
		return productVOs;
	}

	public void setProductVOs(List<ProductVO> productVOs) {
		this.productVOs = productVOs;
	}

	public List<List<ProductVO>> getProductVOSS() {
		return productVOSS;
	}

	public void setProductVOSS(List<List<ProductVO>> productVOSS) {
		this.productVOSS = productVOSS;
	}

	public List<List<StorehouseVO>> getStoreHouseVOSS() {
		return storeHouseVOSS;
	}

	public void setStoreHouseVOSS(List<List<StorehouseVO>> storeHouseVOSS) {
		this.storeHouseVOSS = storeHouseVOSS;
	}

	public List<StorehouseVO> getStorehouseVOs() {
		return storehouseVOs;
	}

	public void setStorehouseVOs(List<StorehouseVO> storehouseVOs) {
		this.storehouseVOs = storehouseVOs;
	}

	public List<List<EstablishmentVO>> getEstablishmentSS() {
		return establishmentSS;
	}

	public void setEstablishmentSS(List<List<EstablishmentVO>> establishmentSS) {
		this.establishmentSS = establishmentSS;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public List<PurchaseBillExtVO> getPurchaseBillExtVOs() {
		return purchaseBillExtVOs;
	}

	public void setPurchaseBillExtVOs(List<PurchaseBillExtVO> purchaseBillExtVOs) {
		this.purchaseBillExtVOs = purchaseBillExtVOs;
	}

	public List<PurchaseBillVO> getPurchaseBillVOs() {
		return purchaseBillVOs;
	}

	public void setPurchaseBillVOs(List<PurchaseBillVO> purchaseBillVOs) {
		this.purchaseBillVOs = purchaseBillVOs;
	}

	public PurchaseBillVO getPurchaseBillVO() {
		return purchaseBillVO;
	}

	public void setPurchaseBillVO(PurchaseBillVO purchaseBillVO) {
		this.purchaseBillVO = purchaseBillVO;
	}

	public PurchaseBillExtVO getPurchaseBillExtVO() {
		return purchaseBillExtVO;
	}

	public void setPurchaseBillExtVO(PurchaseBillExtVO purchaseBillExtVO) {
		this.purchaseBillExtVO = purchaseBillExtVO;
	}

	public PurchaseBillItemVO getPurchaseBillItemVO() {
		return purchaseBillItemVO;
	}

	public void setPurchaseBillItemVO(PurchaseBillItemVO purchaseBillItemVO) {
		this.purchaseBillItemVO = purchaseBillItemVO;
	}

	public void setProductVOSS(ProductVO findProductByPbId) {

	}
}