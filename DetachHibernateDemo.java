package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hibernetdemo.Employee;

public class DetachHibernateDemo {

	public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
	EntityManager manager = factory.createEntityManager();
	Employee employee=manager.find(Employee.class, 100);
	EntityTransaction transaction=manager.getTransaction();
    employee.setName("miller");
	transaction.begin();
	
	//manager.detach(transaction);
	manager.merge(employee);
	manager.persist(employee);
	
	transaction.commit();
	

	}

}
