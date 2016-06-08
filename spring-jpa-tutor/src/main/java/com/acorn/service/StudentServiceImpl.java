package com.acorn.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.repo.StudentRepository;
import com.acorn.repo.entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public void createStudent(Student s) throws Exception {
		try {
			repo.save(s);
		}catch(Exception se) {
			se.printStackTrace();
			System.out.println(se.getMessage());
			throw se;
		}
		
	}

	@Override
	public Student findByRegId(String id) throws Exception {
		return repo.findByRegId(id);
	}

}
