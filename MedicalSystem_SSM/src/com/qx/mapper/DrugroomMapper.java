package com.qx.mapper;

import java.util.List;

import com.qx.po.Drugroom;

public interface DrugroomMapper {
	
	//出库—领药药房
    public List<Drugroom> findDrugRoom_ID ();
	
}