package com.qx.mapper;

import java.util.List;

import com.qx.po.Company;

public interface CompanyMapper {
	
	//药品录入—查询供应商Id
	public List<Company> findCompanyId();
    
}