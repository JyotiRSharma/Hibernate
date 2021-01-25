package com.hibPrac.cache.SecondLevelCache;

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
    	
    	Session session1 = sf.openSession();
    	Transaction tx = session1.beginTransaction();
    	Alien a1 = (Alien)session1.get(Alien.class, 1);
    	
    	System.out.println(a1);
    	tx.commit();
    	
    	Session session2 = sf.openSession();
    	Transaction tx2 = session2.beginTransaction();
    	Alien a2 = (Alien)session2.get(Alien.class, 1);
    	
    	System.out.println(a2);
    	tx2.commit();
    	
    }
}
