package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.ProductDAOw;
import com.erp.model.dao.PurchaseBillDAOw;
import com.erp.model.dao.PurchaseBillExtDAOw;
import com.erp.model.dao.PurchaseBillItemDAOw;
import com.erp.model.dao.StoreHouseDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillExtVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.PurchaseBillVO;
import com.erp.model.vo.StorehouseVO;
import com.erp.model.vo.TallySetVO;

public class TuihuobiaofanshenheMgr {

	PurchaseBillDAOw purchaseBillDAO = new PurchaseBillDAOw();
	PurchaseBillItemDAOw purchaseBillItemDAO=new PurchaseBillItemDAOw();
StoreHouseDAOw storeHouseDAO=new StoreHouseDAOw();
EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
BankAccountDAOw bankAccountDAO=new BankAccountDAOw();
PurchaseBillExtDAOw purchaseBillExtDAO=new PurchaseBillExtDAOw();
ProductDAOw productDAO=new ProductDAOw();
TallySetDAOw tallySetDAO=new TallySetDAOw();
	
	public List<List<EstablishmentVO>> findEsts(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> ids=new 	ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			ids.add(purchaseBillVO.getProviderId());
		}
		List<List<EstablishmentVO>> establishments=establishmentDAO.getEstsByPayBillIds(ids);
		return establishments;
	}

	public List<List<StorehouseVO>> findStores(List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> ids=new 	ArrayList<Long>();
		for (PurchaseBillVO purchaseBillVO : purchaseBillVOs) {
			ids.add(purchaseBillVO.getStorehouseId());
		}
		List<List<StorehouseVO>> sLists=storeHouseDAO.getStoreHousesByBillIds(ids);
		return sLists;
	}
	public void shenhetongguo(long id) {
		purchaseBillDAO.shenhetongguo(id);
		
	}
	public EstablishmentVO findEstByPbId(long id) {
		return establishmentDAO.findEstByPbId(id);
	}
	public StorehouseVO getStoreHouseByPbId(long id) {
		return storeHouseDAO.getStoreHouseByPbId(id);
	}
	public PurchaseBillVO findPbByPbId(long id) {
		return purchaseBillDAO.findPbByPbId(id);
	}
	public List<ProductVO> findProductByPbId(long id) {
		return productDAO.findProductByPbId(id);
	}
	public List<PurchaseBillItemVO> findPBIS(long id) {
		return purchaseBillDAO.findPBIS(id);
	}
	public TallySetVO findTallySetByPbId(long id) {
		return tallySetDAO.findTallySetByPbId(id);
	}
	public BankAccountVO findBankByPbId(long id) {
		return bankAccountDAO.findBankByPbId(id);
	}
	public PurchaseBillExtVO findPbeByPbId(long id) {
		return purchaseBillExtDAO.findPbeByPbId(id);
	}
	public void shenhebutongguo(long id) {
		purchaseBillDAO.shenhebutongguo(id);
		
	}
	public List<PurchaseBillVO> findIsYPbs(long tallySetId) {
		return purchaseBillDAO.findIsYPbs(tallySetId); 
	}
}
