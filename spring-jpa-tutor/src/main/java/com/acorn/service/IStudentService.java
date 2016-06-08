package com.acorn.service;

import javax.transaction.Transactional;

import com.acorn.repo.entity.Student;


public interface IStudentService {
	
	@Transactional(rollbackOn=Exception.class)
	public void createStudent(Student s) throws Exception;
	
	@Transactional(rollbackOn=Exception.class)
	public Student findByRegId(String id) throws Exception;

}
