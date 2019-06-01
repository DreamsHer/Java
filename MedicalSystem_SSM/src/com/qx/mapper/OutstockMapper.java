package com.qx.mapper;

import java.util.List;

import com.qx.po.Outstock;

public interface OutstockMapper {
	
	//自动生成出库单号
	public List<Outstock> findChuKuDanHao(String outstockcode);
    
}