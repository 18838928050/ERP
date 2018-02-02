package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillExtDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.BusinessBillItemExtDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.WorkCenterDAOw;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.WorkCenterVO;

public class MakeBillMgr {
	BusinessBillDAOw businessBillDAO=new BusinessBillDAOw();
	EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
	BusinessBillExtDAOw businessBillExtDAO=new BusinessBillExtDAOw();
	BusinessBillItemDAOw businessBillItemDAO=new BusinessBillItemDAOw();
	BusinessBillItemExtDAOw businessBillItemExtDAO=new BusinessBillItemExtDAOw();
	WorkCenterDAOw workCenterDAO=new WorkCenterDAOw();

	/**
	 * 
	 * 要制作的业务单
	 */
	public List<BusinessBillVO> getBusinessBillVOsByLimits() {
		// TODO Auto-generated method stub
		return businessBillDAO.getBusinessBillVOsByLimits();
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<EstablishmentVO> getEstablistmentbyid(List<BusinessBillVO> businessBillVOs) throws Exception {
		List<EstablishmentVO> es=new ArrayList<EstablishmentVO>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			es.add(establishmentDAO.getById(businessBillVO.getClientId()));
		}
		
		return es;
	}

	/**
	 * @param list 
	 * @throws Exception 
	 * @说明：
	 */
	public List<BusinessBillExtVO> getBusinessBillExtByIds(List<BusinessBillVO> list) throws Exception {
		List<BusinessBillExtVO> bs=new ArrayList<BusinessBillExtVO>();
		for (BusinessBillVO businessBillVO : list) {
			bs.add(businessBillExtDAO.getById(businessBillVO.getId()));
		}
		
		
		return bs;
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillItemVO> getBusinessBillItemByBillIds(	List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			ids.add(businessBillVO.getId());
		}
		return businessBillItemDAO.getBusinessBillItemByBillIdfor(ids);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<BusinessBillItemExtVO> getBBIEById(	List<BusinessBillItemVO> businessBillItemVOs) throws Exception {
		List<BusinessBillItemExtVO> bb=new ArrayList<BusinessBillItemExtVO>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			bb.add(businessBillItemExtDAO.getById(businessBillItemVO.getId()));
		}
		return bb;
		
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List<WorkCenterVO> getWorkCentersVo(		List<BusinessBillItemVO> businessBillItemVOs) throws Exception {
		List<WorkCenterVO> w=new ArrayList<WorkCenterVO>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			w.add(workCenterDAO.getById(businessBillItemVO.getWcId()));
		}
		return w;
	}
}
