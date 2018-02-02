/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.system.mgr.YewuduizhangMgrrr;
import com.erp.controller.vto.YewuduizhangVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.YwduizhangVOOO;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月20日 下午6:40:43 一份耕耘，一份收获*****
 */
public class SonghuoduizhangAction extends BaseAction<YewuduizhangVTO> {
	YewuduizhangMgrrr yewuduizhangMgrrr = new YewuduizhangMgrrr();
	private Integer CurrentPageNum;
	private Integer MaxNumEveryPage;
	FenyeMode fenyeMode = new FenyeMode();

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return MaxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		MaxNumEveryPage = maxNumEveryPage;
	}

	public FenyeMode getFenyeMode() {
		return fenyeMode;
	}

	public void setFenyeMode(FenyeMode fenyeMode) {
		this.fenyeMode = fenyeMode;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	public String findAll() throws Exception {
		MaxNumEveryPage = (MaxNumEveryPage == null || MaxNumEveryPage.equals("")) ? 10
				: MaxNumEveryPage;
		fenyeMode = yewuduizhangMgrrr.fenyeService(MaxNumEveryPage, CurrentPageNum);
		List<EstablishmentVO> establishmentVOs = fenyeMode.getEstList();
		model.setEstablishmentVOs(establishmentVOs);
		return "toFindAll";
	}

	public String duizhang() {
		String estCode = model.getEstablishmentVO().getEstCode();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// 包括已收完款的业务单，网络公司，包括下属单位，日期升序
		String sqlString = "SELECT 	BB.order_date AS a, 	BB.bill_code AS b,	MT.type_name AS c,	BBI.finished_content AS d,"
				+ " BBI.pro_name AS e,	BBI.specification AS f,	BBI.unit AS g,	BBI.amount AS h,	BBI.unit_price AS i,"
				+ " 	BBI.cost AS j,	BBI.make_require AS k,	E.linkman AS l FROM 	establishment AS E,"
				+ "	business_bill_item AS BBI,	business_bill AS BB,	make_type AS MT,	business_bill_ext AS BBE"
				+ " WHERE 	BBI.bill_id = BB.id AND BBI.make_type_id = MT.id AND BB.client_id = E.id AND E.est_code = '"
				+ estCode
				+ "'"
				+ " AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBE.enabled = 'Y'  ORDER BY"
				+ "	a ASC";
		Query query = session.createNativeQuery(sqlString);
		List<YwduizhangVOOO> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(YwduizhangVOOO.class)).list();
		ActionContext.getContext().put("list", list);
		return "duizhang";

	}
}
