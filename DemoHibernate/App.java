package com.demo.yoto.DemoHib;



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

    	Alien yoto = new Alien();
    	yoto.setAid(101);
    	yoto.setAname("Jyoti");
    	yoto.setAcolor("Blue");
    	
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sf = cfg.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(yoto);
    	
    	tx.commit();
    	
    }
}
