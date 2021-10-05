package com.ty.hibernet;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateByUsingDynamic {

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
		
		 String update="update Employee set Sname=:Sname,S_Designation=:desig where Sid=:id";
		 Query query=manager.createQuery(update);
//		 query.setParameter("Sname", args[1]);
//		 query.setParameter("desig", args[2]);
//		 query.setParameter("id", Integer.parseInt(args[0]) );
		 
		 System.out.println("enter the id");
		 int n=sc.nextInt();
		 
		 System.out.println("enter the name");
		 String name=sc.next();
		 
		 System.out.println("enter the designation");
		 String desig=sc.next();
		 
		 query.setParameter("id", n);
		 query.setParameter("Sname", name);
		 query.setParameter("desig", desig);
		 
		 int result=query.executeUpdate();
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
