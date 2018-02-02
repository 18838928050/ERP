package com.erp.controller.finance.mgr;

import java.util.List;

import com.erp.model.dao.InComeBillDAO;
import com.erp.model.vo.IncomeBill;

/**
 * 其他收入
 * @author JiaQi
 *
 */
public class InComeBillMgr {
	private InComeBillDAO inComeBillDAO = new InComeBillDAO();
	/**
	 * 获取订单数量
	 * @return
	 */
	public List<IncomeBill> findAllCanUse(String date1,String date2) {
		return inComeBillDAO.findAllCanUse(date1,date2);
	}

}
