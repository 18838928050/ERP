package com.erp.controller.system.mgr;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

import com.erp.model.dao.EstPriceDAOw;
import com.erp.model.vo.EstPriceVO;
import com.erp.model.vo.FenyeMode;

public class EstPriceMgr {
	EstPriceDAOw estPriceDAO = new EstPriceDAOw();

	public int getEstPriceSequenceCodeMax() {
		return estPriceDAO.getEstPriceSequenceCodeMax();
	}

	public void save(EstPriceVO estPrice) throws Exception {

		EstPriceVO estPriceVO = new EstPriceVO();
		estPriceVO.setId(estPrice.getId());
		estPriceVO.setProName(estPrice.getProName());
		estPriceVO.setSpecification(estPrice.getSpecification());
		estPriceVO.setUnit(estPrice.getUnit());
		estPriceVO.setPrice(estPrice.getPrice());
		estPriceVO.setMakeRequire(estPrice.getMakeRequire());
		estPriceVO.setMark(estPrice.getMark());

		System.out.println("***" + estPriceVO);
		estPriceDAO.save(estPrice);
	}

	@Test
	public void testName() throws Exception {
		EstPriceVO estPriceVO = new EstPriceVO();
		estPriceVO.setId(0);
		estPriceVO.setEstId(0);
		estPriceVO.setProId(0);
		estPriceVO.setSequenceCode(0);
		estPriceDAO.save(estPriceVO);
	}

	public EstPriceVO getEstPriceById(long id) throws Exception {
		// TODO Auto-generated method stub
		return estPriceDAO.getById(id);
	}

	public List<EstPriceVO> getEstPriceList() {
		// TODO Auto-generated method stub
		return estPriceDAO.getEstPriceList();
	}

	public void update(EstPriceVO estPrice) throws Exception {
		estPriceDAO.update(estPrice);

	}

	public void DeleteEstPriceVOById(long id) throws Exception {
		estPriceDAO.DeleteEstPriceVOById(id);
	}

	public FenyeMode fenyeService(Integer MaxNumEveryPage, Integer currentPageNum) {
		System.out.println(currentPageNum + "......");
		System.out.println(MaxNumEveryPage);
		FenyeMode fenyeMode = new FenyeMode();

		// 1:每页最大数据
		fenyeMode.setMaxNumEveryPage(MaxNumEveryPage);
		// currentPageNum=currentPageNum-1;
		// 判断 如果用户没有输入页数 怎默认设置当前页数为第一页 否则按照用户输入的
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;

		// 获取结果集
		Query query = estPriceDAO.getQuery();
		Integer allResultNum = query.list().size();
		// 3：设置全部结果数
		fenyeMode.setAllResultNum(allResultNum);

		Integer allPageNum = (allResultNum % MaxNumEveryPage == 0) ? allResultNum / MaxNumEveryPage
				: allResultNum / MaxNumEveryPage + 1;
		System.out.println("curr" + currentPageNum + "......");
		System.out.println("fenyeMode.getMaxNumEveryPage()" + fenyeMode.getMaxNumEveryPage());

		// 4:设置一共多少页
		fenyeMode.setAllPageNum(allPageNum);
		if (currentPageNum > allPageNum) {
			currentPageNum = allPageNum;
		}
		// 2:设置当前页
		fenyeMode.setCurrentPageNum(currentPageNum);
		// 设置每页最大数量
		query.setMaxResults(fenyeMode.getMaxNumEveryPage());
		// 设置从第几条数据开始
		query.setFirstResult((currentPageNum - 1) * MaxNumEveryPage);
		// 取得结果集
		List<EstPriceVO> establishmentVOs = query.list();
		// 5：装在结果集
		fenyeMode.setEstPriceList(establishmentVOs);
		return fenyeMode;
	}
}
