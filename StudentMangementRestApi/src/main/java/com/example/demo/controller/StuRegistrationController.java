package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StuRegistrationModel;
import com.example.demo.Service.StuRegistrationService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class StuRegistrationController {
	@Autowired
	StuRegistrationService ser;
	@PostMapping("/register")
	public StuRegistrationModel StudentInsert(@RequestBody StuRegistrationModel reg){
		return ser.StudentInsert(reg);
	}
	@GetMapping("/gettingdata")
	public List<StuRegistrationModel> gettingall(){
		return ser.getall();
	}
}
