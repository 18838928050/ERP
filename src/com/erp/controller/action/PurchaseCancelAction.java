/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.DrawbackMgr;
import com.erp.controller.system.mgr.PurchaseCancelMgr;
import com.erp.controller.vto.PurchaseCancelVTOw;

/**
 * @author： 如约而至 @time：2017年10月10日 下午3:44:57
 *******************************************************************
 @说明： 采购单作废 退款单作废 两者的业务逻辑基本一致 只有一点：采购单筛选：P 开始 退款：O开始
 *******************************************************************/
public class PurchaseCancelAction extends BaseAction<PurchaseCancelVTOw> {

	PurchaseCancelMgr purchaseCancelMgr = new PurchaseCancelMgr();

	//这是退货单中的查看  但是
	public String tuilistdetail() throws Exception {

		// 由前台传来的id 得到
		model.setPurchaseBillVO(purchaseCancelMgr.getPBById(model
				.getPurchaseBillVO().getId()));
		// pb.provider_id=e.id
		model.setEstablishmentVO(purchaseCancelMgr.getEById(model
				.getPurchaseBillVO()));
		model.setTallySetVO(purchaseCancelMgr.getTallyset(model
				.getPurchaseBillVO().getTallySetId()));

		// pb.id=pbe.id
		model.setPurchaseBillExtVO(purchaseCancelMgr.getPEBById(model
				.getPurchaseBillVO().getId()));

		// pb.storeid=s.id
		model.setStorehouseVO(purchaseCancelMgr.getSByid(model
				.getPurchaseBillVO()));
		// pb.id=pbi.billid 一对多
		model.setPurchaseBillItemVOs(purchaseCancelMgr.getPBIByBillId(model
				.getPurchaseBillVO()));
		// pbi.product_id=p.id
		model.setProductVOs(purchaseCancelMgr.getPById(model
				.getPurchaseBillItemVOs()));

		return "listdetail";
	}

	// 退货单作废中的作废
	public String tuicancelling() {
		// 先将enable 设为N system_log 以后再填
		purchaseCancelMgr
				.setCancleByPEBid(model.getPurchaseBillExtVO().getId());

		return "tolist";
	}

	// 退货单作废中的关联
	public String tuiguanlian() throws Exception {
		// 这里由前台传入E.id 再传入 账套 账套 由公共的 登陆时 账套 session 传来吧
		model.setPurchaseBillVO(purchaseCancelMgr.getPBById(model
				.getPurchaseBillVO().getId()));
		Long tallysetId = 2l;
		model.setPayBillVOs(purchaseCancelMgr.getPayBillByTallIdAndEId(
				tallysetId, model.getEstablishmentVO().getId()));
		model.setAdjustBillVOs(purchaseCancelMgr.getAdjustBiByTallIdAndEId(
				tallysetId, model.getEstablishmentVO().getId()));
		return "tuiguanlian";
	}

	// 首次打开退款单作废
	public String listtuikuan() throws Exception {

		model.setPurchaseBillVOs(purchaseCancelMgr
				.getPurchaseBillsForTKByLimits());
		model.setPurchaseBillExtVOs(purchaseCancelMgr.getPBEByids(model
				.getPurchaseBillVOs()));
		model.setEstablishmentVOs(purchaseCancelMgr.getEstablistments(model
				.getPurchaseBillVOs()));
		model.setStorehouseVOs(purchaseCancelMgr.getStoreHByid(model
				.getPurchaseBillVOs()));
		return "listtuikuan";
	}

	/********************************************************************************************************/
	// 采购单作废里的关联
	public String guanlian() throws Exception {
		// 这里由前台传入E.id 再传入 账套 账套 由公共的 登陆时 账套 session 传来吧
		model.setPurchaseBillVO(purchaseCancelMgr.getPBById(model
				.getPurchaseBillVO().getId()));
		Long tallysetId = 2l;
		model.setPayBillVOs(purchaseCancelMgr.getPayBillByTallIdAndEId(
				tallysetId, model.getEstablishmentVO().getId()));
		model.setAdjustBillVOs(purchaseCancelMgr.getAdjustBiByTallIdAndEId(
				tallysetId, model.getEstablishmentVO().getId()));

		return "guanlian";
	}

	// 采购单作废里的zuofei
	public String cancelling() {
		// 先将enable 设为N system_log 以后再填
		purchaseCancelMgr
				.setCancleByPEBid(model.getPurchaseBillExtVO().getId());

		return "tolist";
	}

	// 采购单作废里的查看
	public String listdetail() throws Exception {

		// 由前台传来的id 得到
		model.setPurchaseBillVO(purchaseCancelMgr.getPBById(model
				.getPurchaseBillVO().getId()));
		// pb.provider_id=e.id
		model.setEstablishmentVO(purchaseCancelMgr.getEById(model
				.getPurchaseBillVO()));
		model.setTallySetVO(purchaseCancelMgr.getTallyset(model
				.getPurchaseBillVO().getTallySetId()));

		// pb.id=pbe.id
		model.setPurchaseBillExtVO(purchaseCancelMgr.getPEBById(model
				.getPurchaseBillVO().getId()));

		// pb.storeid=s.id
		model.setStorehouseVO(purchaseCancelMgr.getSByid(model
				.getPurchaseBillVO()));
		// pb.id=pbi.billid 一对多
		model.setPurchaseBillItemVOs(purchaseCancelMgr.getPBIByBillId(model
				.getPurchaseBillVO()));
		// pbi.product_id=p.id
		model.setProductVOs(purchaseCancelMgr.getPById(model
				.getPurchaseBillItemVOs()));

		return "listdetail";
	}

	// 首次打开
	public String list() throws Exception {
		// 自定义条件
		model.setPurchaseBillVOs(purchaseCancelMgr.getPurchaseBillsByLimits());
		// pb.provider_id=e.id
		model.setEstablishmentVOs(purchaseCancelMgr.getEstablistments(model
				.getPurchaseBillVOs()));
		// pb.id=pbe.id=>pbe
		model.setPurchaseBillExtVOs(purchaseCancelMgr.getPBEByids(model
				.getPurchaseBillVOs()));
		// pb.storehourse_id=storehosrse.id=s
		model.setStorehouseVOs(purchaseCancelMgr.getStoreHByid(model
				.getPurchaseBillVOs()));

		return "listUI";
	}

}
