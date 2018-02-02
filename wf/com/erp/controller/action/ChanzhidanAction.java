package com.erp.controller.action;

import com.erp.controller.system.mgr.ChanzhidanMGR;
import com.erp.controller.vto.ChanzhiVTO;

//产值单登记   产值单审核 与反审核
public class ChanzhidanAction  extends BaseAction<ChanzhiVTO>{
	ChanzhidanMGR chanzhidanMGR=new ChanzhidanMGR();
	
	//产值单一览表
	public String liyanbiao() throws Exception {
		model.setOvBillVOs(chanzhidanMGR.yilanbiao());
		return "yilanbiaoui";
	}
	
	//反审核
	public String fanshenhe() throws Exception {
		chanzhidanMGR.fanshenhe(model.getOvBillVO().getId());
		return "tofanshenhe";
	}
	
	//反审核
		public String fanshenhew() throws Exception {
			chanzhidanMGR.fanshenhe(model.getOvBillVO().getId());
			return "toyilanbiaoui";
		}
	
	
	//反审核UI
	public String fanshenheUI() throws Exception {
		model.setOvBillVOs(chanzhidanMGR.getFanshenheUI());
		return "fanshenheUI";
	}
	
	//审核
	public String shenhe() throws Exception {
		chanzhidanMGR.shenhe(model.getOvBillVO().getId());
		return "toshenheui";
	}
	
	//审核
		public String shenhew() throws Exception {
			chanzhidanMGR.shenhe(model.getOvBillVO().getId());
			return "toyilanbiaoui";
		}
	
	
	//产值审核UI
	public String shenheUI() throws Exception {
		model.setOvBillVOs(chanzhidanMGR.getShenheUI());
		return "shenheui";
		
	}
	
	
	
	
	
	
	
	
	
	//增加产值
	public String add() throws Exception {
		chanzhidanMGR.saveOB(model.getOvBillVO());
		return null;
	}
	
	
	
	//进入增加产值页面
	public String addUI() throws Exception {
		return "add";
	}
	

}
	