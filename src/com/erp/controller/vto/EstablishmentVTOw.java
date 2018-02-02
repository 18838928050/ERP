package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.CooperBillExtVO;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.GatherBillVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.TallySetVO;

public class EstablishmentVTOw {

	private EstablishmentVO establishmentVO;
	private CooperBillVO cooperBill;
	private CooperBillItemVO cooperBillItem;
	private CooperBillExtVO cooperBillExt;
	private MakeTypeVO makeTypeVO;
	private GatherBillVO gatherBillVO;
	private List<GatherBillVO> gatherBillVOs;

	public GatherBillVO getGatherBillVO() {
		return gatherBillVO;
	}

	public void setGatherBillVO(GatherBillVO gatherBillVO) {
		this.gatherBillVO = gatherBillVO;
	}

	public List<GatherBillVO> getGatherBillVOs() {
		return gatherBillVOs;
	}

	public void setGatherBillVOs(List<GatherBillVO> gatherBillVOs) {
		this.gatherBillVOs = gatherBillVOs;
	}

	private List<TallySetVO> tallySetVOs;
	private List<CooperBillItemVO> cooperBillItemVOs;
	// 用来盛放最终单
	private List<List<CooperBillItemVO>> cooperbillitemvoSS;

	public List<List<CooperBillItemVO>> getCooperbillitemvoSS() {
		return cooperbillitemvoSS;
	}

	public void setCooperbillitemvoSS(List<List<CooperBillItemVO>> cooperbillitemvoSS) {
		this.cooperbillitemvoSS = cooperbillitemvoSS;
	}

	private List<CooperBillVO> cooperBillVOs;
	private List<MakeTypeVO> makeTypeVOs;
	private List<List<MakeTypeVO>> makeLists;

	public List<List<MakeTypeVO>> getMakeLists() {
		return makeLists;
	}

	public void setMakeLists(List<List<MakeTypeVO>> makeLists) {
		this.makeLists = makeLists;
	}

	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}

	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}

	public MakeTypeVO getMakeTypeVO() {
		return makeTypeVO;
	}

	public void setMakeTypeVO(MakeTypeVO makeTypeVO) {
		this.makeTypeVO = makeTypeVO;
	}

	public CooperBillItemVO getCooperBillItem() {
		return cooperBillItem;
	}

	public void setCooperBillItem(CooperBillItemVO cooperBillItem) {
		this.cooperBillItem = cooperBillItem;
	}

	public CooperBillExtVO getCooperBillExt() {
		return cooperBillExt;
	}

	public void setCooperBillExt(CooperBillExtVO cooperBillExt) {
		this.cooperBillExt = cooperBillExt;
	}

	private TallySetVO tallySetVO;

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public List<CooperBillItemVO> getCooperBillItemVOs() {
		return cooperBillItemVOs;
	}

	public void setCooperBillItemVOs(List<CooperBillItemVO> cooperBillItemVOs) {
		this.cooperBillItemVOs = cooperBillItemVOs;
	}

	public List<TallySetVO> getTallySetVOs() {
		return tallySetVOs;
	}

	public void setTallySetVOs(List<TallySetVO> tallySetVOs) {
		this.tallySetVOs = tallySetVOs;
	}

	public List<CooperBillVO> getCooperBillVOs() {
		return cooperBillVOs;
	}

	public void setCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		this.cooperBillVOs = cooperBillVOs;
	}

	public CooperBillVO getCooperBill() {
		return cooperBill;
	}

	public void setCooperBill(CooperBillVO cooperBill) {
		this.cooperBill = cooperBill;
	}

	private List<EstablishmentVO> establishmentVOs;

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

}
