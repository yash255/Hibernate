package hibernate.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.MultipleBagFetchException;

import com.mysql.cj.Query;

import hibernate.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.openSession();
		//HQL
		//Syntax
		//
		String query = "from Student";
		Query q =(Query) session.createQuery(query);
		
		//single (unique)
       // Multiple (list)		
		List<Student> list = q.list();
		
		
		session.close();
		factory.close();
	}

}
