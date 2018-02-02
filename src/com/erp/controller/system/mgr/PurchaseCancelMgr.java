/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.AdjustBillDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PayBillDaow;
import com.erp.model.dao.ProductDAOw;
import com.erp.model.dao.PurchaseBillDAOw;
import com.erp.model.dao.PurchaseBillExtDAOw;
import com.erp.model.dao.PurchaseBillItemDAOw;
import com.erp.model.dao.StoreHouseDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.StorehouseVO;
import com.erp.model.vo.TallySetVO;

/**
 @author： 如约而至    @time：2017年10月10日 下午3:51:30 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class PurchaseCancelMgr {
	PurchaseBillDAOw purchaseBillDAO=new PurchaseBillDAOw();
	EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
	PurchaseBillExtDAOw purchaseBillExtDAO=new PurchaseBillExtDAOw();
	StoreHouseDAOw storeHouseDAO=new StoreHouseDAOw();
	ProductDAOw productDAO=new ProductDAOw();
	PurchaseBillItemDAOw purchaseBillItemDAO=new PurchaseBillItemDAOw();
	TallySetDAOw tallySetDAO=new TallySetDAOw();
	PayBillDaow payBillDao=new PayBillDaow();
	AdjustBillDAOw adjustBillDAO=new AdjustBillDAOw();

	/**
	 * @说明：
	 */
	public List<PurchaseBillVO> getPurchaseBillsByLimits() {
		return purchaseBillDAO.getPurchaseBillsByLimits();
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<EstablishmentVO> getEstablistments(	List<PurchaseBillVO> purchaseBillVOs) throws Exception {
		List<EstablishmentVO> se=new ArrayList<EstablishmentVO>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			 se.add(  establishmentDAO.getById(purchaseBillVO.getProviderId()));
		}
		return se;
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<PurchaseBillExtVO> getPBEByids(List<PurchaseBillVO> purchaseBillVOs) throws Exception {
		List<PurchaseBillExtVO> ps=new ArrayList<PurchaseBillExtVO>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			ps.add(purchaseBillExtDAO.getById(purchaseBillVO.getId()));
		}
		
		return ps;
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<StorehouseVO> getStoreHByid(List<PurchaseBillVO> purchaseBillVOs) throws Exception {
		List<StorehouseVO> ps=new ArrayList<StorehouseVO>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			ps.add(storeHouseDAO.getById(purchaseBillVO.getStorehouseId()));
		}
		return ps;
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public PurchaseBillVO getPBById(long id) throws Exception {
		return purchaseBillDAO.getById(id);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public EstablishmentVO getEById(PurchaseBillVO purchaseBillVO) throws Exception {
		// TODO Auto-generated method stub
		return establishmentDAO.getById(purchaseBillVO.getProviderId());
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public StorehouseVO getSByid(PurchaseBillVO purchaseBillVO) throws Exception {
		// TODO Auto-generated method stub
		return storeHouseDAO.getById(purchaseBillVO.getStorehouseId());
	}

	/**
	 * @说明：
	 */
	public List<PurchaseBillItemVO> getPBIByBillId(PurchaseBillVO purchaseBillVO) {
		
		return purchaseBillItemDAO.getgetPBIByBillId(purchaseBillVO.getId());
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<ProductVO> getPById(List<PurchaseBillItemVO> purchaseBillItemVOs) throws Exception {
		List<ProductVO> ps=new ArrayList<ProductVO>();
		for (PurchaseBillItemVO purchaseBillItemVO : purchaseBillItemVOs) {
			ps.add(productDAO.getById(purchaseBillItemVO.getProductId()));
		}
		
		return ps;
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public TallySetVO getTallyset(long tallySetId) throws Exception {
		return tallySetDAO.getById(tallySetId);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public PurchaseBillExtVO getPEBById(long id) throws Exception {
		return purchaseBillExtDAO.getById(id);
	}

	/**
	 * @说明：
	 */
	public List<PayBillVO> getPayBillByTallIdAndEId(Long tallysetId, long eid) {

		return payBillDao.getPayBillByTallIdAndEId(tallysetId,eid);
	}

	/**
	 * @说明：
	 */
	public List<AdjustBillVO> getAdjustBiByTallIdAndEId(Long tallysetId, long id) {
		return adjustBillDAO.getAdjustBiByTallIdAndEId(tallysetId,id);
	}

	/**
	 * @说明：
	 */
	public void setCancleByPEBid(long id) {
		purchaseBillExtDAO.setCancleByPEBid(id);
	}

	/**
	 * @说明：退款
	 */
	public List<PurchaseBillVO> getPurchaseBillsForTKByLimits() {
		// TODO Auto-generated method stub
		return purchaseBillDAO.getPurchaseBillsForTKByLimits();
	}

	
}
