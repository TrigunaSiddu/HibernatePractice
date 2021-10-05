package com.ty.hibernet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hibernetdemo.Employee;

public class FindAllJpqlImpl {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		String findAll="from Employee";
		Query query=manager.createQuery(findAll);
		List<Employee> list=query.getResultList();
        System.out.println(list);
        System.out.println("==========================");
        for(Employee employee : list) {
        	System.out.println(employee);
        }
	}

}
