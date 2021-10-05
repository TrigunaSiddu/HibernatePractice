package com.ty.hibernet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hibernetdemo.Employee;

public class SingleDatajpql {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		String findAll="from Employee where Sid=200";
		Query query=manager.createQuery(findAll);
		Employee employee=(Employee) query.getSingleResult();
		System.out.println(employee);
		System.out.println("============");
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getDesignation());
		
		

	}

}
