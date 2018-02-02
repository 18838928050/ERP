package com.erp.controller.action;

import org.junit.Test;

import com.erp.controller.system.mgr.WaixieshangdengMGR;
import com.erp.controller.vto.LoginVTOw;
import com.erp.controller.vto.WaixieshangdengjiVTO;

public class WaixieshangdengjiAction extends BaseAction<WaixieshangdengjiVTO>{
	WaixieshangdengMGR waixieshangdengMGR=new WaixieshangdengMGR();
	
	//修改
	public String update() throws Exception {
		model.setEstablishment(waixieshangdengMGR.getEById(model.getEstablishment().getId()));
		return "toudpate";
	}
	
	
	//删除
		public String delete() throws Exception {
			waixieshangdengMGR.delete(model.getEstablishment().getId());
			return "tolistall";
		}
	
	
	//启用
	public String start() throws Exception {
		waixieshangdengMGR.start(model.getEstablishment().getId());
		return "tolistall";
	}
	//停用
		public String stop() throws Exception {
			waixieshangdengMGR.stop(model.getEstablishment().getId());
			return "tolistall";
		}
	
	//查看外协项目
	public String waixiexiangmu() throws Exception {
		System.out.println(model.getEstablishment().getId()+"----");
		model.setCooperBillVOs(waixieshangdengMGR.getCB(model.getEstablishment().getId()));
		model.setcList(waixieshangdengMGR.getCBI(model.getCooperBillVOs()));
		model.setMakeTypeVOs(waixieshangdengMGR.getMak(model.getcList()));
		
		return "xiangmu";
	}
	
	//查看所有外协商
	public String listall() throws Exception {
		model.setEstablishmentVOs(waixieshangdengMGR.getAllEs());
		return "listall";
	}
	//转到新增外协商
	public String toAddCooperNew() throws Exception {
		return "toadd";
	}
	//新增外协商        
	public String AddCooperNew() throws Exception {
		waixieshangdengMGR.addEstablishment(getModel());
		return "toadd";
	}

}
