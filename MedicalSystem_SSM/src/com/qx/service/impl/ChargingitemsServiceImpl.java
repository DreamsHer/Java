package com.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.qx.mapper.ChargingitemsMapper;
import com.qx.mapper.ChargingitemsdetailMapper;
import com.qx.po.Chargingitems;
import com.qx.po.Chargingitemsdetail;
import com.qx.service.ChargingitemsService;

@Transactional
@Service("chargingitemsService")
public class ChargingitemsServiceImpl implements ChargingitemsService {
	
	@Autowired
	private ChargingitemsMapper chargingitemsMapper;
	
	@Autowired
	private ChargingitemsdetailMapper chargingitemsdetailMapper;
	
	@Override
	public List<Chargingitems> findOuBianHao(String invoicecode) {
		return chargingitemsMapper.findOuBianHao(invoicecode);
	}

	@Override
	public boolean InsertShouFei(Chargingitems chargingitems) {
		return chargingitemsMapper.InsertShouFei(chargingitems);
	}

	@Override
	public boolean InsertShouFeiMingXi(Chargingitemsdetail chargingitemsdetail) {
		return chargingitemsdetailMapper.InsertShouFeiMingXi(chargingitemsdetail);
	}

	@Override
	public List<Chargingitemsdetail> findPageTuiKuan(String where, int startIndex,
			int pageSize) {
		return chargingitemsdetailMapper.findPageTuiKuan(where, startIndex, pageSize);
	}

	@Override
	public int getTotalRow(String where) {
		return chargingitemsdetailMapper.getTotalRow(where);
	}

	@Override
	public List<Chargingitemsdetail> findQiTaTongJi(String where,
			int startIndex, int pageSize) {
		return chargingitemsdetailMapper.findQiTaTongJi(where, startIndex, pageSize);
	}

	@Override
	public int getQiTaTongJiRow(String where) {
		return chargingitemsdetailMapper.getQiTaTongJiRow(where);
	}

}
