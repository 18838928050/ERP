/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.GatherBillVO;
import com.erp.model.vo.MakeTypeVO;

/**
 @author： 如约而至    @time：2017年9月9日 下午9:41:40 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class ReciveringCheckVTOw {
	private EstablishmentVO establishmentVO;
	private List<EstablishmentVO> establishmentVOs;
	
	private CooperBillVO cooperBillVO;
	private List<CooperBillVO> cooperBillVOs;
	private CooperBillItemVO cooperBillItemVO;
	//用来盛放最终单
	private List<List<CooperBillItemVO>> cooperbillitemvoSS;
	private GatherBillVO gatherBillVO;
	
	private List<GatherBillVO> gatherBillVOs;
	private MakeTypeVO makeTypeVO;
	
	private List<MakeTypeVO> makeTypeVOs;
	
	
	
	
	
	
	
	
	
	
	public List<MakeTypeVO> getMakeTypeVOs() {
		return makeTypeVOs;
	}
	public void setMakeTypeVOs(List<MakeTypeVO> makeTypeVOs) {
		this.makeTypeVOs = makeTypeVOs;
	}
	public List<GatherBillVO> getGatherBillVOs() {
		return gatherBillVOs;
	}
	public void setGatherBillVOs(List<GatherBillVO> gatherBillVOs) {
		this.gatherBillVOs = gatherBillVOs;
	}
	public List<List<CooperBillItemVO>> getCooperbillitemvoSS() {
		return cooperbillitemvoSS;
	}
	public void setCooperbillitemvoSS(
			List<List<CooperBillItemVO>> cooperbillitemvoSS) {
		this.cooperbillitemvoSS = cooperbillitemvoSS;
	}
	public List<CooperBillVO> getCooperBillVOs() {
		return cooperBillVOs;
	}
	public void setCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		this.cooperBillVOs = cooperBillVOs;
	}
	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}
	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}
	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}
	public CooperBillVO getCooperBillVO() {
		return cooperBillVO;
	}
	public void setCooperBillVO(CooperBillVO cooperBillVO) {
		this.cooperBillVO = cooperBillVO;
	}
	public CooperBillItemVO getCooperBillItemVO() {
		return cooperBillItemVO;
	}
	public void setCooperBillItemVO(CooperBillItemVO cooperBillItemVO) {
		this.cooperBillItemVO = cooperBillItemVO;
	}
	public GatherBillVO getGatherBillVO() {
		return gatherBillVO;
	}
	public void setGatherBillVO(GatherBillVO gatherBillVO) {
		this.gatherBillVO = gatherBillVO;
	}
	public MakeTypeVO getMakeTypeVO() {
		return makeTypeVO;
	}
	public void setMakeTypeVO(MakeTypeVO makeTypeVO) {
		this.makeTypeVO = makeTypeVO;
	}
	

}
