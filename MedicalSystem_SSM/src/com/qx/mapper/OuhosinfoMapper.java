package com.qx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Ouhosinfo;

public interface OuhosinfoMapper {
	
	//挂号单号
	public List<Ouhosinfo> findByGuaHao(String mzregno);
	
	//新增门诊挂号
	public boolean InsertOuhosinfo(Ouhosinfo ouhosinfo);	
	
	//查询收费病人信息	
	public List<Ouhosinfo> findPage(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
	
	public int getTotalRow(@Param("where")String where);
	
	//回填病人信息 
	public Ouhosinfo findHuiTian(@Param("intwhere")int intwhere);
    
}