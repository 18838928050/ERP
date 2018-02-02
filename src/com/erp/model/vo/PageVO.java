/**
 * 
 */
package com.erp.model.vo;

import java.util.List;

/**
 * @author： 如约而至 @time：2017年8月4日 下午2:15:19
 *******************************************************************
 @说明：分页
 *******************************************************************/
public class PageVO {
	// 存放数值
	private List<CooperBillVO> resultlist;
	// 当前页的页数
	private Integer currentPageNum;
	// 一共页数
	private Integer allPageNum;
	// 每页结果
	private Integer maxNumEveryPage;
	// 一共多少条结果
	private Integer allResultNum;

	public List<CooperBillVO> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<CooperBillVO> resultlist) {
		this.resultlist = resultlist;
	}

	public Integer getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public Integer getAllPageNum() {
		return allPageNum;
	}

	public void setAllPageNum(Integer allPageNum) {
		this.allPageNum = allPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return maxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		this.maxNumEveryPage = maxNumEveryPage;
	}

	public Integer getAllResultNum() {
		return allResultNum;
	}

	public void setAllResultNum(Integer allResultNum) {
		this.allResultNum = allResultNum;
	}

	@Override
	public String toString() {
		return "FenyeMode [currentPageNum=" + currentPageNum + ", allPageNum=" + allPageNum
				+ ", maxNumEveryPage=" + maxNumEveryPage + ", allResultNum=" + allResultNum + "]";
	}

}
