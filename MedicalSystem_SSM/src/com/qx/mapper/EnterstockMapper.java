package com.qx.mapper;

import java.util.List;

import com.qx.po.Enterstock;

public interface EnterstockMapper {
   
	//进库单号
	public List<Enterstock> FindEnterStockCode (String EnterStockCode);
		
	//新增药品入库信息
	public boolean insertEnterStock(Enterstock enterstock);
	
}