/**
 * 
 */
package com.erp.model.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ReceiveBillItemVO;

/**
 * @author： 如约而至 @time：2017年9月21日 下午6:32:42
 *******************************************************************
 @说明：
 *******************************************************************/
public class ReceiveBillItemDAOw extends BaseDAOw<ReceiveBillItemDAOw> {


	// 这是已收数据 参数 BB.id
	public List<BigDecimal> getYishou(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<ReceiveBillItemVO>> rs = new ArrayList<List<ReceiveBillItemVO>>();
		for (Long long1 : ids) {
			rs.add(session.createQuery(
					"from ReceiveBillItemVO where businessBillId ='" + long1
							+ "'").list());
		}
		// 假如4个单子 则就有4个yishou ; 而一个yishou:由一个或者多个RBI.this_cost 相加而成！！！
		List<BigDecimal> yishou = new ArrayList<BigDecimal>();
		// 循环得到
		for (List<ReceiveBillItemVO> list : rs) {
			BigDecimal bg = new BigDecimal(0l);
			for (ReceiveBillItemVO receiveBillItemVO : list) {
				bg = bg.add(receiveBillItemVO.getThisCost());
			}
			yishou.add(bg);
		}
		return yishou;
	}
	
	

	// 已收金额测试成功
	@Test
	public void testName() throws Exception {
		List<Long> ids = new ArrayList<Long>();
		ids.add(3462l);
		ids.add(3463l);
		ids.add(3468l);
		ids.add(3482l);

		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		List<List<ReceiveBillItemVO>> rs = new ArrayList<List<ReceiveBillItemVO>>();
		for (Long long1 : ids) {
			rs.add(session.createQuery(
					"from ReceiveBillItemVO where businessBillId ='" + long1
							+ "'").list());
		}

		// 已收金额 yishou
				List<BigDecimal> total_cost = new ArrayList<BigDecimal>();
				// 下面是得到4个BBI.total_cost(由于这个一直不变) 所以任取一个就行
				for (List<ReceiveBillItemVO> list : rs) {
					for (ReceiveBillItemVO receiveBillItemVO : list) {
						System.out.println(receiveBillItemVO.getTotalCost());
						total_cost.add(receiveBillItemVO.getTotalCost());
						
					}
				}
				System.err.println("======");
				for (BigDecimal bigDecimal : total_cost) {
					System.out.println(bigDecimal);
				}
				
	}

}
