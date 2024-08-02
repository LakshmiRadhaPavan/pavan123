package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.StuRegistrationModel;
import com.example.demo.Repository.StuRegistrationRepository;

@Service
public class StuRegistrationService {
	@Autowired
	StuRegistrationRepository reg;
	public StuRegistrationModel StudentInsert(StuRegistrationModel reg2)
	{
		return reg.save(reg2);
	}
	public List<StuRegistrationModel> getall()
	{
		return (List<StuRegistrationModel>) reg.findAll();
	}
}
