package com.erp.controller.subcontractCancel.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.controller.subcontractCancel.vo.SelectVO;
import com.erp.model.dao.BaseDAO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CooperBillVO;

/**
 * 外协单 dao
 * @author guo
 *
 */
public class CooperBillDAO extends BaseDAO<CooperBillVO>{
	
//	根据条件进行搜索
	public List<CooperBillVO> findByWhere(SelectVO selectVO) {
		try {
			String sql="from CooperBillVO where ";
			
			String cooperDateBegin = selectVO.getBeginDate();//外协的开始日期 搜索条件
			String cooperDateEnd = selectVO.getEndDate();//外协的截至日期 搜索条件
			String establishment = selectVO.getCooperatorId();//外协商 对应客户表 COOPERATOR
			String managerName = selectVO.getManagerName();//业务员
			String billCode = selectVO.getBillCode();//外协单号
			String departmentId = selectVO.getDepartmentId();//部门编号
			String costBegin = selectVO.getBeginCost();//外协金额	开始金额	搜索条件
			String costEnd = selectVO.getEndCost();//外协金额	结束金额	搜索条件
			String examined = selectVO.getEnabled();//审核状态
			String tallySetId = selectVO.getTallySetId();//账套公司
			
			
			if(cooperDateBegin != null && cooperDateEnd !=null){
					sql=sql+" cooperDate > "+cooperDateBegin+" cooperDate < "+cooperDateEnd;
			}
			if(establishment != null){
				sql=sql+" and cooperatorId	= "+establishment;
			}
			if(managerName != null){
				sql=sql+" and managerName = "+managerName;
			}
			if(billCode != null){
				sql=sql+" and billCode = "+billCode;
			}
			if(departmentId != null){
				sql=sql+" and departmentId = "+departmentId;
			}
			if(costBegin != null && costEnd != null){
				sql=sql+" and cost > "+costBegin +" and cost < "+costEnd;
			}
			if(examined != null ){
				sql=sql+" and examined = "+examined;
			}
			if(tallySetId != null ){
				sql=sql+" and tallySetId = "+tallySetId;
			}
			
			System.out.println(sql);
			
			Session session=HibernateUtils.getSession();
			session.beginTransaction();
			List<CooperBillVO> cooperBills =session.createQuery
					("from CooperBillVO where cooperDate > ? and cooperDate < ? ").setString(0, "2015").setString(1, "2016").list();
			session.close();
			return cooperBills;
		}catch (Exception e) {
			return null;
		}	
	}
}