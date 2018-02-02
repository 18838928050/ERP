/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.BusinessBillItemExtDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.OutPutDAOw;
import com.erp.model.dao.WorkCenterDAOw;
import com.erp.model.dao.WorkPressDAOw;
import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.OutputVO;
import com.erp.model.vo.WorkCenterVO;
import com.erp.model.vo.WorkProcessVO;

/**
 * @author fu
 *
 */
public class ChanliangRegisterMgr {
	BusinessBillDAOw businessBillDAO = new BusinessBillDAOw();
	OutPutDAOw outPutDAO = new OutPutDAOw();
	BusinessBillItemDAOw billItemDAO = new BusinessBillItemDAOw();
	MakeTypeDAOw makeTypeDAO = new MakeTypeDAOw();
	WorkPressDAOw workPressDAO = new WorkPressDAOw();
	WorkCenterDAOw workCenterDAO = new WorkCenterDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	BusinessBillItemExtDAOw billItemExtDAO = new BusinessBillItemExtDAOw();

	/**
	 * @return
	 */
	public List<BusinessBillVO> getListAllBBByLImitsAndTime() {
		return businessBillDAO.getListAllBBByLImitsAndTime();
	}

	/**
	 * @param businessBillVOs
	 * @return
	 */
	public List<List<BusinessBillItemVO>> getbbiSS(List<BusinessBillVO> businessBillVOs) {
		List<Long> bbiBillIds = new ArrayList<>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			bbiBillIds.add(businessBillVO.getId());

		}
		return businessBillDAO.getbbiSS(bbiBillIds);
	}

	/**
	 * @param list
	 * @return
	 */
	public List<BusinessBillVO> getBbS(List<List<BusinessBillItemVO>> list) {
		List<Long> bbIds = new ArrayList<>();
		for (List<BusinessBillItemVO> list2 : list) {
			for (BusinessBillItemVO businessBillItemVO : list2) {
				bbIds.add(businessBillItemVO.getBillId());

			}

		}
		return billItemDAO.getBbs(bbIds);
	}

	/**
	 * @param businessBillVO2
	 * @return
	 */
	public List<EstablishmentVO> getEs(List<BusinessBillVO> businessBillVO2) {
		List<Long> eIds = new ArrayList<>();
		for (BusinessBillVO businessBillVO : businessBillVO2) {
			eIds.add(businessBillVO.getClientId());

		}
		return establishmentDAO.getEs(eIds);
	}

	/**
	 * @param businessBillItemVOss
	 * @return
	 */
	public List<WorkCenterVO> getWCs(List<List<BusinessBillItemVO>> businessBillItemVOss) {
		List<Long> wcIds = new ArrayList<>();
		for (List<BusinessBillItemVO> list : businessBillItemVOss) {
			for (BusinessBillItemVO businessBillItemVO : list) {
				wcIds.add(businessBillItemVO.getWcId());
			}

		}
		// TODO Auto-generated method stub
		return workCenterDAO.getWCs(wcIds);
	}

	/**
	 * @param businessBillItemVOss
	 * @return
	 */

	public List<BusinessBillItemExtVO> getBBIEs(List<List<BusinessBillItemVO>> businessBillItemVOss) {
		List<Long> bbieIds = new ArrayList<>();
		for (List<BusinessBillItemVO> list : businessBillItemVOss) {
			for (BusinessBillItemVO businessBillItemVO : list) {
				bbieIds.add(businessBillItemVO.getId());
			}
		}

		return billItemExtDAO.getBBIEs(bbieIds);
	}

	/**
	 * @param businessBillItemVOss
	 * @return
	 */
	public List<MakeTypeVO> getMts(List<List<BusinessBillItemVO>> businessBillItemVOss) {
		List<Long> mtIds = new ArrayList<>();
		for (List<BusinessBillItemVO> list : businessBillItemVOss) {
			for (BusinessBillItemVO businessBillItemVO : list) {
				mtIds.add(businessBillItemVO.getMakeTypeId());

			}

		}
		// TODO Auto-generated method stub
		return makeTypeDAO.getMakeTypeByIds(mtIds);
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BusinessBillItemVO getbbiSS(long id) throws Exception {

		return billItemDAO.getById(id);
	}

	/**
	 * @param businessBillItemVO
	 * @return
	 * @throws Exception
	 */
	public BusinessBillVO getB(BusinessBillItemVO businessBillItemVO) throws Exception {
		long bbId = businessBillItemVO.getBillId();
		// TODO Auto-generated method stub
		return businessBillDAO.getById(bbId);
	}

	/**
	 * @param businessBillVO
	 * @return
	 * @throws Exception
	 */
	public EstablishmentVO getE(BusinessBillVO businessBillVO) throws Exception {
		long eId = businessBillVO.getClientId();
		// TODO Auto-generated method stub
		return establishmentDAO.getById(eId);
	}

	/**
	 * @param businessBillItemVO
	 * @return
	 * @throws Exception
	 */
	public MakeTypeVO getMts(BusinessBillItemVO businessBillItemVO) throws Exception {
		long mtId = businessBillItemVO.getMakeTypeId();
		return makeTypeDAO.getById(mtId);
	}

	/**
	 * @param businessBillItemVO
	 * @return
	 * @throws Exception
	 */
	public WorkCenterVO getWC(BusinessBillItemVO businessBillItemVO) throws Exception {
		long wcId = businessBillItemVO.getWcId();
		return workCenterDAO.getById(wcId);
	}

	/**
	 * @param businessBillItemVO
	 * @return
	 */
	public List<List<OutputVO>> getOp(BusinessBillItemVO businessBillItemVO) {

		return outPutDAO.getOp(businessBillItemVO);
	}

	public List<WorkProcessVO> getWpS(List<List<OutputVO>> list) {
		List<Long> wpIds = new ArrayList<>();
		for (List<OutputVO> list2 : list) {
			for (OutputVO outputVO : list2) {

				wpIds.add(outputVO.getProcessId());
			}

		}
		return workPressDAO.getWPs(wpIds);
	}
}
