package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.ProductDAOw;
import com.erp.model.dao.ProductTypeDAOw;
import com.erp.model.dao.PurchaseBillDAOw;
import com.erp.model.dao.PurchaseBillItemDAOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.ProductTypeVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;

public class CaigoumingxiMgr {
	PurchaseBillDAOw purchaseBillDAO = new PurchaseBillDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	PurchaseBillItemDAOw purchaseBillItemDAO = new PurchaseBillItemDAOw();
	ProductTypeDAOw productTypeDAO = new ProductTypeDAOw();
	ProductDAOw productDAO = new ProductDAOw();

	public List<PurchaseBillVO> findPurchaseBillsByLimit(long tallySetId) {
		return purchaseBillDAO.findPurchaseBillsByLimit(tallySetId);
	}

	public List<List<ProductVO>> findProductVOssByPbIds(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			ids.add(purchaseBillVO.getId());
		}

		List<List<ProductVO>> pList = purchaseBillItemDAO.findProductVOssByPBids(ids);
		return pList;
	}

	/*
	 * public List<List<ProductVO>>
	 * findProductVOssByPbIIds(List<List<PurchaseBillItemVO>> list) { List<Long>
	 * billIds=new ArrayList<Long>(); for (List<PurchaseBillItemVO>
	 * purchaseBillItemVOs : list) { for (PurchaseBillItemVO purchaseBillItemVO
	 * : purchaseBillItemVOs) { billIds.add(purchaseBillItemVO.getBillId()); } }
	 * System.out.println(
	 * "这是得到的PBI.billId,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"
	 * +billIds); List<List<ProductVO>>
	 * pList2=productDAO.findProductVOssByPbIIds(billIds); return pList2; }
	 */
	public List<List<PurchaseBillItemVO>> findPBIss(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> purchaseBillids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			purchaseBillids.add(purchaseBillVO.getId());

		}
		List<List<PurchaseBillItemVO>> pList = purchaseBillItemDAO.findPBIss(purchaseBillids);
		return pList;
	}

	public List<ProductTypeVO> findPsByProIds(List<List<ProductVO>> productVOSS) {
		List<Long> productTypeIds = new ArrayList<Long>();
		for (List<ProductVO> productvos : productVOSS) {
			for (ProductVO productVO : productvos) {
				productTypeIds.add(productVO.getProductTypeId());
			}
		}
		return productTypeDAO.findPsByProIds(productTypeIds);
	}

	public List<EstablishmentVO> findEstsByPbIds(List<PurchaseBillVO> purchaseBillVOs2) {
		List<Long> estids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs2) {
			estids.add(purchaseBillVO.getProviderId());
		}
		return establishmentDAO.findEstsByPbIds(estids);
	}

	public List<List<ProductVO>> findProductVOssByPbIIds(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> billids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			billids.add(purchaseBillVO.getId());

		}
		return productDAO.findProductVOssByPbIIds(billids);
	}

	public List<PurchaseBillVO> findPurchaseBillVOs2(
			List<List<PurchaseBillItemVO>> purchaseBillItemVOSS) {
		List<Long> pbIds = new ArrayList<Long>();
		for (List<PurchaseBillItemVO> list : purchaseBillItemVOSS) {
			for (PurchaseBillItemVO purchaseBillItemVO : list) {
				pbIds.add(purchaseBillItemVO.getBillId());
			}
		}
		System.out.println(pbIds);
		return purchaseBillDAO.findPurchaseBillVOs2(pbIds);
	}

	public List<List<PurchaseBillItemVO>> findPBIss2(List<PurchaseBillVO> purchaseBillVOs) {

		return purchaseBillItemDAO.findPBIss2(purchaseBillVOs);
	}

	/**
	 * @fu 采购汇总
	 * @return
	 */
	public String findCaigouhuizong() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public List<PurchaseBillItemVO>
	 * findPBIchongfuBillIds(List<PurchaseBillVO> purchaseBillVOs) { return
	 * purchaseBillItemDAO.findPBIchongfuBillIds(purchaseBillVOs); }
	 */

}
