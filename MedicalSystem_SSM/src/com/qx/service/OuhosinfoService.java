package com.qx.service;

import java.util.List;

import com.qx.po.Ouhosinfo;

public interface OuhosinfoService {

	//挂号单号 
	public List<Ouhosinfo> findByGuaHao(String mzregno);
	
	//新增门诊挂号  
	public boolean InsertOuhosinfo(Ouhosinfo ouhosinfo);
	
	//查询收费病人信息	
	public List<Ouhosinfo> findPage(String where,int startIndex,int pageSize);		
	
	public int getTotalRow(String where);
	
	//回填病人信息
	public Ouhosinfo findHuiTian(int intwhere);
	
	
}
