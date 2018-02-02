package com.erp.controller.make.mgr;

import java.util.List;

import com.erp.controller.make.dao.OutPutDao;
import com.erp.model.vo.OutputVO;

/**
 * 
 * @author WE
 *
 */
public class OutputMgr{
	private OutPutDao outPutDao = new OutPutDao();
	
	public List<OutputVO> findAll(){
		List<OutputVO> outPuts = null;
		try {
			outPuts = outPutDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outPuts;
		
	}

}
