/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import com.erp.controller.vto.PlaceVTOw;
import com.erp.model.dao.PlaceDaow;
import com.erp.model.vo.AreaVO;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 @author： 如约而至    @time：2017年9月2日 下午11:13:23 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class PlaceMgr {
	private PlaceDaow placeDAO=new PlaceDaow();



	/**
	 * @说明：汇总所有正向查找 
	 */
	public List<AreaVO> findAll(long id) {
		System.out.println("---------"+id);
		if("".equals(id)||0L==id){
			//正向查找省
			return placeDAO.findAllSheng();
		}
		else {
			
		 return 	placeDAO.findAllById(id);
		}
	}



	/**
	 * @throws Exception 
	 * @说明：删除
	 */
	public String delete(Long id) throws Exception {
		placeDAO.delete(id);
		
		//级联删除 下级部门
		List<AreaVO> listid=findAll(id);
		for (AreaVO areaVO : listid) {
			placeDAO.delete(areaVO.getId());
		}
		
		return "getTop";
		
		
	}









	/**
	 * @throws Exception 
	 * @说明：
	 */
	public List gerTreePlace() throws Exception {
		return placeDAO.gerTreePlace();
	}



	/**
	 * @说明：
	 */
	public List<AreaVO> getAllsheng() {
		return placeDAO.getSheng();
	}



	/**
	 * @说明：由县得到市
	 */
	public List<AreaVO> getAllCity(Long parentId) {
		return placeDAO.getAllCity(parentId);
	}



	/**
	 * @throws Exception 
	 * @说明：
	 */
	public AreaVO getAreaById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return placeDAO.getById(id);
	}



	/**
	 * @说明：
	 */
	public List<AreaVO> getAllXianByParentId(Long ids) {
		// TODO Auto-generated method stub
		//这个直接用了 get 城市的方法；
		return placeDAO.getAllCity(ids);
	}



	/**
	 * @throws Exception 
	 * @说明：安排怎么讲新数据插入  并且 利用上层数据
	 */
	public void addPlace(String areaName, String childRenName) throws Exception {
		System.out.println(areaName+"==="+childRenName);
		if(areaName.equals("str")){
			//这是要添加省份
			AreaVO areaVO=new AreaVO();
			areaVO.setAreaName(childRenName);
			areaVO.setEnabled("Y");
			areaVO.setParentId(0);
			areaVO.setParentIdStr(null);
			int  sequCode=placeDAO.getSequCode()+1;
			String strcode=String.valueOf(sequCode);
			areaVO.setSequCode(strcode);
			placeDAO.save(areaVO);
		}else {
			AreaVO areaVOvo=  placeDAO.getParentIdByAreaName(areaName);
			System.out.println();
			AreaVO areaVO=new AreaVO();
			areaVO.setAreaName(childRenName);
			areaVO.setEnabled("Y");
			areaVO.setParentId(areaVOvo.getId());
			String string=areaVOvo.getParentIdStr()+areaVOvo.getId()+";";
			
			areaVO.setParentIdStr(string);
			//添加县
			Integer maxsizePar=placeDAO.getSequCodeMaxByParId(areaVOvo.getId())+1;
			String sequ=String.valueOf(maxsizePar);
			areaVO.setSequCode(areaVOvo.getSequCode()+"."+maxsizePar);
			
			
			
			placeDAO.save(areaVO);
			
			
		}
		 
		 
		 
		 
	}



	

	
	
	

}
