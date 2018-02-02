/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import org.hibernate.SQLQuery;

import com.erp.model.dao.YewuduizhangDaoo;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;

/**
 * @author：fu
 * @date 2017年12月20日 下午7:38:42 一份耕耘，一份收获*****
 */
public class YewuduizhangMgrrr {
	YewuduizhangDaoo yewuduizhangDaoo = new YewuduizhangDaoo();

	/**
	 * @return
	 * @throws Exception
	 * 
	 */
	public List findAll() throws Exception {
		return (List) yewuduizhangDaoo.findAlll();
	}

	/**
	 * @param maxNumEveryPage
	 * @param currentPageNum
	 * @return
	 */
	public FenyeMode fenyeService(Integer maxNumEveryPage, Integer currentPageNum) {
		FenyeMode fenyeMode = new FenyeMode();
		fenyeMode.setMaxNumEveryPage(maxNumEveryPage);
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;
		SQLQuery query = yewuduizhangDaoo.findAlll();
		Integer allResultNum = query.list().size();
		// 3：设置全部结果数
		fenyeMode.setAllResultNum(allResultNum);
		Integer allPageNum = (allResultNum % maxNumEveryPage == 0) ? allResultNum / maxNumEveryPage
				: allResultNum / maxNumEveryPage + 1;
		// 4:设置一共多少页
		fenyeMode.setAllPageNum(allPageNum);
		// 5：设置如果到了最后一页，那么跳回到第一页
		if (currentPageNum > allPageNum) {
			currentPageNum = allPageNum;
		}
		// 再设置一次当前页currentPageNum
		fenyeMode.setCurrentPageNum(currentPageNum);
		// 设置每页最大数量
		query.setMaxResults(fenyeMode.getMaxNumEveryPage());
		// 设置从第几条数据开始
		query.setFirstResult((currentPageNum - 1) * maxNumEveryPage);
		// 取得结果集
		List<EstablishmentVO> establishmentVOs = query.list();
		// 5：装在结果集
		fenyeMode.setEstList(establishmentVOs);
		System.out.println(establishmentVOs + ".....IK...........bankAccountVOs");
		return fenyeMode;
	}

}
