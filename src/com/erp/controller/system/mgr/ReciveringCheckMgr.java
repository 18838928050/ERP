/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.CooperBillDAOw;
import com.erp.model.dao.CooperBillItemDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.GatherBillDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.GatherBillVO;
import com.erp.model.vo.MakeTypeVO;

/**
 @author： 如约而至    @time：2017年9月9日 下午9:46:38 
 *******************************************************************
 @说明： 
 *******************************************************************/
@SuppressWarnings("null")
public class ReciveringCheckMgr {
	private EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
	private CooperBillDAOw cooperBillDAO=new CooperBillDAOw();
	private CooperBillItemDAOw cooperBillItemDAO=new CooperBillItemDAOw();
	private GatherBillDAOw gatherBillDAO=new GatherBillDAOw();
	private MakeTypeDAOw makeTypeDAO=new MakeTypeDAOw();
	/**
	 * @说明：获得所有外协商
	 */
	public List<EstablishmentVO> getAllWaixie() {
		return establishmentDAO.getAllWaixie();
	}

	/**
	 * @说明：//由E.id=CB.cooperartor_id 得到CB  
	 */
	public List<CooperBillVO> getCooperBillsByCooperatorId(long cooperatorId,  String sort, String timeLimit) {
		return cooperBillDAO.getCooperBillByCooperatorIdAndTimeSort(cooperatorId,sort,timeLimit);
	}

	/**
	 * @说明：
	 */
	public List<List<CooperBillItemVO>> getCooperBillItemsByBillIds(
			List<CooperBillVO> cooperBillVOs) {
		//获得cd的id的数组
		List<CooperBillVO> cooperBillVOss= cooperBillVOs;
		List<Long> listCBids=new ArrayList<Long>();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			listCBids.add(cooperBillVO.getId());
		}
		List<List<CooperBillItemVO>> cooperBillItemVOs=cooperBillItemDAO.getCooperBillItemByBillIDs(listCBids);
		return cooperBillItemVOs;
	}

	/**
	 * @说明：
	 */
	public List<GatherBillVO> getGatherBillByCooperBillID(List<CooperBillVO> cooperBillVOs) {
		List<CooperBillVO> cooperBillVOss= cooperBillVOs;
		List<Long> listCBids=new ArrayList<Long>();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			listCBids.add(cooperBillVO.getId());
		}
		List<GatherBillVO> gatherBillVOs=gatherBillDAO.getGatherBillByCooperBillIds(listCBids);
		
		
		return gatherBillVOs;
	}

	/**
	 * @说明：
	 */
	
	public List<MakeTypeVO> getMakeTypeByIds(List<List<CooperBillItemVO>> cooperbillitemvoSS) {
		List<Long> ids=new ArrayList<Long>();
		
		for (List<CooperBillItemVO> list : cooperbillitemvoSS) {
			for (CooperBillItemVO cooperBillItemVO : list) {
				ids.add(cooperBillItemVO.getMakeTypeId());
			}
		}
		return makeTypeDAO.getMakeTypeByIds(ids);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public EstablishmentVO getEstablishmentById(long id) throws Exception {
		return establishmentDAO.getById(id);
	}

	

}
