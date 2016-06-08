package com.acorn.repo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@NotEmpty
	@Column(name="course_id",unique=true)
	private String courseId;
	
	@NotEmpty
	@Column(name="course_name",unique=true)
	private String courseName;
	
	@Column(name="course_duration")
	private int courseDuration;

}
