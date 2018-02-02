/**
 * 
 */
package com.erp.controller.action;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.BusinessBillActionMgr;
import com.erp.controller.vto.BusinessBillVTOw;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.SerarchBeans;
import com.erp.util.TransMoneyToUP;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： 如约而至 @time：2017年9月12日 下午8:04:05
 *******************************************************************
 @说明： 业务单一览表
 *******************************************************************/
@SuppressWarnings("serial")
public class BusinessBillAction extends BaseAction<BusinessBillVTOw> {
	BusinessBillActionMgr businessBillActionMgr = new BusinessBillActionMgr();

	public String updateend() throws Exception {
		// 更改BB
		// businessBillActionMgr.updateBusinessBill(model.getBusinessBillVO());
		System.out.println(model.getBusinessBillVO());
		// all是汇总所有的账单
		List<BusinessBillItemVO> all = new ArrayList<BusinessBillItemVO>();

		// 第一个table的账单
		List<BusinessBillItemVO> b = model.getBusinessBillItemVOsOne();
		for (BusinessBillItemVO businessBillItemVO : b) {
			all.add(businessBillItemVO);
		}
		// 第二个table的账单
		List<BusinessBillItemVO> b1 = model.getBusinessBillItemVOsTwo();
		for (BusinessBillItemVO businessBillItemVO : b1) {
			all.add(businessBillItemVO);
		}
		// 第三个table的账单
		List<BusinessBillItemVO> b2 = model.getBusinessBillItemVOsThree();
		for (BusinessBillItemVO businessBillItemVO : b2) {
			all.add(businessBillItemVO);
		}

		businessBillActionMgr.updateBusinessBillItems(all);
		return null;
	}

	/**
	 * 
	 * @throws Exception
	 * @说明：打印小票
	 */
	public String printXiaopiao() throws Exception {
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillById(model.getBusinessBillVO()
				.getId()));
		BusinessBillVO billVO = model.getBusinessBillVO();
		// 由BB.id=BBI.bill_id===>BBI
		model.setBusinessBillItemVOs(businessBillActionMgr.getBusinessBillItemByBillId(model
				.getBusinessBillVO().getId()));
		model.setMakeTypeVOs(businessBillActionMgr.getMakeTypeById(model.getBusinessBillItemVOs()));
		model.setWorkCenterVOs(businessBillActionMgr.getWorkCenterById(model
				.getBusinessBillItemVOs()));
		// 由BB.client_id=E.id ===>E
		model.setEstablishmentVO(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVO().getClientId()));
		// 一式三联 百联菜户
		Long id = 9l;// 数据表中销售单不存在对应的这句话： 一式三联，白联财务，红联客户，黄联留存 服务电话：0371-66520971
						// 66758900 营销QQ：800071588 网址：http://www.xzy365.com
		model.setCodeRuleVO(businessBillActionMgr.getCodeRuleByYEwudan(id));

		// 小票下面需要公司信息
		model.setEnterpriseInfoVO(businessBillActionMgr.getEnterpriseInfo());

		return "toXiaopiaoUI";
	}

	/**
	 * 打印收据
	 * 
	 * @throws Exception
	 */
	public String printShouju() throws Exception {
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillById(model.getBusinessBillVO()
				.getId()));
		// BB.bank_account_id=BA.id
		model.setBankAccountVO(businessBillActionMgr.getBankAccountById(model.getBusinessBillVO()
				.getBankAccountId()));
		// 将金额转成大写
		ActionContext.getContext().put("impresTrans",
				TransMoneyToUP.moneyToUp(model.getBusinessBillVO().getImprest()));
		Long id = 9l;// 数据表中销售单不存在对应的这句话： 一式三联，白联财务，红联客户，黄联留存 服务电话：0371-66520971
						// 66758900 营销QQ：800071588 网址：http://www.xzy365.com
		model.setCodeRuleVO(businessBillActionMgr.getCodeRuleByYEwudan(id));
		return "toXiaoshoujuUI";
	}

	/**
	 * 
	 * @throws Exception
	 * @说明：打印销售单
	 */
	public String printXiaoshoudan() throws Exception {
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillById(model.getBusinessBillVO()
				.getId()));
		BusinessBillVO billVO = model.getBusinessBillVO();
		// 由BB.id=BBI.bill_id===>BBI
		model.setBusinessBillItemVOs(businessBillActionMgr.getBusinessBillItemByBillId(model
				.getBusinessBillVO().getId()));
		model.setMakeTypeVOs(businessBillActionMgr.getMakeTypeById(model.getBusinessBillItemVOs()));
		model.setWorkCenterVOs(businessBillActionMgr.getWorkCenterById(model
				.getBusinessBillItemVOs()));
		// 由BB.client_id=E.id ===>E
		model.setEstablishmentVO(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVO().getClientId()));
		// 一式三联 百联菜户
		Long id = 9l;// 数据表中销售单不存在对应的这句话： 一式三联，白联财务，红联客户，黄联留存 服务电话：0371-66520971
						// 66758900 营销QQ：800071588 网址：http://www.xzy365.com
		model.setCodeRuleVO(businessBillActionMgr.getCodeRuleByYEwudan(id));
		return "toXiaoshoudanUI";
	}

	/**
	 * 
	 * @throws Exception
	 * @说明：打印制作单
	 */
	public String printZhizuodan() throws Exception {
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillById(model.getBusinessBillVO()
				.getId()));
		BusinessBillVO billVO = model.getBusinessBillVO();
		// 由BB.id=BBI.bill_id===>BBI
		model.setBusinessBillItemVOs(businessBillActionMgr.getBusinessBillItemByBillId(model
				.getBusinessBillVO().getId()));
		model.setMakeTypeVOs(businessBillActionMgr.getMakeTypeById(model.getBusinessBillItemVOs()));
		model.setWorkCenterVOs(businessBillActionMgr.getWorkCenterById(model
				.getBusinessBillItemVOs()));
		// 由BB.client_id=E.id ===>E
		model.setEstablishmentVO(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVO().getClientId()));
		// 一式三联 百联菜户
		Long id = 8l;// 制作单
		model.setCodeRuleVO(businessBillActionMgr.getCodeRuleByYEwudan(id));
		return "toZhizuodanUI";
	}

	/**
	 * 业务单打印
	 * 
	 * @throws Exception
	 */
	public String printYewudan() throws Exception {
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillById(model.getBusinessBillVO()
				.getId()));
		BusinessBillVO billVO = model.getBusinessBillVO();
		// 由BB.id=BBI.bill_id===>BBI
		model.setBusinessBillItemVOs(businessBillActionMgr.getBusinessBillItemByBillId(model
				.getBusinessBillVO().getId()));
		model.setMakeTypeVOs(businessBillActionMgr.getMakeTypeById(model.getBusinessBillItemVOs()));
		model.setWorkCenterVOs(businessBillActionMgr.getWorkCenterById(model
				.getBusinessBillItemVOs()));
		// 由BB.client_id=E.id ===>E
		model.setEstablishmentVO(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVO().getClientId()));
		// 一式三联 百联菜户
		Long id = 5l;// 业务单
		model.setCodeRuleVO(businessBillActionMgr.getCodeRuleByYEwudan(id));
		return "toYewudanUI";
	}

	/**
	 * 业务改单中单个数据删除
	 */
	public String delete() {
		System.out.println(model.getBusinessBillVO().getBillCode());
		System.out.println("delte222");
		return "toUpdateUI";
	}

	/**
	 * 
	 * @说明：修改之前的数据准备
	 */
	public String updateUI() throws Exception {

		System.out.println("model:" + model.getBusinessBillVO().getBillCode());
		// 准备回显BB
		model.setBusinessBillVO(businessBillActionMgr.getBusinessBillByBillCode(model
				.getBusinessBillVO().getBillCode()));

		// 由BB.client_id=E.id ===>E
		model.setEstablishmentVO(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVO().getClientId()));

		// 由BB.id=BBI.bill_id===>BBI
		model.setBusinessBillItemVOs(businessBillActionMgr.getBusinessBillItemByBillId(model
				.getBusinessBillVO().getId()));

		/**
		 * 为了能分三个table BBI ， 按照price_type的 三个类型 分成三个List<BBI> 放在List<List<BBI>>
		 */

		model.setBusinessBillItemListsList(businessBillActionMgr
				.getBusinessBillItemByBillIdForThreeTable(model.getBusinessBillVO().getId()));

		/************************* 计算三个table下的记录面积 金额 开始 *******************************************/
		// 下面是 业务改单中三个table 每个table下的 记录 面积 金额 单数汇总

		List<BusinessBillItemVO> one = model.getBusinessBillItemListsList().get(0);

		// 第一个table下面的记录数
		BigDecimal firsttableJilu = new BigDecimal(one.size());
		// 第一个table下面的面积
		BigDecimal firsttableArea = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : one) {
			firsttableArea = firsttableArea.add(businessBillItemVO.getSquareNum());
		}

		// 第1个table下面的金额
		BigDecimal firtableMon = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : one) {
			firtableMon = firtableMon.add(businessBillItemVO.getCost());
		}

		// 第二个table
		List<BusinessBillItemVO> se = model.getBusinessBillItemListsList().get(1);
		// 第2个table下面的记录数
		BigDecimal setableJilu = new BigDecimal(se.size());
		// 第2个table下面的长度
		BigDecimal setableLeng = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : se) {
			setableLeng = setableLeng.add(businessBillItemVO.getWidth().multiply(
					businessBillItemVO.getAmount()));
		}

		// 第2个table下面的金额
		BigDecimal setableMon = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : se) {
			setableMon = setableMon.add(businessBillItemVO.getCost());
		}

		// 第3个table
		List<BusinessBillItemVO> th = model.getBusinessBillItemListsList().get(2);
		// 第3个table下面的记录数
		BigDecimal thtableJilu = new BigDecimal(th.size());
		// 第3个table下面的数量
		BigDecimal thtableAmoo = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : th) {
			thtableAmoo = thtableAmoo.add(businessBillItemVO.getAmount());
		}

		// 第3个table下面的金额
		BigDecimal thtableMon = new BigDecimal(0);
		for (BusinessBillItemVO businessBillItemVO : th) {
			thtableMon = thtableMon.add(businessBillItemVO.getCost());
		}

		List<BigDecimal> threetableDeli = new ArrayList<BigDecimal>();
		threetableDeli.add(firsttableJilu);
		threetableDeli.add(firsttableArea);
		threetableDeli.add(firtableMon);
		threetableDeli.add(setableJilu);
		threetableDeli.add(setableLeng);
		threetableDeli.add(setableMon);
		threetableDeli.add(thtableJilu);
		threetableDeli.add(thtableAmoo);
		threetableDeli.add(thtableMon);
		ActionContext.getContext().put("threetableDeli", threetableDeli);

		/************************* 计算三个table下的记录面积 金额 结束 *******************************************/

		// 由BBI.make_type_id=MT.id===>MT
		// model.setMakeTypeVOs(businessBillActionMgr.getMakeTypeById(model.getBusinessBillItemVOs()));
		model.setMaketypeListList(businessBillActionMgr.getMakeTypeByIdForThreeTable(model
				.getBusinessBillItemListsList()));

		// 由多个BBI.wc_id=workcenter.id===>WC
		// model.setWorkCenterVOs(businessBillActionMgr.getWorkCenterById(model.getBusinessBillItemVOs()));
		model.setWorkCenterListList(businessBillActionMgr.getWorkCenterByIdForThreeTable(model
				.getBusinessBillItemListsList()));

		// 由BB.tall_set_id=TS.id===》TS
		model.setTallySetVO(businessBillActionMgr.getTallySetById(model.getBusinessBillVO()
				.getTallySetId()));
		// 由BB.id=A.agent_id===》A
		model.setAccessoryVOs(businessBillActionMgr.getAccessoryByAgaentId(model
				.getBusinessBillVO().getId()));
		// BB.id=BBE.id====>BBE
		model.setBusinessBillExtVO(businessBillActionMgr.getBusinessBillExtsById(model
				.getBusinessBillVO().getId()));
		// BB.department_id=D.id
		model.setDepartmentVO(businessBillActionMgr.getDepartmentById(model.getBusinessBillVO()
				.getDepartmentId()));
		// BB.pay_mode_id=PM.id
		model.setPayModeVO(businessBillActionMgr.getPayModeById(model.getBusinessBillVO()
				.getPayModeId()));
		// 获得所有的部门
		model.setDepartmentVOs(businessBillActionMgr.getDepartmentAll());
		// 获得所有付款方式
		model.setPayModeVOs(businessBillActionMgr.getAllPayMode());

		return "toEditAddUI";
	}

	/**
	 * 
	 * @说明：这是多个条件搜索！！！
	 */
	public String search() {

		SerarchBeans se = new SerarchBeans();
		// 获得所有business_bill 同时还要使BBE中的enabled为Y 才能显示
		model.setBusinessBillVOs(businessBillActionMgr.getBusinessBillsSearch(se));
		// 由bb.client_id=E.id ==>E
		model.setEstablishmentVOs(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVOs()));
		// 由bb.id=BBE.id ==>BBE
		model.setBusinessBillExtVOs(businessBillActionMgr.getBusinessBillExtsByIds(model
				.getBusinessBillVOs()));
		// 由bb.pay_mode_id=paymode.id ==》PM
		model.setPayModeVOs(businessBillActionMgr.getPayModeByIds(model.getBusinessBillVOs()));

		// 调账说明：每调账（增加 减少）一次 ，AB和ABI就会增加一个数据
		// :调账=一个或多个ABI.this_cost相加；其中this_cost:有正负之分 正负就是AB.adjust_type
		// 调账专用：BB.id=ABI.business_bill_id 一个BB.id 对应多个ABI ，多个BB.id
		// 就对应双层list个ABI

		// 直接获得调账了 (这是调账 只是命名不好)
		model.setZhangtaos(businessBillActionMgr
				.getAdjustBillItemByBusinessBillIdsAndGetZhangtaoDate(model.getBusinessBillVOs()));

		// 已收金额数据
		model.setYishous(businessBillActionMgr.getYishous(model.getBusinessBillVOs()));

		// jine总金额
		List<BigDecimal> jine = new ArrayList<BigDecimal>();

		List<BusinessBillVO> b = model.getBusinessBillVOs();
		for (BusinessBillVO businessBillVO : b) {
			jine.add(businessBillVO.getCost());
		}

		// tiaozhang 调账数据
		List<BigDecimal> tiaozhang = model.getZhangtaos();

		// 已收数据
		List<BigDecimal> yishou = model.getYishous();

		List<BigDecimal> qiankuan = new ArrayList<BigDecimal>();
		for (int i = 0; i < jine.size(); i++) {
			qiankuan.add(jine.get(i).add(tiaozhang.get(i)).subtract(yishou.get(i)));
		}
		// 欠款已放入值栈 欠款完成！！
		model.setQianMoneys(qiankuan);

		// 下面开始业务单一览表 表单上面的对当前所列记录的汇总数据
		// 合同
		BigDecimal hetongSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			hetongSum = hetongSum.add(businessBillVO.getCost());
		}
		// 已优惠
		BigDecimal youhuiSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			youhuiSum = youhuiSum.add(businessBillVO.getFavCost());
		}
		// 调账
		BigDecimal tiaozhangSum = new BigDecimal(0l);
		for (BigDecimal a : model.getZhangtaos()) {
			tiaozhangSum = tiaozhangSum.add(a);
		}
		// 已收
		BigDecimal yishouSum = new BigDecimal(0l);
		for (BigDecimal a : model.getYishous()) {
			yishouSum = yishouSum.add(a);
		}
		// 预付款
		BigDecimal yufukuanSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			yufukuanSum = yufukuanSum.add(businessBillVO.getImprest());
		}
		// 欠款
		BigDecimal qiankuanSum = new BigDecimal(0l);
		for (BigDecimal a : model.getQianMoneys()) {
			qiankuanSum = qiankuanSum.add(a);
		}
		// 面积合计
		BigDecimal mianjiSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			mianjiSum = mianjiSum.add(businessBillVO.getSquare());
		}
		// 长度合计 米
		BigDecimal changduSumM = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			changduSumM = changduSumM.add(businessBillVO.getLengM());
		}
		// 长度合计 公分
		BigDecimal changduSumCM = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			changduSumCM = changduSumCM.add(businessBillVO.getLengCm());
		}
		// 合同单数：
		BigDecimal hetongdanshuSum = new BigDecimal(model.getBusinessBillVOs().size());

		if (yishouSum.equals(0)) {
			yishouSum = new BigDecimal(1);
		}
		if (hetongSum.equals(0)) {
			hetongSum = new BigDecimal(1);
		}
		// 这是回款率
		BigDecimal r = (yishouSum).divide(hetongSum, 4, BigDecimal.ROUND_HALF_DOWN).setScale(4,
				BigDecimal.ROUND_HALF_DOWN);
		// 百分数显示
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(2);
		ActionContext.getContext().put("huikuanlv", percent.format(r.doubleValue()));

		List<BigDecimal> huizongSum = new ArrayList<BigDecimal>();
		huizongSum.add(hetongSum);
		huizongSum.add(youhuiSum);
		huizongSum.add(tiaozhangSum);
		huizongSum.add(yishouSum);
		huizongSum.add(yufukuanSum);
		huizongSum.add(qiankuanSum);
		huizongSum.add(mianjiSum);
		huizongSum.add(changduSumM);
		huizongSum.add(changduSumCM);
		huizongSum.add(hetongdanshuSum);
		ActionContext.getContext().put("huizongSum", huizongSum);

		return "search";
	}

	/**
	 * index查看所有 可以添加限制（暂时不加）
	 */
	public String listUI() throws Exception {

		// 获得所有business_bill 同时还要使BBE中的enabled为Y 才能显示
		model.setBusinessBillVOs(businessBillActionMgr.getBusinessBillsByLimit());
		// 由bb.client_id=E.id ==>E
		model.setEstablishmentVOs(businessBillActionMgr.getEstablishmentById(model
				.getBusinessBillVOs()));
		// 由bb.id=BBE.id ==>BBE
		model.setBusinessBillExtVOs(businessBillActionMgr.getBusinessBillExtsByIds(model
				.getBusinessBillVOs()));
		// 由bb.pay_mode_id=paymode.id ==》PM
		model.setPayModeVOs(businessBillActionMgr.getPayModeByIds(model.getBusinessBillVOs()));

		// 调账说明：每调账（增加 减少）一次 ，AB和ABI就会增加一个数据
		// :调账=一个或多个ABI.this_cost相加；其中this_cost:有正负之分 正负就是AB.adjust_type
		// 调账专用：BB.id=ABI.business_bill_id 一个BB.id 对应多个ABI ，多个BB.id
		// 就对应双层list个ABI

		// 直接获得调账了 (这是调账 只是命名不好)
		model.setZhangtaos(businessBillActionMgr
				.getAdjustBillItemByBusinessBillIdsAndGetZhangtaoDate(model.getBusinessBillVOs()));

		// 已收金额数据
		model.setYishous(businessBillActionMgr.getYishous(model.getBusinessBillVOs()));

		// jine总金额
		List<BigDecimal> jine = new ArrayList<BigDecimal>();

		List<BusinessBillVO> b = model.getBusinessBillVOs();
		for (BusinessBillVO businessBillVO : b) {
			jine.add(businessBillVO.getCost());
		}

		// tiaozhang 调账数据
		List<BigDecimal> tiaozhang = model.getZhangtaos();

		// 已收数据
		List<BigDecimal> yishou = model.getYishous();

		List<BigDecimal> qiankuan = new ArrayList<BigDecimal>();
		for (int i = 0; i < jine.size(); i++) {
			qiankuan.add(jine.get(i).add(tiaozhang.get(i)).subtract(yishou.get(i)));
		}
		// 欠款已放入值栈 欠款完成！！
		model.setQianMoneys(qiankuan);

		// 下面开始业务单一览表 表单上面的对当前所列记录的汇总数据
		// 合同
		BigDecimal hetongSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			hetongSum = hetongSum.add(businessBillVO.getCost());
		}
		// 已优惠
		BigDecimal youhuiSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			youhuiSum = youhuiSum.add(businessBillVO.getFavCost());
		}
		// 调账
		BigDecimal tiaozhangSum = new BigDecimal(0l);
		for (BigDecimal a : model.getZhangtaos()) {
			tiaozhangSum = tiaozhangSum.add(a);
		}
		// 已收
		BigDecimal yishouSum = new BigDecimal(0l);
		for (BigDecimal a : model.getYishous()) {
			yishouSum = yishouSum.add(a);
		}
		// 预付款
		BigDecimal yufukuanSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			yufukuanSum = yufukuanSum.add(businessBillVO.getImprest());
		}
		// 欠款
		BigDecimal qiankuanSum = new BigDecimal(0l);
		for (BigDecimal a : model.getQianMoneys()) {
			qiankuanSum = qiankuanSum.add(a);
		}
		// 面积合计
		BigDecimal mianjiSum = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			mianjiSum = mianjiSum.add(businessBillVO.getSquare());
		}
		// 长度合计 米
		BigDecimal changduSumM = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			changduSumM = changduSumM.add(businessBillVO.getLengM());
		}
		// 长度合计 公分
		BigDecimal changduSumCM = new BigDecimal(0l);
		for (BusinessBillVO businessBillVO : model.getBusinessBillVOs()) {
			changduSumCM = changduSumCM.add(businessBillVO.getLengCm());
		}
		// 合同单数：
		BigDecimal hetongdanshuSum = new BigDecimal(model.getBusinessBillVOs().size());

		if (yishouSum.equals(0)) {
			yishouSum = new BigDecimal(1);
		}
		if (hetongSum.equals(0)) {
			hetongSum = new BigDecimal(1);
		}

		// 这是回款率
		BigDecimal r = (yishouSum).divide(hetongSum, 4, BigDecimal.ROUND_HALF_DOWN).setScale(4,
				BigDecimal.ROUND_HALF_DOWN);
		// 百分数显示
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(2);
		ActionContext.getContext().put("huikuanlv", percent.format(r.doubleValue()));

		List<BigDecimal> huizongSum = new ArrayList<BigDecimal>();
		huizongSum.add(hetongSum);
		huizongSum.add(youhuiSum);
		huizongSum.add(tiaozhangSum);
		huizongSum.add(yishouSum);
		huizongSum.add(yufukuanSum);
		huizongSum.add(qiankuanSum);
		huizongSum.add(mianjiSum);
		huizongSum.add(changduSumM);
		huizongSum.add(changduSumCM);
		huizongSum.add(hetongdanshuSum);
		ActionContext.getContext().put("huizongSum", huizongSum);
		return "toListUI";
	}
}
