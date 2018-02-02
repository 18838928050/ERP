/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuandanchakanBean;
import com.erp.model.vo.anzhuangdanzuofeiBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月19日 下午3:05:52 一份耕耘，一份收获*****
 */
public class anzhuangdanzuofeiAction extends BaseAction<AnzhuangdannVTO> {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,BB.bill_code AS d,	BB.content AS e,"
				+ "	SB.setu_name_str AS f,SB.crea_name  AS g,SB.exam AS h   FROM 	business_bill AS BB,setu_bill AS SB,"
				+ " establishment AS E WHERE 	SB.bb_id = BB.ID AND BB.client_id = E.ID AND SB.enab = 'Y'";
		Query query = session.createNativeQuery(sql);
		List<anzhuangdanzuofeiBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(anzhuangdanzuofeiBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	public String chakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String a = model.getAnzhuangdanzuofeiBean().getA();
		System.out.println(a + "]]]]]]]]]]]]]]]]]]]]]");
		String sql = "SELECT 	SB.bill_code AS a, 	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,"
				+ "	BB.phone AS e,	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,"
				+ "	BBI.specification AS i,	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,"
				+ "	SB.addr AS n,	SB.cost AS o,	SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,"
				+ "	SB.need_car AS s,	SB.requ AS t,	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,"
				+ " SB.exam_name AS x,	SB.exam_time AS y,	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,"
				+ " 	business_bill AS BB,	setu_bill AS SB,	business_bill_ext AS BBE,"
				+ "	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,	make_type AS MT,	tally_set AS TS WHERE"
				+ "	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND BB.tally_set_id = 2 AND BBE.examined = 'Y'"
				+ " AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id "
				+ "AND SB.bill_code = '"
				+ a
				+ "' AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY "
				+ "	SB.bill_code";
		String sql2 = "SELECT 	SB.bill_code AS a, 	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,"
				+ "	BB.phone AS e,	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,"
				+ "	BBI.specification AS i,	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,"
				+ "	SB.addr AS n,	SB.cost AS o,	SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,"
				+ "	SB.need_car AS s,	SB.requ AS t,	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,"
				+ " SB.exam_name AS x,	SB.exam_time AS y,	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,"
				+ " 	business_bill AS BB,	setu_bill AS SB,	business_bill_ext AS BBE,"
				+ "	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,	make_type AS MT,	tally_set AS TS WHERE"
				+ "	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND BB.tally_set_id = 2 AND BBE.examined = 'Y'"
				+ " AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id "
				+ " AND SB.bill_code = '"
				+ a
				+ "' AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY "
				+ "	SB.bill_code";
		Query query = session.createNativeQuery(sql);
		Query query2 = session.createNativeQuery(sql2);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		// 这个数组是有GroupBy的，不在jsp的table里面遍历
		List<AnzhuandanchakanBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("list2", list2);
		// 查项目类型，通过bbi.make_type_id
		return "toChakan";
	}

	public String zuofei() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String a = model.getAnzhuangdanzuofeiBean().getA();
		String sql = "update setu_bill set enab='N' where bill_code='" + a + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";
	}

	public String tuichu() {
		return "toList";

	}
}
