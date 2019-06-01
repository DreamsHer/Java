package com.qx.mapper;

import java.util.List;

import com.qx.po.Chargingitems;

public interface ChargingitemsMapper {
	
	//自动生成编号
	public List<Chargingitems> findOuBianHao(String invoicecode);
		
	//新增收费项目信息
	public boolean InsertShouFei(Chargingitems chargingitems);
    
}