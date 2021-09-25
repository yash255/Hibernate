package hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.Embedding.*;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
	   Student student = new Student();
	   student.setId(4);
	   student.setCity("Pune");
	   student.setName("Yash");
	   student.setCerti(new Certificate("Java","1 month"));
	   
	   //student : Transient
	   Session session=factory.openSession();
	   Transaction tx = session.beginTransaction(); 
	   session.save(student);
	   
	   //student: Persistent - session,database
	   student.setName("Jeff");
	   tx.commit();
	   session.close();
	   
	   //student: Detach -   session
	   student.setName("Rohan");
	   factory.close();
	   

	}

}
