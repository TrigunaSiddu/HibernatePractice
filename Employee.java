package com.ty.hibernetdemo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
//@Table(name = "student")
public class Employee implements Serializable {
	@Id
	@Column(name = "Sid")
	private int id;

	@Column(name = "Sname")
	private String name;

	@Column(name = "S_salary")
	private double salary;

	@Column(name = "S_Designation")
	private String designation;

}
