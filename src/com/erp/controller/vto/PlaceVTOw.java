/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.AreaVO;

/**
 @author： 如约而至    @time：2017年9月2日 下午11:14:46 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class PlaceVTOw {
	private AreaVO area;
	private List<AreaVO> aList;
	private boolean hasParent;
	private boolean hasChild;
	
	
	
	
	public boolean isHasParent() {
		return hasParent;
	}
	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public AreaVO getArea() {
		return area;
	}
	public void setArea(AreaVO area) {
		this.area = area;
	}
	public List<AreaVO> getaList() {
		return aList;
	}
	public void setaList(List<AreaVO> aList) {
		this.aList = aList;
	}
	@Override
	public String toString() {
		return "PlaceVTO [area=" + area + ", aList=" + aList + ", hasParent="
				+ hasParent + ", hasChild=" + hasChild + "]";
	}

	

}
