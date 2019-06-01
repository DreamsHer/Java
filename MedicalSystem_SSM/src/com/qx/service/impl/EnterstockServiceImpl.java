package com.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.EnterstockMapper;
import com.qx.mapper.EnterstockdetailMapper;
import com.qx.po.Enterstock;
import com.qx.po.Enterstockdetail;
import com.qx.service.EnterstockService;

@Transactional
@Service("enterstockService")
public class EnterstockServiceImpl implements EnterstockService {

	@Autowired
	private EnterstockMapper enterstockMapper;
	
	@Autowired
	private EnterstockdetailMapper enterstockdetailMapper;

	//进库单号
	@Override
	public List<Enterstock> FindEnterStockCode(String EnterStockCode) {		
		return enterstockMapper.FindEnterStockCode(EnterStockCode);
	}

	//新增药品入库信息
	@Override
	public boolean insertEnterStock(Enterstock enterstock) {
		return enterstockMapper.insertEnterStock(enterstock);
	}

	//新增药品入库明细
	@Override
	public boolean insertEnterStockDetail_ID(Enterstockdetail enterstockdetail) {
		return enterstockdetailMapper.insertEnterStockDetail_ID(enterstockdetail);
	}

	//查询入库明细信息--审核
	@Override
	public List<Enterstockdetail> getEnterStocks(String where, int startIndex,
			int pageSize) {
		return enterstockdetailMapper.getEnterStocks(where, startIndex, pageSize);
	}

	//查询入库明细信息--审核--行数 
	@Override
	public int getEnterStockRow(String where) {
		return enterstockdetailMapper.getEnterStockRow(where);
	}
	

}
