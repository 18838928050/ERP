package com.erp.model.dao;

import com.erp.model.vo.TallySetVO;
/**
 * 
 * @author WE
 *
 */
public class TallySetDAOwe extends BaseDAO<TallySetVO>{
	
	public void stopTallySetById(long id, Integer str) throws Exception {
		str=0;
		TallySetVO tallySetVO = getById(id);
		if (str == 1) {
			tallySetVO.setSys(new String("N"));
		} else {
			tallySetVO.setSys(new String("Y"));
		}
		update(tallySetVO);

}
}