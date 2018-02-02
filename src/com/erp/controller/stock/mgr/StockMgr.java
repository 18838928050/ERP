package com.erp.controller.stock.mgr;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.erp.controller.stock.dao.AlloBillDAO;
import com.erp.controller.stock.dao.InBillDAO;
import com.erp.controller.stock.dao.InOutHistoryDAO;
import com.erp.controller.stock.dao.OutBillDAO;
import com.erp.controller.stock.dao.ProductDAO;
import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.stock.vo.InBillVO;
import com.erp.controller.stock.vo.InOutHistoryVO;
import com.erp.controller.stock.vo.OutBillVO;
import com.erp.controller.stock.vo.ProductVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 客户业务 逻辑处理
 * @author guo
 *
 */
public class StockMgr {
	private AlloBillDAO alloBillDAO = new AlloBillDAO();
	private InBillDAO inBillDAO = new InBillDAO();
	private OutBillDAO outBillDAO = new OutBillDAO();
	private ProductDAO productDAO = new ProductDAO();
	private InOutHistoryDAO inOutHistoryDAO = new InOutHistoryDAO();

	//作废单个挑拨单
	public void updateAlloBill(AlloBillVO alloBill) {
		try {
			alloBillDAO.updeateEnabled(alloBill.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//作废单个入库单 
	public void updateInBill(InBillVO inBillVO) {
		try {
			inBillDAO.updeateEnabled(inBillVO.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//作废单个出库单
	public void updateOutBill(OutBillVO outBill) {
		try {
			outBillDAO.updeateEnabled(outBill.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//	查询所有的挑拨单
	public void findAllAlloBill() {
		//		将所有的员工都遍历出来
		List<AlloBillVO> alloBills;
		try {
			alloBills = alloBillDAO.findAll();
			//		将发现的员工发送到前台
			ActionContext.getContext().getValueStack().set("alloBills", alloBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	查询所有入库单
	public void findAllInBill() {
		List<InBillVO> inBills;
		try {
			inBills = inBillDAO.findAll();
			ActionContext.getContext().getValueStack().set("inBills", inBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		将发现的员工发送到前台
	}

	//	查询所有的出库单
	public void findAllOutBill(){
		List<OutBillVO> outBills;
		try {
			outBills = outBillDAO.findAll();
			ActionContext.getContext().getValueStack().set("outBills", outBills);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	查询所有的库存
	public void findAllProduct(){
		List<ProductVO> products;
		try {
			products = productDAO.findAll();
			ActionContext.getContext().getValueStack().set("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	查询所有收发存明细
	public void findAllInOutHistory(){
		List<InOutHistoryVO> inOutHistorys;
		try {
			inOutHistorys = inOutHistoryDAO.findAll();
			ActionContext.getContext().getValueStack().set("inOutHistorys", inOutHistorys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	查询所有的收发存总表
	public void findInOutCount(){
		List<ProductVO> products;
		try {
			products = productDAO.findAll();
			ActionContext.getContext().getValueStack().set("products", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}