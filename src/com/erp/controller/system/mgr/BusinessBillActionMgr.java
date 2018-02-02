/**
 * 
 */
package com.erp.controller.system.mgr;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.erp.model.dao.AccessoryDAOw;
import com.erp.model.dao.AdjustBillDAOw;
import com.erp.model.dao.AdjustBillItemDAOw;
import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillExtDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.CodeRuleDAOw;
import com.erp.model.dao.DepartmentDAOw;
import com.erp.model.dao.EnterpriseInfoDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.PayModeDAOw;
import com.erp.model.dao.ReceiveBillItemDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.dao.WorkCenterDAOw;
import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.AdjustBillItemVO;
import com.erp.model.vo.AdjustBillVO;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.BusinessBillExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.CodeRuleVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EnterpriseInfoVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.SerarchBeans;
import com.erp.model.vo.TallySetVO;
import com.erp.model.vo.WorkCenterVO;

/**
 @author： 如约而至    @time：2017年9月12日 下午8:06:10 
 *******************************************************************
 @说明： 业务单一览表
 *******************************************************************/
public class BusinessBillActionMgr {
	BusinessBillDAOw businessBillDAO=new BusinessBillDAOw();
	EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
	BusinessBillExtDAOw businessBillExtDAO=new BusinessBillExtDAOw();
	PayModeDAOw payModeDAO=new PayModeDAOw();
	BusinessBillItemDAOw businessBillItemDAO=new BusinessBillItemDAOw();
	WorkCenterDAOw workCenterDAO=new WorkCenterDAOw();
	MakeTypeDAOw makeTypeDAO=new MakeTypeDAOw();
	TallySetDAOw tallySetDAO=new TallySetDAOw();
	AccessoryDAOw accessoryDAO=new AccessoryDAOw();
	DepartmentDAOw departmentDAO=new DepartmentDAOw();
	CodeRuleDAOw codeRuleDAO=new CodeRuleDAOw();
	AdjustBillItemDAOw  adjustBillItemDAO=new AdjustBillItemDAOw();
	BankAccountDAOw bankAccountDAO=new BankAccountDAOw();
	EnterpriseInfoDAOw enterpriseInfoDAO=new EnterpriseInfoDAOw();
	AdjustBillDAOw adjustBillDAO=new AdjustBillDAOw();
	ReceiveBillItemDAOw receiveBillItemDAO=new ReceiveBillItemDAOw();
	
	
	
	
	/**
	 * @throws Exception 
	 * @说明：
	 */
	public TallySetVO getTallySetById(long tallySetId) throws Exception {
		return tallySetDAO.getById(tallySetId);
	}


	/**
	 * @说明：由于要加很多限制添加  所以不能直接获得所有
	 */
	public List<BusinessBillVO> getBusinessBillsByLimit() {
		// TODO Auto-generated method stub
		return businessBillDAO.getBusinessBillsByLimit();
	}



	/**
	 * @说明：//由bb.client_id=E.id ==>E
	 */
	public List<EstablishmentVO> getEstablishmentById(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
				ids.add(businessBillVO.getClientId());
		}
		return establishmentDAO.getByIds(ids);
	}



	/**
	 * @说明：
	 */
	public List<BusinessBillExtVO> getBusinessBillExtsByIds(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
				ids.add(businessBillVO.getId());
		}
		return businessBillExtDAO.getByIds(ids);
	}



	/**
	 * @说明：
	 */
	public List<PayModeVO> getPayModeByIds(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
				ids.add(businessBillVO.getPayModeId());
		}
		return payModeDAO.getByIds(ids);
	}



	/**
	 * @throws Exception 
	 * @说明：
	 */
	public EstablishmentVO getEstablishmentById(long clientId) throws Exception {
		// TODO Auto-generated method stub
		return establishmentDAO.getById(clientId);
	}



	/**
	 * @说明：
	 */
	public List<BusinessBillItemVO> getBusinessBillItemByBillId(long id) {
		return businessBillItemDAO.getBusinessBillItemByBillId(id);
	}

	


	/**
	 * @说明：
	 */
	public BusinessBillVO getBusinessBillByBillCode(String billCode) {
		return businessBillDAO.getBusinessBillByBillCode(billCode);
	}



	



	
	


	/**
	 * @说明：
	 */
	public List<AccessoryVO> getAccessoryByAgaentId(long id) {
		return accessoryDAO.getAccessoryByAgaentId(id);
	}


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public BusinessBillExtVO getBusinessBillExtsById(long id) throws Exception {
		// TODO Auto-generated method stub
		return businessBillExtDAO.getById(id);
	}


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public DepartmentVO getDepartmentById(long departmentId) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.getById(departmentId);
	}


	/**
	 * @说明：
	 */
	public List<DepartmentVO> getDepartmentAll() {
		return departmentDAO.getAll();
	}


	/**
	 * @说明：
	 */
	public List<PayModeVO> getAllPayMode() {
		return payModeDAO.getAll();
	}


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public PayModeVO getPayModeById(long payModeId) throws Exception {
		// TODO Auto-generated method stub
		return payModeDAO.getById(payModeId);
	}

	
	/**
	 * @说明：
	 */
	
	
	public List<MakeTypeVO> getMakeTypeById(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
				ids.add(businessBillItemVO.getMakeTypeId());
		}
		
		return makeTypeDAO.getMakeTypeByIds(ids);
	}
	

	/**
	 * @说明：由于在业务改单中 有三个table  每个table是按照BBI中的price_type 的三个类型分类（只有三个类型 AREA AMOUNT LENGTH）
	 */
	public List<List<BusinessBillItemVO>> getBusinessBillItemByBillIdForThreeTable(	long id) {
		List<List<BusinessBillItemVO>> bs=new ArrayList<List<BusinessBillItemVO>>();
		bs.add(businessBillItemDAO.getBusinessBillItemByBillId(id,"AREA"));
		bs.add(businessBillItemDAO.getBusinessBillItemByBillId(id, "LENGTH"));
		bs.add(businessBillItemDAO.getBusinessBillItemByBillId(id, "AMOUNT"));
		return bs;
	}


	/**
	 * @说明：在业务改单中有三个表 三个表中 每个表都有一个maketype 数组  由于只用判断  Amount  area length  三个
	 */
	public List<List<MakeTypeVO>> getMakeTypeByIdForThreeTable(List<List<BusinessBillItemVO>> businessBillItemListsList) {
		List<List<MakeTypeVO>> m=new ArrayList<List<MakeTypeVO>>();
		List<Long> ids0=new ArrayList<Long>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(0)) {
				ids0.add(businessBillItemVO.getMakeTypeId());
		}
		 m.add( makeTypeDAO.getMakeTypeByIds(ids0));
		
		 List<Long> ids2=new ArrayList<Long>();
		 for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(1)) {
				ids2.add(businessBillItemVO.getMakeTypeId());
		}
		 m.add( makeTypeDAO.getMakeTypeByIds(ids2));
		 List<Long> ids3=new ArrayList<Long>();
		 for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(2)) {
				ids3.add(businessBillItemVO.getMakeTypeId());
		}
		 m.add(makeTypeDAO.getMakeTypeByIds(ids3));
		return m;
	}

	/**
	 * @说明：为了业务改单中的三个表格 每个表格对应一个BBI，所有获得每个表格的BBIbusinessBillItemListsList.get(0) 由BBI.wc_id=WC.id
	 */
	public List<List<WorkCenterVO>> getWorkCenterByIdForThreeTable(List<List<BusinessBillItemVO>> businessBillItemListsList) {
		List<List<WorkCenterVO>> m=new ArrayList<List<WorkCenterVO>>();
		List<Long> ids0=new ArrayList<Long>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(0)) {
				ids0.add(businessBillItemVO.getWcId());
		}
		m.add( workCenterDAO.getByIds(ids0));
		
		 List<Long> ids2=new ArrayList<Long>();
		 for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(1)) {
				ids2.add(businessBillItemVO.getWcId());
		}
			
		 m.add( workCenterDAO.getByIds(ids2));
		 List<Long> ids3=new ArrayList<Long>();
		 for (BusinessBillItemVO businessBillItemVO : businessBillItemListsList.get(2)) {
				ids3.add(businessBillItemVO.getWcId());
		}
		 m.add( workCenterDAO.getByIds(ids3));
		return m;
	}

	
	/**
	 * @说明：
	 */
	public List<WorkCenterVO> getWorkCenterById(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			ids.add(businessBillItemVO.getWcId());
		}
		return workCenterDAO.getByIds(ids);
	}


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public BusinessBillVO getBusinessBillById(long id) throws Exception {
		return businessBillDAO.getById(id);
	}


	/**
	 * @throws Exception 
	 * @说明：由于就是显示业务单  所以
	 */
	public CodeRuleVO getCodeRuleByYEwudan(Long id) throws Exception {
		return codeRuleDAO.getById(id);
	}


	


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public BankAccountVO getBankAccountById(long bankAccountId) throws Exception {
		return bankAccountDAO.getById(bankAccountId);
	}


	/**
	 * @throws Exception 
	 * @说明：
	 */
	public EnterpriseInfoVO getEnterpriseInfo() throws Exception {
		return enterpriseInfoDAO.getById(1l);
	}

	
	/**
	 * @说明：有几个订单 获得几个调账的数据（已经处理了）
	 */
	public List<BigDecimal> getAdjustBillItemByBusinessBillIdsAndGetZhangtaoDate(
			List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
				ids.add(businessBillVO.getId());
		}
		return adjustBillItemDAO.getByBusinessBillIds(ids);
	}


	/**
	 * @说明：得到已收数据
	 */
	public List<BigDecimal> getYishous(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
				ids.add(businessBillVO.getId());
		}
		return receiveBillItemDAO.getYishou(ids);
	}


	/**
	 * @说明：更新多个BBI
	 */
	public void updateBusinessBillItems(List<BusinessBillItemVO> all) {
		businessBillItemDAO.updateBusinessBillItems(all);
	}


	/**
	 * @说明：
	 */
	public List<BusinessBillVO> getBusinessBillsSearch(SerarchBeans se) {
		return businessBillDAO.getBusinessBillsSearch(se);
	}





	

	
	
	
	
}
