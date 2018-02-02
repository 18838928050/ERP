/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import com.erp.controller.stock.vo.OutBillVO;
import com.erp.model.dao.OutbillDaoByfu;
import com.erp.model.dao.ProductDAOByfu;
import com.erp.model.dao.PurchaseBillItemDAOByfu;
import com.erp.model.dao.StoreHouseDAOByfu;
import com.erp.model.vo.Product;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.StorehouseVO;

/**
 @author： fu    @time：2017年12月3日 下午2:27:24 
 @说明： 一份耕耘，一份收获
 **/
public class CaigouhuizongMgr {
	ProductDAOByfu productDAOByfu=new ProductDAOByfu();
	OutbillDaoByfu outbillDaoByfu=new OutbillDaoByfu();
	StoreHouseDAOByfu storeHouseDAOByfu=new StoreHouseDAOByfu();
	PurchaseBillItemDAOByfu purchaseBillItemDAOByfu=new PurchaseBillItemDAOByfu();
	/**
	 * @说明：
	 */
	public List<OutBillVO> getOutBillVOs(String productCode) {
		return outbillDaoByfu.getOutBillVOS(productCode);
	}
	/**
	 * @说明：
	 */
	public List<StorehouseVO> getStorehourses(List<OutBillVO> outBillVOs) {
		return storeHouseDAOByfu.getStorehourses(outBillVOs);
	}
	/**
	 * @说明：
	 */
	public Product getProduct(String productCode) {
		return productDAOByfu.getProduct(productCode) ;
	}
	/**
	 * @说明：
	 */
	public List<PurchaseBillItemVO> getPBIs(String productCode) {
		return purchaseBillItemDAOByfu.getPBIs(productCode);
	}

}
