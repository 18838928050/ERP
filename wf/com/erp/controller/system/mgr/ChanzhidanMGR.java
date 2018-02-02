package com.erp.controller.system.mgr;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.erp.model.dao.OvBillDAOw;
import com.erp.model.vo.OvBillVO;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

public class ChanzhidanMGR {
	OvBillDAOw ovBillDAOw=new OvBillDAOw();
	//保存产值单
	public void saveOB(OvBillVO o) throws Exception {
		OvBillVO ovBillVO2=new OvBillVO();
		Random r=new Random();
		
		String str="Y(2)201708000"+new Random().nextInt(9);
		ovBillVO2.setId(new Random().nextInt(60000));
		ovBillVO2.setOutType("VIR");
		ovBillVO2.setOutDate(new Date());
		ovBillVO2.setStafferId(new Random().nextInt(9));
		ovBillVO2.setDepId(new Random().nextInt(9));
		ovBillVO2.setExamined("Y");
		ovBillVO2.setCreaterId(new Random().nextInt(60000));
		ovBillVO2.setCreateTime(new Date());
		ovBillVO2.setDisableManId(new Random().nextInt(60000));
		ovBillVO2.setDisableManId(new Random().nextInt(60000));
		ovBillVO2.setTallySetId(2);
		ovBillVO2.setEnabled("Y");
		
		ovBillVO2.setExaminerId(new Random().nextInt(9));
		ovBillVO2.setBillCode(str);
		ovBillVO2.setMark(o.getMark());
		ovBillVO2.setCost(o.getCost());
		ovBillVO2.setDescription(o.getDescription());
		ovBillVO2.setCreaterName("邵丽萍");
		ovBillDAOw.save(ovBillVO2);
		
	}
	public List<OvBillVO> getShenheUI() {
		
		return ovBillDAOw.getShenheUI();
	}
	public void shenhe(long id) {
		ovBillDAOw.shenhe(id);
		
	}
	public List<OvBillVO> getFanshenheUI() {
		// TODO Auto-generated method stub
		return ovBillDAOw.getFanshenheUI();
	}
	public void fanshenhe(long id) {
		ovBillDAOw.fanshenhe(id);
		
	}
	public List<OvBillVO> yilanbiao() {
		// TODO Auto-generated method stub
		return ovBillDAOw.yilanbiaoui();
	}
	

}
