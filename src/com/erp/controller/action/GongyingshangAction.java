/**
 * 
 */
package com.erp.controller.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.GongyingshangMgr;
import com.erp.controller.vto.GongyingshangVTOw;
import com.erp.model.vo.EstablishmentContactVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.TallySetVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： 如约而至 @time：2017年10月6日 下午3:08:21
 *******************************************************************
 @说明： 供应 商： 2：供应商管理
 *******************************************************************/
public class GongyingshangAction extends BaseAction<GongyingshangVTOw> {
	GongyingshangMgr gongyingshangMgr = new GongyingshangMgr();

	public String dengji() throws Exception{
		//  登记已经实现了 30%  登记过后 不显示出来  是因为 e: enabled  和 est_code : g
		gongyingshangMgr.saveEst(model.getEstablishmentVO());
		gongyingshangMgr.saveEstContact(model.getEstablishmentContactVOs());
		return "tolistUI";
	}
	
	public String dengjiUI() {
		return "dengjiUI";
	}

	// 删除附件
	public String deleteFujian() throws Exception {
		System.out.println("****:" + model.getEstablishmentVO().getId());
		gongyingshangMgr.deleteFujianByid(model.getAccessoryVO().getId());
		return "tofujian";
	}

	// 相关记录中 的附件
	public String fujian() throws Exception {
		System.out.println("****:" + model.getEstablishmentVO().getId());
		model.setEstablishmentVO(gongyingshangMgr.getEstablistmenteByid(model
				.getEstablishmentVO().getId()));
		model.setAccessoryVOs(gongyingshangMgr.getFujanByEid(model
				.getEstablishmentVO().getId()));
		return "fujian";
	}

	public String upload() {

		return "tolistUI";
	}

	// delete
	public String delete() {
		// 删除供应商
		gongyingshangMgr.deleteByMakeEnableForN(model.getEstablishmentVO()
				.getId());
		return "tolistUI";
	}

	// 启用账号
	public String start() {
		gongyingshangMgr.stopOrstart(model.getEstablishmentVO().getId(),
				"start");
		return "tolistUI";

	}

	// 停用账号
	public String stop() {
		gongyingshangMgr
				.stopOrstart(model.getEstablishmentVO().getId(), "stop");
		return "tolistUI";
	}

	// 修改后保存 供应商信息
	public String editSave() {
		System.out.println("editsave ");
		gongyingshangMgr.editSaveEstablistment(model.getEstablishmentVO());
		gongyingshangMgr.editSaveEstablistmentContactVos(model
				.getEstablishmentContactVOs());

		return "tolistUI";
	}

	// 查看编辑供应商
	public String editGongyingshang() throws Exception {
		// 有id==》E
		model.setEstablishmentVO(gongyingshangMgr.getEstablistmenteByid(model
				.getEstablishmentVO().getId()));

		// e.tallyset_id=ts.id
		model.setTallySetVO(gongyingshangMgr.getTallySetVO(model
				.getEstablishmentVO().getTallySetId()));
		// e.id=多个EC.estId
		model.setEstablishmentContactVOs(gongyingshangMgr
				.getEstabliContactVosByEstId(model.getEstablishmentVO().getId()));
		return "editGongyingshang";
	}

	// 调账记录
	public String adjustBillhistory() {
		model.setAdjustBillVOs(gongyingshangMgr
				.getAdjustBillVOsByClientId(model.getEstablishmentVO().getId()));

		return "adjusthistory";
	}

	// 付款记录
	public String payhistory() throws Exception {
		// e.id=多个PB
		model.setPayBillVOs(gongyingshangMgr.getPayBillVOsByReceiveId(model
				.getEstablishmentVO().getId()));
		List<PayBillVO> pays = model.getPayBillVOs();
		BigDecimal bigDecimal = new BigDecimal(0);
		for (PayBillVO payBillVO : pays) {
			bigDecimal = bigDecimal.add(payBillVO.getCost());
		}
		ActionContext.getContext().put("payall", bigDecimal);

		return "payhistory";
	}

	// 采购记录
	public String purchasehistory() throws Exception {
		// id=>e
		model.setEstablishmentVO(gongyingshangMgr.getEstablistmenteByid(model
				.getEstablishmentVO().getId()));
		// e.id=PB.provider_id==>PB
		model.setPurchaseBillVOs(gongyingshangMgr
				.getPurchaseBillVOsByProviderIds(model.getEstablishmentVO()));

		// PB.id=PBI.bill_id==>PBI
		model.setpLists(gongyingshangMgr.getPurchaseBillItemVOsByBillIds(model
				.getPurchaseBillVOs()));
		List<PurchaseBillItemVO> purchaseBillItemVOs = new ArrayList<PurchaseBillItemVO>();
		for (List<PurchaseBillItemVO> list : model.getpLists()) {
			for (PurchaseBillItemVO purchaseBillItemVO : list) {
				purchaseBillItemVOs.add(purchaseBillItemVO);
			}
		}
		ActionContext.getContext().put("purchaseBillItemVOs",
				purchaseBillItemVOs);

		// 金额
		List<List<PurchaseBillItemVO>> ps = model.getpLists();
		BigDecimal bi = new BigDecimal(0);
		for (List<PurchaseBillItemVO> list : ps) {
			for (PurchaseBillItemVO purchaseBillItemVO : list) {
				bi = bi.add(purchaseBillItemVO.getCost());
			}
		}

		ActionContext.getContext().put("allcost", bi);

		// PBI.product_id=P.id
		model.setProductVOss(gongyingshangMgr.getProductVosByIds(model
				.getpLists()));
		List<ProductVO> pps = new ArrayList<ProductVO>();
		for (List<ProductVO> list : model.getProductVOss()) {
			for (ProductVO productVO : list) {
				pps.add(productVO);
			}
		}

		ActionContext.getContext().put("products", pps);

		return "caigouUI";
	}

	/**
	 * 供应商管理
	 */
	// 查看所有供应商
	public String listUI() {
		model.setEstablishmentVOs(gongyingshangMgr.getEstablishmentVOsByLimits());
		model.settSetVOs(gongyingshangMgr.getSetVOsByIds(model.getEstablishmentVOs()));
		return "listUI";
	}

}
