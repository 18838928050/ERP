/**
 * 
 */
package com.erp.model.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hamcrest.core.Is;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AdjustBillItemVO;
import com.erp.model.vo.AdjustBillVO;

/**
 @author： 如约而至    @time：2017年9月18日 下午9:38:21 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class AdjustBillItemDAOw extends BaseDAOw<AdjustBillItemVO>{

	
	
	/**
	 * @说明：有几个订单 获得几个调账的数据（已经处理了）
	 */
	public List<BigDecimal> getByBusinessBillIds(List<Long> ids) {
		
		//ids是账单对应的BB.id =ABI.business_bill_id 中的BB.id 
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<BigDecimal> tiaozhangs=new ArrayList<BigDecimal>();
		//一共是ids个数据需要得到账套  这个ids个中  每一个 包含一个或者多个ABI
		for (Long long1 : ids) {
			BigDecimal bigDecimal=new BigDecimal(0);
			//获得一个或者多个ABI 也就是一个或多个this_cost
			List<AdjustBillItemVO> as=  session.createQuery("from AdjustBillItemVO where businessBillId='"+long1+"'").list();
			for (AdjustBillItemVO aa : as) {
				String typename=(String) session.createQuery("select adjustType from AdjustBillVO a where a.id='"+aa.getBillId()+"'").uniqueResult();
				//对每个this_cost进行变负数操作
				if(typename.equals("COLLECT_ABATE")){
					aa.setThisCost(aa.getThisCost().negate());
				}
				bigDecimal=bigDecimal.add(aa.getThisCost());
			}
			tiaozhangs.add(bigDecimal);
		}
		return tiaozhangs;
	}
	
	
	
	//这是查找调账数据
	@Test
	public void testName() throws Exception {
		//ids是账单对应的BB.id =ABI.business_bill_id 中的BB.id 
		List<Long> ids=new ArrayList<Long>();
		ids.add(3462l);
		ids.add(3463l);
		ids.add(3468l);
		ids.add(3482l);
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<AdjustBillItemVO> adjustBillItemVOs=new ArrayList<AdjustBillItemVO>();
		//一共是ids个数据需要得到账套  这个ids个中  每一个 包含一个或者多个ABI
		for (Long long1 : ids) {
			BigDecimal bigDecimal=new BigDecimal(0);
			//获得一个或者多个ABI 也就是一个或多个this_cost
			List<AdjustBillItemVO> as=  session.createQuery("from AdjustBillItemVO where businessBillId='"+long1+"'").list();
			for (AdjustBillItemVO aa : as) {
				String typename=(String) session.createQuery("select adjustType from AdjustBillVO a where a.id='"+aa.getBillId()+"'").uniqueResult();
				//对每个this_cost进行变负数操作
				if(typename.equals("COLLECT_ABATE")){
					aa.setThisCost(aa.getThisCost().negate());
				}
				bigDecimal=bigDecimal.add(aa.getThisCost());
			}
			System.out.println(bigDecimal+"**");
		}
	}
	

}
