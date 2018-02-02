package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.EstablishmentMgr;
import com.erp.controller.vto.EstablishmentVTOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;

@SuppressWarnings("serial")
public class EstablishmentAction extends BaseAction<EstablishmentVTOw> {

	EstablishmentMgr establishmentMgr = new EstablishmentMgr();
	private List<EstablishmentVO> estList;
	private Integer CurrentPageNum;// 当前页
	private Integer maxNumEveryPage;// 每页最大条数
	// 分页模型
	private FenyeMode fenyeMode = new FenyeMode();

	public FenyeMode getFenyeMode() {
		return fenyeMode;
	}

	public Integer getMaxNumEveryPage() {
		return maxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		this.maxNumEveryPage = maxNumEveryPage;
	}

	public void setFenyeMode(FenyeMode fenyeMode) {
		this.fenyeMode = fenyeMode;
	}

	public List<EstablishmentVO> getEstList() {
		return estList;
	}

	public void setEstList(List<EstablishmentVO> estList) {
		this.estList = estList;
	}

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	public String EstablishmentUI() {
		maxNumEveryPage = (maxNumEveryPage == null || maxNumEveryPage.equals("")) ? 10
				: maxNumEveryPage;
		fenyeMode = establishmentMgr.fenyeService(maxNumEveryPage, CurrentPageNum);
		List<EstablishmentVO> establishmentVOs = fenyeMode.getEstList();
		return "tofirstlistSelectUI";
	}

	public String listUI() throws Exception {
		String sort = "asc";
		String timeLimit = "";
		Long tallyset = 1l;
		String hasPay = "包括已付完款的外协单";
		// 从firstSelectUI得到的id
		model.setEstablishmentVO((EstablishmentVO) establishmentMgr.getEstablishmentById(model
				.getEstablishmentVO().getId()));
		// 由E.id=CB.cooperartor_id 得到CB 这是LIst
		model.setCooperBillVOs(establishmentMgr.getCooperBillsByCooperatorId(model
				.getEstablishmentVO().getId(), sort, tallyset, timeLimit, hasPay));

		// 由E.id=CB.cooperartor_id 得到CB 这是List，过滤了是否付完款，时间、账套，排序的id
		model.setCooperBillVOs(establishmentMgr.getCooperBillsByCooperatorId(model
				.getEstablishmentVO().getId(), sort, tallyset, timeLimit, hasPay));

		// 由CB.id=CBI.bill_id ==>CBI ： 将全部cooperBillVOs的值传入此方法作为参数 获得多个的CB.id；
		// 从而得到多个CBI；(一个CB有多个CBI）
		model.setCooperbillitemvoSS(establishmentMgr.getCooperBillItemsByBillIds(model
				.getCooperBillVOs()));

		// 由CB.id=gatherBill.cooper_bill_id ==>得到Gather_bill
		model.setGatherBillVOs(establishmentMgr.getGatherBillByCooperBillID(model
				.getCooperBillVOs()));

		// 由CBI.make_type_id=Make_type.id 得到make_type
		model.setMakeTypeVOs(establishmentMgr.getMakeTypeByIds(model.getCooperbillitemvoSS()));
		return "toListUI";
	}

}
