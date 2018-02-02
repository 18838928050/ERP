/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.erp.controller.system.mgr.CaigoumingxiMgr;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.ManyTableBean;

/**
 * @author fu
 *
 */
public class cailiaocailiaocaigouhuizongAction extends BaseAction<ManyTableBean> {
	CaigoumingxiMgr caigoumingxiMgr = new CaigoumingxiMgr();
@SuppressWarnings("deprecation")
@Test
	public void findAll() {
		String sql = "SELECT P.product_code  productCode,P.product_name productName,P.unit unit,"
				+ " Sum(PBI.amount)  amount,PBI.unit_price unitPrice,PBI.unit_price*Sum(PBI.amount) cost"
				+ " FROM product P,purchase_bill PB,purchase_bill_ext PBE ,"
				+ " purchase_bill_item PBI WHERE PBI.product_id = P.id AND PBE.id = PB.id AND PBI.bill_id = PB.id AND"
				+ " PB.tally_set_id = 2 AND PBE.enabled = 'Y' AND PBE.examined = 'Y' AND PB.bill_type = 'BUY' GROUP BY P.product_code ";
		Session session = HibernateUtils.getSession();
			NativeQuery<cailiaocaigouhuizongBean> list=
		 (NativeQuery<cailiaocaigouhuizongBean>) session.createSQLQuery(sql).list();
			list.addEntity(cailiaocaigouhuizongBean.class);
			String []lStrings=  list.getNamedParameters();
			for (String string : lStrings) {
				System.out.println(string);
				
			}
	}

@Test
public void test1(){
		
	String sql = "SELECT P.product_code  productCode,P.product_name productName,P.unit unit,"
				+ " Sum(PBI.amount)  amount,PBI.unit_price unitPrice,PBI.unit_price*Sum(PBI.amount) cost"
				+ " FROM product P,purchase_bill PB,purchase_bill_ext PBE ,"
				+ " purchase_bill_item PBI WHERE PBI.product_id = P.id AND PBE.id = PB.id AND PBI.bill_id = PB.id AND"
				+ " PB.tally_set_id = 2 AND PBE.enabled = 'Y' AND PBE.examined = 'Y' AND PB.bill_type = 'BUY' GROUP BY P.product_code";
	
	
	Session session=HibernateUtils.getSession();
	Query query=  session.createNativeQuery(sql);
	List<Pro> p=query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(Pro.class)).list();

	for (Pro pro : p) {
		System.out.println(pro);
	}
	
}

}
