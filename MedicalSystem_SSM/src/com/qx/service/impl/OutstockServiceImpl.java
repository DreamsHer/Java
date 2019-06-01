package com.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.DrugroomMapper;
import com.qx.mapper.OutstockMapper;
import com.qx.po.Drugroom;
import com.qx.po.Outstock;
import com.qx.service.OutstockService;

@Transactional
@Service("outstockService")
public class OutstockServiceImpl implements OutstockService {

	@Autowired
	private DrugroomMapper duDrugroomMapper;
	
	@Autowired
	private OutstockMapper outstockMapper;
	
	@Override
	public List<Drugroom> findDrugRoom_ID() {
		return duDrugroomMapper.findDrugRoom_ID();
	}

	@Override
	public List<Outstock> findChuKuDanHao(String outstockcode) {
		return outstockMapper.findChuKuDanHao(outstockcode);
	}
	
	

}
