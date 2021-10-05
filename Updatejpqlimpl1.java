package com.ty.hibernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Updatejpqlimpl1 {

	public static void main(String[] args) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try
		{
		 factory = Persistence.createEntityManagerFactory("emp");
		 manager = factory.createEntityManager();
		
		 transaction=manager.getTransaction();
		 transaction.begin();
		 
		// String update="update Employee set Sname='bharath' where Sid=300";
		// Query query=manager.createQuery(update);
		 String delete="delete from Employee where Sid=200";
		 Query query=manager.createQuery(delete);
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
