/**
 * 
 */
package com.erp.controller.action;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.PlaceMgr;
import com.erp.controller.vto.PlaceVTOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AreaVO;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.xml.internal.ws.message.StringHeader;

/**
 @author： 如约而至    @time：2017年9月2日 下午10:45:23 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class PlaceShowAction extends BaseAction<PlaceVTOw>{
	private PlaceMgr placeMgr=new PlaceMgr();
	private PlaceVTOw placeVTO=new PlaceVTOw();

	//当前操作的省市县的本条记录的id，不是parentID
	private Long id=0l;
	private String childRenName;
	public String getChildRenName() {
		return childRenName;
	}
	public void setChildRenName(String childRenName) {
		this.childRenName = childRenName;
	}


	/**
	 * 上级名字     下级名字
	 * @说明：增加
	 */
	public String add() throws Exception {
		//注意 名称是必须填的 所以 这里就不用再添加判断了
		//
		placeMgr.addPlace(model.getArea().getAreaName(),childRenName);
		return null;
	}
	
	
	/**
	 * 返回到上一级  也就是每进入一个市  就把市下面的所有县的第一个县的id_str 放到session中。用于返回上级！！
	 * @throws Exception 
	 */
	
	public String getTop() throws Exception{
		AreaVO areaVO=(AreaVO) ActionContext.getContext().getSession().get("top");
		String []ids=areaVO.getParentIdStr().split(";");
		//市 返回到 省
		if(ids.length==2){
				model.setaList(placeMgr.getAllsheng());
		}
		
		//县返回到市
		if(ids.length==3){
			String ss=ids[1];
			 Long parentId=Long.parseLong(ss);
			 model.setaList(placeMgr.getAllCity(parentId));
		}
		return "toListUI";
	}
	
	
	/**
	 * 
	 * @说明：删除数据
	 */
	public String delete() throws Exception {
		AreaVO areaVO=placeMgr.getAreaById(id);
		placeMgr.delete(id);
		String str=areaVO.getParentIdStr();
		
		
		String [] aaa=str.split(";");
		for (String string : aaa) {
			System.out.println(string);
		}
		if(str.equals("")){
			System.out.println("weikong");
			model.setaList(placeMgr.getAllsheng());
		}else if (aaa.length==2) {
			String ss=aaa[1];
			Long ids=Long.parseLong(ss);
			model.setaList(placeMgr.getAllCity(ids));
		}
		else if (aaa.length==3) {
			String ss=aaa[2];
			Long ids=Long.parseLong(ss);
			model.setaList(placeMgr.getAllXianByParentId(ids));
		}
		return "toListUI";
	}
	
	
	/**
	 * index查看所有
	 */
	public String listUI() throws Exception {
		ActionContext.getContext().getSession().put("id", id);
		model.setaList(placeMgr.findAll(id));
		return "toListUI";
	}
	
	/**
	 * 
	 * @说明：增加之前的数据准备
	 */
	public String addUI() throws Exception {
		List<String> listtree=  placeMgr.gerTreePlace();
		 ActionContext.getContext().put("listtree", listtree );
		return "toEditAddUI";
	}
	
	
	
	
	
	/**
	 * 
	 * @说明：修改之前的数据准备
	 */
	public String updateUI() throws Exception {
		return "toEditAddUI";
	}
	
	/**
	 * 
	 * @说明：修改数据
	 */
	public String update() throws Exception {
		return "toList";
	}
	
	
	
	/**
	 * 
	 * @说明：查询数据
	 */
	public String findUI() throws Exception {
		return "toList";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
