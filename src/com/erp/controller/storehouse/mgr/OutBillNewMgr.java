package com.erp.controller.storehouse.mgr;

import java.util.List;
import com.erp.controller.vto.OutBillVTO;
import com.erp.model.dao.OutBillDAO;
import com.erp.model.dao.OutBillItemDAO;
import com.erp.model.dao.ProductDAO;
import com.erp.model.dao.StorehouseDAO;
import com.erp.model.vo.OutBillItem;
import com.erp.model.vo.Product;
import com.erp.model.vo.Storehouse;

/**
 * 出库单
 * @author JiaQi
 *
 */
public class OutBillNewMgr {
	private StorehouseDAO storehouseDAO = new StorehouseDAO();
	private OutBillDAO outBillDAO = new OutBillDAO();
	private OutBillItemDAO outBillItemDAO = new OutBillItemDAO();
	
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
	 * 获取全部可用材料
	 */
	public List<Product> fingAllCanUseProduct(){
		ProductDAO productDAO = new ProductDAO();
		return productDAO.fingAllCanUseProduct();
	}

	/**
	 * 保存出库单
	 * @param model
	 */
	public void saveOutBillVTO(OutBillVTO model) {
		try {
			outBillDAO.save(model.getOutBill());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存出库单项
	 * @param outBillItems
	 */
	public void saveOutBillItems(List<OutBillItem> outBillItems) {
		for (int i = 0; i < outBillItems.size(); i++) {
			try {
				outBillItemDAO.save(outBillItems.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
