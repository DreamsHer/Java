package com.qx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.qx.po.Chargingitemsdetail;

public interface ChargingitemsdetailMapper {
	
	//新增收费项目明细信息
	public boolean InsertShouFeiMingXi(Chargingitemsdetail chargingitemsdetail);
		
	
	//查询收费信息退药退款
	public List<Chargingitemsdetail> findPageTuiKuan(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
				
	//查询收费信息退药退款总行数 
	public int getTotalRow(@Param("where")String where);
	
			
	//模糊查询其他统计信息
	public List<Chargingitemsdetail> findQiTaTongJi(@Param("where")String where,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);		
		
	//查询其他统计信息行数
	public int getQiTaTongJiRow(@Param("where")String where);
}