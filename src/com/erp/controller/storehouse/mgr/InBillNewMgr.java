package com.erp.controller.storehouse.mgr;

import java.util.List;

import com.erp.controller.vto.InBillVTO;
import com.erp.model.dao.InBillDAO;
import com.erp.model.dao.InBillItemDAO;
import com.erp.model.dao.InTypeDAO;
import com.erp.model.dao.ProductDAO;
import com.erp.model.dao.StorehouseDAO;
import com.erp.model.vo.InBillItem;
import com.erp.model.vo.InType;
import com.erp.model.vo.Product;
import com.erp.model.vo.Staffer;
import com.erp.model.vo.Storehouse;

/**
 * 入库单
 * @author JiaQi
 *
 */
public class InBillNewMgr {
	private StorehouseDAO storehouseDAO = new StorehouseDAO();
	private InBillItemDAO inBillItemDAO = new InBillItemDAO();
	private InTypeDAO inTypeDAO = new InTypeDAO();
	private InBillDAO inBillDAO = new InBillDAO();
	/**
	 * 获取全部仓库
	 * @return
	 */
	public List<Storehouse> findAllStorehouse() {
		List<Storehouse> storehouses = null;
		try {
			storehouses = storehouseDAO.findAllCanUse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return storehouses;
	}
	
	/**
	 * 获取全部入库类型
	 * @return
	 */
	public List<InType> findAllInType() {
		List<InType> inTypes = null;
		inTypes = inTypeDAO.findAllCanUseInType();
		return inTypes;
	}
	
	/**
	 * 获取全部可用材料
	 */
	public List<Product> fingAllCanUseProduct(){
		ProductDAO productDAO = new ProductDAO();
		return productDAO.fingAllCanUseProduct();
	}

	/**
	 * 保存入库单
	 * @param model
	 */
	public void saveInBillVTO(InBillVTO model) {
		try {
			inBillDAO.save(model.getInBill());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 保存材料项
	 * @param inBillItems
	 */
	public void saveInBillItems(List<InBillItem> inBillItems) {
		for (int i = 0; i < inBillItems.size(); i++) {
			try {
				inBillItemDAO.save(inBillItems.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
