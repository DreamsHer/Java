package com.qx.mapper;

import java.util.List;

import com.qx.po.Stock;

public interface StockMapper {
	
	//进货编号
	public List<Stock> findStockcode(String stockcode);
	
	//新增进货表信息
	public boolean InsertStock(Stock stock);
	
}