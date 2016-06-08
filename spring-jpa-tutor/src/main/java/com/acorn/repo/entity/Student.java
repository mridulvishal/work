package com.acorn.repo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3036196482961767580L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Size(message="{NotEmpty.regId}",min=1,max=12345)
	@Column(name="stud_reg_id",unique=true)
	private String regId;
	
	@Column(name="stud_name")
	private String name;
	
	@Column(name="stud_address")
	private String address;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="student_course",
				joinColumns={@JoinColumn(name="stud_id",referencedColumnName="id",table="student")},
				inverseJoinColumns={@JoinColumn(name="course_id",referencedColumnName="id",table="course")})
	private List<Course> courses;
}
