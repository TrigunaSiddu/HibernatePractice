package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernetdemo.Employee;

public class UpdateHibernate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Employee employee=manager.find(Employee.class, 100);
		employee.setName("Dinga");
		EntityTransaction transaction=null;
		 transaction=manager.getTransaction();
		 transaction.begin();

		 manager.persist(employee);

		transaction.commit();
		System.out.println(employee);
		
	}

}
