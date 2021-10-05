package com.ty.hibernet;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

import com.ty.hibernetdemo.InavalidId;
import com.ty.hibernetdemo.Student;

public class StudentManagement {
	Scanner sc = new Scanner(System.in);
	private static final boolean Student = false;
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	Student student;

	public void seeData() {
		try {
			factory = Persistence.createEntityManagerFactory("empp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String data = " from Student";
			Query query = manager.createQuery(data);
			List<Student> list = query.getResultList();
			System.out.println("===============");
			for (Student student : list) {
				System.out.println(student);
			}

			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	public void particularData() {
		try {
			factory = Persistence.createEntityManagerFactory("empp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String data = "from Student where roll_no=:rollno";
			Query query = manager.createQuery(data);
			System.out.println("enter the roll no");
			int n = sc.nextInt();
			student = manager.getReference(Student.class, n);

			try {
				if (student.getRoll_no() == n) {
					query.setParameter("rollno", n);
					Student student = (Student) query.getSingleResult();

					System.out.println("============");
					System.out.println("roll no :" + student.getRoll_no());
					System.out.println("Name :" + student.getName());
					System.out.println("phone no :" + student.getPhno());
					System.out.println("standard :" + student.getStandard());

					transaction.commit();
				} else {
					// throw new InavalidId();
				}
			} catch (Exception e) {
				throw new InavalidId();
			}
		} catch (Exception e) {

			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

	public void updateData() {
		try {
			factory = Persistence.createEntityManagerFactory("empp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			System.out.println("enter the roll no you wish to update");
			int n = sc.nextInt();
			System.out.println("do you want to update the name :(y/n)");
			char ch = sc.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				System.out.println("enter the name");
				String name = sc.next();

				String update = "update Student set name=:name where roll_no=:n";
				Query query = manager.createQuery(update);
				query.setParameter("name", name);
				query.setParameter("n", n);
				int result = query.executeUpdate();
				System.out.println("updated sucessfully....");
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("do you want to update the phono :(y/n)");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("enter the number");
					long num = sc.nextLong();
					String update = "update Student set phno=:num where roll_no=:n";
					Query query = manager.createQuery(update);
					query.setParameter("num", num);
					query.setParameter("n", n);
					int result = query.executeUpdate();
					System.out.println("updated sucessfully....");
				} else if (c == 'n' || c == 'N') {
					System.out.println("do you want update the standard :(y/n)");
					char s = sc.next().charAt(0);
					if (s == 'y' || s == 'Y') {
						System.out.println("enter the standard");
						String stnd = sc.next();
						String update = "update Student set Standard=:stnd where roll_no=:n";
						Query query = manager.createQuery(update);
						query.setParameter("stnd", stnd);
						query.setParameter("n", n);
						int result = query.executeUpdate();
						System.out.println("updated sucessfully....");
					} else if (s == 'n' || s == 'N') {
						System.out.println("phno not required update");
					}
				}
			} else {
				System.out.println("updated.....");
			}
			transaction.commit();

		}

		catch (Exception e) {

			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}

	}

	public void deleteData() {
		try {
			factory = Persistence.createEntityManagerFactory("empp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			System.out.println("enter the roll num ");
			int rn = sc.nextInt();
			String data = "delete from Student where roll_no=:rollno";
			Query query = manager.createQuery(data);
			student = manager.getReference(Student.class, rn);
			try {
				
				if (student.getRoll_no() == rn) {
					query.setParameter("rollno", rn);
					query.executeUpdate();
					System.out.println("deleted sucessfylly");
				}
				else
				{
					throw new InavalidId();
				}
			} catch (Exception e) {
				throw new InavalidId();
			}
			transaction.commit();

		}

		catch (Exception e) {

			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}

	}

	public static void main(String[] args) {
//		Student student=new Student();
//		student.setRoll_no(6);
//		student.setName("lavanya");
//		student.setPhno(77894568);
//		student.setStandard("10 th standard");
		StudentManagement sm = new StudentManagement();
		Scanner sc = new Scanner(System.in);
		boolean exit=false;
		do
		{
			System.out.println("1.press 1 to see all data");
			System.out.println("2.press 2 to see any particular data");
			System.out.println("3.press 3 to update any particular data");
			System.out.println("4.press 4 to delete the data");
			System.out.println("5.press 5 to exit");
			int n=sc.nextInt();
			switch(n)
			{
			case 1: sm.seeData();
			        break;
			case 2: sm.particularData();
			       break;
			case 3: sm.updateData();
			       break;
			case 4: sm.deleteData();
			      break;
			case 5:exit=true; 
			       System.out.println("thank you");
			       break;
			      default:System.out.println("invalid option");
			}
		}
		while(!exit);

	}

}
