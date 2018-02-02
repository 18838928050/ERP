/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import com.erp.controller.system.mgr.SongHuoMRG;
import com.erp.controller.vto.LoginVTOw;
import com.erp.controller.vto.SongHuoVTO;
import com.erp.model.vo.BusinessBillItemExtVO;

/**
 * @author： 如约而至 @time：2017年12月15日 上午9:42:23
 *******************************************************************
 @说明：送货 VTO:多个实体类 MGR: duoge dao
 *******************************************************************/
public class SongHuoAction extends BaseAction<SongHuoVTO> {

	SongHuoMRG songHuoMRG = new SongHuoMRG();

	public String zuofei() throws Exception {

		// songHuoMRG.zuofeisonghuodan(model.getDeliverBillVO().getBillCode());
		LoginVTOw user = (LoginVTOw) this.getServletRequest().getSession().getAttribute("loginVTO");
		System.out.println(user);
		return "tolist";

	}

	// 查看
	public String chakan() throws Exception {
		model.setDeliverBillVO(songHuoMRG.getOnlyDBByBillcode(model.getDeliverBillVO()
				.getBillCode()));
		model.setBusinessBillVO(songHuoMRG.getBusinessById(model.getDeliverBillVO()
				.getBusinessBillId()));
		model.setEstablishmentVO(songHuoMRG.getEById(model.getBusinessBillVO().getClientId()));
		model.setDepartmentVO(songHuoMRG.getDById(model.getBusinessBillVO().getDepartmentId()));
		model.setPayModeVO(songHuoMRG.getPMById(model.getBusinessBillVO().getPayModeId()));
		model.setTallySetVO(songHuoMRG.getTallYByid(model.getBusinessBillVO().getTallySetId()));
		// bb.id=bbi.bill_id
		model.setBusinessBillItemVOs(songHuoMRG.getBBIByBillId(model.getBusinessBillVO().getId()));
		// bbi.maketypeid=mt.id
		model.setMakeTypeVOs(songHuoMRG.getMTsById(model.getBusinessBillItemVOs()));
		// bbi.id=bbie.id
		model.setBillItemExtVOs(songHuoMRG.getBBIE(model.getBusinessBillItemVOs()));
		List<BusinessBillItemExtVO> dd = model.getBillItemExtVOs();
		for (BusinessBillItemExtVO businessBillItemExtVO : dd) {
			System.out.println(businessBillItemExtVO.getDeliAmou());
		}
		return "chakan";
	}

	// 查看所有 手动设置账套
	public String listUI() throws Exception {
		model.setDeliverBillVOs(songHuoMRG.getAllDB());
		model.setBusinessBillVOs(songHuoMRG.getAllBBByid(model.getDeliverBillVOs()));
		model.setEstablishmentVOs(songHuoMRG.getAllEById(model.getBusinessBillVOs()));
		return "listui";
	}

}
