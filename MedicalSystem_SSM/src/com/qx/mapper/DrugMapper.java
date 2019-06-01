package com.qx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Drug;

public interface DrugMapper {
	
	//查询药品信息
	public List<Drug> findDrugId(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
				
	//查询药品信息行数
	public int getDrugIdRow(@Param("where")String where);
	
	//回填药品信息
	public Drug getHuiTianDrug(@Param("intwhere")int intwhere);
	
}