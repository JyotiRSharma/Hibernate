import java.util.List;
import java.util.Random;

import org.hibernate.Query;
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
        
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	Random r = new Random();
    	
//    	for (int i = 0; i<50; i++)
//    	{
//    		Alien a = new Alien();
//    		a.setaId(i);
//    		a.setaName("Name "+r.nextInt(50));
//    		a.setaColor("Color "+r.nextInt(5));
//    		
//    		session.save(a);
//    	}
    	
    	Query q = session.createQuery("from Alien where aId = 0");
    	
    	Alien alien = (Alien)q.uniqueResult();
    	
    	System.out.println(alien);
    	
    	//    	List<Alien> aliens = q.list();
//    	
//    	for (Alien a: aliens)
//    	{
//    		System.out.println(a);
//    	}
    	
    	tx.commit();
    }
}
