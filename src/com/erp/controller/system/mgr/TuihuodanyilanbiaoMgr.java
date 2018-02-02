package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.CaigoudanyilanbiaoDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PurchaseBillExtDAOw;
import com.erp.model.dao.StoreHouseDAOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.StorehouseVO;

public class TuihuodanyilanbiaoMgr {
	CaigoudanyilanbiaoDAOw	caigoudanyilanbiaoDAO=new CaigoudanyilanbiaoDAOw();
	PurchaseBillExtDAOw purchaseBillExtDAO=new PurchaseBillExtDAOw();
	StoreHouseDAOw storeHouseDAO=new StoreHouseDAOw();
	EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
		public List findAll(long tallySetId) {
		return	caigoudanyilanbiaoDAO.findtuiAll(tallySetId);
		}
		public List<PurchaseBillExtVO> findPbesByPbIds(List<PurchaseBillVO> purchaseBillVOs) {
			List<Long> ids=new ArrayList<Long>();
			for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
				ids.add(purchaseBillVO.getId());
			}
			return purchaseBillExtDAO.findPbesByPbIds(ids);
		}
		public List<StorehouseVO> findStoresByPbIds(List<PurchaseBillVO> purchaseBillVOs) {
			List<Long> ids=new ArrayList<Long>();
			for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
				ids.add(purchaseBillVO.getStorehouseId());
			}
			return storeHouseDAO.findStoresByPbIds(ids);
		}
		public List<List<EstablishmentVO>> findEstsByPbIds(List<PurchaseBillVO> purchaseBillVOs) {
			List<Long> ids=new ArrayList<Long>();
			for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
				ids.add(purchaseBillVO.getProviderId());
			}
			List<List<EstablishmentVO>> eLists=establishmentDAO.getEstsByPayBillIds(ids);
			return eLists;
		}
}
