package com.qx.service;

import java.util.List;

import com.qx.po.Drugroom;
import com.qx.po.Outstock;

public interface OutstockService {
	
	//出库—领药药房
    public List<Drugroom> findDrugRoom_ID ();
    
    //自动生成出库单号
  	public List<Outstock> findChuKuDanHao(String outstockcode);

}
