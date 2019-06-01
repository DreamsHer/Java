package com.qx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qx.po.Company;
import com.qx.po.Drug;
import com.qx.po.Stock;
import com.qx.po.Stockdetail;

public interface StockService {
	
	//进货编号
	public List<Stock> findStockcode(String stockcode);
	
	//查询药品信息
	public List<Drug> findDrugId(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
					
	//查询药品信息行数
	public int getDrugIdRow(@Param("where")String where);
	
	//回填药品信息
	public Drug getHuiTianDrug(@Param("intwhere")int intwhere);
	
	//新增进货表信息
	public boolean InsertStock(Stock stock);
	
	//新增收费明细信息
	public boolean InsertStockdetail(Stockdetail stockdetail);
	
	//药品录入—查询供应商Id
	public List<Company> findCompanyId();
	
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
