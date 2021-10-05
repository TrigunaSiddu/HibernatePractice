package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.hibernetdemo.Employee;

public class FindHibernateImp1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
//	Employee employee=manager.find(Employee.class, 100);
		Employee employee = manager.getReference(Employee.class, 100);

		System.out.println(employee);

		System.out.println("_____________________");

		System.out.println("Id :" + employee.getId());
		System.out.println("Name :" + employee.getName());
		System.out.println("Designation :" + employee.getDesignation());
		System.out.println("salary :" + employee.getSalary());

	}

}
