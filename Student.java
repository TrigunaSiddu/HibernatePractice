package com.ty.hibernetdemo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Student implements Serializable {
@Id	
private int roll_no;
private String name;
private long phno;
private String standard;


}
