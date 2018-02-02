package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.erp.controller.vto.waixeiVTOO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.WaixieBean;
import com.opensymphony.xwork2.ActionContext;

public class WaixiedanyilanbiaoAction extends BaseAction<waixeiVTOO> {
public String findAll() {
	Session session=HibernateUtils.getSession();
	session.beginTransaction();
	
	String sql="SELECT        "
+"CB.bill_code AS a,          "
+"CB.cooper_date AS b,        "
+"E.est_name AS c,            "
+"CB.content AS d,            "
+"CB.cost AS f,               "
+"CBE.adjust_cost AS g,       "
+"CBE.paied_cost AS h,        "
+"CB.manager_name AS j,       "
+"CB.creater_name AS k,       "
+"CBE.examined AS l,          "
+"CBE.has_gather AS m,        "
+"CBE.has_pay AS n            "
+"FROM                        "
+"	cooper_bill AS CB,        "
+"	establishment AS E,       "
+"	cooper_bill_ext AS CBE    "
+"WHERE                       "
+"CB.tally_set_id = 2 AND     "
+"CB.id = CBE.id AND          "
+"CB.cooperator_id = E.id AND "
+"CBE.examined = 'N' AND      "
+"CBE.enabled = 'Y'           ";
	Query query = session.createNativeQuery(sql);
	List<WaixieBean> list = query.unwrap(SQLQuery.class)
			.setResultTransformer(Transformers.aliasToBean(WaixieBean.class)).list();
	ActionContext.getContext().put("list", list);
	return "toFindAll";
	
		
}


@Test
public void testName() throws Exception {
	Session session=HibernateUtils.getSession();
	session.beginTransaction();
	
	String sql="SELECT          "
+"	CB.bill_code AS a,          "
+"	CB.cooper_date AS b,        "
+"	E.est_name AS c,            "
+"	CB.content AS d,            "
+"	CB.cost AS f,               "
+"	CBE.adjust_cost AS g,       "
+"	CBE.paied_cost AS h,        "
+"	CB.manager_name AS j,       "
+"	CB.creater_name AS k,       "
+"	CBE.examined AS l           "
+"FROM                          "
+"	cooper_bill AS CB,          "
+"	establishment AS E,         "
+"	cooper_bill_ext AS CBE      "
+"WHERE                         "
+"	CB.tally_set_id = 2         "
+"AND CB.id = CBE.id            "
+"AND CB.cooperator_id = E.id   "
+"AND CBE.examined = 'N'        "
+"AND CBE.enabled = 'Y'";
	Query query = session.createNativeQuery(sql);
	List<WaixieBean> list = query.unwrap(SQLQuery.class)
			.setResultTransformer(Transformers.aliasToBean(WaixieBean.class)).list();
	for (WaixieBean waixieBean : list) {
		System.out.println(waixieBean);
		
	}
}
}
