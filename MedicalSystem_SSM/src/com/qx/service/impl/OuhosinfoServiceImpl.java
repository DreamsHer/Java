package com.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.OuhosinfoMapper;
import com.qx.po.Ouhosinfo;
import com.qx.service.OuhosinfoService;

@Transactional
@Service("ouhosinfoService")
public class OuhosinfoServiceImpl implements OuhosinfoService {

	@Autowired
	private OuhosinfoMapper ouhosinfoMapper;

	/**
	 * 挂号单号
	 */
	@Override
	public List<Ouhosinfo> findByGuaHao(String mzregno) {
		return ouhosinfoMapper.findByGuaHao(mzregno);
	}

	/**
	 * 新增门诊挂号
	 */
	@Override
	public boolean InsertOuhosinfo(Ouhosinfo ouhosinfo) {
		return ouhosinfoMapper.InsertOuhosinfo(ouhosinfo);
	}

	/**
	 * 查询收费病人信息
	 */
	@Override
	public List<Ouhosinfo> findPage(String where, int startIndex, int pageSize) {		
		return ouhosinfoMapper.findPage(where, startIndex, pageSize);		
	}

	@Override
	public int getTotalRow(String where) {		
		return ouhosinfoMapper.getTotalRow(where);				
	}

	/**
	 * 回填病人信息
	 */
	@Override
	public Ouhosinfo findHuiTian(int intwhere) {
		return ouhosinfoMapper.findHuiTian(intwhere);
	}
	
}
