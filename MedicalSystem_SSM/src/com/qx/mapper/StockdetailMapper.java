package com.qx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Stockdetail;

public interface StockdetailMapper {
   
	//新增进货明细信息
	public boolean InsertStockdetail(Stockdetail stockdetail);
	
	//查询请购单入库信息
	public List<Stockdetail> getYaoPinRuKu(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
				
	//查询请购单入库信息行数 
	public int getYaoPinRuKuRow(@Param("where")String where);
	
	//回填请购单入库信息
	public Stockdetail getHuiTianStock(@Param("intwhere") int intwhere);
	
	
	//门诊收费 ，调出收费药品信息
	public List<Stockdetail> getShouFeiYaoPin(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
					
	//门诊收费 ，调出收费药品信息行数 
	public int getShouFeiYaoPinRow(@Param("where")String where);
		
	//回填门诊收费病人信息
	public Stockdetail HuiTianShouFeiYaoPin(@Param("intwhere") int intwhere);
	
}