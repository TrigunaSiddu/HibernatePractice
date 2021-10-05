package com.ty.hibernet;

import java.util.Scanner;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hibernetdemo.Employee;

public class FindByUsingDynamicjpql {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);

	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try
	{
	 factory = Persistence.createEntityManagerFactory("emp");
	 manager = factory.createEntityManager();
	 String findById="from Employee where Sid=:Sid";
	 Query query=manager.createQuery(findById);
	 System.out.println("enter the id ");
	 int n=sc.nextInt();
	 query.setParameter("Sid", n);
	 Employee employee=(Employee) query.getSingleResult();
	 System.out.println(employee);
	 
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
