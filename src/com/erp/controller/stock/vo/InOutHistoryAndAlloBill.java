package com.erp.controller.stock.vo;

import java.util.Date;

/**
 * 调拨单 和 进出库
 * 问题（进出库对应的是两条记录）
 * @author guo
 *
 */
public class InOutHistoryAndAlloBill {
	private String billCode;//单号
	private Date alloDate = new Date();//调拨日期
	private String description;//摘要
	private String managerName;//经办人
	private String examined = "N";//是否审核
	private String enabled = "Y";//是否启用
	private long tallySetId = 0L;//归属类型
	private String ioType;//in out 入  出
}