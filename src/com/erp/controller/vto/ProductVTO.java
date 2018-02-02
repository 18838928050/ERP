package com.erp.controller.vto;

import java.util.List;

import com.erp.controller.stock.vo.OutBillVO;
import com.erp.model.vo.OutBillItem;
import com.erp.model.vo.Product;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.StorehouseVO;

public class ProductVTO {
	private PurchaseBillItemVO purchaseBillItemVO;
	private OutBillVO outBillVO;
	private OutBillItem outBillItem;
	private ProductType productType;
	private Product product;
	private List<StorehouseVO> storehouseVOs;
	private List<OutBillVO> outBillVOs;
	private List<PurchaseBillItemVO> purchaseBillItemVOs;
	
	public List<PurchaseBillItemVO> getPurchaseBillItemVOs() {
		return purchaseBillItemVOs;
	}
	public void setPurchaseBillItemVOs(List<PurchaseBillItemVO> purchaseBillItemVOs) {
		this.purchaseBillItemVOs = purchaseBillItemVOs;
	}
	public PurchaseBillItemVO getPurchaseBillItemVO() {
		return purchaseBillItemVO;
	}
	public void setPurchaseBillItemVO(PurchaseBillItemVO purchaseBillItemVO) {
		this.purchaseBillItemVO = purchaseBillItemVO;
	}
	public List<StorehouseVO> getStorehouseVOs() {
		return storehouseVOs;
	}
	public void setStorehouseVOs(List<StorehouseVO> storehouseVOs) {
		this.storehouseVOs = storehouseVOs;
	}
	public List<OutBillVO> getOutBillVOs() {
		return outBillVOs;
	}
	public void setOutBillVOs(List<OutBillVO> outBillVOs) {
		this.outBillVOs = outBillVOs;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OutBillVO getOutBillVO() {
		return outBillVO;
	}
	public void setOutBillVO(OutBillVO outBillVO) {
		this.outBillVO = outBillVO;
	}
	public OutBillItem getOutBillItem() {
		return outBillItem;
	}
	public void setOutBillItem(OutBillItem outBillItem) {
		this.outBillItem = outBillItem;
	}
	
	

}
