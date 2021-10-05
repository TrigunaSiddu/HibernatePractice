package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernetdemo.Employee;

public class RemoveHibernateImp1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		
//		Employee employee=manager.find(Employee.class, 100);
		
		EntityTransaction transaction=manager.getTransaction();
		Object emp=manager.getReference(Employee.class,202);
	    	
		
		 transaction.begin();
	     manager.remove(emp);
		transaction.commit();	

	}

}
