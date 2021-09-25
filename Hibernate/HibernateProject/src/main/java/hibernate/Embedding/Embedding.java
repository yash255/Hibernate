package hibernate.Embedding;
import hibernate.Embedding.*;


import javax.persistence.EntityTransaction;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Embedding {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println( "Project started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(101);
		student1.setCity("Delhi");
		student1.setName("Modi");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("3 days");
		student1.setCerti(certificate);
		

		Student student2 = new Student();
		student2.setId(102);
		student2.setCity("Mumbai");
		student2.setName("Kriti");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Python");
		certificate1.setDuration("1 week");
		student2.setCerti(certificate1);
		
		Session s = factory.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		s.save(student1);
		s.save(student2);
		tx.commit();
		s.clear();
		factory.close();
	}

}
