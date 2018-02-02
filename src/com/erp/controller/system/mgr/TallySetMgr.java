package com.erp.controller.system.mgr;

import java.util.List;
import com.erp.model.dao.TallySetDAOwe;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.TallySetVO;


/**
 * 
 * @author WE
 *
 */
public class TallySetMgr {
private TallySetDAOwe tallySetDaowe = new TallySetDAOwe();
	/**
	 * 查询tallyset表
	 */
	public List<TallySetVO> findAll(){
		List<TallySetVO> tallySet = null;
		try {
			tallySet = tallySetDaowe.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}
		return tallySet;
	}

	/**
	 * 根据id删除tallyset表中的某条记录
	 * @param id
	 */
	public void deleteTallySet(long id) {
		try {
			tallySetDaowe.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 增加 tallyset表中的记录，保存到数据库中
	 */
	public void saveTallySet(TallySetVO tallySet) {
		try {
			tallySetDaowe.save(tallySet);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}


	/**
	 * 通过id查询获得tallyset表某个记录
	 * @param id
	 * @return
	 */
	public TallySetVO getById(long id) {
		TallySetVO tallySet = null;
		try {
			tallySet = tallySetDaowe.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tallySet;
	}

	/**
	 * 更新tallyset表
	 * @param tallyset
	 */
	public void updateTallySet(TallySetVO tallySet) {
		try {
			tallySetDaowe.update(tallySet);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}
	
	public void stopById(long id, Integer str) throws Exception {
		tallySetDaowe.stopTallySetById(id, str);

	}

	

}
