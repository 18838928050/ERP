/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.AccessoryDAOw;
import com.erp.model.dao.AdjustBillDAOw;
import com.erp.model.dao.EstablishmentContactDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PayBillDaow;
import com.erp.model.dao.ProductDAOw;
import com.erp.model.dao.PurchaseBillDAOw;
import com.erp.model.dao.PurchaseBillItemDAOw;
import com.erp.model.dao.TallySetDAOw;
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
 * @author： 如约而至 @time：2017年10月6日 下午3:12:50
 *******************************************************************
 @说明： 供应商
 *******************************************************************/
public class GongyingshangMgr {
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	TallySetDAOw tallySetDAO = new TallySetDAOw();
	PurchaseBillDAOw purchaseBillDAO = new PurchaseBillDAOw();
	PurchaseBillItemDAOw purchaseBillItemDAO = new PurchaseBillItemDAOw();
	ProductDAOw productDAO = new ProductDAOw();
	PayBillDaow payBillDao = new PayBillDaow();
	AdjustBillDAOw adjustBillDAO = new AdjustBillDAOw();
	EstablishmentContactDAOw establishmentContactDAO = new EstablishmentContactDAOw();
	AccessoryDAOw accessoryDAO=new AccessoryDAOw();

	/**
	 * @说明：
	 */
	public List<EstablishmentVO> getEstablishmentVOsByLimits() {
		return establishmentDAO.getEstablishmentVOsByLimits();
	}

	/**
	 * @说明：
	 */
	public List<TallySetVO> getSetVOsByIds(
			List<EstablishmentVO> establishmentVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (EstablishmentVO establishmentVO : establishmentVOs) {
			ids.add(establishmentVO.getTallySetId());
		}

		return tallySetDAO.getSetVOsByIds(ids);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public EstablishmentVO getEstablistmenteByid(long id) throws Exception {
		return establishmentDAO.getById(id);
	}

	/**
	 * @说明：
	 */
	public List<PurchaseBillVO> getPurchaseBillVOsByProviderIds(
			EstablishmentVO establishmentVOs) {
		return purchaseBillDAO.getPurchaseBillVOsByProviderIds(establishmentVOs
				.getId());
	}

	/**
	 * @说明：
	 */
	public List<List<PurchaseBillItemVO>> getPurchaseBillItemVOsByBillIds(
			List<PurchaseBillVO> purchaseBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (PurchaseBillVO purchaseBillItemVO : purchaseBillVOs) {
			ids.add(purchaseBillItemVO.getId());
		}

		return purchaseBillItemDAO.getPurchaseBillItemVOsByBillIds(ids);
	}

	/**
	 * @说明：
	 */
	public List<List<ProductVO>> getProductVosByIds(
			List<List<PurchaseBillItemVO>> purchaseBillItemVOs) {
		List<List<Long>> ids = new ArrayList<List<Long>>();
		for (List<PurchaseBillItemVO> list : purchaseBillItemVOs) {
			List<Long> ii = new ArrayList<Long>();
			for (PurchaseBillItemVO purchaseBillItemVO : list) {
				ii.add(purchaseBillItemVO.getProductId());
			}
			ids.add(ii);
		}

		return productDAO.getProductVosByIds(ids);
	}

	/**
	 * @说明：
	 */
	public List<PayBillVO> getPayBillVOsByReceiveId(long id) {

		return payBillDao.getPayBillVOsByReceiveId(id);
	}
	/**
	 * @说明：
	 */
	public List<AdjustBillVO> getAdjustBillVOsByClientId(long id) {
		return adjustBillDAO.getAdjustBillVOsByClientId(id);
	}

	/**
	 * @说明：
	 */
	public List<EstablishmentContactVO> getEstabliContactVosByEstId(long id) {
		// TODO Auto-generated method stub
		return establishmentContactDAO.getEstabliContactVosByEstId(id);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public TallySetVO getTallySetVO(long tallySetId) throws Exception {
		return tallySetDAO.getById(tallySetId);
	}

	/**
	 * @说明：
	 */
	public void editSaveEstablistment(EstablishmentVO establishmentVO) {
		establishmentDAO.editSaveEstablistment(establishmentVO);
	}

	/**
	 * @说明：
	 */
	public void editSaveEstablistmentContactVos(
			List<EstablishmentContactVO> establishmentContactVOs) {
		establishmentContactDAO
				.editSaveEstablistmentContactVos(establishmentContactVOs);
	}


	/**
	 * @说明：
	 */
	public void stopOrstart(long id, String string) {
		establishmentDAO.stop(id,string);
		
	}

	/**
	 * @说明：删除供应商
	 */
	public void deleteByMakeEnableForN(long id) {
		establishmentDAO.deleteByMakeEnableForN(id);
	}

	/**
	 * @说明：
	 */
	public List<AccessoryVO> getFujanByEid(long id) {
		return accessoryDAO.getFujanByEid(id);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public void deleteFujianByid(long id) throws Exception {
		accessoryDAO.delete(id);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public void saveEst(EstablishmentVO establishmentVO) throws Exception {
		establishmentDAO.save(establishmentVO);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public void saveEstContact(
			List<EstablishmentContactVO> establishmentContactVOs) throws Exception {
		for (EstablishmentContactVO establishmentContactVO : establishmentContactVOs) {
			establishmentContactDAO.save(establishmentContactVO);
		}
		
	}

}
