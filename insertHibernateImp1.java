package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernetdemo.Employee;

public class insertHibernateImp1 {

public static void main(String[] args) {
	Employee employee=new Employee();
	employee.setId(600);
	employee.setName("sonu");
	employee.setSalary(7000.00);
	employee.setDesignation("trainee");
	
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try
	{
	
	 factory=Persistence.createEntityManagerFactory("emp");
	 manager=factory.createEntityManager();
	 transaction=manager.getTransaction();
	 transaction.begin();

	 manager.persist(employee);

	transaction.commit();
	}
	catch(Exception e) {
		
		e.printStackTrace();
		if(transaction != null) {
			transaction.rollback();
		}
	}
	finally {
		if(manager !=null) {
			manager.close();
		}
		if(factory !=null) {
			factory.close();
		}
	}
	}
}
