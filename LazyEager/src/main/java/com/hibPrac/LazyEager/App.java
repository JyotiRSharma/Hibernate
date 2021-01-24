package com.hibPrac.LazyEager;

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
        
    	Laptop laptop = new Laptop();
    	laptop.setlId(101);
    	laptop.setlName("Dell");
    	
    	Alien al = new Alien();
    	al.setaColor("Yellow");
    	al.setaId(1);
    	al.setaName("Jyoti");
    	al.getLaptop().add(laptop);
    	
    	laptop.setAlien(al);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(al);
    	session.save(laptop);
    	
    	tx.commit();
    	
    	Alien a1 = (Alien)session.get(Alien.class, 1);
    	System.out.println(a1);
    }
}
