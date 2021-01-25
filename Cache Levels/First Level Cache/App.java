import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
		//1st session
		Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
		
		Alien a1 = (Alien)session.get(Alien.class, 1);
    	System.out.println(a1);
    	tx.commit();
    	
		//2nd Session
    	Session session2 = sf.openSession();
    	Transaction tx2 = session2.beginTransaction();
    	
    	Alien a2 = (Alien)session2.get(Alien.class, 1);
    	System.out.println(a2);
    	tx2.commit();
    	
    	//Example of first level cache, where different session cannot access the same data.
    	
    }
}