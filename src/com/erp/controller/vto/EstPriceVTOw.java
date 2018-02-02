package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.EstPriceVO;

public class EstPriceVTOw {
	private EstPriceVO estPrice;
	private List<EstPriceVO> estPriceVOs;

	public EstPriceVO getEstPrice() {
		return estPrice;
	}

	public void setEstPrice(EstPriceVO estPrice) {
		this.estPrice = estPrice;
	}

	public List<EstPriceVO> getEstPriceVOs() {
		return estPriceVOs;
	}

	public void setEstPriceVOs(List<EstPriceVO> estPriceVOs) {
		this.estPriceVOs = estPriceVOs;
	}

}
