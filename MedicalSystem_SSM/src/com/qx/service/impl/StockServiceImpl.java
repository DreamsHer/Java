package com.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.CompanyMapper;
import com.qx.mapper.DrugMapper;
import com.qx.mapper.StockMapper;
import com.qx.mapper.StockdetailMapper;
import com.qx.po.Company;
import com.qx.po.Drug;
import com.qx.po.Stock;
import com.qx.po.Stockdetail;
import com.qx.service.StockService;

@Transactional
@Service("stockService")
public class StockServiceImpl implements StockService{

	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private StockdetailMapper stockdetailMapper;
	
	@Autowired
	private DrugMapper drugMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public List<Stock> findStockcode(String stockcode) {
		return stockMapper.findStockcode(stockcode);
	}

	@Override
	public List<Drug> findDrugId(String where, int startIndex, int pageSize) {
		return drugMapper.findDrugId(where, startIndex, pageSize);
	}

	@Override
	public int getDrugIdRow(String where) {
		return drugMapper.getDrugIdRow(where);
	}

	@Override
	public Drug getHuiTianDrug(int intwhere) {
		return drugMapper.getHuiTianDrug(intwhere);
	}

	@Override
	public boolean InsertStock(Stock stock) {
		return stockMapper.InsertStock(stock);
	}

	@Override
	public boolean InsertStockdetail(Stockdetail stockdetail) {
		return stockdetailMapper.InsertStockdetail(stockdetail);
	}

	@Override
	public List<Company> findCompanyId() {
		return companyMapper.findCompanyId();
	}

	@Override
	public List<Stockdetail> getYaoPinRuKu(String where, int startIndex,int pageSize) {
		return stockdetailMapper.getYaoPinRuKu(where, startIndex, pageSize);
	}

	@Override
	public int getYaoPinRuKuRow(String where) {
		return stockdetailMapper.getYaoPinRuKuRow(where);
	}

	@Override
	public Stockdetail getHuiTianStock(int intwhere) {
		return stockdetailMapper.getHuiTianStock(intwhere);
	}

	@Override
	public List<Stockdetail> getShouFeiYaoPin(String where, int startIndex,int pageSize) {
		return stockdetailMapper.getShouFeiYaoPin(where, startIndex, pageSize);
	}

	@Override
	public int getShouFeiYaoPinRow(String where) {
		return stockdetailMapper.getShouFeiYaoPinRow(where);
	}

	@Override
	public Stockdetail HuiTianShouFeiYaoPin(int intwhere) {
		return stockdetailMapper.HuiTianShouFeiYaoPin(intwhere);
	}

	

}
