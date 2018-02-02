/**
 * 
 */
package com.erp.controller.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuandanchakanBean;
import com.erp.model.vo.AnzhuandanwangongBean;
import com.erp.model.vo.AnzhuangdanwanggongBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： fu @time：2017年12月6日 下午2:04:03
 * @说明： 一份耕耘，一份收获 安装单完工
 *
 **/
public class anzhuangdanwangongAction extends BaseAction<AnzhuangdannVTO> {

	public String findAll() {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT SB.bill_code AS a,SB.bill_date AS b,"
				+ "BB.bill_code AS d,BB.content AS e,SB.cost AS f,SB.plan_date AS g,"
				+ "SB.setu_name_str AS h,SB.mng_name AS i,SB.crea_name AS j FROM establishment AS E ,"
				+ "business_bill AS BB ,setu_bill AS SB ,business_bill_ext AS BBE ,business_bill_item_ext AS BBIE ,"
				+ "business_bill_item AS BBI WHERE SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND "
				+ "SB.enab = 'Y' AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND "
				+ "BBI.bill_id = BB.id AND BBIE.maked = 'Y' AND SB.exam = 'Y' AND SB.enab = 'Y' AND SB.comp = 'N' GROUP BY SB.bill_code";
		Query query = session.createNativeQuery(sql);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<AnzhuandanwangongBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanwangongBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	public String chakan() {
		String a = model.getAnzhuandanwangongBean().getA();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND  SB.bill_code = '"
				+ a
				+ "' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id";
		String sql2 = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND SB.bill_code = '"
				+ a
				+ "' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY SB.bill_code";

		Query query = session.createNativeQuery(sql);
		Query query2 = session.createNativeQuery(sql2);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		// 这个数组是有GroupBy的，不在jsp的table里面遍历
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<AnzhuandanchakanBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("list2", list2);

		// 查项目类型，通过bbi.make_type_id
		return "toChakan";
	}

	public String wangongdan() {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String a = model.getAnzhuandanwangongBean().getA();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());
		String sql = "SELECT SB.bill_code AS a,	SB.bill_date AS b,	BB.bill_code AS c,	E.est_name AS d,	SB.setu_name_str AS e,"
				+ "	SB.cost AS f FROM 	establishment AS E,	business_bill AS BB,	setu_bill AS SB,	business_bill_ext AS BBE,"
				+ "	business_bill_item_ext AS BBIE,	business_bill_item AS BBI WHERE 	SB.bb_id = BB.id AND BB.client_id = E.id"
				+ " AND BB.tally_set_id = 2 AND SB.enab = 'Y' AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id"
				+ " AND BBI.id = BBIE.id AND BBI.bill_id = BB.id AND BBIE.maked = 'Y' AND SB.exam = 'Y' AND SB.enab = 'Y'"
				+ " AND SB.comp = 'N' AND SB.bill_code = '" + a + "' GROUP BY SB.bill_code";
		Query query = session.createNativeQuery(sql);
		List<AnzhuangdanwanggongBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuangdanwanggongBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("date", date);
		return "wangongdan";
	}

	public String wangong() throws UnsupportedEncodingException {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());
		String SBbillCode = model.getSetuBillVOO().getBillCode();
		String sql = "update setu_bill set comp='Y',comp_time='" + date
				+ "',comp_name='杨海波'  where bill_code='" + SBbillCode + "'";
		System.out.println(session);
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toFirstUI";
	}

}
