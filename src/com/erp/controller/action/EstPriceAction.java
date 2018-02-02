package com.erp.controller.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.EstPriceMgr;
import com.erp.controller.vto.EstPriceVTOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.EstPriceVO;
import com.erp.model.vo.FenyeMode;

public class EstPriceAction extends BaseAction<EstPriceVTOw> {

	EstPriceMgr estPriceMgr = new EstPriceMgr();
	private List<EstPriceVO> estPriceList;
	private Integer CurrentPageNum;// 当前页
	private Integer maxNumEveryPage;// 每页最大条数
	// 分页模型
	private FenyeMode fenyeMode = new FenyeMode();

	public List<EstPriceVO> getEstPriceList() {
		return estPriceList;
	}

	public void setEstPriceList(List<EstPriceVO> estPriceList) {
		this.estPriceList = estPriceList;
	}

	public EstPriceMgr getEstPriceMgr() {
		return estPriceMgr;
	}

	public void setEstPriceMgr(EstPriceMgr estPriceMgr) {
		this.estPriceMgr = estPriceMgr;
	}

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return maxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		this.maxNumEveryPage = maxNumEveryPage;
	}

	public FenyeMode getFenyeMode() {
		return fenyeMode;
	}

	public void setFenyeMode(FenyeMode fenyeMode) {
		this.fenyeMode = fenyeMode;
	}

	public String EstPriceUI() {
		String hql = "from EstPriceVO order by id asc";
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Query<EstPriceVO> query = session.createQuery(hql);
		maxNumEveryPage = (maxNumEveryPage == null || maxNumEveryPage
				.equals("")) ? 10 : maxNumEveryPage;
		fenyeMode = estPriceMgr.fenyeService(maxNumEveryPage, CurrentPageNum);
		System.out.println(fenyeMode.toString());

		List<EstPriceVO> estPriceVOS = fenyeMode.getEstPriceList();
		for (EstPriceVO estPriceVO : estPriceVOS) {
			System.out.println(estPriceVO);
		}

		return "toListUI";
	}

	/**
	 * 增加价格手册回显增加页面
	 */

	public String addEstPriceUI() throws Exception {
		EstPriceVO estPriceVO = new EstPriceVO();
		estPriceVO
				.setSequenceCode(estPriceMgr.getEstPriceSequenceCodeMax() + 1);
		model.setEstPrice(estPriceVO);
		return "toEditAndUI";
	}

	/**
	 * 
	 * @说明：增加价格类型
	 */
	public String addEstPrice() throws Exception {
		System.out.println("===" + model.getEstPrice());
		estPriceMgr.save(model.getEstPrice());
		return "toList";
	}

	/**
	 * 
	 * @说明：编辑价格回显功能
	 */
	public String editEstPriceUI() throws Exception {
		model.setEstPrice(estPriceMgr.getEstPriceById(model.getEstPrice()
				.getId()));

		System.out.println(model.getEstPrice());
		return "toEditAndUI";
	}

	/**
	 * 
	 * @说明：编辑价格
	 */
	public String editEstPrice() throws Exception {
		System.out.println(model.getEstPrice());

		estPriceMgr.update(model.getEstPrice());
		return "toList";

	}

	public String DeleteEstPriceVOById() throws Exception {
		estPriceMgr.DeleteEstPriceVOById(model.getEstPrice().getId());
		return "toList";
	}

}
