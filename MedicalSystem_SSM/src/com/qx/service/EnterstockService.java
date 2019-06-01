package com.qx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Enterstock;
import com.qx.po.Enterstockdetail;

public interface EnterstockService {
	
	//进库单号
	public List<Enterstock> FindEnterStockCode (String EnterStockCode);
	
	//新增药品入库信息
	public boolean insertEnterStock(Enterstock enterstock);
		
	//新增药品入库
	public boolean insertEnterStockDetail_ID(Enterstockdetail enterstockdetail);
	
	//查询入库明细信息--审核
	public List<Enterstockdetail> getEnterStocks(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
						
	//查询入库明细信息--审核--行数 
	public int getEnterStockRow(@Param("where")String where);
	

}
