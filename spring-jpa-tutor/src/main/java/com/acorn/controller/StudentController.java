package com.acorn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.repo.entity.Student;
import com.acorn.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public  @ResponseBody ResponseEntity<Void> createStudent(@RequestBody @Valid Student s,BindingResult result) throws Exception{
		if(result.hasErrors()){
			throw new Exception(result.getAllErrors().get(0).getDefaultMessage());
		}
		service.createStudent(s);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public  @ResponseBody ResponseEntity<Student> getStudent(@RequestParam("regid") String regId) throws Exception{
		
		Student s = service.findByRegId(regId);
		if(s == null){
			return new ResponseEntity<Student>(s,HttpStatus.NOT_FOUND);
		}
		ResponseEntity<Student> entity =  new ResponseEntity<Student>(s,HttpStatus.OK);
		return entity;
	}

}
