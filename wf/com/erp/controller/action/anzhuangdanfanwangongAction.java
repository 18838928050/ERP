package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuandanfanwangongBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： fu @time：2017年12月6日 下午2:04:03
 * @说明： 一份耕耘，一份收获 安装单完工
 *
 **/
public class anzhuangdanfanwangongAction extends BaseAction<AnzhuangdannVTO> {

	public String findAll() {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT SB.bill_code AS a,SB.bill_date AS b,"
				+ "BB.bill_code AS d,BB.content AS e,SB.cost AS f,SB.plan_date AS g,"
				+ "SB.setu_name_str AS h,SB.mng_name AS i,SB.comp_name AS j FROM establishment AS E ,"
				+ "business_bill AS BB ,setu_bill AS SB ,business_bill_ext AS BBE ,business_bill_item_ext AS BBIE ,"
				+ "business_bill_item AS BBI WHERE SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND "
				+ "SB.enab = 'Y' AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND "
				+ "BBI.bill_id = BB.id AND BBIE.maked = 'Y' AND SB.exam = 'Y' AND SB.enab = 'Y' AND SB.comp = 'Y' GROUP BY SB.bill_code";
		Query query = session.createNativeQuery(sql);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<AnzhuandanfanwangongBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanfanwangongBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	// 反完工
	public String fanwangong() {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getSetuBillVOO().getBillCode();
		// SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-hh-dd");
		// Date date=simpleDateFormat.parse("");

		String sql = "update setu_bill set comp='N',comp_time=null,comp_name=null where bill_code='"
				+ SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toFirstUI";
	}

}
