/**
 * 
 */
package com.erp.controller.action;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.ReciveringCheckMgr;
import com.erp.controller.vto.ReciveringCheckVTOw;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.GatherBillVO;
import com.erp.model.vo.MakeTypeVO;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 @author： 如约而至    @time：2017年9月7日 下午2:25:02 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class ReciveringCheckAction extends BaseAction<ReciveringCheckVTOw>{
	private ReciveringCheckMgr reciveringCheckMgr=new ReciveringCheckMgr();
	
	
	/**
	 * 进入第一个页面，选择外协商
	 */
	public String firstlistSelectUI() throws Exception {
		model.setEstablishmentVOs(reciveringCheckMgr.getAllWaixie());
		return "tofirstlistSelectUI";
	}
	
	/**
	 * 
	 * @说明：获得日期 排序类型 e.id 三个查询条件==>查询所有并且返回
	 */
	public String listUI() throws Exception {
		//由于前端没有做好  默认先升序排序:  order by date asc  按照时间升序   desc 降序
		String sort="asc";
		String timeLimit="";
		model.setEstablishmentVO(reciveringCheckMgr.getEstablishmentById(model.getEstablishmentVO().getId()));
		//由E.id=CB.cooperartor_id 得到CB  这是LIst
		model.setCooperBillVOs(reciveringCheckMgr.getCooperBillsByCooperatorId(model.getEstablishmentVO().getId() ,sort,timeLimit));
		
		System.err.println("111111111111111111");
		List<CooperBillVO> cooperBillVOs=model.getCooperBillVOs();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			System.err.println(cooperBillVO);
		}
		
		//由CB.id=CBI.bill_id ==>CBI  ：  将全部cooperBillVOs的值传入此方法作为参数 获得多个的CB.id； 从而得到多个CBI；
		model.setCooperbillitemvoSS((reciveringCheckMgr.getCooperBillItemsByBillIds(model.getCooperBillVOs())));
		
		System.out.println("2222222222222222222222");
		List<List<CooperBillItemVO>> cList=model.getCooperbillitemvoSS();
		for (List<CooperBillItemVO> list : cList) {
			for (CooperBillItemVO cooperBillItemVO : list) {
				System.err.println(cooperBillItemVO);
			}
		}
		
		
		
		//由CB.id=gatherBill.cooper_bill_id  ==>得到Gather_bill
		model.setGatherBillVOs(reciveringCheckMgr.getGatherBillByCooperBillID(model.getCooperBillVOs()));
		System.out.println("333333333");
		List<GatherBillVO> gatherBillVOs=model.getGatherBillVOs();
		for (GatherBillVO gatherBillVO : gatherBillVOs) {
			System.err.println(gatherBillVO);
		}
		
		
		//由CBI.make_type_id=Make_type.id  得到make_type
		System.out.println("44444444444444");
		model.setMakeTypeVOs(reciveringCheckMgr.getMakeTypeByIds(model.getCooperbillitemvoSS()));
		List<MakeTypeVO> makeTypeVOs=model.getMakeTypeVOs();
		for (MakeTypeVO makeTypeVO : makeTypeVOs) {
			System.err.println(makeTypeVO);
		}
		return "toListUI";
	}

	
	
	
	

}
