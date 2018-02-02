/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.OutPutDAOw;
import com.erp.model.dao.WorkCenterDAOw;
import com.erp.model.dao.WorkPressDAOw;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.OutputVO;
import com.erp.model.vo.WorkCenterVO;
import com.erp.model.vo.WorkProcessVO;

/**
 * @author： 如约而至 @time：2017年10月12日 下午9:27:52
 *******************************************************************
 @说明：
 *******************************************************************/
public class OuputDetailMgr {
	BusinessBillDAOw businessBillDAO = new BusinessBillDAOw();
	OutPutDAOw outPutDAO = new OutPutDAOw();
	BusinessBillItemDAOw billItemDAO = new BusinessBillItemDAOw();
	MakeTypeDAOw makeTypeDAO = new MakeTypeDAOw();
	WorkPressDAOw workPressDAO = new WorkPressDAOw();
	WorkCenterDAOw workCenterDAO = new WorkCenterDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();

	/**
	 * @说明：得到所有的
	 */
	public List<BusinessBillVO> getListAllBBByLImits() {
		return businessBillDAO.getListAllBBByLImits();
	}

	/**
	 * @param list
	 * @return
	 */
	public List<OutputVO> getOp(List<List<BusinessBillItemVO>> businessBillItemVOss) {
		List<Long> opItemIds = new ArrayList<>();
		for (List<BusinessBillItemVO> list : businessBillItemVOss) {
			for (BusinessBillItemVO businessBillItemVO : list) {
				opItemIds.add(businessBillItemVO.getId());

			}
		}
		System.out.println(opItemIds + "pppppppppppppppppppppppppppppppp");
		return outPutDAO.getOp(opItemIds);
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
	 * @param list2
	 * @return
	 */
	public List<BusinessBillItemVO> getbbis(List<OutputVO> list2) {
		List<Long> bbiIds = new ArrayList<>();
		for (OutputVO outputVO : list2) {
			bbiIds.add(outputVO.getBbItemId());
		}
		return billItemDAO.getbbis(bbiIds);
	}

	/**
	 * @param businessBillItemVOs
	 * @return
	 */
	public List<BusinessBillVO> getBBs(List<BusinessBillItemVO> businessBillItemVOs) {
		return businessBillDAO.getBBs(businessBillItemVOs);
	}

	/**
	 * @param businessBillItemVOs
	 * @return
	 */
	public List<MakeTypeVO> getMT(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> mtIds = new ArrayList<>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			mtIds.add(businessBillItemVO.getMakeTypeId());
		}
		// TODO Auto-generated method stub
		return makeTypeDAO.getMT(mtIds);
	}

	/**
	 * @param list
	 * @return
	 */
	public List<WorkProcessVO> getWPs(List<OutputVO> list) {
		List<Long> wpIdsList = new ArrayList<>();
		for (OutputVO outputVO : list) {

			wpIdsList.add(outputVO.getProcessId());
		}
		return workPressDAO.getWPs(wpIdsList);
	}

	/**
	 * @param businessBillItemVOs
	 * @return
	 */
	public List<WorkCenterVO> getWCs(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> wcIds = new ArrayList<>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			wcIds.add(businessBillItemVO.getWcId());

		}
		// TODO Auto-generated method stub
		return workCenterDAO.getWCs(wcIds);
	}

	/**
	 * @param businessBillVOs
	 * @return
	 */
	public List<EstablishmentVO> getEs(List<BusinessBillVO> businessBillVOs) {
		List<Long> eIds = new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			eIds.add(businessBillVO.getClientId());
		}
		// TODO Auto-generated method stub
		return establishmentDAO.getByIds(eIds);
	}

	/**
	 * @param outputVOs
	 * @throws Exception
	 */
	public void deleteOP(List<OutputVO> outputVOs) throws Exception {
		for (OutputVO outputVO : outputVOs) {
			long id = outputVO.getId();
			outPutDAO.delete(id);
		}
	}

}
