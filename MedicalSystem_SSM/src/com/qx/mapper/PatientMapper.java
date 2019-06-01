package com.qx.mapper;

import com.qx.po.Patient;

public interface PatientMapper {
	
	//录入病人信息
	public boolean InsertPatient(Patient patient);
	
	
	
	
	  
    int deleteByPrimaryKey(Integer patientId);
  
    Patient selectByPrimaryKey(Integer patientId);
 
    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}