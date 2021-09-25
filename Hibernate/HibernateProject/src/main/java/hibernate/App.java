package hibernate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.sql.Date;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(3);
        st.setName("Shweta");
        st.setCity("Pune");
        System.out.println(st);
        
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street3");
        ad.setCity("Pune");
        ad.setOpen(true);
        ad.setAddDate(new Date());
        ad.setX(123.258);
        ad.setAddressID(3);
        
        //Reading Images
        try {
        	FileInputStream fis = new FileInputStream("/home/yash/Documents/JDBC/pic1.jpeg");
            byte[] data=new byte[fis.available()];
            fis.read(data);
            ad.setImage(data);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        
        
        Session session =factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done");
        
       
    }
}
