/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.ProductDAOw;
import com.erp.model.dao.ProductTypeDAOw;
import com.erp.model.dao.PurchaseBillDAOw;
import com.erp.model.dao.PurchaseBillItemDAOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;

/**
 * @author： 如约而至 @time：2017年10月10日 下午6:45:15
 *******************************************************************
 @说明：
 *******************************************************************/
public class GYScaigouhuizongMgr {
	PurchaseBillDAOw purchaseBillDAO = new PurchaseBillDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	PurchaseBillItemDAOw purchaseBillItemDAO = new PurchaseBillItemDAOw();
	ProductTypeDAOw productTypeDAO = new ProductTypeDAOw();
	ProductDAOw productDAO = new ProductDAOw();

	/**
	 * @说明：
	 */
	public List<PurchaseBillVO> getPurchaseBillVOS(long tallySetId) {
		// TODO Auto-generated method stub
		return purchaseBillDAO.getPurchaseBillVOS(tallySetId);
	}

	/**
	 * @说明：
	 */
	public List<List<PurchaseBillItemVO>> findPBIss(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> purchaseBillids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			purchaseBillids.add(purchaseBillVO.getId());

		}
		List<List<PurchaseBillItemVO>> PBISS = purchaseBillItemDAO.findPBIss(purchaseBillids);
		return PBISS;
	}

	/**
	 * @说明：
	 */
	public List<List<PurchaseBillItemVO>> findPBIss2(List<PurchaseBillVO> purchaseBillVOs) {
		// TODO Auto-generated method stub
		return purchaseBillItemDAO.findPBIss2(purchaseBillVOs);
	}

	/**
	 * @说明：
	 */
	public List<List<ProductVO>> findProductVOssByPbIIds(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> billids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			billids.add(purchaseBillVO.getId());

		}
		return productDAO.findProductVOssByPbIIds(billids);
	}

	/**
	 * @param purchaseBillItemVOSS
	 * @return
	 */
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

	/**
	 * @param purchaseBillVOs2
	 * @return
	 */
	public List<EstablishmentVO> findEstsByPbIds(List<PurchaseBillVO> purchaseBillVOs2) {
		List<Long> estids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs2) {
			estids.add(purchaseBillVO.getProviderId());
		}
		return establishmentDAO.findEstsByPbIds(estids);
	}

}
