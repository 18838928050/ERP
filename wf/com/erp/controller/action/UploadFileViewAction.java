/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.system.mgr.UploadFileViewMgr;
import com.erp.controller.vto.UploadFileViewVTO;

/**
 @author： 如约而至    @time：2017年12月3日 下午7:00:39 
 *******************************************************************
 @说明： 上传文件一览表
 *******************************************************************/
public class UploadFileViewAction  extends BaseAction<UploadFileViewVTO>{
	UploadFileViewMgr uploadFileViewMgr=new UploadFileViewMgr();

	//第一次打开
	public String list(){
		model.setAccessoryVOs(uploadFileViewMgr.getAllAccessByLimit());
		model.setWorkCenterVOs(uploadFileViewMgr.getAllWCByidOfExtId(model.getAccessoryVOs()));
		model.setBusinessBillVOs(uploadFileViewMgr.getBBByidOfAgaenIds(model.getAccessoryVOs()));
		model.setEstablishmentVOs(uploadFileViewMgr.getEsByidOfClienid(model.getBusinessBillVOs()));
		return "list";
	}
	

}
