/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.system.mgr.CaigouhuizongMgr;
import com.erp.controller.vto.ProductVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.PurchaseBillItemVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author fu 材料采购汇总一览表
 * @说明：目前的条件是：PBE.examined=Y,PBE.paid=Y,PBE.enabled=Y,PBE.examined=Y,PB.tallySetId=2,PB.bill_type=buy,PB.id=PBI.bill_id,PB.id=PBE.id 
 * PBE:purchase_billext p:product pbi:purchase_bill_item
 * Group by Product.product_code 查出来的东西C72-001有错误
 *
 */
public class caigouhuizongAction extends BaseAction<ProductVTO> {
	CaigouhuizongMgr caigouhuizongMgr = new CaigouhuizongMgr();

	public CaigouhuizongMgr getCaigouhuizongMgr() {
		return caigouhuizongMgr;
	}

	public void setCaigouhuizongMgr(CaigouhuizongMgr caigouhuizongMgr) {
		this.caigouhuizongMgr = caigouhuizongMgr;
	}



	public String findAll() {
		String sql = "SELECT P.product_code AS a,	P.product_name AS b,	P.unit AS c,"
				+ "	Sum(PBI.amount) AS d,	PBI.unit_price AS e,	PBI.unit_price * Sum(PBI.amount) AS f"
				+ " FROM	product AS P INNER JOIN purchase_bill AS PB, purchase_bill_ext AS PBE, purchase_bill_item AS PBI"
				+ " WHERE	PBI.product_id = P.id AND PBE.id = PB.id AND PBI.bill_id = PB.id AND PB.tally_set_id = 2 AND PBE.enabled = 'Y'"
				+ " AND PBE.examined = 'Y' AND PB.bill_type = 'BUY' GROUP BY 	P.product_code";
		Session session = HibernateUtils.getSession();
		Query query = session.createNativeQuery(sql);
		List<Pro> pList = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(Pro.class)).list();
		ActionContext.getContext().put("pList", pList);
		return "toList";
	}

	
	
	
	
	
	public String Chukumingxi() {
		// 这是传过来的ProductCode
		// 单号，出库日期，仓库，经办人
		model.setOutBillVOs(caigouhuizongMgr.getOutBillVOs(model.getProduct().getProductCode()));
		// 单材料编号，品名规格，单位
		model.setProduct(caigouhuizongMgr.getProduct(model.getProduct().getProductCode()));
		//仓库
		model.setStorehouseVOs(caigouhuizongMgr.getStorehourses(model.getOutBillVOs()));
		//数量，单价，金额
		model.setPurchaseBillItemVOs(caigouhuizongMgr.getPBIs(model.getProduct().getProductCode()));
		for (PurchaseBillItemVO iterable_element : model.getPurchaseBillItemVOs()) {
			System.out.println(iterable_element);
			
		}
		return "toChuku";

	}

}
