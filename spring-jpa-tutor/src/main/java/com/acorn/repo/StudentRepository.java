package com.acorn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.repo.entity.Student;

@Repository("studentRepo")
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Student findByRegId(String id) throws Exception;
	
}
