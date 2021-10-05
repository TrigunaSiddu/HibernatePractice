package com.ty.hibernet;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDynamicjpql {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try
		{
		
		 factory=Persistence.createEntityManagerFactory("emp");
		 manager=factory.createEntityManager();
		 transaction=manager.getTransaction();
		 transaction.begin();
		 
		 String delete="Delete from Employee where Sid=:id";
		 Query query=manager.createQuery(delete);
		 System.out.println("enter the id");
		 int n=sc.nextInt();
		 query.setParameter("id",n );
		 query.executeUpdate();
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
