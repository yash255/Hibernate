package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	public static void main(String[] args) {
		//get,load
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		//get
		Student student = session.get(Student.class, 2);
		System.out.println(student);
		
		/*//load
		Student student = session.load(Student.class, 1);
		System.out.println(student);*/
		
	//	Address address = session.get(Address.class, 2);
	//	System.out.println(address.getCity());
		
		
		factory.close();
		
	}

}
