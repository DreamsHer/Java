package com.qx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qx.mapper.PatientMapper;
import com.qx.po.Patient;
import com.qx.service.PatientService;

@Transactional
@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public boolean InsertPatient(Patient patient) {
		return patientMapper.InsertPatient(patient);
	}
	
}
