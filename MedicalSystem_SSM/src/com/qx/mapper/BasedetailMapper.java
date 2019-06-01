package com.qx.mapper;

import java.util.List;

import com.qx.po.Basedetail;

public interface BasedetailMapper {
    
	//查询性别
    public List<Basedetail> findByBaseId(Integer basetypeId);
    
    //查询挂号类型
    public List<Basedetail> findByBaseId1(Integer basetypeId);
    
    //查询挂号科室
    public List<Basedetail> findByBaseId2(Integer basetypeId);	
	
    
}