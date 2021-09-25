package hibernate.Many_to_Many;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setEid(101);
		e1.setName("Yash");
		e2.setEid(102);
		e2.setName("Shruti");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(1);
		p1.setPname("LMS");
		p2.setPid(2);
		p2.setPname("CHATBOT");
		
		List<Employee> list1 = new ArrayList<Employee>();
		
		
		List<Project> list2 = new ArrayList<Project>();
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		//
		e1.setProjects(list2);
		p2.setEmployees(list1);
		
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		
		
		
		
		
		
		factory.close();

	}

}
